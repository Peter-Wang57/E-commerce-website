package bean;

public class OrderItem {
    private Integer orderID;
    private String productID;
    private Integer number;
    private float price;
    private String productname;

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
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

    public String getProducname() {
        return productname;
    }

    public void setProducname(String producname) {
        this.productname = producname;
    }

    public OrderItem(Integer orderID, String productID, Integer number, float price, String producname) {
        this.orderID = orderID;
        this.productID = productID;
        this.number = number;
        this.price = price;
        this.productname = producname;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderID=" + orderID +
                ", productID='" + productID + '\'' +
                ", number=" + number +
                ", price=" + price +
                ", producname='" + productname + '\'' +
                '}';
    }

    public OrderItem() {

    }
}
