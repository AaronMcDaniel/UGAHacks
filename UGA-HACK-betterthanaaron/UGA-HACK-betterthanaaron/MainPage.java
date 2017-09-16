package tiffanyxhsieh.android.restaurant;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);



        TextView seating = (TextView) findViewById(R.id.seatingField);
        seating.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent numbersIntent = new Intent(MainPage.this, PeoplePrompt.class);
                startActivity(numbersIntent);

            }
        });
    }}
