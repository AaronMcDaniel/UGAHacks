package tiffanyxhsieh.android.restaurant;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Integer.parseInt;
import static java.util.logging.Logger.global;


public class MainActivity extends AppCompatActivity {

    public static String test1;
    public static int finalTableNum;
    public static  Restaurant restaurant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restauranttotaltablessetup);



        Button toTableMaxSetup=(Button)findViewById(R.id.buttonToTableMax);
        toTableMaxSetup.setOnClickListener(new View.OnClickListener() {



            public void onClick(View view) {
                EditText totalNumberOfTables=(EditText) findViewById(R.id.totaltables);
                test1=totalNumberOfTables.getText().toString();
                finalTableNum=Integer.parseInt(test1);

                 restaurant = new Restaurant(finalTableNum);

                Intent numbersIntent = new Intent(MainActivity.this, TableMaximums.class);
                startActivity(numbersIntent);



                 //   finalTableNum=Character.getNumericValue(test1.charAt(0));
            }


        });

    }




}





