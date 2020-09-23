import java.io.*;
import java.util.*;
//interface
 interface Vehicle {
    public String getName();
    public int getTopSpeed();
    public int getMaxPassengers();
    public static String fastestVehicle(ArrayList<Vehicle> array){

      int max = 0;
      String maxName = null;
    for (int i = 0; i < array.size() ; i++) {
      if (array.get(i) instanceof Vehicle) {
        Vehicle v = (Vehicle) array.get(i);

        if (v.getTopSpeed()>max) {
          max = v.getTopSpeed();
          maxName = v.getName();
          }
      }
    }


    return maxName;

    }
}

public class Car implements Vehicle{
//intance variables
String name;
int topSpeed;
int maxPassengers;
double weight;
//main
public static void main (String [] args) {

  ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
  vehicles.add(new Car("Mazda 3", 190,5,1.3));
  vehicles.add(new Car("Lamborghini Gallardo", 325,2,1.45));
  vehicles.add(new Ship("Titanic", 39,3327, 52310));
  vehicles.add(new Car("Toyota Avensis", 200,5,2.02));
  vehicles.add(new Ship("Nimitz", 58,5680, 100020));
  printVehicles(vehicles);

}



//constructor
public Car(String brand, int speed, int noPassengers, double w){
  if (speed<0 || noPassengers<=0 || w<0 || brand.isEmpty()) {
    throw new IllegalArgumentException("Invalid inputs");
  }

  name = brand;
  topSpeed = speed;
  maxPassengers = noPassengers;
  weight = w;
}

//implementation of class Car
public String getName(){
  return name;
}

public int getTopSpeed(){
  return topSpeed;
}

public int getMaxPassengers(){
  return maxPassengers;
}

public double getWeight(){
  return weight;
}

public static void printVehicles(ArrayList<Vehicle> array){

  for (int i = 0; i < array.size() ; i++) {
    if (array.get(i) instanceof Car) {
      Car v = (Car) array.get(i);

    System.out.println("This car weighs " + v.getWeight() + " tonnes");

  }

  if (array.get(i) instanceof Ship) {
    Ship v = (Ship) array.get(i);

  System.out.println("This ship displaces " + v.getDisplacement() + " tonnes of water");

}
}
}

}


class Ship implements Vehicle{
  //intance variables
  String name;
  int topSpeed;
  int maxPassengers;
  double displacement;

  //constructor
  public Ship(String n, int speed, int noPassengers, double d){
    if (speed<0 || noPassengers<=0 || noPassengers>9999|| d<0 || n.isEmpty()|| n == " ") {
      throw new IllegalArgumentException("Invalid inputs");
    }

    name = n;
    topSpeed = speed;
    maxPassengers = noPassengers;
    displacement = d;
  }

  //implementation of class Car
  public String getName(){
    return name;
  }

  public int getTopSpeed(){
    return topSpeed;
  }

  public int getMaxPassengers(){
    return maxPassengers;
  }

  public double getDisplacement(){
    return displacement;
  }

  public static void printVehicles(ArrayList<Vehicle> array){

    for (int i = 0; i < array.size() ; i++) {
      if (array.get(i) instanceof Ship) {
        Ship v = (Ship) array.get(i);

      System.out.println("This ship displaces " + v.getDisplacement() + " tonnes of water");

    }
  }
  }


}
