import java.util.*;
interface Human  extends Comparable<Human>{
  int getAge();
  String getName();
}


public class Person implements Human{
//intance variables
private int age;
private String name;

//main
public static void main (String [] args) {
  Manager m1 = new Manager("Matthew", 41, "UCD", 50000);
Manager m2 = new Manager("Marvin", 50, "UCD", 60000);
Employee e1 = new Employee("Edward", 24, "UCD", 35000);
Employee e2 = new Employee("Elliott", 31, "UCD", 48000);
Employee e3 = new Employee("Ernesto", 28, "UCD", 38000);
Employee e4 = new Employee("Emily", 34, "UCD", 42000);
m1.addEmployee(e1);
m1.addEmployee(e2);
m2.addEmployee(e3);
m2.addEmployee(m1);
m1.addEmployee(e4);
System.out.println(m1.compareTo(m2) + " " + m2.compareTo(m1) + " " + m1.compareTo(m1));
System.out.println(m1.equals(m2) + " " + m2.equals(m1) + " " + m1.equals(m1));
System.out.println(m1.compareTo(e1) + " " + m1.compareTo(e2) + " " + e1.compareTo(m1) + " " + e2.compareTo(m1));
System.out.println(m1.equals(e1) + " " + m1.equals(e2) + " " + e1.equals(m1) + " " + e2. equals(m1));
Employee e5 = new Employee(m1.getName(), m1.getAge(), m1.getEmployer(), m1.getSalary());
System.out.println(e5.compareTo(m1) + " " + m1.compareTo(e5));
System.out.println(e5.equals(m1) + " " + m1.equals(e5));
}



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

class Manager extends Employee{
  //intance variables
  private ArrayList<Employee> team;


  //constructor
  public Manager(String n, int a, String e, int s){
    super(n, a, e, s);
    team = new ArrayList<Employee>();
  }

  public void addEmployee(Employee emp){
    team.add(emp);
  }

  public ArrayList<Employee> getTeam(){
    return team;
  }

  public String toString(){
    String s = null;
    s = "Manager:[" + getName() + ", " + getAge() + "][" + getEmployer() + ", " + getSalary() + "]" + "[Team: " + team.size() + "]";
    return s;
  }


  public int getSalary(){
    int total = 0;
    for (int i = 0;i< team.size() ;i++ ) {
      Employee e = team.get(i);
      total = total + e.getSalary();
    }
    int bonus = (int)(Math.round(total/team.size()));
    int money = bonus + super.getSalary();
    return money;
  }

  public boolean equals(Object o){
    if (super.equals(o) && o instanceof Manager) {
      Manager k = (Manager)o;
      return k.getTeam().equals(getTeam());
    }
    else return super.equals(o);
  }



}
