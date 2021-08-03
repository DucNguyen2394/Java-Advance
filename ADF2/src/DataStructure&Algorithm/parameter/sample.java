package parameter;

public class sample {
    public static void updateAge(int age){
        age +=1;
        System.out.println(age);
    }

    public static void update(Student std){
        std.age += 1;
    }

    public static void main(String[] args) {
        Student student = new Student("duc", 15);
        System.out.println(student.age);
//        updateAge(student.age);
        update(student);
        System.out.println(student.age);

    }
}
