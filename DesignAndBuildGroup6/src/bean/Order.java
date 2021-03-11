package bean;

public class Order {
    private Integer orderID;
    private String clientID;

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", clientID='" + clientID + '\'' +
                '}';
    }

    public Order(Integer orderID, String clientID) {
        this.orderID = orderID;
        this.clientID = clientID;
    }
    public Order() {
    }
}
