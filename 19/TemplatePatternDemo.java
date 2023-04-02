/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package templatepatterndemo;

/**
 *
 * @author user
 */
abstract class Game
{
    abstract void initialize();
    abstract void start();
    abstract void end();
    public final void play()
    {
        initialize();
        start();
        end();
    }
}
class Chess extends Game
{
    @Override
    public void initialize()
    {
        System.out.println("Chess game is initialized. Start playing...");
    }
    @Override
    public void start()
    {
        System.out.println("Game started. Welcome to the chess game!");
    }
    @Override
    public void end()
    {
        System.out.println("Game finished!");
    }
}
class Soccer extends Game
{
    @Override
    public void initialize()
    {
        System.out.println("Soccer game is initialized. Start playing...");
    }
    @Override
    public void start()
    {
        System.out.println("Game started. Welcome to the soccer game!");
    }
    @Override
    public void end()
    {
        System.out.println("Game finished!");
    }
}
public class TemplatePatternDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Game g = (Game) Class.forName("templatepatterndemo.Soccer").getConstructor().newInstance();
        g.play();
    }
    
}
