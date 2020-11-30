package classLoader;

import java.lang.reflect.*;

public class ClassInfo {
    public static void printClassInfo(String path) throws ClassNotFoundException {
        MyClassLoader loader = new MyClassLoader();
        Class<?> inputClass = loader.findClass(path);

        System.out.println("Class name: " + inputClass.getName());
        System.out.println();
        Constructor<?>[] constructors = inputClass.getConstructors();
        System.out.println("Class constructors:");

        if(constructors.length == 0){
            System.out.println("This class doesn't contain constructors");
        } else {
            for(Constructor<?> constructor : constructors){
                StringBuilder out = new StringBuilder();
                out.append(constructor.getName());
                out.append("(");
                Parameter[] parameters = constructor.getParameters();
                int i = 1;
                for(Parameter parameter : parameters){
                    out.append(parameter.getType().getName());
                    out.append(" ");
                    out.append(parameter.getName());

                    if(i != parameters.length){
                        out.append(", ");
                    }
                    i++;
                }
                out.append(")");
                System.out.println(out.toString());
            }
        }

        Field[] fields = inputClass.getDeclaredFields();


        System.out.println();
        System.out.println("Class fields:");
        if(fields.length == 0){
            System.out.println("This class doesn't contain fields");
        } else {
            for(Field field : fields){
                System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType().getName() + " " + field.getName());
            }
        }

        Method[] methods = inputClass.getDeclaredMethods();

        System.out.println();
        System.out.println("Class methods:");
        if(methods.length == 0){
            System.out.println("This class doesn't contain methods");
        } else {
            for(Method method : methods){
                Parameter[] parameters = method.getParameters();
                StringBuilder out = new StringBuilder();
                out.append(Modifier.toString(method.getModifiers()));
                out.append(" ");
                out.append(method.getReturnType().getName());
                out.append(" ");
                out.append(method.getName());
                out.append("(");

                int i = 1;
                for(Parameter parameter : parameters){
                    out.append(parameter.getType().getName());
                    out.append(" ");
                    out.append(parameter.getName());
                    if(i != parameters.length){
                        out.append(", ");
                    }

                    i++;
                }
                out.append(")");
                System.out.println(out.toString());
            }
        }
        System.out.println();
        System.out.println();
    }
}
