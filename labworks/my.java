public class my{
	public static void main(String[] args) {
		Circle a = new Circle();
		System.out.println(a);
		a.Calculate_Area(1);
        a.Print_Area();
		a.Display_Area();
		
		Square s = new Square();
		System.out.println(s);
		s.Calculate_Area(5);
        s.Print_Area();
		s.Display_Area();

		Rectangle r = new Rectangle();
		System.out.println(r);
		r.Calculate_Area(5, 10);
        r.Print_Area();
		r.Display_Area();
	}
}

class Circle extends Shape{
    private double radius;
    private double Area;
    Circle(){
        super();
    }
	public String toString(){
		return "This is a Circle";
	}
	public void Display_Area(){
	    System.out.println(this.Area);
	}
	void Print_Area(){
		System.out.println(this.Area);
	}
	public double Calculate_Area(double radius){
	    Area = radius * radius * Math.PI;
		return Area;
	}
}

class Shape extends Object{
    private double Area;
    Shape(){
        Area = 0;
    }

	public String toString(){
		return "This is a Shape";
	}
	double Calculate_Area(){
		return Area;
	}
	public void Display_Area(){
	    System.out.println(this.Area);
	}
	void Print_Area(){
	    System.out.println(this.Area);
	}
}

class Square extends Shape{
    private double Length;
    private double Area;
    Square(){
        super();
    }

	public String toString(){
		return "This is a Square";
	}
	public void Display_Area(){
	    System.out.println(this.Area);
	}
	void Print_Area(){
		System.out.println(this.Area);
	}
	public double Calculate_Area(double Length){
	    Area = Length * Length;
		return Area;
	}
}
class Rectangle extends Shape{
	private double Length, Breadth;
    private double Area;
    Rectangle(){
        super();
    }

    public String toString(){
		return "This is a Rectangle";
	}
	public void Display_Area(){
	    System.out.println(this.Area);
	}
	void Print_Area(){
		System.out.println(this.Area);
	}
	public double Calculate_Area(double Length, double Breadth){
	    Area = Length * Breadth;
		return Area;
	}
}
