package mz.ac.isutc.i33.tl1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaPessoas extends AppCompatActivity {

    private TextView nome, idade, sexo, Altura, Peso, Provincia, Deficiencia;

    private ArrayList<Pessoa> ArrayPessoas;
    private ArrayList<Pessoa> pessoas;
    private DbHelper db;
    private ListView listView;
    private PessoaAdapter pessoaAdapter;
    private AlertDialog alerta;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pessoas);
        nome = findViewById(R.id.tbNome);
        idade = findViewById(R.id.tbIdade);
        sexo = findViewById(R.id.tbGenero);
        Altura = findViewById(R.id.tbAltura);
        Peso = findViewById(R.id.tbPeso);
        Provincia = findViewById(R.id.tbProvincia);
        Deficiencia = findViewById(R.id.tbDificiencia);
        db = new DbHelper(this);
        listView = findViewById(R.id.ListViewPessoas);

        ArrayPessoas = new ArrayList<>();
        pessoas = new ArrayList<>();





        viewData();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                
            }
        });



    }

    private void viewData(){
        Cursor cursor = db.viewData();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "Não tem dados inseridos ", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                ArrayPessoas.add(cursor.getString(1));
            }
            pessoaAdapter = new PessoaAdapter(this, android.R.layout.simple_list_item_1,ArrayPessoas);
            listView.setAdapter(pessoaAdapter);

            pessoas.add(new Pessoa("Mario",1, "Maputo", "Masculino","Sim",24,1.90,
                    170));


            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Toast.makeText(getBaseContext(),i+"",Toast.LENGTH_LONG).show();

                    //Cria o gerador do AlertDialog
                    AlertDialog.Builder builder = new AlertDialog.Builder(getBaseContext());
                    //define o titulo
                    builder.setTitle("Confirmacao");
                    //define a mensagem
                    builder.setMessage("Deseja apagar o Usuário?");
                    //define um botão como positivo
                    builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            Toast.makeText(getBaseContext(), "Apagado com sucesso", Toast.LENGTH_SHORT).show();
                            pessoas.remove(pessoas.get(i));
//
                            //mostrar();
                        }
                    });
                    //define um botão como negativo.
                    builder.setNegativeButton("Nao", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            Toast.makeText(getBaseContext(), "Nao foi apagado", Toast.LENGTH_SHORT).show();
                        }
                    });
                    //cria o AlertDialog
                    alerta = builder.create();
                    //Exibe
                    alerta.show();
                }

            });

        }
    }
}