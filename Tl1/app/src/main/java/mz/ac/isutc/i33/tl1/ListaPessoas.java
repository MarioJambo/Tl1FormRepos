package mz.ac.isutc.i33.tl1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

public class ListaPessoas extends AppCompatActivity {

    private EditText nome, idade, sexo, Altura, Peso, Provincia, Deficiencia;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pessoas);
    }
}