import java.util.Scanner;
import java.awt.Rectangle;
import java.awt.Point;

public class rectanglePoints {

	public static void main (String [] args) {

		Rectangle box = new Rectangle(5,5,67,7);
		Point p1 = new Point(1,1);
		Point p2 = new Point(7,7);

		boolean ans1 = box.contains(p1);
		if (ans1) {
			System.out.println("The point p1 is inside the box");
		}
		else System.out.println("The point p1 is outside the box");

		boolean ans2 = box.contains(p2);
		if (ans2) {
			System.out.println("The point p2 is inside the box");
		}
		else System.out.println("The point p2 is outside the box");

	}
}

/*
	public static void Rectangle(int a, int b)
	{
    System.out.println("Sum: " + (a + b));
		System.out.println("Product: " + (a * b));
		System.out.println("Concatenation: " + a + b);
		System.out.println("Power: " + Math.pow(a, b));

    }

}
*/
