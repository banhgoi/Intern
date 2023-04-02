package stockexchange;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;
public class Admin extends User {
    public Map<Integer, User> users = new TreeMap<>();
    public Map<Integer, Transaction> transactions = new TreeMap<>();
    public Map<Integer, Trader> traders = new TreeMap<>();
    public Map<Integer, Stock> stocks = new TreeMap<>();
    public Map<Integer, Company> companies = new TreeMap<>();
    public Map<Integer, Order> orders = new TreeMap<>();
    public Admin() {
    }

    public Admin(Integer id, String fullname, String email, String phone) {
        super(id, fullname, email, phone);
    }
    public void removeUser(Integer id)
    {
        users.remove(id);
    }
    public Integer createUserID()
    {
        Integer ranNum = ThreadLocalRandom.current().nextInt(1,1000000000);
        while (users.containsKey(ranNum)) ranNum = ThreadLocalRandom.current().nextInt(1,1000000000);
        return ranNum;
    }
    public Integer createTraderID()
    {
        Integer ranNum = ThreadLocalRandom.current().nextInt(1,1000000000);
        while (traders.containsKey(ranNum)) ranNum = ThreadLocalRandom.current().nextInt(1,1000000000);
        return ranNum;
    }
    public Integer createCompanyID()
    {
        Integer ranNum = ThreadLocalRandom.current().nextInt(1,1000000000);
        while (companies.containsKey(ranNum)) ranNum = ThreadLocalRandom.current().nextInt(1,1000000000);
        return ranNum;
    }
    public Integer createOrderID()
    {
        Integer ranNum = ThreadLocalRandom.current().nextInt(1,1000000000);
        while (orders.containsKey(ranNum)) ranNum = ThreadLocalRandom.current().nextInt(1,1000000000);
        return ranNum;
    }
    public Integer createTransactionID()
    {
        Integer ranNum = ThreadLocalRandom.current().nextInt(1,1000000000);
        while (transactions.containsKey(ranNum)) ranNum = ThreadLocalRandom.current().nextInt(1,1000000000);
        return ranNum;
    }
    public Integer createStockID()
    {
        Integer ranNum = ThreadLocalRandom.current().nextInt(1,1000000000);
        while (stocks.containsKey(ranNum)) ranNum = ThreadLocalRandom.current().nextInt(1,1000000000);
        return ranNum;
    }
    public void createUser(String fullname, String email, String phone)
    {
        if (!userEmailExists(email) && !userPhoneExists(phone)) 
        {
            Integer ID = createUserID();
            users.put(ID, new User(ID, fullname, email, phone));
        }
        else
        {
            if (userEmailExists(email)) System.out.println("The email " + email + " has already existed.");
            if (userPhoneExists(phone)) System.out.println("The phone number " + phone + " has already existed.");
            System.out.println("Cannot create this user.");
        }
    }
    public void createTrader(String fullname, String email, String phone)
    {
        if (!traderEmailExists(email) && !traderPhoneExists(phone)) 
        {
            Integer ID = createTraderID();
            traders.put(ID, new Trader(ID, fullname, email, phone));
        }
        else
        {
            if (traderEmailExists(email)) System.out.println("The email " + email + " has already existed.");
            if (traderPhoneExists(phone)) System.out.println("The phone number " + phone + " has already existed.");
            System.out.println("Cannot create this trader.");
        }
    }
    public void createCompany(String name, String address, String email)
    {
        if (!companyEmailExists(email)) 
        {
            Integer companyID = createCompanyID();
            companies.put(companyID, new Company(companyID, name, address, email));
        }
        else System.out.println("The email " + email + " has already existed. Cannot create this trader.");
    }
    public void createStock(Integer priceID, Integer companyID, Integer minPrice, Integer maxPrice)
    {
        if (companyIDExists(companyID)) 
        {
            Integer stockID = createStockID();
            stocks.put(companyID, new Stock(priceID, stockID, companyID, companies.get(companyID).getName(), minPrice, maxPrice));
        }
        else System.out.println("The company " + companyID + " does not exist. Cannot create this stock.");
    }
    public void createTransaction(Integer orderBuyID, Integer orderSellID, Date date, Integer buyID, Integer sellID, Integer stockID, Integer amount, Integer price)
    {
        if (stockIDExists(stockID)) 
        {
            Integer transactionID = createTransactionID();
            transactions.put(transactionID, new Transaction(transactionID, orderBuyID, orderSellID, new java.util.Date(), buyID, sellID, stockID, amount, price));
        }
        else System.out.println("The stock " + stockID + " does not exist. Cannot create this transaction.");
    }
    public void createOrder(Integer traderID, Boolean type, Integer stockID, Integer amount, Integer price)
    {
        if (traderIDExists(traderID) && stockIDExists(stockID)) 
        {
            Integer orderID = createOrderID();
            orders.put(orderID, new Order(orderID, new java.util.Date(), traderID, type, stockID, amount, price));
        }
        else
        {
            if (!traderIDExists(traderID)) System.out.println("The trader " + traderID + " does not exist.");
            if (!stockIDExists(stockID)) System.out.println("The stock " + stockID + " does not exist.");
            System.out.println("Cannot create this trader.");
        }
    }
    public boolean userEmailExists(String email)
    {
        List<User> userList = new ArrayList<>(users.values());
        return userList.stream().anyMatch(p -> p.getEmail().equals(email));
    }
    public boolean userPhoneExists(String phone)
    {
        List<User> userList = new ArrayList<>(users.values());
        return userList.stream().anyMatch(p -> p.getPhone().equals(phone));
    }
    public boolean traderEmailExists(String email)
    {
        List<Trader> traderList = new ArrayList<>(traders.values());
        return traderList.stream().anyMatch(p -> p.getEmail().equals(email));
    }
    public boolean traderPhoneExists(String phone)
    {
        List<Trader> traderList = new ArrayList<>(traders.values());
        return traderList.stream().anyMatch(p -> p.getPhone().equals(phone));
    }
    public boolean companyIDExists(Integer id)
    {
        List<Integer> companyIDList = new ArrayList<>(companies.keySet());
        return companyIDList.stream().anyMatch(p -> p.equals(id));
    }
    public boolean stockIDExists(Integer id)
    {
        List<Integer> stockIDList = new ArrayList<>(stocks.keySet());
        return stockIDList.stream().anyMatch(p -> p.equals(id));
    }
    public boolean traderIDExists(Integer id)
    {
        List<Integer> traderIDList = new ArrayList<>(traders.keySet());
        return traderIDList.stream().anyMatch(p -> p.equals(id));
    }
    public boolean companyEmailExists(String email)
    {
        List<Company> companyList = new ArrayList<>(companies.values());
        return companyList.stream().anyMatch(p -> p.getEmail().equals(email));
    }
    public User searchUserByID(Integer id)
    {
        return users.get(id);
    }
    public Trader searchTraderByID(Integer id)
    {
        return traders.get(id);
    }
    public Company searchCompanyByID(Integer id)
    {
        return companies.get(id);
    }
    public Order searchOrderByID(Integer id)
    {
        return orders.get(id);
    }
    public Stock searchStockByID(Integer id)
    {
        return stocks.get(id);
    }
    public Transaction searchTransactionByID(Integer id)
    {
        return transactions.get(id);
    }
    public List<User> searchUserByName(String name)
    {
        List<User> userList = new ArrayList<>(users.values());
        return userList.stream().filter(p -> p.getFullname().contains(name)).collect(Collectors.toList());
    }
    public List<Trader> searchTraderByName(String name)
    {
        List<Trader> traderList = new ArrayList<>(traders.values());
        return traderList.stream().filter(p -> p.getFullname().contains(name)).collect(Collectors.toList());
    }
    public List<Company> searchCompanyByName(String name)
    {
        List<Company> companyList = new ArrayList<>(companies.values());
        return companyList.stream().filter(p -> p.getName().contains(name)).collect(Collectors.toList());
    }
    public List<User> searchUserByEmail(String email)
    {
        List<User> userList = new ArrayList<>(users.values());
        return userList.stream().filter(p -> p.getEmail().contains(email)).collect(Collectors.toList());
    }
    public List<Trader> searchTraderByEmail(String email)
    {
        List<Trader> traderList = new ArrayList<>(traders.values());
        return traderList.stream().filter(p -> p.getEmail().contains(email)).collect(Collectors.toList());
    }
    public List<Company> searchCompanyByEmail(String email)
    {
        List<Company> companyList = new ArrayList<>(companies.values());
        return companyList.stream().filter(p -> p.getEmail().contains(email)).collect(Collectors.toList());
    }
    public List<User> searchUserByPhoneNumber(String phone)
    {
        List<User> userList = new ArrayList<>(users.values());
        return userList.stream().filter(p -> p.getPhone().contains(phone)).collect(Collectors.toList());
    }
    public List<Trader> searchTraderByPhoneNumber(String phone)
    {
        List<Trader> traderList = new ArrayList<>(traders.values());
        return traderList.stream().filter(p -> p.getPhone().contains(phone)).collect(Collectors.toList());
    }
    public List<Company> searchCompanyByAddress(String address)
    {
        List<Company> companyList = new ArrayList<>(companies.values());
        return companyList.stream().filter(p -> p.getAddress().contains(address)).collect(Collectors.toList());
    }
    public List<Order> filterOrderByDate(Date date)
    {
        List<Order> orderList = new ArrayList<>(orders.values());
        return orderList.stream().filter(p -> p.getDate().equals(date)).collect(Collectors.toList());
    }
    public List<Order> filterOrderByTraderID(Integer traderID)
    {
        List<Order> orderList = new ArrayList<>(orders.values());
        return orderList.stream().filter(p -> p.getTraderID().equals(traderID)).collect(Collectors.toList());
    }
    public List<Order> filterOrderByType(boolean type)
    {
        List<Order> orderList = new ArrayList<>(orders.values());
        return orderList.stream().filter(p -> p.getType().equals(type)).collect(Collectors.toList());
    }
    public List<Order> filterOrderByStockID(Integer stockID)
    {
        List<Order> orderList = new ArrayList<>(orders.values());
        return orderList.stream().filter(p -> p.getStockID().equals(stockID)).collect(Collectors.toList());
    }
    public List<Stock> filterStockByCompany(Integer companyID)
    {
        List<Stock> stockList = new ArrayList<>(stocks.values());
        return stockList.stream().filter(p -> p.getCompanyID().equals(companyID)).collect(Collectors.toList());
    }
    public List<Transaction> filterTransactionByDate(Date date)
    {
        List<Transaction> transactionList = new ArrayList<>(transactions.values());
        return transactionList.stream().filter(p -> p.getDate().equals(date)).collect(Collectors.toList());
    }
    public List<Transaction> filterTransactionByStockID(Integer stockID)
    {
        List<Transaction> transactionList = new ArrayList<>(transactions.values());
        return transactionList.stream().filter(p -> p.getStockID().equals(stockID)).collect(Collectors.toList());
    }
}
