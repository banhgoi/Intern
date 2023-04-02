/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package caretaker;
import java.util.*;
/**
 *
 * @author user
 */
class Memento
{
    private double x, y;
    public void setX(double x)
    {
        this.x = x;
    }
    public double getX()
    {
        return x;
    }
    public void setY(double y)
    {
        this.y = y;
    }
    public double getY()
    {
        return y;
    }
    public Memento(double x, double y)
    {
        setX(x);
        setY(y);
    }
}
class Originator
{
    private double x, y;
    public void setX(double x)
    {
        this.x = x;
    }
    public double getX()
    {
        return x;
    }
    public void setY(double y)
    {
        this.y = y;
    }
    public double getY()
    {
        return y;
    }
    public Originator(double x, double y)
    {
        setX(x);
        setY(y);
    }
    public Memento save()
    {
        return new Memento(x, y);
    }
    public void undo(Memento memento)
    {
        x = memento.getX();
        y = memento.getY();
    }
    @Override
    public String toString()
    {
        return "(" + x + "; " + y + ")";
    }
}
public class CareTaker {
    private final Map<String, Memento> savedPointStorage = new HashMap<>();
    public void saveMemento(Memento memento, String savedPointName)
    {
        System.out.println("Saving state..." + savedPointName);
        savedPointStorage.put(savedPointName, memento);
    }
    public Memento getMemento(String savedPointName)
    {
        System.out.println("Undo at..." + savedPointName);
        return savedPointStorage.get(savedPointName);
    }
    public void clearSavedPoints()
    {
        System.out.println("Clearing all saved points...");
        savedPointStorage.clear();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CareTaker careTaker = new CareTaker();
        Originator originator = new Originator(5, 10);
        careTaker.saveMemento(originator.save(), "#1");
        System.out.println("State saved (#1): " + originator);
        originator.setY(originator.getX() * 10);
        System.out.println("State changed: " + originator);
        originator.undo(careTaker.getMemento("#1"));
        System.out.println("State before changing: " + originator);
    }
    
}
