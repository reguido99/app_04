package fisei.greyes.repaso004;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivitySegunda extends AppCompatActivity {

    private TextView textView_mensaje;
    private Button button_visualizar;
    private int codigoRequerido = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_activity);

        textView_mensaje = findViewById(R.id.textViewMensaje);
        button_visualizar = findViewById(R.id.buttonVisualizar);

        Bundle bundle = getIntent().getExtras();
        String usuario = bundle.getString("parametro_usuario");
        String clave = bundle.getString("parametro_clave");

        textView_mensaje.setText("Datos recuperados: "+usuario+" "+clave);

    }

    public void OnclickMostrar(View view)
    {
        Intent intent = new Intent(this,ActivityTercer.class);
        startActivityForResult(intent,codigoRequerido);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if((requestCode == codigoRequerido) && (resultCode ==RESULT_OK))
        {
            textView_mensaje.setText("eligio el item: "+data.getDataString());
        }else{
            Toast.makeText(this,"Error encontrado",Toast.LENGTH_SHORT).show();
        }
    }
}