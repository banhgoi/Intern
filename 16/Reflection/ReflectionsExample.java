package executorforkjoin.reflections.classClass;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionsExample {
    public static void getClassInfo() throws ClassNotFoundException {
        Class<?> aClazz = Class.forName("executorforkjoin.reflections.classClass.Cat");
        System.out.println("Name: " + aClazz.getName());
        System.out.println("Simple name: " + aClazz.getSimpleName());
        System.out.println("Package name: " + aClazz.getPackageName());

        Class<?> superClazz = aClazz.getSuperclass();
        System.out.println("SuperClass of Cat: "+superClazz.getName());

        System.out.println("\nInterFace:");
        Class<?>[] InterClazz = aClazz.getInterfaces();
        for (Class<?> inter: InterClazz) {
            System.out.println(" +"+inter.getSimpleName());
        }

        System.out.println("\nContructors:");
        Constructor<?>[] Cons = aClazz.getConstructors();
        for (Constructor<?> con: Cons) {
            System.out.println(" +"+con.getName()+" has " +con.getParameterCount()+" param");
        }

        System.out.println("\nDecalred Methods:");
        Method[] Meds = aClazz.getDeclaredMethods();
        for (Method med: Meds) {
            System.out.println(" +"+med.getName()+" has " +med.getParameterCount()+" param");
        }

        System.out.println("\nFields :");
        Field[] flds = aClazz.getFields();
        for (Field fld: flds) {
            System.out.println(" +"+fld.getName());
        }

        System.out.println("\nAnotations :");
        Annotation[] ans = aClazz.getAnnotations();
        for (Annotation an: ans) {
            System.out.println(" +"+an.annotationType().getSimpleName());
        }


        int modi = aClazz.getModifiers();
        boolean ispublic = Modifier.isPublic(modi);
        boolean isFinal = Modifier.isFinal(modi);
        boolean isAbs = Modifier.isAbstract(modi);
        boolean isInterface = Modifier.isInterface(modi);

    }

    public static void main(String[] args) throws ClassNotFoundException {
        try {
            getClassInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
