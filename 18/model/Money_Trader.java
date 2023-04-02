package company.model;

public class Money_Trader {
    int idTrader;
    int money;

    public Money_Trader(int idTrader, int money) {
        this.idTrader = idTrader;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Money_Trader{" +
                "idTrader=" + idTrader +
                ", money=" + money +
                '}';
    }
}
