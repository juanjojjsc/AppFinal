package mx.com.itesm.afinal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.gc.materialdesign.views.ButtonRectangle;
import com.gc.materialdesign.widgets.ProgressDialog;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cliente extends AppCompatActivity {



    private static final String url = "http://ubiquitous.csf.itesm.mx/~pddm-1022009/ServiciosProyecto/servicio.productos.index.php";


    private List<Object> list;                  //Lista de objetos del request
    private Gson gson;
    //private ProgressDialog progressDialog;
    private ListView catList;

    private Map<String,Object> mapCat;          //Mapa auxiliar para las categorías e ingresar a sus datos
    private String categories_IDs[];
    private String categories_Modelos[];
    private String categories_Precios[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_cliente);

        catList = (ListView) findViewById(R.id.listViewCliente);

        //progressDialog = new ProgressDialog(Cliente.this);
        //progressDialog.setMessage("Cargando datos...");
        //progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        //progressDialog.show();


        //String request de las categorías/
                StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Log.d("Categories", "Making the requests");


                gson = new Gson();
                list = (List) gson.fromJson(s, List.class);
                categories_IDs = new String[list.size()];
                categories_Modelos = new String[list.size()];
                categories_Precios = new String[list.size()];

                /*
                * Obtiene los nombres de las categorías elemento por elemento y los guarda en la lista de categorías
                * */
                for (int i=0; i < list.size(); ++i) {
                    mapCat = (Map<String, Object>)list.get(i);
                    categories_IDs[i] = (String) mapCat.get("modelo");
                    //categories_Modelos[i] = (String) mapCat.get("modelo");
                    //categories_Precios[i] = (String) mapCat.get("precio");
                }

                /*
                * Pone los nombres de la lista de categorías en el list view*/
                catList.setAdapter(new ArrayAdapter(Cliente.this, android.R.layout.simple_list_item_1, categories_IDs));
                //progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(Cliente.this, "Error", Toast.LENGTH_LONG).show();
            }
        });

        RequestQueue rQueue = Volley.newRequestQueue(Cliente.this);
        rQueue.add(request);

        /*
        * Cuando se toca un elemento de la categoría este manda a llamar a otra ctividad con el
        * numero de categoría de los autos a desplegar*/
       catList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               //Obtiene el id de la categoría y co combierte a Double para que pueda ser manejado en la siguiente actividad/
               //mapCat = (Map<String, Object>)list.get(position);
               String myID = (String)mapCat.get("producto_id");
               String myModelo = (String)mapCat.get("modelo");
               String myPrecio = (String)mapCat.get("precio");



               Intent intent = new Intent(getBaseContext(), Producto.class);
               intent.putExtra("producto_id", String.valueOf(myID));
               intent.putExtra("modelo", String.valueOf(myModelo));
               intent.putExtra("precio", String.valueOf(myPrecio));
               startActivity(intent);

               //Log.d("ALC", String.valueOf(s_catID));

               //Intent intent = new Intent(getApplicationContext(), Producto.class);
               //intent.putExtra("producto_id", String.valueOf(s_catID)); //Aqui manda el id de la categoría/
                       //startActivity(intent);

           }
       });







}}
