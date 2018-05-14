package mx.com.itesm.afinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.gc.materialdesign.views.ButtonRectangle;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.HashMap;
import java.util.Map;

public class Dueno extends AppCompatActivity {

    //Usuario
    private MaterialEditText etUsername;
    private MaterialEditText etPassword;
    //Cliente
    private MaterialEditText etNombre;
    private MaterialEditText etApellidoP;
    private MaterialEditText etApellidoM;
    private MaterialEditText etIFE;
    private MaterialEditText etTel;
    private MaterialEditText etDireccion;

    private ButtonRectangle botonBorrar;

    //String URL_POST = "http://ubiquitous.csf.itesm.mx/~pddm-1022009/ServiciosProyecto/servicio.usuarios.create.php?username=cliente7&password=cliente7&nivel=4";
    String URL_POST = "http://ubiquitous.csf.itesm.mx/~pddm-1022009/ServiciosProyecto/servicio.usuarios.delete.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dueno);

        etUsername = (MaterialEditText) findViewById(R.id.editTextUsuario1);
        etPassword = (MaterialEditText) findViewById(R.id.editTextPassword1);
        etNombre = (MaterialEditText) findViewById(R.id.editTextNombre1);
        etApellidoP = (MaterialEditText) findViewById(R.id.editTextApellidoP1);
        etApellidoM = (MaterialEditText) findViewById(R.id.editTextApellidoM1);
        etIFE = (MaterialEditText) findViewById(R.id.editTextIFE1);
        etApellidoP = (MaterialEditText) findViewById(R.id.editTextTel1);
        etDireccion = (MaterialEditText) findViewById(R.id.editTextDireccion1);
        botonBorrar = (ButtonRectangle) findViewById(R.id.buttonRegistrar1);

        botonBorrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                borrarUsuarioPOST(etUsername.getText().toString(),etPassword.getText().toString());
            }

        });

    }

    private void borrarUsuarioPOST(String username, String password)
    {

        String URL_PARAMS = URL_POST + "?username=" + username + "&password=" + password;
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_PARAMS, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplication(),response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Dueno.this,error+"", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                String nivel = "5";
                if(username.contains("cliente"))
                    nivel = "4";
                if(username.contains("vendedor"))
                    nivel = "3";
                //params.put("username",username);
                //params.put("password",password);
                //params.put("nivel",nivel);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
