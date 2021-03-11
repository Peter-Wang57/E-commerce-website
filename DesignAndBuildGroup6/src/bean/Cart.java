package bean;

public class Cart {
    private String clientID;
    private Integer productID;
    private Integer number;
    private float price;

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "clientID='" + clientID + '\'' +
                ", productID=" + productID +
                ", number=" + number +
                ", price=" + price +
                '}';
    }

    public Cart(String clientID, Integer productID, Integer number, float price) {
        this.clientID = clientID;
        this.productID = productID;
        this.number = number;
        this.price = price;
    }
    public Cart() {

    }
}
