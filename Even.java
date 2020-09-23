public class Even {

    public static void main(String[] args)
    {
        String evenNumbers = "";
        boolean isEven = true;

        for (int i = 0; i <= 100; i++)
        {
            isEven = CheckEven(i);
            if (isEven)
            {
                evenNumbers = evenNumbers + i + " ";
            }
        }
        System.out.println(evenNumbers);
    }




    public static boolean CheckEven(int numberToCheck)
    {
        int remainder;

            remainder = numberToCheck % 2;
                if (remainder == 0)
            {
                return true;
            }

            else return false;

    }

}
