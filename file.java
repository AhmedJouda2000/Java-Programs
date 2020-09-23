import java.util.*;
import java.io.*;

public class file{

//main
public static void main (String [] args) {

writeFile();
}

public static void writeFile(){

  Scanner input = new Scanner(System.in);
  String line = "";


  line = input.nextLine();

  try(FileWriter out = new FileWriter( "message.txt" )){
    out.write(line);
      out.flush();
      out.close();
  }
  catch (IOException ex) {ex.printStackTrace();}

}

}
