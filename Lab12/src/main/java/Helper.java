import java.beans.JavaBean;
import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Helper {
    public Helper() {}
    public static void getInfoOfClass(String path) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        File classFile = new File(path);
        String className = classFile.getName();

        Class reflectClass = Class.forName(className);
        System.out.println("Nume clasa: " + reflectClass.getName());
        System.out.println("Nume pachet: " + getPackageName(classFile.getParentFile()) + "\n");

        System.out.println("class " + getClassAccesType(reflectClass) + " " + reflectClass.getName() + " { ");
        getMethods(reflectClass);
        System.out.println("}");

        invokeMethodsTestStaticNoArgs(reflectClass);

        verifyClassAnnotatedWithTest(reflectClass);
    }

    private static void verifyClassAnnotatedWithTest(Class reflectClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        for (Annotation annotation : reflectClass.getAnnotations()) {
            if (annotation instanceof JavaBean) {
                System.out.println("Class has @JavaBean. @Test didn't worked.");

                int totalTests = 0;
                int badTests   = 0;

                Method[] classMethods = reflectClass.getMethods();
                Object newObject = reflectClass.getConstructor().newInstance();
                for (Method method : classMethods) {
                    for (Annotation annotation2 : method.getAnnotations()) {
                        if (annotation2 instanceof org.junit.Test) {
                            try {
                                totalTests++;
                                method.invoke(newObject, 2);
                            } catch(Exception e) {
                                badTests++;
                            }
//                            run(reflectClass);
                        }
                    }
                }
                System.out.println("We have " + totalTests + " tests.");
                System.out.println("It failed " + badTests + " tests.");
                System.out.println("It passwd " + (totalTests - badTests) + " tests.");
            }
        }
    }

    public static String getPackageName(File file){
        if(file.getParentFile().getName().equals("src")) {
            return file.getName();
        }
        return getPackageName(file.getParentFile()) + "." + file.getName();
    }

    static String getClassAccesType(Class reflectClass) {
        int classModifier = reflectClass.getModifiers(); // isFinal, isInterface etc
        return getAccesType(classModifier);
    }

    private static String getMethodAccesType(Method method) {
        int methodModifier = method.getModifiers();
        return getAccesType(methodModifier);
    }

    private static String getAccesType(int classModifier) {
        if(Modifier.isPublic(classModifier)) {
            return "public";
        } else if(Modifier.isPrivate(classModifier)) {
            return "private";
        } else {
            return "protected";
        }
    }

    static void getMethods(Class reflectClass) {
        Method[] classMethods = reflectClass.getMethods();
        for (Method method : classMethods) {
            System.out.print("   "  + getMethodAccesType(method) +
                    " " + method.getReturnType().getName() + " " +
                    method.getName() + " (");
            Class[] parameterTypes = method.getParameterTypes();
            for(int i = 0; i < parameterTypes.length - 1; ++i) {
                System.out.print(parameterTypes[i].getName() + ", ");
            }
            if(parameterTypes.length > 0) {
                System.out.print(parameterTypes[parameterTypes.length - 1].getName());
            }
            System.out.println(");");
        }
    }

    static void invokeMethodsTestStaticNoArgs(Class reflectClass) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Method[] classMethods = reflectClass.getMethods();
        Object newObject = reflectClass.getConstructor().newInstance();
        for (Method method : classMethods) {
            if(method.getParameterCount() == 0) {
                int methodModifier = method.getModifiers();
                if(Modifier.isStatic(methodModifier)) {
                    for (Annotation annotation : method.getAnnotations()) {
                        if (annotation instanceof org.junit.Test) {
                            method.invoke(newObject);
                        }
                    }
                }
            }
        }
    }

    public static void readAllFiledFromFolder(File folder, String path) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        for (File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                readAllFiledFromFolder(fileEntry, path + "/" + fileEntry.getName());
            } else if(fileEntry.getName().endsWith(".java")){
                String fullPath = path + "/" + fileEntry.getName();
                fullPath = fullPath.substring(0, fullPath.length() - 5);
                getInfoOfClass(fullPath);
            }
        }
    }
}
