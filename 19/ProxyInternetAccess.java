/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proxyinternetaccess;

/**
 *
 * @author user
 */
interface OfficeInternetAccess
{
    void grantInternetAccess();
}
class RealInternetAccess implements OfficeInternetAccess
{
    private String employeeName;
    public RealInternetAccess(String employeeName)
    {
        this.employeeName = employeeName;
    }
    @Override
    public void grantInternetAccess()
    {
        
    }
}
public class ProxyInternetAccess implements OfficeInternetAccess {
    private String employeeName;
    private int employeeRole;
    private RealInternetAccess realAccess;
    public ProxyInternetAccess(String employeeName, int employeeRole)
    {
        this.employeeName = employeeName;
        this.employeeRole = employeeRole;
    }
    public int getRole(String employeeName)
    {
        return employeeRole;
    }
    @Override
    public void grantInternetAccess()
    {
        if (getRole(employeeName) > 4)
        {
            realAccess = new RealInternetAccess(employeeName);
            realAccess.grantInternetAccess();
        }
        else System.out.println("No Internet access granted. Your job level is below 5.");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
