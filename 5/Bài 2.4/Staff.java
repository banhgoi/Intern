package OOP;

public class Staff extends Person{
    private String school;
    private double salary;

    public Staff(String name, String address, String school, double salary) {
        super(name, address);
        this.school = school;
        this.salary = salary;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String program) {
        this.school = program;
    }

    public int getSalary() {
        return (int)salary;
    }

    public void setSalary(int  year) {
        this.salary = (int)salary*year;
    }

    public double upToSalary(int percent){
        return this.getSalary()*percent;
    }
}
