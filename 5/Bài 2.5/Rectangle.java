package OOP;

public class Rectangle extends Shape {
    protected double width;
    protected double length;


    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }
    public Rectangle(String color, boolean filled) {
        super(color,filled);
    }

    public Rectangle() {
    }

    public Rectangle(String color, boolean filled, double width, double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return this.getWidth()*this.getLength();
    }

    @Override
    public double getPerimeter() {
        return (this.getWidth()+this.getLength())*2;
    }

    @Override
    public String toString() {
        String a = "Rectangle: width "+this.getWidth()+" lenght "+this.getLength()+ "\nArea " + this.getArea() + "\nPerimeter " + this.getPerimeter();
        return a;
    }
}
