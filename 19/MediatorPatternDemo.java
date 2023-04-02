/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mediatorpatterndemo;
import java.util.*;
/**
 *
 * @author user
 */
abstract class ChatMediator
{
    public abstract void sendMessage(String message, User user);
    public abstract void addUser(User user);
    public abstract List<User> getUsers();
}
abstract class User
{
    protected ChatMediator mediator;
    protected String name;
    public User(ChatMediator mediator, String name)
    {
        this.mediator = mediator;
        this.name = name;
    }
    public abstract void send(String message);
    public abstract void receive(String message);
    @Override
    public int hashCode()
    {
        return name.hashCode();
    }
    @Override
    public boolean equals(Object object)
    {
        if (object == null || this.getClass() != object.getClass()) return false;
        return name.equals(((User) object).name);
    }
}
class ChatMediatorImplementation extends ChatMediator
{
    public ChatMediatorImplementation(String groupName)
    {
        System.out.println("The group " + groupName + " created.");
    }
    private List<User> users = new ArrayList<>();
    @Override
    public void addUser(User user)
    {
        System.out.println(user.name + " joined this group.");
        users.add(user);
    }
    @Override
    public void sendMessage(String message, User user)
    {
        for (User u: users)
            if (!u.equals(user))
                u.receive(message);
    }
    @Override
    public List<User> getUsers()
    {
        return users;
    }
}
class UserImplementation extends User
{
    public UserImplementation(ChatMediator mediator, String name)
    {
        super(mediator, name);
    }
    @Override
    public void send(String message)
    {
        System.out.println("--> " + name + " is sending the message '" + message + "'");
        mediator.sendMessage(message, this);
    }
    @Override
    public void receive(String message)
    {
        System.out.println(name + " received the message '" + message + "'");
    }
}
public class MediatorPatternDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ChatMediator mediator = new ChatMediatorImplementation("Java design pattern");
        System.out.println();
        mediator.addUser(new UserImplementation(mediator, "Admin"));
        mediator.addUser(new UserImplementation(mediator, "User 1"));
        mediator.addUser(new UserImplementation(mediator, "User 2"));
        mediator.addUser(new UserImplementation(mediator, "User 3"));
        System.out.println();
        mediator.getUsers().get(0).send("Hi all");
        System.out.println();
        for (int i = 1; i < mediator.getUsers().size(); i++) 
        {
            mediator.getUsers().get(i).send("Hi admin");
            System.out.println();
        }
    }
    
}
