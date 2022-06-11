package homework;

import java.io.IOException; 
import java.io.FileWriter;
public class hw9{
    public static void main(String[] args) {
        Users u = new Users("Nursultan", "123123123123", "66666666666");
        u.er();
    }
}
class Users extends Errors
{
    private String name;
    private String IIN;
    private String phone;
    Users(String n, String i, String p){
        name = n;
        IIN= i;
        phone = p;
    }
    public void er(){
        if(IIN.length() != 12 || phone.length() != 11){
            try {
                FileWriter myWriter = new FileWriter("filename.txt");
                myWriter.write(IIN + " " + phone);
                myWriter.close();
            } catch (IOException e) {
                System.out.println("ERROR");
                e.printStackTrace();
            }
            throw new ArithmeticException("IIN or phone are wrong");
        }
        else{
            System.out.println("Good job!");
        }
    }

}

abstract class Errors{
    public abstract void er();
}
