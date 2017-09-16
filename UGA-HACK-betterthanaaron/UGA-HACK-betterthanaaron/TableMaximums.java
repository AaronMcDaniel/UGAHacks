package tiffanyxhsieh.android.restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static tiffanyxhsieh.android.restaurant.MainActivity.finalTableNum;
import static tiffanyxhsieh.android.restaurant.MainActivity.restaurant;
import static tiffanyxhsieh.android.restaurant.MainActivity.test1;
import static tiffanyxhsieh.android.restaurant.R.id.table1max;
import static tiffanyxhsieh.android.restaurant.R.id.table2max;
import static tiffanyxhsieh.android.restaurant.R.id.table3max;
import static tiffanyxhsieh.android.restaurant.R.id.table4max;
import static tiffanyxhsieh.android.restaurant.R.id.table5max;
import static tiffanyxhsieh.android.restaurant.Restaurant.laySize;
import static tiffanyxhsieh.android.restaurant.TableListAdapter.inputs;

public class TableMaximums extends AppCompatActivity {

    /*
    public static int table1max;
    public static int table2max;
    public static int table3max;
    public static int table4max;
    public static int table5max;
    public static String test01;
    public static String test02;
    public static String test03;
    public static String test04;
    public static String test05;
    */

    private ArrayList<Table> table = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_list);

        for( int i = 0; i < laySize; i++ ){
            table.add(new Table(i));
        }

        final ListView listview = (ListView) findViewById(R.id.list);

        final TableListAdapter adapter = new TableListAdapter(this, R.layout.table_list, table);
        listview.setAdapter(adapter);


        Button toMenuSetup=(Button)findViewById(R.id.pleasecontinuetomenu);
        toMenuSetup.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
               // Log.d("M",""+table1max);
               int[] seats = processList();
                for (int i = 0; i<laySize; i++){
                    System.out.println("*******************************************\n"+seats[i]);
                    restaurant.layout[i] = new Table (seats[i]);
                }



             Intent MainPage=new Intent(TableMaximums.this,MainPage.class);
              startActivity(MainPage);
            }
        });

    }

    public int[] processList() {
        int[] seats = new int[table.size()];
        for( int i = 0; i < table.size(); i++ ) {
            EditText input = inputs.get(i);
            seats[i] = (int)Integer.parseInt(input.getText().toString());
        }

        return seats;
    }

}
