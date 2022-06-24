package exemplo03;
// Heranca

import java.util.Scanner;

public class AppPerson {
    public static void main(String[] args) {
        String name;
        int age;
        Student student = new Student("Laura", "ADS");
        Person person = new Student("Douglas", "SI");
        Scanner sc = new Scanner(System.in); // le a partir do teclado, de arquivo...

        // usando o scanner
        System.out.println("digite um nome ");
        name = sc.nextLine();

        System.out.println("digite a idade ");
        age = Integer.parseInt(sc.nextLine());

        Person person2 = new Student(nome, "Java")

        //student.name = "Laura";
        System.out.println(student.getName());
        System.out.println(student.getCourse());
        System.out.println(person); // .toString()


    }
}
