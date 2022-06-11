import java.util.*;
import java.util.HashMap;
import java.util.Scanner;

public class a{
	public static void main(String args[]){
		HashMap<Integer , String> lab9 = new HashMap<>();

		lab9.put(1,"ggorgg");
		lab9.put(2,"shadowfiend");
		lab9.put(3,"pudge");
		lab9.put(4,"invoker");
		
		Scanner n = new Scanner(System.in);
		int m = n.nextInt();

		System.out.println("HashMap: " +  lab9);
		System.out.println("Is in HashMap: " + lab9.containsKey(m));
		System.out.println("Value: " + lab9.get(m));		
	}
}