package BusinessLayer;

public class BaseProduct extends MenuItem{
    private String name;
    private int price;

    public BaseProduct(String name, int price){
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {this.name = name;}
    public void setPrice(int price) {this.price = price;}

    public String toString() {
        return this.name;
    }
    public int computePrice() {
        return this.price;
    }
    public String getName() {
        return name;
    }
}
