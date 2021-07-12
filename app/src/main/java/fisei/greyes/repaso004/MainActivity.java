package fisei.greyes.repaso004;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText_usuario;
    private EditText editText_clave;
    private Button button_ingresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_clave = findViewById(R.id.editTextTextClave);
        editText_usuario = findViewById(R.id.editTextTextUser);
        button_ingresar = findViewById(R.id.btnIngresar);


    }
    public void OnclickInhresar(View view)
    {
        String user= editText_usuario.getText().toString();
        String password = editText_clave.getText().toString();

        if( !user.matches("")&& !password.matches(""))
        {
            Intent intent = new Intent(this,ActivitySegunda.class);
            intent.putExtra("parametro_usuario",user);;
            intent.putExtra("parametro_clave",password);
            startActivity(intent);

        }else{
            Toast.makeText(this,"Campos obligatorios",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //return super.onOptionsItemSelected(item);
        //int id = item.getItemId();
        switch (item.getItemId())
        {
            case R.id.menuAcercaDe:
                Toast.makeText(this,"Selecciono el menu Acerca de",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

}




