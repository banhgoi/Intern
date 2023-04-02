package executorforkjoin.reflections.classClass;

import executorforkjoin.reflections.classClass.Excel;
import executorforkjoin.reflections.classClass.ExcelColumn;
import jdk.jfr.Label;

@Excel(name = "Cat")
@Noti(hello="day la meo")
public class Cat extends Animal implements Say {
    public static final String SAY = "Meo Meo";
    public static final int Legs = 4;

    @ExcelColumn(index = 0, title = "Name")
    private String name;
    @ExcelColumn(index = 1, title = "Age")
    @Label("hehe")
    public int age;

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }




    @Override
    public void print() {

    }
}
