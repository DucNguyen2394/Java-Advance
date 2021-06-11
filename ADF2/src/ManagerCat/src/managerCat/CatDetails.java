package managerCat;

import java.util.Scanner;

public class CatDetails implements Icat {
	String type;
	String color;
	String living;
	
	public CatDetails(){
		
	}

	public CatDetails(String type, String color, String living) {
		super();
		this.type = type;
		this.color = color;
		this.living = living;
	}

	public void input() {
		Scanner scan = new Scanner(System.in); 
		System.out.println("Enter type: ");
		type = scan.nextLine();
		System.out.println("Enter color: ");
		color = scan.nextLine();
		System.out.println("Enter living: ");
		living = scan.nextLine();
	}

	public void output() {
		System.out.println(toString());
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getLiving() {
		return living;
	}

	public void setLiving(String living) {
		this.living = living;
	}

	@Override
	public String toString() {
		return "CatDetails [Name = " + name + ", type= " + type + ", color= " + color + ", living= " + living + "]";
	}
	
 
}
