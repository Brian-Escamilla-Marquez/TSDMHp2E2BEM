package mx.edu.isc.tesoem.tsdmhp2e2bem;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class principalActivity2 extends AppCompatActivity {

    EditText txtnombre, txtedad, txtcorreo;
    Button btenvia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_principal2);

        // Configuración de los márgenes para la barra de sistema (Edge to Edge)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicialización de los campos de entrada
        txtnombre = findViewById(R.id.txtnombre);
        txtedad = findViewById(R.id.txtedad);
        txtcorreo = findViewById(R.id.txtcorreo);
        btenvia = findViewById(R.id.btenvia);

        // Configuración del botón para enviar los datos
        btenvia.setOnClickListener(v -> {
            // Obtenemos los datos de los EditText
            String nombre = txtnombre.getText().toString().trim();
            String correo = txtcorreo.getText().toString().trim();
            String edadStr = txtedad.getText().toString().trim();

            // Verificamos que los campos no estén vacíos
            if (nombre.isEmpty() || correo.isEmpty() || edadStr.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                // Convertimos la edad a entero
                int edad = Integer.parseInt(edadStr);

                // Creamos el objeto Userdatos
                Userdatos userdatos = new Userdatos(nombre, correo, edad);

                // Creamos el Intent para pasar los datos a la siguiente actividad
                Intent intent = new Intent(principalActivity2.this, recibeActivity.class);

                // Enviamos el objeto Userdatos como Parcelable
                intent.putExtra("usuario", userdatos);

                // Iniciamos la actividad
                startActivity(intent);

                // Terminamos la actividad actual
                finish();

            } catch (NumberFormatException e) {
                // Si la edad no es válida, mostramos un mensaje de error
                Toast.makeText(this, "Edad inválida", Toast.LENGTH_SHORT).show();
            }
        });
    }
}