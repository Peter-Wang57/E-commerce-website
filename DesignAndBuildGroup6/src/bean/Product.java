package bean;

public class Product {
    private Integer productID;
    private float price;
    private String productName;
    private String type1;
    private String Details;
    private Integer inventory;
    private String merchantID;
    private String type2;

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public String getMerchantID() {
        return merchantID;
    }

    public void setMerchantID(String merchantID) {
        this.merchantID = merchantID;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", price=" + price +
                ", productName='" + productName + '\'' +
                ", type1='" + type1 + '\'' +
                ", Details='" + Details + '\'' +
                ", inventory=" + inventory +
                ", merchantID='" + merchantID + '\'' +
                ", type2='" + type2 + '\'' +
                '}';
    }

    public Product(Integer productID, float price, String productName, String type1, String details, Integer inventory, String merchantID, String type2) {
        this.productID = productID;
        this.price = price;
        this.productName = productName;
        this.type1 = type1;
        Details = details;
        this.inventory = inventory;
        this.merchantID = merchantID;
        this.type2 = type2;
    }
    public Product() {
    }
}
