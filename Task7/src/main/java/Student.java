public class Student {
    private String name;
    private int age;
    private String group;

    public Student(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof Student) {
            Student student = (Student) obj;
            return this.name.equals(student.name) && this.age == student.age && this.name.equals(student.name);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (int) (31 * ((name == null) ? 0 : name.hashCode()) + age) * 31 + ((group == null) ? 0 : name.hashCode());
    }
}

class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Strelchenko", 19, "TV-91");
        Student student2 = new Student("Levkun", 19, "TV-91");
        Student student3 = new Student("Levkun", 19, "TV-91");

        if (student1.hashCode() == student2.hashCode()) {
            if (student1.equals(student2)) {
                System.out.println("Объекты равны.");
            } else {
                System.out.println("Объекты не равны.");
            }
        } else {
            System.out.println("Объекты не равны.");
        }


        if (student3.hashCode() == student2.hashCode()) {
            if (student3.equals(student2)) {
                System.out.println("Объекты равны.");
            } else {
                System.out.println("Объекты не равны.");
            }
        } else {
            System.out.println("Объекты не равны.");
        }
    }
}

