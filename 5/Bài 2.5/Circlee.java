package OOP;

public class Circlee extends Shape {
    public Circlee() {

    }

    public Circlee(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.pow(radius, 2) * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return Math.PI*2*getRadius();
    }

    @Override
    public String toString() {
        String a = "Circle: Radius " + this.getRadius() + ", Area " + this.getArea()+ ", Perimeter " + this.getPerimeter();
        return a;
    }
}
