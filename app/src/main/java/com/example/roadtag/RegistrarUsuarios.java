package com.example.roadtag;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class RegistrarUsuarios extends AppCompatActivity {

    //Inputs
    EditText etextNombre, etextApellido, etextEmail, etextContrasenia, etextContraseniaC;
    Spinner sEmpresa;
    CheckBox cboxTerminos;
    Button btnRegistrarUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuarios);

        //Ocultando barra de herramientas
        this.getSupportActionBar().hide();

        //Pareando
        etextNombre = findViewById(R.id.etextNombre);
        etextApellido = findViewById(R.id.etextApellido);
        etextEmail = findViewById(R.id.etextEmail);
        etextContrasenia = findViewById(R.id.etextContrasenia);
        etextContraseniaC = findViewById(R.id.etextContraseniaC);

        sEmpresa = findViewById(R.id.sEmpresas);

        cboxTerminos = findViewById(R.id.cboxTerminos);

        btnRegistrarUsuario = findViewById(R.id.btnRegistrarUsuario);

        //Acción del botón para registrar
        btnRegistrarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Si está listo para hacer el registro
                if(estanListosEdittexts(etextNombre, etextApellido, etextEmail, etextContrasenia, etextContraseniaC)
                && estaContraseniaConfirmada() && estanCondicionesAceptadas()){
                    //Lo realizamos con el método, pasando url local y el archivo .php del servicio
                    ejecutarServicio("http://10.0.0.13:80/roadtag/insertar_usuario.php");
                }
            }
        });

    }

    //Comprueba edittexts
    private boolean estanListosEdittexts(EditText ...edittexts){
        for(EditText e:edittexts){
            if(e.getText().toString().isEmpty() || e.getText().toString().equals("")){
                return false;
            }
        }
        return true;
    }

    //Comprueba el checbkox
    private boolean estanCondicionesAceptadas(){
        return cboxTerminos.isChecked();
    }

    //Comprueba si las contraseñas coinciden
    private boolean estaContraseniaConfirmada(){
        return etextContrasenia.getText().toString().equals(etextContraseniaC.getText().toString());
    }

    //Hace el registro en la base de datos
    private void ejecutarServicio(String URL){
        //Si es exitoso
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(RegistrarUsuarios.this, "Conectado al servidor", Toast.LENGTH_SHORT).show();
            }
            //Si arroja un error en la conexión
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(RegistrarUsuarios.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            //Mandando datos en hashmap para usar un POST a la bdd
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                //Objeto map para asignar clave y valor
                Map<String, String> parametros = new HashMap<String, String>();
                //Asignando
                parametros.put("nombre", etextNombre.getText().toString());
                parametros.put("apellido", etextApellido.getText().toString());
                parametros.put("email", etextEmail.getText().toString());
                parametros.put("contrasenia", etextContrasenia.getText().toString());
                parametros.put("empresa", sEmpresa.getSelectedItem().toString());
                //Retorno de estos para que se manden por POST
                return parametros;
            }
        };

        //Haciendo nueva fila de peticiones
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        //Agregandola
        requestQueue.add(stringRequest);
    }
}