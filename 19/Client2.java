/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package client;
import java.util.*;
/**
 *
 * @author user
 */
interface Account
{
    void openAccount();
}
abstract class Bank implements Account
{
    protected Account account;
    public Bank(Account account)
    {
        this.account = account;
    }
    @Override
    public abstract void openAccount();
}
class CheckingAccount implements Account
{
    @Override
    public void openAccount()
    {
        
    }
}
class SavingAccount implements Account
{
    @Override
    public void openAccount()
    {
        
    }
}
enum BankType
{
    VIETINBANK, TECHCOMBANK, SCB, MB, CAKE_BY_VPBANK;
}
class VietinBank extends Bank
{
    public VietinBank(Account account)
    {
        super(account);
    }
    @Override
    public void openAccount()
    {
        System.out.print("\nYour account at VietinBank is ");
        account.openAccount();
        System.out.println();
    }
}
class TechcomBank extends Bank
{
    public TechcomBank(Account account)
    {
        super(account);
    }
    @Override
    public void openAccount()
    {
        System.out.print("\nYour account at TechcomBank is ");
        account.openAccount();
        System.out.println();
    }
}
class SCB extends Bank
{
    public SCB(Account account)
    {
        super(account);
    }
    @Override
    public void openAccount()
    {
        System.out.print("\nYour account at SCB is ");
        account.openAccount();
        System.out.println();
    }
}
class MB extends Bank
{
    public MB(Account account)
    {
        super(account);
    }
    @Override
    public void openAccount()
    {
        System.out.print("\nYour account at MB is ");
        account.openAccount();
        System.out.println();
    }
}
class CakeByVPBank extends Bank
{
    public CakeByVPBank(Account account)
    {
        super(account);
    }
    @Override
    public void openAccount()
    {
        System.out.print("\nYour account at Cake by VPBank is ");
        account.openAccount();
        System.out.println();
    }
}
public class Client2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Bank vietinBank = new VietinBank(new CheckingAccount());
        vietinBank.openAccount();
        Bank techcomBank = new TechcomBank(new CheckingAccount());
        techcomBank.openAccount();
        Bank scb = new SCB(new CheckingAccount());
        scb.openAccount();
        Bank mb = new MB(new CheckingAccount());
        mb.openAccount();
        Bank cakeByVPBank = new CakeByVPBank(new CheckingAccount());
        cakeByVPBank.openAccount();
        System.out.println();
    }
    
}
