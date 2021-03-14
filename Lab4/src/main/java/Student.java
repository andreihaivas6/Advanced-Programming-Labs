public class Student {
    private String name;
    private Integer mark;

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, Integer mark) {
        this.name = name;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    //    public static int compareByName(Student s1, Student s2){
//        return s1.getName().compareTo(s2.getName());
//    }

    @Override
    public String toString() {
        return "Student{'" + name + '\'' +
                 ", " + mark +
                "}";
    }
}
