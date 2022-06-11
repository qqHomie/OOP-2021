import java.lang.Math;
import java.util.Random;

//package kz.kbtu;

// final class Math{
// 	static int a = 1;
// }

public class Week4a{
	public static void main(String[] args) {
		final int x = 3; // constant value
		//System.out.println(x);
		//x++;

		// Math m = new Math();
		// System.out.println(m.a);
		// m.a = 2;
		// System.out.println(m.a);

		//System.out.println(Math.a);

		System.out.println(Math.PI);
		System.out.println(Math.sqrt(4));
		System.out.println(Math.abs(-111));

		System.out.println(Math.random());

		Random r = new Random();
		System.out.println(r.nextInt(1000));
	}
}