import java.util.Scanner;

public class Money {

 int wholeNumber;
 int decimalPart;
 boolean positive;
 char currencySymbol;

public Money(int no, int de, boolean po, char cu) {
  if (de>99 || de<0) {
    throw new IllegalArgumentException("Decimal Part is not between 0 and 99");
  }
  if (no<0) {
    throw new IllegalArgumentException("Whole number is negative");
  }
  if (cu != '$' && cu != '?' && cu != '#') {
    throw new IllegalArgumentException("Unvalid Currency");
  }

  this.wholeNumber = no;
  this.positive = po;
  this.decimalPart = de;
  this.currencySymbol = cu;

}

 public static void main (String [] args)
 {
   Money m1 = new Money(1, 1, true, '$');
Money m2 = new Money(200, 10, true, '#');
System.out.println(m1.greaterThan(m2));

Money m3 = new Money(1, 1, true, '#');
Money m4 = new Money(200, 10, true, '$');
System.out.println(m4.greaterThan(m3));

Money m5 = new Money(1, 1, false, '$');
Money m6 = new Money(1, 1, true, '$');
System.out.println(m5.greaterThan(m6));

Money m7 = new Money(1, 1, false, '$');
Money m8 = new Money(1, 1, true, '$');
System.out.println(m8.greaterThan(m7));

  }

  public void setWholeNumber(int i){
    if (i<0) {
      throw new IllegalArgumentException("Whole number is negative");
    }
    this.wholeNumber = i;
  }

  public void setDecimalPart(int i){
    if (i>99 || i<0) {
      throw new IllegalArgumentException("Decimal Part is not between 0 and 99");
    }
    this.decimalPart = i;
  }

  public void setPositive(boolean i){
    this.positive = i;
  }

  public void setCurrencySymbol(char i){
    if (currencySymbol != '$' && currencySymbol != '?' && currencySymbol != '#') {
      throw new IllegalArgumentException("Invalid Currency");
    }
    this.currencySymbol = i;
  }







/*  public String greaterThan(Money second){

    String g = null;

    if (positive == second.positive) {
      if (wholeNumber > second.wholeNumber) {
        g = "true";
      }
      if (wholeNumber == second.wholeNumber) {
        if (decimalPart > second.decimalPart) {
          g = "true";
        }
        else g = "false";

        }
      }
      else g = "false";

      return g;
    }

  }*/


  public boolean greaterThan(Money second){
    if (positive == true && second.positive == false ) {

    
      return true;
    }
    if (positive == false && second.positive == true) {
      return false;
    }

      if (wholeNumber > second.wholeNumber) {
        return true;
      }
      if (wholeNumber == second.wholeNumber) {
        if (decimalPart > second.decimalPart) {
          return true;
        }
        else {return false;}
      }
      else {return false;}

  }
}
