package ExecuteTasks;

import BusinessLayer.*;
import DataLayer.RestaurantSerialization;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

public class OpenRestaurant extends Observable {
    public static void main(String[] args) throws IOException {
        Restaurant restaurant;
        RestaurantSerialization serialization = new RestaurantSerialization();
        if(args.length != 0){
            restaurant = serialization.deserialize(args[0]);
        }
        else{
            restaurant = new Restaurant("PT cea mai buna mancare");
            initMeniu("Meniu TP");
            serialization.serialize("restaurant.ser",restaurant);
        }
        Restaurant.start();
    }
    private static void initMeniu(String numeMeniu){
        CompositeProduct menu = new CompositeProduct(numeMeniu);
        ArrayList<MenuItem> produseMeniu = new ArrayList<>();

        produseMeniu.add(new BaseProduct("supa cu legume",20));
        produseMeniu.add(new BaseProduct("gulas original", 35));
        produseMeniu.add(new BaseProduct("legume la gratar", 23));
        produseMeniu.add(new BaseProduct("salata cesar", 25));
        produseMeniu.add(new BaseProduct("cola",5));
        produseMeniu.add(new BaseProduct("apa plata",3));

        for (MenuItem item:produseMeniu) {
            menu.addItem(item);
        }
    }
}
