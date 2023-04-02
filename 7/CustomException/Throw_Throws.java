package OOP.Excep.CustomException;

public class Throw_Throws {

    public static void main(String args[]) {
        Throw_Throws TaT = new Throw_Throws();
        try {
            TaT.check();
        } catch (customEx cus) {
            System.out.println("Catch customEx");
        }
    }

    public void check() throws customEx {
        throw new customEx("Day la customEx");
    }
}
