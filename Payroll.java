 public class Payroll {

public static double OVERTIME_RATE = 1.25;
public static int REGULAR_WEEK = 55;
public static int LEVEL_ONE_PAY = 20;
public static int LEVEL_TWO_PAY = 40;
public static int LEVEL_THREE_PAY = 40;
public  enum PayLevel{ONE, TWO, THREE};

	public static void main (String [] args) {
		PayClaim p = new PayClaim(70, Payroll.PayLevel.TWO);
p.calculatePay();
System.out.println(p);
	}

public static double calculatePay(int noHoursWorked, PayLevel level)
{
	double pay = 0;
	int rate = 0;
	int reg_week = REGULAR_WEEK;

	if (noHoursWorked>80 || noHoursWorked<1) {
		throw new IllegalArgumentException("Hours out of range!");
	}

	else {
	switch(level){
		case ONE:
			rate = LEVEL_ONE_PAY;
			break;
		case TWO:
				rate = LEVEL_TWO_PAY;
				break;
		case THREE:
				rate = LEVEL_THREE_PAY;
				break;
		}
	if (noHoursWorked <= reg_week)
	{
		pay = noHoursWorked * rate;
	}
	else if(noHoursWorked > reg_week){
		pay = (reg_week*rate) + ((noHoursWorked - reg_week)*(rate*OVERTIME_RATE));
	}
	return pay;
}
}


}

class PayClaim{
	int noHoursWorked;
	Payroll.PayLevel payLevel;
	double calculatedPay;

//constructor
	public PayClaim(int hours, Payroll.PayLevel level){
		if (hours<1 || hours>80) {
			throw new IllegalArgumentException("Hours worked out of range!");
		}
		noHoursWorked = hours;
		payLevel = level;
	}

//accessors
	public int getNoHoursWorked(){
		return noHoursWorked;
	}
	public Payroll.PayLevel getPayLevel(){
		return payLevel;
	}
	public double getCalculatedPay(){
		return calculatedPay;
	}

	//mutators
	private boolean pay_was_set = false;
	public void setCalculatedPay(double pay){
		if (pay<= 0) {
			throw new IllegalArgumentException("Calculated pay is not greater than 0!");
		}
		this.calculatedPay = pay;
		pay_was_set = true;
	}

	public void calculatePay(){
		double amount = Payroll.calculatePay(noHoursWorked, payLevel);
		this.calculatedPay = amount;
		pay_was_set = true;
	}

	//tostring
	public String toString(){
		String s = null;
		if (!pay_was_set)
		{
			if (noHoursWorked == 1)
			{
				s = "PayClaim for " + noHoursWorked + " hour, at PayLevel " + payLevel;
			}
			else{s = "PayClaim for " + noHoursWorked + " hours, at PayLevel " + payLevel;}
		}

		else if (pay_was_set)
		{
			if (noHoursWorked == 1)
			{
				s = "PayClaim for " + noHoursWorked + " hour, at PayLevel " + payLevel + ", which gives " + calculatedPay;
			}
			else{s = "PayClaim for " + noHoursWorked + " hours, at PayLevel " + payLevel + ", which gives " + calculatedPay;}
		}

		return s;
	}
}
