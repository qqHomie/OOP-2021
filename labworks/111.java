import java.util.*;

public class Task {
    public static class FavoriteClasses {
        private favorite1;
        private favorite2;
        private favorite3;
        FavoriteClasses(fav1, fav2, fav3){
            this.favorite1 = fav1;
            this.favorite2 = fav2;
            this.favorite3 = fav3;
        }

        public void getFav1(){
            return this.favorite1;
        }

        public void getFav2(){
            return this.favorite2;
        }

        public void getFav3(){
            return this.favorite3;
        }
    }

    public static void main(String[] args){
        List r=new ArrayList();
        r.add(3.5);
        r.add(7.2);
        FavoriteClasses a = new FavoriteClasses("world", 66, r.get(0));
        System.out.println("My favorites are " + a.getFav1() + ", "  + a.getFav2() + ", and " + a.getFav3() + ".");
    }
}
