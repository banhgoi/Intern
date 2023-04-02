package OOP;

public class Book {
    private String name;
    private Authour authour;
    private double price;
    private int count;


    public Book(String name, Authour authour, double price,int count) {
        this.name = name;
        this.authour = authour;
        this.price = price;
        this.count=count;
    }

    public String getName() {
        return name;
    }

    public Authour getAuthour() {
        return authour;
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public String toString() {
        String a = "Name Book: " + this.getName()  + ", Price: " + this.getPrice() + ", Count: " + this.getCount() + "\nAuthour " + this.getAuthour();
        return a;
    }
}
