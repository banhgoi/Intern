/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package observerpatterndemo;
import java.util.*;
import java.io.*;
/**
 *
 * @author user
 */
class EventSource extends Observable implements Runnable
{
    @Override
    public void run()
    {
        try
        {
            final InputStreamReader isr = new InputStreamReader(System.in);
            final BufferedReader br = new BufferedReader(isr);
            while (true)
            {
                String response = br.readLine();
                setChanged();
                notifyObservers(response);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
class ResponseHandler implements Observer
{
    private String response;
    @Override
    public void update(Observable object, Object argument)
    {
        if (argument instanceof String)
        {
            response = (String) argument;
            System.out.println("Received response: " + response);
        }
    }
}
public class ObserverPatternDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.print("Enter text: ");
        final EventSource eventSource = new EventSource();
        final ResponseHandler responseHandler = new ResponseHandler();
        eventSource.addObserver(responseHandler);
        Thread thread = new Thread(eventSource);
        thread.start();
    }
    
}
