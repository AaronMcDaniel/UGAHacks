package tiffanyxhsieh.android.restaurant;

import static android.R.attr.type;

public class Item
{
    private double price;
    private String name = "";
    private String type = ""; //MAKE ENUM

    public Item(String n, double pr, String kind){ //FIX WITH ENUMS
        name = n;
        price = pr;
        type = kind; // ENUM POR FAVOR
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public String getType(){
        return type;
    }

    public void setName(String nam){
        name = nam;
    }

    public void setPrice(int pric){
        price = pric;
    }
}

