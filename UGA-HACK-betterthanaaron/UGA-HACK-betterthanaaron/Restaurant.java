package tiffanyxhsieh.android.restaurant;

/**
 * Created by Tiffany on 11/5/16.
 */

public class Restaurant {
    public Table[] layout;
    public static Item[] menu;
    public static Party[] waitList;

    public static int laySize;

    final int DEFAULT_CAPACITY = 10;

    public Restaurant( int size ){
        layout=new Table[size];//of Tables
        menu=new Item[size];//of Items
        laySize=size;
    }

    public Restaurant(){
        layout = new Table[DEFAULT_CAPACITY];
        menu = new Item[DEFAULT_CAPACITY];
        laySize=DEFAULT_CAPACITY;
    }

    public void addTable(int num){
        Table[] temp=new Table[layout.length+1];
        boolean isAdded=false;
        if(layout.length==0){
            temp[0]=new Table(num);
        }
        else
        {
            for(int i=0;i<layout.length;i++){
                if(i==0&&layout.length>1&&layout[1].size>=num){
                    temp[i]=new Table(num);
                    isAdded=true;
                    temp[i+1]=layout[i];
                }
                else if(layout.length==1){
                    if(layout[0].size>=num){
                        temp[0]=layout[0];
                        temp[1]=new Table(num);
                    }
                    else{
                        temp[0]=new Table(num);
                        temp[1]=layout[0];

                    }

                }
                else if( i>0&&layout[i].getSize()>=num&&layout[i-1].getSize()<num){
                    temp[i]=new Table(num);
                    isAdded=true;
                    temp[i+1]=layout[i];
                }
                else if(!isAdded){
                    temp[i]=layout[i];


                    if(i==layout.length-1){
                        temp[i+1]=new Table(num);
                    }
                }
                else{
                    temp[i+1]=layout[i];
                }



            }
        }
        layout=temp;
    }
    //addmenu
    public void addMenu(String n, double pr, String kind){
        Item[] temp=new Item[1];
        boolean isAdded=false;

        if(menu.length == 0){
            temp[0] = new Item(n, pr, kind);
        }
        else
        {
            for(int i=0;i<temp.length;i++)
            {
                if(menu[i].getType().equalsIgnoreCase(kind)&&!isAdded)
                {
                    temp[i] = new Item(n, pr, kind);
                    isAdded = true;
                    temp[i+1] = menu[i];
                }
                else if(!isAdded)
                {
                    temp[i] = menu[i];
                    if(i == menu.length-1)
                    {
                        temp[i+1] = new Item(n, pr, kind);
                    }
                }
                else
                {
                    temp[i+1] = menu[i];
                }
            }
        }
    }



    public int sitParty(int pSize){
        for(int i = 0; i< layout.length; i++){
            if(layout[i].size>=pSize&&!layout[i].isOccupied){
                layout[i].isOccupied=true;
                return i+1;
            }
        }
        return -1;

    }

    public void partyLeft(int i){
        layout[i].isOccupied=false;
    }
    //finds table to sit in, and make table full
    //then returns table that is sitting




    public static Item[] getMenu(){
        return menu;
    }

    public class Party{
        int size;
        String name;
        public Party(int s, String n){
            size=s;
            name=n;
        }

    }
}




