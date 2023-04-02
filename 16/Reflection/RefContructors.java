package executorforkjoin.reflections.classContructors;

import executorforkjoin.reflections.classClass.Cat;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class RefContructors {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<Cat> catClass = Cat.class;

//      get info params of constructor
        System.out.println("\nParams");
        Constructor<?> cons = catClass.getConstructor(String.class, int.class);
        Class<?>[] paramClass = cons.getParameterTypes();
        for (Class<?> pr : paramClass) {
            System.out.println(" +" + pr.getSimpleName());
        }

        Cat tom = (Cat) cons.newInstance("Tom", 3);
        System.out.println("\nCat: "+ tom.getName()+", Age: "+tom.getAge());
    }
}
