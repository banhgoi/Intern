package executorforkjoin.reflections.classMethod;

import executorforkjoin.reflections.classClass.Cat;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RefMethod {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Class<Cat> catClass = Cat.class;
        Method getAge = catClass.getMethod("getAge");
        Class<?> returnType = getAge.getReturnType();
        System.out.println("getAge return: "+returnType.getSimpleName());

        //Reflection style
        Cat meo = new Cat("meo", 5);
        System.out.println("Age of Meo: "+getAge.invoke(meo));


        Method setAge = catClass.getMethod("setAge",int.class);
        setAge.invoke(meo, 7);
        System.out.println("New age: "+meo.getAge());


        System.out.println("\nPrivate Method:");
        Method pri_method = catClass.getDeclaredMethod("setName", String.class);
        pri_method.setAccessible(true);
        System.out.println("Name before: "+meo.getName());
        pri_method.invoke(meo,"Gau Gau");
        System.out.println("New name: "+meo.getName());

    }

}
