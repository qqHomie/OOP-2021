import java.util.Scanner;
import java.util.ArrayList;
public class Week14 {

    static void Task1(String arr[], String s){
        int cnt = 0;
        for(String i: arr){
            if(i.equals(s)) {
                cnt++;
            }
        }
        System.out.println("word \"" + s + "\" occurs in array " + cnt + " times");
    }

    static boolean Task2(ArrayList<Integer> arr, int a){
        
        for(int i: arr){
            if (a == i && a!=0) {
                return true;
            }
        }
        return false;
    }
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        // 1
        System.out.println("TASK 1");
        System.out.println("Enter string:");
        String words[] = {"uchiha", "itachi", "naruto", "sakura", "loves", "sasuke", "anime", "hate", "boruto"};
        String word = scan.nextLine();
        Task1(words, word);
        
        // 2

        int n = 5;
        ArrayList<Integer> a = new ArrayList<Integer>();
        System.out.println("TASK 2");
        System.out.println("Enter integers:");

        while(n!=0){
            Integer num = scan.nextInt();
            a.add(num);
            n -= 1;
        }
        System.out.println("Enter target:");
        int t;
        t = scan.nextInt();
        scan.close();
        if(Task2(a, t)){
            System.out.println("found");
        }else{
            System.out.println("not found");
        }
    }
}