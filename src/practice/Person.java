package practice;

import java.io.Serializable;


public class Person implements Serializable{
	public String name;
	public int id;
	
	public void displayPerson(){
		System.out.println("person " + name + " has id " + id);
	}
	
}

/*
class serializationDemo{
	 public static void main(String [] args) {
	      Person p = new Person();
	      p.name = "someone inprogress...";
	      p.id= 112223333;
	      
	      try {
	         FileOutputStream fileOut =
	         new FileOutputStream("/tmp/Person.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(p);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in /tmp/person.ser");
	      }catch(IOException i) {
	         i.printStackTrace();
	      }
	   }
}

class deserializationDemo{
	public static void main(String [] args) {
	      Employee p = null;
	      try {
	         FileInputStream fileIn = new FileInputStream("/tmp/person.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         e = (Person) in.readObject();
	         in.close();
	         fileIn.close();
	      }catch(IOException i) {
	         i.printStackTrace();
	         return;
	      }catch(ClassNotFoundException c) {
	         System.out.println("Person class not found");
	         c.printStackTrace();
	         return;
	      }
	      
	      System.out.println("Deserialized Person...");
	      System.out.println("Name: " + p.name);
	      System.out.println("Address: " + p.id);
	   }
}*/