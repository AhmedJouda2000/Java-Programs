public class Div {

  public static void main(String[] args)
  {
      String wantedNumbers = "";
      boolean isDivBy3 = true;
      boolean isDivBy5 = true;

      for (int i = 1; i <= 500; i++)
      {
          isDivBy3 = Check3(i);
          isDivBy5 = Check5(i);

          if (isDivBy3 || isDivBy5)
          {
              wantedNumbers = wantedNumbers + i + " ";
          }
      }
      System.out.println(wantedNumbers);
  }




  public static boolean Check3(int numberToCheck)
  {
      int remainder;

          remainder = numberToCheck % 3;
              if (remainder == 0)
          {
              return true;
          }

          else return false;

  }

  public static boolean Check5(int numberToCheck)
  {
      int remainder;

          remainder = numberToCheck % 5;
              if (remainder == 0)
          {
              return true;
          }

          else return false;

  }

}
