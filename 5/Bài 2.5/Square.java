package OOP;

public class Square extends Rectangle {

    private double side;


    public Square() {
    }

    public Square(double side, String color, boolean filled) {
        super(color,filled);
        this.side = side;
    }

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public boolean isFilled() {
        return filled;
    }
    public double getArea() {
        return Math.pow(this.getSide(),2);
    }
    public double getPerimeter() {
        return this.getSide()*4;
    }

    public void setLenght() {
        super.setLength(side);
    }
    public void setWidth() {
        super.setWidth(side);
    }
    public String toString() {
        String a = "Square: side " + this.getSide()+ "\nArea: "+this.getArea()+ "\nPerimeter: "+this.getPerimeter()+ "\nFilled: "+this.isFilled();
        return a;
    }
}
