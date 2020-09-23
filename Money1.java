import java.util.Scanner;

public class Money {

 int wholeNumber;
 int decimalPart;
 boolean positive;
 char currencySymbol;



 public static void main (String [] args)
 {
   Money m3 = new Money();
m3.wholeNumber = 2;
m3.decimalPart = 10;
m3.positive = true;
m3.currencySymbol = '$';

Money m4 = new Money();
m4.wholeNumber = 2;
m4.decimalPart = 10;
m4.positive = true;
m4.currencySymbol = '$';
System.out.println(m3.equals(m4));

  }


  public String toString()
  {
    String s = null;

    if (positive)
    {
       s = String.valueOf(currencySymbol) + wholeNumber + "." + String.format("%02d", decimalPart);
    }

    if (!positive)
    {
      s = "-" + String.valueOf(currencySymbol) + wholeNumber + "." + String.format("%02d", decimalPart);
    }

    return s;

  }

/*
  public String equals(Money second)
  {
    String g = null;
    if (second.toString() == toString()) {
        g = "true";
    }

    else g = "false";
    return g;
  }
*/

public String equals(Money second)
{
  String g = null;
  if ((second.currencySymbol == currencySymbol) && (second.wholeNumber == wholeNumber) && (second.decimalPart == decimalPart) && (second.positive == positive)) {
    g = "true";
  }
  else g = "false";
  return g;
}
}
