package tiffanyxhsieh.android.restaurant;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class PeoplePrompt extends AppCompatActivity {
    public static String test1;
    public static int partyNum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_prompt);
        final TextView ans = (TextView) findViewById(R.id.partyAnswer);
        Button buttonSitParty = (Button) findViewById(R.id.buttonSitParty);
        buttonSitParty.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                int ret = 0;
                EditText numberOfPeople = (EditText) findViewById(R.id.numberOfPeople);
                test1 = numberOfPeople.getText().toString();
                partyNum = Integer.parseInt(test1);
                ret =MainActivity.restaurant.sitParty(partyNum);

                if (ret>0){
                ans.setText("Table #"+ret);}

                else{
                    ans.setText("All tables are occupied. The party has been added to the waitlist.");
                }



                //partyAnswer.set


            }


        });


}}
