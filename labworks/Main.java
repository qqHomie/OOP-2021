import java.io.*; 
import java.util.*;   
public class Main{    
    public static void main(String args[]){      
        HashMap <String, String> map = new HashMap <String, String> ();   
        
        map.put ("uchiha", "itachi");
        map.put ("oop", "java");
        map.put ("day", "night");
        map.put ("week", "week");
        map.put ("map", "set");
        map.put ("key", "value");
        System.out.println("\nZhakysh Dariga\n");
        
        for(Map.Entry m:map.entrySet()){
            System.out.println(m.getKey() +  " - "  + m.getValue());
        }
        
        System.out.println("\n Program to test if a map contains a mapping for the specified key: \n" );

        System.out.println("Is key \"book\" exists?");
        if (map.containsKey("book")) {
            System.out.println("YES, Value is: " + map.get("book"));
        } else {
            System.out.println("NO");
        }
        
        System.out.println("Is key \"monkey\" exists?");
        if (map.containsKey("monkey")) {
            System.out.println("YES, Value is: " + map.get("monkey"));
        } else {
            System.out.println("NO");
        } 
        
        System.out.println("Is key \"set\" exists?");
        if (map.containsKey("set")) {
            System.out.println("YES, Value is: " + map.get("set"));
        } else {
            System.out.println("NO");
  }
    }
}
