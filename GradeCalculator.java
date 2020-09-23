import java.util.*;
import java.io.*;

public class GradeCalculator{

//main
public static void main (String [] args) {

  try {
  GradeCalculator.readFile("grades2.csv");
} catch (Exception ex) {
  ex.printStackTrace();
}

}



public static void readFile(String s) throws IOException{

      File f = new File(s);
      Scanner scan = new Scanner(f);
      Scanner scan1;
      double c1, c2, exam, grade;
      String studentID;

      while(scan.hasNextLine()) {

        scan1 = new Scanner(scan.nextLine());
        scan1.useDelimiter(",");

        studentID = scan1.next();
        c1 = Double.parseDouble(scan1.next());
        c2 = Double.parseDouble(scan1.next());
        exam = Double.parseDouble(scan1.next());

        grade = (c1*0.2) + (c2*0.3) + (exam*0.5);
        System.out.println(studentID + " " + grade);

      }





}
}
