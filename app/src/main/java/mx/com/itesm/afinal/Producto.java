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

    private String idProducto ="";
    private String modeloProducto ="";
    private String precioProducto ="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_producto);



        idProducto = getIntent().getExtras().getString("producto_id");
        modeloProducto = getIntent().getExtras().getString("modelo");
        precioProducto = getIntent().getExtras().getString("precio");

        etProducto = (TextView) findViewById(R.id.textViewProducto);
        etPrecio = (TextView) findViewById(R.id.textViewPrecio);

        botonComprar = (ButtonRectangle) findViewById(R.id.buttonComprar);
        botonReparar = (ButtonRectangle) findViewById(R.id.buttonReparar);

        etProducto.setText(modeloProducto);
        etPrecio.setText("$"+precioProducto);

        Toast.makeText(getApplicationContext(),"ID: " + idProducto, Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(),"Producto: " + modeloProducto, Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(),"Precio: " + precioProducto, Toast.LENGTH_SHORT).show();


        botonComprar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"Producto Agregado a Carrito", Toast.LENGTH_LONG).show();
            }

        });

        botonReparar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"Precio Reparacion: $3400", Toast.LENGTH_LONG).show();
            }

        });


    }
}
