package mx.com.itesm.afinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.gc.materialdesign.views.ButtonRectangle;

public class Venta extends AppCompatActivity {


    private String myID ="";
    private String myFecha="";
    private String myCantidad ="";
    private String myProducto ="";
    private String myCliente ="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_venta);


        myID = getIntent().getExtras().getString("venta_producto_id");
        myFecha = getIntent().getExtras().getString("fecha_venta");
        myCantidad = getIntent().getExtras().getString("cantidad");
        myProducto = getIntent().getExtras().getString("producto_id");
        myCliente = getIntent().getExtras().getString("cliente_id");



        Toast.makeText(getApplicationContext(),"ID: " + myID, Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(),"Fecha: " + myFecha, Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(),"Cantidad: " + myCantidad, Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(),"Producto: " + myProducto, Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(),"Cliente: " + myCliente, Toast.LENGTH_SHORT).show();



    }
}
