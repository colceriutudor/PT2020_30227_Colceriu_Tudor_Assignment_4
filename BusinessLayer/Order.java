package BusinessLayer;

public class Order {
    private static int orderNo;
    private int orderID, table, orderTotal;
    private String date;
    public Order(int table, String date){
        orderNo++;
        this.orderID = orderNo;
        this.table = table;
        this.date = date;
    }
    @Override
    public int hashCode(){
        return table;
    }
    public int getTable() {return table;}
    public String getDate() {return date;}
    public int getOrderTotal() {return orderTotal;}
    public void setOrderTotal(int orderTotal) {this.orderTotal = orderTotal;}

    @Override
    public String toString() {
        return "Table: " + table;
    }
}
