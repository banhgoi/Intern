package executorforkjoin.reflections.classField;

import executorforkjoin.reflections.classClass.Cat;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class RefField {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class<Cat> catClass = Cat.class;
        Field field = catClass.getField("age");

        Class<?> fltype = field.getType();
//        System.out.println("Field type: "+fltype.getSimpleName());
        System.out.println("Field type: "+catClass.getField("age").getType().getSimpleName());


        Cat Bin = new Cat("Bin", 10);
        Field fieldAge = catClass.getField("age");

        int age = (int) fieldAge.get(Bin);
        System.out.println("Age: "+age);
        fieldAge.set(Bin,5);
        System.out.println("new Age: "+Bin.getAge());


        System.out.println("\nAnotations :");
        Annotation[] ans = fieldAge.getAnnotations();
        for (Annotation an: ans) {
            System.out.println(" +"+an.annotationType().getSimpleName());
        }

        System.out.println("\nPrivate Fields:");
        Field pri_field = catClass.getDeclaredField("name");
        System.out.println("NAME: "+pri_field.getType().getSimpleName());

        pri_field.setAccessible(true);
        Cat Pia = new Cat("Pia");
        System.out.println("New value of name: Rambo");
        pri_field.set(Pia, "Rambo");
        System.out.println("After: "+Pia.getName());


    }
}
