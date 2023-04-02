/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package statepatterndemo;

/**
 *
 * @author user
 */
interface State
{
    void handleRequest();
}
class NewState implements State
{
    @Override
    public void handleRequest()
    {
        System.out.println("Submit a post for admin approval.");
    }
}
class SubmittedState implements State
{
    @Override
    public void handleRequest()
    {
        System.out.println("Successfully submitted, waiting for admin approval.");
    }
}
class ApprovedState implements State
{
    @Override
    public void handleRequest()
    {
        System.out.println("An admin approved your post.");
    }
}
class DeclinedState implements State
{
    @Override
    public void handleRequest()
    {
        System.out.println("An admin declined your post.");
    }
}
class RemovedState implements State
{
    @Override
    public void handleRequest()
    {
        System.out.println("An admin removed your post.");
    }
}
class PostContext
{
    private State state;
    public void setState(State state)
    {
        this.state = state;
    }
    public void applyState()
    {
        state.handleRequest();
    }
}
public class StatePatternDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PostContext context = new PostContext();
        context.setState(new NewState());
        context.applyState();
        context.setState(new SubmittedState());
        context.applyState();
        context.setState(new ApprovedState());
        context.applyState();
        context.setState(new DeclinedState());
        context.applyState();
        context.setState(new RemovedState());
        context.applyState();
    }
    
}
