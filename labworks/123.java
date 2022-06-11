/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main{
    static boolean isExist(List list, Integer x){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) == x){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List <Integer> ar = new ArrayList<>();
        
        while(sc.hasNext()){
            int a = sc.nextInt();
            if(a == 0) break;
            else ar.add(a);
        }
        int x = sc.nextInt();
        // System.out.println a);
        
        if(isExist (ar, x)){
            System.out.println("Found!");
        }
        else{
            System.out.println("Not found!");
        }
        
    }
}

