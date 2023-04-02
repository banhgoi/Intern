package OOP;

public class Student {
    private String name;
    private int age;
    private double score;
    private Address address;


    public Student() {
    }

    public Student(String name, int age, double score, Address address) {
        this.name = name;
        this.age = age;
        this.score = score;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getScore() {
        return score;
    }

    public Address getAddress() {
        return address;
    }

    //getRating


    public void setName(String name) {
        this.name = name;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String toString() {
        String a = "Name: " + this.getName() + ", Age " + this.getAge() + ", Score " + this.getScore() + "\nAddress: " + this.getAddress()+"\n"+this.getRating();
        return a;
    }

    public String getRating() {
        String a = "";
        if(this.getScore()<6.5&this.getScore()>=5)
            return a= "Xep loai: rung binh" ;
        else if (this.getScore()>=6.5&this.getScore()<8.5) {
            return a= "Xep loai: Kha" ;
        }else return a="Xep loai: Gioi";

    }
}
