public class Week5b{
	public static void main(String[] args) {
		

		String str = new String("Abcdabsa");
		// System.out.println(str.toLowerCase());
	}
}
class Student{
    private String name;
    private int age;
    public String id;
    private double gpa = 4;
    String specialty;
    public static int x;
    
    Student(String n, int a){
        name = n;
        age = a;
    }
    
    public double getGPA(){return gpa;}
    public void setGPA(double gpa){
        if (gpa > 4 || gpa < 0) {
            System.out.println("Error message: Incorrect length of GPA");
        } else {
            this.gpa = gpa; // gpa = 2;
        }
    }
    
    static void changeNumber(int s){ // a = x = 5
    // s = 10;
        Student.x = s;
    }
    
    static void changeName(Student s, String newName){ // s = s1
        s.name = newName;
    }
    
    public String getName(){
        return "Student: " + this.name;
    }
    
    public Boolean printStudent(){
        Boolean result = false;
        if (gpa > 1) {
            System.out.println("Student: " + name);
            System.out.println("Age: " + age);
            System.out.println("GPA: " + gpa);
            result = true;
        }
        return result;
    }
}
    
public class Week5a{
    public static void main(String[] args) {
    Student s1 = new Student("Aibek", 13);
    // System.out.println(s1.getGPA()); // 4
    // s1.printStudent(); // 1
    // s1.setGPA(2);
    // System.out.println(s1.getGPA());
    
    // System.out.println(s1.name);
    // System.out.println(s1.getName());
    // System.out.println(s1.specialty);
    // System.out.println(s1.gpa);
    // System.out.println(s1.getGPA());
    
     //double d = s1.getGPA();
    
     //s1.gpa = 4.0;
    //s1.setGPA(3.5);
    //System.out.println(s1.gpa);
    //System.out.println(s1.getGPA());
    
    // int x = 51;
    // System.out.println(x);
    // Student.changeNumber(x);
    // System.out.println(Student.x);
    
    // System.out.println(s1.getName());
    // Student.changeName(s1, "Aibol");
    // System.out.println(s1.getName());
    
    int[] arr = new int[10];
    String[] str = new String[10];
    Student[] students = new Student[10];
    
    // System.out.println(arr[2]);
    // System.out.println(students[9]);
    // System.out.println(str[2]);
    
    students[0] = new Student("Abay", 21);
    students[1] = new Student("Zere", 22);
    // students[1].setGPA(3);
    // // System.out.println(students[0].getName());
    // // System.out.println(students[1].getName());
    // // System.out.println(students[2].printStudent()); // error
    // students[1].printStudent();
    
    
    for(int i=2; i<students.length; i++){
        students[i] = new Student("XXX", i);
    }
    
    int i = 0;
    for(i=0; i<students.length; i++){ // i=0,1,2,..,9 i=10
        students[i].printStudent();
        System.out.println("\n");
    }
    
    // System.out.println(i);
    }
}
/*
TASK-1: Create two groups of students (2 arrays), and initialize them;
TASK-2: Create a static method that compares two student arrays, 
		and returns how many students from 2 have the same name;
TASK-3: Modify the Student to make it an immutable class;
TASK-4: Create the Classes Course and Faculty, 
		and demonstrate their relationships to the Student class like in the lecture slides.
*/