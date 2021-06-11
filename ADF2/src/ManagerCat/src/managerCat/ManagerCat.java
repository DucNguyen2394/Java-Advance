package managerCat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ManagerCat {
	ArrayList<CatDetails> catList = new ArrayList<>();
	Scanner scan = new Scanner(System.in);
	public ManagerCat(){
		
	}
	
	public void enter(){
		int n;
		System.out.println("1.Enter n number cat ");
		n = Integer.parseInt(scan.nextLine());
		for(int i = 0; i < n; i++){
			CatDetails cat = new CatDetails();
			cat.input();
			catList.add(cat);
		}
	}
	
	public void display(){
		for(int i = 0; i < catList.size(); i++){
			catList.get(i).output();
		}
	}
	
	public void sort(){
		Collections.sort(catList, new Comparator<CatDetails>(){
			public int compare(CatDetails o1, CatDetails o2){
				return o1.getColor().compareToIgnoreCase(o2.getColor());
			}
		});
		display();
	}
	
	public void find(){
		String a;
		int count = 0;
		System.out.println("1.Enter type you need find ");
		a = scan.nextLine();
		for(int i = 0; i < catList.size(); i++){
			if(catList.get(i).getType().equalsIgnoreCase(a)){
				catList.get(i).output();
				count ++;
			}
		}
		if(count == 0){
			System.out.println("can't find cat's type");
		}
	}
	
}
