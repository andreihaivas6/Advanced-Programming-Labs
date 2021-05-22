import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Main {
    public Main() {}
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
//        String pathClass = "D:\\Facultate\\MATERII\\An 2 Sem2\\3. PA\\Laboratoare\\Lab12\\src\\main\\java\\Student";

        String pathFolder = "D:\\Facultate\\MATERII\\An 2 Sem2\\3. PA\\Laboratoare\\Lab12";
        Helper.readAllFiledFromFolder(new File(pathFolder), pathFolder);
    }
}
