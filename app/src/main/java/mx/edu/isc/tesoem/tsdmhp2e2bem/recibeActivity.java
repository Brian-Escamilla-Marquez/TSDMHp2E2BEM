package mx.edu.isc.tesoem.tsdmhp2e2bem;


import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class recibeActivity extends AppCompatActivity {

    TextView lblnombre, lbledad, lblcorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recibe);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lblnombre = findViewById(R.id.lblnombre);
        lbledad = findViewById(R.id.lbledad);
        lblcorreo = findViewById(R.id.lblcorreo);

        // ✅ Obtener el objeto Parcelable
        Userdatos user = getIntent().getParcelableExtra("usuario");

        if (user != null) {
            lblnombre.setText(user.getNombre());
            lbledad.setText(String.valueOf(user.getEdad()));
            lblcorreo.setText(user.getCorreo());
        }
    }
}