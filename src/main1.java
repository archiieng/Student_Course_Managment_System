import java.util.Scanner;

public class main1 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);

        Student[] students = new Student[10];
        int studentCount = 0;
        boolean running = true;

        while (running) {
            System.out.println("**** Student Management System ***");
            System.out.println("1.Add students");
            System.out.println("2.Show all students");
            System.out.println("3.Show high student's GPA");
            System.out.println("4.Make student study");
            System.out.println("5.Show average GPA");
            System.out.println("6.Delete student");
            System.out.println("7.Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    if(studentCount == students.length){
                        System.out.println("Student list is full");
                        break;
                    }
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine().toLowerCase();

                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();

                    System.out.print("Enter gpa: ");
                    double gpa = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Enter major: ");
                    String major = scanner.nextLine().toLowerCase();

                    if(age < 16 || (gpa < 0.0 && gpa >= 4.0)){
                        System.out.print("Age cannot be less than 16");
                        System.out.println("GPA must be between 0.0 and 4.0");
                    }
                    students[studentCount] = new Student(name,age,gpa,major);
                    studentCount++;

                    System.out.println("Student added successfully");
                    break;

                case 2:
                    if(studentCount == 0){
                        System.out.println("Student list is empty");
                    } else{
                        for(int i = 0; i < studentCount; i++){
                            students[i].showInfo();
                        }
                    break;
                    }

                case 3:
                    boolean foundHighGpa = false;
                    for(int i = 0; i < studentCount; i++){
                        if(students[i].gpa >= 3.5){
                            students[i].showInfo();
                            foundHighGpa = true; // this is question for me why I need foundHighGpa?
                        }
                    }
                    if(!foundHighGpa){ // this one to confusing
                        System.out.println("No high GPA students found.");
                    }
                    break;
                case 4:
                    for(int i = 0; i < studentCount; i++){
                        System.out.println(i+1 + " - " + students[i].name);
                    }
                    System.out.println("Choose student number: ");
                    int studentNumber = scanner.nextInt();

                    if(studentNumber < 0 || studentNumber > studentCount){
                        System.out.println("Invalid student number");
                    }else {
                        students[studentNumber - 1].study();
                    }
                    break;
                case 5:
                    double total = 0;
                    for(int i = 0; i < studentCount; i++){
                        total += students[i].gpa;
                    }
                    if(studentCount == 0){
                        System.out.println("There is no students yet");
                    } else{
                        double average = total / studentCount;
                        System.out.println("Average GPA: " + average);
                    }
                    break;
                case 6:
                    for(int i = 0; i < studentCount; i++){
                        System.out.println(i+1 + " - " + students[i].name);
                    }
                    System.out.println("Choose student to remove: ");
                    int studentNumber = scanner.nextInt();
                    int index = studentNumber - 1;

                    for(int i = index; i < studentCount - 1; i++){
                        students[i] = students[i+1]; // I do not understand this part
                    }
                    students[studentCount - 1] = null; // and this one is confusing
                    studentCount--;
                    System.out.println("Student removed successfully");
                    break;
                case 7:
                    running = false;
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        }
        scanner.close();
    }
}
