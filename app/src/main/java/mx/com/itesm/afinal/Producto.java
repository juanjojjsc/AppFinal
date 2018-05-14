package mx.com.itesm.afinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.gc.materialdesign.views.ButtonRectangle;
import com.rengwuxian.materialedittext.MaterialEditText;

public class Producto extends AppCompatActivity {


    private TextView etProducto;
    private ButtonRectangle botonComprar;
    private TextView etPrecio;
    private ButtonRectangle botonReparar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_producto);


        etProducto = (TextView) findViewById(R.id.textViewProducto);
        etPrecio = (TextView) findViewById(R.id.textViewPrecio);

        botonComprar = (ButtonRectangle) findViewById(R.id.buttonComprar);
        botonReparar = (ButtonRectangle) findViewById(R.id.buttonReparar);


        botonComprar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"Producto Arreglado", Toast.LENGTH_LONG).show();
            }

        });

        botonComprar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"Precio: $3400", Toast.LENGTH_LONG).show();
            }

        });


    }
}
