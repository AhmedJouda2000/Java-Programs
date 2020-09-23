import java.util.Scanner;


public class trianglePrint {

	public static void main (String [] args) {

printTriangle(10, 'z');


	}

	public static void printTriangle(int a, char x)
	{
    if (a>=2 && a<=10) {

			for (int i=1;i<=a ;i++ ) {
				int j=1;
				while(j<=i){
					System.out.print(x + " " );
					j++;
					}
					System.out.println();

			}

    }
		else System.out.println("Not valid input");
    }

}
