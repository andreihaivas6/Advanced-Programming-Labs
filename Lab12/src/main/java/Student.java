import org.junit.Test;

public class Student {
    private Long id;
    private String name;

    public Student() {}

    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Test
    public static void staticTestNoArg(){
        System.out.println("Functie statica @Test fara argumente a rulat");
    }

    @Test
    public static void staticTestOneArg(int x){
        System.out.println("Functie statica @Test cu argumente a rulat");
    }
}
