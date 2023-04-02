package OOP;

public class Studentttt extends Person{
    private String program;
    private int year;
    private double score;

    public Studentttt(String name, String address, String program, int year, double score) {
        super(name, address);
        this.program = program;
        this.year = year;
        this.score = score;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getRating() {
        String a = "";
        if(this.getScore()<6.5&this.getScore()>=5)
            return a= "Xep loai: rung binh" ;
        else if (this.getScore()>=6.5&this.getScore()<8.5) {
            return a= "Xep loai: Kha" ;
        } else if (this.getScore()<5) {
            return a="Xep loai: Yeu";

        }else return a="Xep loai: Gioi";

    }

    public String toString() {
        String a = "Name: " + this.getName() + ", Major: "+this.getProgram()+", Score " + this.getScore() + "\nAddress: " + this.getAddress()+"\n"+this.getRating();
        return a;
    }

}
