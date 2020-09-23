import java.util.Scanner;


public class stringRep {

	public static void main (String [] args) {

		printString("This is my longer String");




	}

	public static void printString(String string)
	{
		System.out.println(string);
		String newString = string.replaceAll("my","your");
		System.out.println(newString);

    }

}
