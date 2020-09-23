import java.util.Scanner;

public class Prime {

    public static void main(String[] args)
    {
        String primeNumbers = "";
        boolean isPrime = true;

        for (int i = 2; i <= 1000; i++)
        {
            isPrime = CheckPrime(i);
            if (isPrime)
            {
                primeNumbers = primeNumbers + i + " ";
            }
        }
        System.out.println(primeNumbers);
    }




    public static boolean CheckPrime(int numberToCheck)
    {
        int remainder;
        for (int i = 2; i <= numberToCheck / 2; i++)
        {
            remainder = numberToCheck % i;
                if (remainder == 0)
            {
                return false;
            }
        }
        return true;

    }

}
