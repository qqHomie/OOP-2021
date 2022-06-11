import java.util.*;
public class Main {
    public static void main(String args[]) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("plus", "+");
        map.put("minus", "-");
        map.put("window", "window");
        map.put("tree", "ball");
        map.put("name", "Aibek");
        map.put("car", "Toyota");
        map.put("light", "light");

        for (Map.Entry m : map.entrySet()){
            if (m.getKey() == m.getValue()){
                System.out.println(m.getKey() + " " + m.getValue());
            }
        }
        System.out.println("Zhaksylykov Nursultan");
    }
}