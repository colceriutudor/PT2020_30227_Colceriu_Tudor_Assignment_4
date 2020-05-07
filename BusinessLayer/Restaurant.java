package BusinessLayer;
import PresentationLayer.IRestaurantProcessing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Restaurant {
    private static Map<Order,ArrayList<MenuItem>> restaurant;
    private String restaurantName;
    public Restaurant(String restaurantName){
        this.restaurantName = restaurantName;
        this.restaurant = new HashMap<>();
    }

    public static void addItem(Order order, ArrayList<MenuItem> orderedItems){
        restaurant.put(order, orderedItems);
    }
    public static void addItemByName(Order order, ArrayList<String> orderedItems){
        ArrayList<MenuItem> menuItems = new ArrayList<>();
        for (String name :orderedItems) {
            menuItems.add(CompositeProduct.getItem(name));
        }
        addItem(order,menuItems);
    }
    public static void tableTotal(Order order){
        if(restaurant.containsKey(order)){
            order.setOrderTotal(0); //reset it (evita suprascriere)
            for (Map.Entry<Order, ArrayList<MenuItem>> entry : restaurant.entrySet()) {
                if(entry.getKey().getTable() == order.getTable()){
                    for (MenuItem item:entry.getValue()) {
                        order.setOrderTotal(order.getOrderTotal() + item.computePrice());
                    }
                }
            }
        }
    }
    public static int tableTotalbyNumber(int table){
        int total = 0;
            for (Map.Entry<Order, ArrayList<MenuItem>> entry : restaurant.entrySet()) {
                if(entry.getKey().getTable() == table){
                    tableTotal(entry.getKey());
                    total = entry.getKey().getOrderTotal();
                    break;
                }
            }
        return total;
    }
    public static String getTableItems(int table){
        String tableItems="";
            for (Map.Entry<Order, ArrayList<MenuItem>> entry : restaurant.entrySet()) {
                if(entry.getKey().getTable() == table){
                    for (MenuItem item:entry.getValue()) {
                        tableItems += item.getName() + ", ";
                    }
                }
            }
        return tableItems;
    }
    public static String displayCheck(int tableNumber){
        String message = null;
        for (Map.Entry<Order, ArrayList<MenuItem>> entry : restaurant.entrySet()) {
            if(entry.getKey().getTable() == tableNumber){
                tableTotal(entry.getKey());
                    message = entry.getKey().toString() + " containing: " + getTableItems(entry.getKey().getTable()) +
                            "\nTOTAL: " + entry.getKey().getOrderTotal() + "RON\n"
                            + "Billing date " + entry.getKey().getDate();
            }
        }
        return message;
    }
    public static Map<Order,ArrayList<MenuItem>> getDB(){ return restaurant; }
    public static void start(){
        IRestaurantProcessing mainFrame = new IRestaurantProcessing();
        mainFrame.setVisible(true);
    }
}
