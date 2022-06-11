import java.util.*;

public class Task {
    public static class FavoriteClasses {
        private favorite1;
        private favorite2;
        private favorite3;
        FavoriteClasses(fav1, fav2, fav3){
            this.favorite1=fav1;
            this.favorite2=fav2;
            this.favorite3=fav3;
        }

        public getFav1(){
            return(this.favorite1);
        }

        public getFav2(){
            return(this.favorite2);
        }

        public getFav3(){
            return(this.favorite3);
        }
    }

    public static main(String[] args){
        List r=new ArrayList();
        r.add(6.3);
        r.add(5.9);
        FavoriteClasses a=new FavoriteClasses("Hello",67,r.get(0));
        System.out.println("My favorites are " + a.getFav1() + ", " a.getFav2() + ", and " + a.getFav3() + ".");
    }
}
