package BusinessLayer;

import java.util.ArrayList;

public class CompositeProduct extends MenuItem{
    public static ArrayList<MenuItem> menu = new ArrayList<>();
    private String name;
    public CompositeProduct(String name){
        this.name = name;
    }

    @Override
    public void addItem(MenuItem item) {
        menu.add(item);
    }

    public static void removeByName(MenuItem item){
        for (MenuItem menuItem:menu) {
            if(menuItem.getName().equals(item.getName()) && (menuItem.computePrice() == item.computePrice())){
                menu.remove(menuItem);
                break;
            }
        }
    }
    public static void updateItem(MenuItem item, MenuItem newItem){
        for (MenuItem menuItem:menu) {
            if(menuItem.getName().equals(item.getName()) && (menuItem.computePrice() == item.computePrice())){
                menuItem.setName(newItem.getName());
                menuItem.setPrice(newItem.computePrice());
            }
        }
    }

    public static MenuItem getItem(String name) {
        for (MenuItem menItem:menu) {
            if(menItem.getName().equals(name)){
                return menItem;
            }
        }
        return null;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPrice(int i) {
        super.setPrice(i);
    }
}
