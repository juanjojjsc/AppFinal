package mx.com.itesm.afinal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cliente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_cliente);

        final ListView listview = (ListView) findViewById(R.id.listViewCliente);
        String[] values = new String[] { "Intel Core i7 6600K",
        "Intel Core i5 3300",
        "Intel Core i3 2200",
        "HP Inkjet Laser 3000",
        "Lexmark LX Laser",
        "Canon Laser Rebel Pro",
        "ROG Predator WQHD 60Hz",
        "ROG Predator 4K 120Hz",
        "ROG Predator Curved 4K G-SYNC 144Hz",
        "Kingston SSD",
        "Kingston SSD",
        "Kingston SSD",
        "Tira LED 1m HoloRGB" };

        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }
        final StableArrayAdapter adapter = new StableArrayAdapter(this,
                android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);
                view.animate().setDuration(2000).alpha(1)
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(),"click", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(Cliente.this, Producto.class);
                                String producto = null;
                                i.putExtra("Producto1", producto);
                                startActivity(i);
                            }
                        });
            }

        });

    }

    private class StableArrayAdapter extends ArrayAdapter<String> {

        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

        public StableArrayAdapter(Context context, int textViewResourceId,
                                  List<String> objects) {
            super(context, textViewResourceId, objects);
            for (int i = 0; i < objects.size(); ++i) {
                mIdMap.put(objects.get(i), i);
            }
        }

        @Override
        public long getItemId(int position) {
            String item = getItem(position);
            return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

    }
}
