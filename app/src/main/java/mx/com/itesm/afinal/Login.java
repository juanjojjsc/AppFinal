package mx.com.itesm.afinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gc.materialdesign.views.ButtonRectangle;

public class Login extends AppCompatActivity {

    ButtonRectangle botonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        botonLogin = (ButtonRectangle) findViewById(R.id.buttonLogin);


        botonLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent actividad = new Intent(Login.this, Cliente.class);
                startActivity(actividad);

            }

        });
    }
}
