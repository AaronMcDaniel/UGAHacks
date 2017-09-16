package tiffanyxhsieh.android.restaurant;

import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import static android.media.CamcorderProfile.get;
import static tiffanyxhsieh.android.restaurant.MainActivity.restaurant;

public class TableOverviewAdapter extends ArrayAdapter<Table> {

    private ArrayList<Table> tableList;
    public static ArrayList<EditText> inputs=new ArrayList<>();

    public TableOverviewAdapter(Context context, int textViewResourceID, ArrayList<Table> tableList) {
        super(context, textViewResourceID, tableList);

    }


    public View getView(int position, View convertView, ViewGroup parent) {
        Log.w("W", "creating View");
        View v = convertView;

        if (v == null) {
            LayoutInflater vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.listrow, null);
        }

        Table table = getItem(position);

        if (table != null) {
            //change edit text to TextView
            TextView tablenumber = (TextView) v.findViewById(R.id.tablenum);
            TextView input = (TextView) v.findViewById(R.id.editText);
            if(MainActivity.restaurant.layout[position].isOccupied){
                tablenumber.setBackgroundColor(234);
                input.setBackgroundColor(234);
            }
            else{
                tablenumber.setBackgroundColor(2000);
                input.setBackgroundColor(2000);
            }

            if (tablenumber != null) {
                tablenumber.setText("Table " + (position + 1));
            }

            if (input != null) {
                input.setText(""+MainActivity.restaurant.layout[position].size); //Find a way to make this bit work, or keep all references of the
                //auto-generated textfields in one collection.
            }

        }

        return v;

    }



}


