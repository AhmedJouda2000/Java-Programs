import java.util.*;

public class calc{
//intance variables

//main
public static void main (String [] args) {

  Scanner scanner = new Scanner(System.in);

double i, j;
String op;



    //repeats at each line cycle

    while(scanner.hasNext()){
        i = scanner.nextDouble();
        if (scanner.hasNextDouble()) {

          System.out.println("neww");
          op = scanner.next();
          j = scanner.nextDouble();
       //  System.out.println(i);
         switch (op) {
             case "+": System.out.println(i+j);
                       i = i + j;
                       break;
             case "-": System.out.println(i-j);
                       i = i - j;
                       break;
             case "x": System.out.println(i*j);
                       i = i * j;
                       break;
             case "/":System.out.println(i/j);
                       i = i/j;
                       break;
             default: System.out.println("unknown operator"); break;
         }
        }
        else{

          while(!(scanner.hasNextDouble()))
          {
            op = scanner.next();
            j = scanner.nextDouble();
         //  System.out.println(i);
           switch (op) {
               case "+": System.out.println(i+j);
                         i = i + j;
                         break;
               case "-": System.out.println(i-j);
                         i = i - j;
                         break;
               case "x": System.out.println(i*j);
                         i = i * j;
                         break;
               case "/":System.out.println(i/j);
                         i = i/j;
                         break;
               default: System.out.println("unknown operator");scanner.nextLine();

          }
          }

    }
}
}
}
