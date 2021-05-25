import org.objectweb.asm.ClassReader;
import org.objectweb.asm.util.TraceClassVisitor;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public Main() {}
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
//        String pathClass = "D:\\Facultate\\MATERII\\An 2 Sem2\\3. PA\\Laboratoare\\Lab12\\src\\main\\java\\Student";

        String pathFolder = "D:\\Facultate\\MATERII\\An 2 Sem2\\3. PA\\Laboratoare\\Lab12";
//        Helper.readAllFilesFromFolder(new File(pathFolder), pathFolder);

        readAllFilesForBonus(new File(pathFolder), pathFolder);


    }

    public static void readAllFilesForBonus(File folder, String path) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException {
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                readAllFilesForBonus(file, path + "/" + file.getName());
            } else if(file.getName().endsWith(".java")){
                String fullPath = path + "/" + file.getName();
                String command = "javac -cp  \"" + fullPath + "\" " + file.getName();
                if(command.endsWith("Main.java")) {
                    Runtime.getRuntime().exec(command);
                    System.out.println(command);

                    String name = file.getName().substring(0, file.getName().length() - 5);
                    try {
                        ClassReader reader = new ClassReader(name);
                        StringWriter stringWriter = new StringWriter();
                        TraceClassVisitor traceClassVisitor = new TraceClassVisitor(new PrintWriter(System.out));
                        reader.accept(traceClassVisitor, 0);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
