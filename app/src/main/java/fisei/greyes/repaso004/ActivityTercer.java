package fisei.greyes.repaso004;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ActivityTercer extends AppCompatActivity {

    private ListView listView_datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tercer_activity);

        listView_datos = findViewById(R.id.listViewDatos);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                cargarListVire());

        listView_datos.setAdapter(adapter);

        listView_datos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemSeleccionado = (String)listView_datos.getAdapter().getItem(position);
                Intent intent = new Intent();
                intent.setData(Uri.parse(itemSeleccionado));
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }

    private List<String> cargarListVire() {
        List<String> list = new ArrayList<>();
        for (int i=1;i<=20;i++)
        {
            String item = "Numero # "+i;
            list.add(item);
        }
        return list;
    }
}