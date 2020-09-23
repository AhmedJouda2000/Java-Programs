import java.util.*;
interface Human  extends Comparable<Human>{
  int getAge();
  String getName();
}





public class input{

//main
public static void main (String [] args) {


  Scanner scanner = new Scanner(System.in);
  String name, employer;
  int age, salary;
  while(scanner.hasNext()){



  //String name;

  do
  {
    try {
       if (scanner.hasNextInt()) {
         int i = scanner.nextInt();
         throw new Exception("Exception thrown");
       }
       else name = scanner.next();
       break;
    }
    catch (Exception e)
    {
      System.out.println("received int expecting String");
    }
  }
  while (true);


  //int age;
  do
  {
      try {
          String s = scanner.next();
          age = Integer.parseInt(s);
          break;
      }
      catch (Exception e)
      {
          System.out.println("received String expecting int");
      }
  }
  while (true);


  //String employer;
  do
  {
    try {
       if (scanner.hasNextInt()) {
         int i = scanner.nextInt();
         throw new Exception("Exception thrown");
       }
       else employer = scanner.next();
       break;
    }
    catch (Exception e)
    {
      System.out.println("received int expecting String");
    }
  }
  while (true);


//  int salary;
  do
  {
      try {
          String s = scanner.next();
          salary = Integer.parseInt(s);
          break;
      }
      catch (Exception e)
      {
          System.out.println("received String expecting int");
      }
  }
  while (true);


Employee m1 = new Employee(name, age, employer, salary);
System.out.println(m1.toString());
}
}

}








class Person implements Human{
//intance variables
private int age;
private String name;





//constructor
public Person(String n, int a){
  if (a<0 ||  n.isEmpty() || n == " ") {
    throw new IllegalArgumentException("Invalid inputs");
  }

  name = n;
  age = a;

}

//implementation of class Person
public int getAge(){
  return age;
}

public String getName(){
  return name;
}

public String toString(){
  String s = null;
  s = "Person:[" + getName() + ", " + getAge() + "]";
  return s;
}

public boolean equals(Object o){
  if (o instanceof Person ) {
      Person p = (Person)o;
      return getAge() == p.getAge() && getName() == p.getName();
  }
  else return false;
}

public int compareTo(Human h){
    if (getAge() < h.getAge()) {
      return -1;
    }
    if (getAge() > h.getAge()) {
      return 1;
    }
    else return 0;
}

}

class Employee extends Person{
  //intance variables
  private String employer;
  private int salary;


  //constructor
  public Employee(String n, int a, String e, int s){
    super(n, a);
    if (e.isEmpty() || e == " " || s<0) {
      throw new IllegalArgumentException("Invalid inputs");
    }

    employer = e;
    salary = s;

  }

  public int getSalary(){
    return salary;
  }
  public  String getEmployer(){
    return employer;
  }

  public String toString(){
    String s = null;
    s = "Employee:[" + getName() + ", " + getAge() + "][" + getEmployer() + ", " + getSalary() + "]" ;
    return s;
  }

  public int compareTo(Human h){




      if (getAge() < h.getAge()) {
        return -1;
      }
      if (getAge() > h.getAge()) {
        return 1;
      }
      if (getAge() == h.getAge()) {

          Employee e = (Employee)h;

        if (getSalary() < e.getSalary()) {
          return -1;
        }
        if (getSalary() > e.getSalary()) {
          return 1;
        }

      }
       return 0;
  }


}
