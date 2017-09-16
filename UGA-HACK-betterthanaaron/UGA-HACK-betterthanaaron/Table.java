package tiffanyxhsieh.android.restaurant;

import static android.R.attr.order;

public class Table {

    public int size;
    public int[]order;
    public double totalPrice;
    public boolean isOccupied;


    public Table(int size) {

        order = new int[Restaurant.getMenu().length];
        this.size = size;
        totalPrice = 0;
        isOccupied = false;

    }

    public void takeOrder(Item food) {
        for (int i = 0; i < Restaurant.getMenu().length; i++) {

                if (Restaurant.menu[i].getName().equals(food.getName())) {
                    order[i]++;
                    totalPrice += food.getPrice();
                }






        }
    }
    public int getSize () {
        return size;
    }
}


