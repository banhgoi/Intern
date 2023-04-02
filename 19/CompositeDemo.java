/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package compositedemo;
import java.util.*;
import java.util.concurrent.*;
/**
 *
 * @author user
 */
interface Employee
{
    int getID();
    String getName();
    double getSalary();
    void print();
    void add(Employee employee);
    void remove(Employee employee);
}
class Accountant implements Employee
{
    private int id;
    private String name;
    private double salary;
    public Accountant(int id, String name, double salary)
    {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    @Override
    public int getID()
    {
        return id;
    }
    @Override
    public String getName()
    {
        return name;
    }
    @Override
    public double getSalary()
    {
        return salary;
    }
    @Override
    public void print()
    {
        
    }
    @Override
    public void add(Employee employee)
    {
        
    }
    @Override
    public void remove(Employee employee)
    {
        
    }
    @Override
    public String toString()
    {
        return "'" + id + " - " + name + " - " + salary + "'";
    }
}
class Cashier implements Employee
{
    private int id;
    private String name;
    private double salary;
    public Cashier(int id, String name, double salary)
    {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    @Override
    public int getID()
    {
        return id;
    }
    @Override
    public String getName()
    {
        return name;
    }
    @Override
    public double getSalary()
    {
        return salary;
    }
    @Override
    public void print()
    {
        
    }
    @Override
    public void add(Employee employee)
    {
        
    }
    @Override
    public void remove(Employee employee)
    {
        
    }
    @Override
    public String toString()
    {
        return "'" + id + " - " + name + " - " + salary + "'";
    }
}
class BankManager implements Employee
{
    private int id;
    private String name;
    private double salary;
    public BankManager(int id, String name, double salary)
    {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    @Override
    public int getID()
    {
        return id;
    }
    @Override
    public String getName()
    {
        return name;
    }
    @Override
    public double getSalary()
    {
        return salary;
    }
    @Override
    public void print()
    {
        
    }
    @Override
    public void add(Employee employee)
    {
        
    }
    @Override
    public void remove(Employee employee)
    {
        
    }
    @Override
    public String toString()
    {
        return "'" + id + " - " + name + " - " + salary + "'";
    }
}
public class CompositeDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Set<Employee> employee = new CopyOnWriteArraySet<Employee>();
        employee.add(new Cashier(106, "Sohan Kumar", 10000));
        employee.add(new Cashier(102, "Mohan Kumar", 20000));
        employee.add(new Accountant(108, "Seema Mahiwal", 30000));
        System.out.println(employee);
        Employee manager = new BankManager(104, "Ashwani Rajput", 40000);
        for (Employee e: employee) manager.add(e);
        manager.print();
    }
    
}
