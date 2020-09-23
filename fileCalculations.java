import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class fileCalculations{

        static void averageIntegers(String s) throws IOException{
          File f = new File(s);
          int maximum, minimum;
          double total = 0;
          double number = 0;
          int value;

          Scanner scan = new Scanner(f);

          maximum = scan.nextInt();
          minimum = scan.nextInt();
          while(scan.hasNextInt()){
            value = scan.nextInt();
            if (maximum < value) {
              maximum = value;
            }
            if (minimum > value) {
              minimum = value;
            }
          }

          scan.reset();
          scan = new Scanner(f);
          while(scan.hasNextInt()){
            total += scan.nextInt();
            number++;
          }
          total /= number;

          System.out.println("Min Value: " + minimum);
          System.out.println("Max Value: " + maximum);
          System.out.println("Average Value : " + (total));


        }


        //main
        public static void main (String [] args) {

          try {
    averageIntegers("03.txt");
  } catch (Exception ex) {
    ex.printStackTrace();
  }

        }
}
