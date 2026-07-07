public class Student {

    String name;
    int age;
    double gpa;
    String major;
    Boolean isEnrolled = true;
    Student(String name, int age, double gpa, String major){
        this.name = name;
        this.age = age;
        this.gpa = gpa;
        this.major = major;
        this.isEnrolled = true;
    }
    void study(){
        System.out.println(this.name + " is studying " + this.major);
    }
    void showInfo(){
        System.out.println("name: " + this.name);
        System.out.println("age: " + this.age);
        System.out.println("gpa: " + this.gpa);
        System.out.println("major: " + this.major);
        System.out.println("Enrolled: " + this.isEnrolled);
    }
}
