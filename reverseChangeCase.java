import java.util.Scanner;


public class reverseChangeCase {

	public static void main (String [] args) {

		String s = reverseChangeCase("abcd");
		System.out.println(s);


	}

		public static String reverseChangeCase(String string)
		{
	    char[] cArray = string.toCharArray();
	    int start=0;
	    int stop=cArray.length-1;
	    char temp;
	    while(stop>start)
			{
	        temp = cArray[start];
	        cArray[start]=cArray[stop];
	        cArray[stop] = temp;

	        start++;
					stop--;
	    }
	    return new String(cArray).toUpperCase();
	}

}
