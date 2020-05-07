package DataLayer;

import BusinessLayer.Restaurant;

import java.io.*;

public class RestaurantSerialization {

    public RestaurantSerialization()  {
    }

    public void serialize(String filename, Restaurant restaurant) {
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(restaurant);

            out.close();
            file.close();

        } catch (IOException ex) {
            System.out.println("ser");
        }
    }

    public Restaurant deserialize(String serFile) {
        try {
            FileInputStream file = new FileInputStream(serFile);
            ObjectInputStream in = new ObjectInputStream(file);

            Restaurant restaurant = (Restaurant) in.readObject();
            in.close();
            file.close();
            return restaurant;
        } catch (IOException ex) {
            System.out.println("deser");
            return null;
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
            return null;
        }
    }
}
