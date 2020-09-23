import java.util.Scanner;


public class Time {

	public int hours;

  public int minutes;

  public int seconds;




public static void main (String [] args) {

	Time morning = new Time();
morning.hours = 4;
morning.minutes = 5;
morning.seconds = 2;
morning.printTime();




}


	public void printTime()
	{


		System.out.println("["+ String.format("%02d", hours) + ":" + String.format("%02d", minutes) + ":" + String.format("%02d", seconds) +"]");

    }
}
