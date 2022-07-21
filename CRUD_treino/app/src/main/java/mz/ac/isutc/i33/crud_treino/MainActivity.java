package mz.ac.isutc.i33.crud_treino;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase bancoDados;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listaDados);
        criarBancoDados();
        InserirDados();
        listarDados();
    }




    //Método que cria a tabela na base de dados
    private void criarBancoDados() {

        try{
            bancoDados  = openOrCreateDatabase("CrudApp",MODE_PRIVATE, null);
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas("  +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT"+", nome VARCHAR)");
            bancoDados.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void InserirDados() {
        try {
            bancoDados = openOrCreateDatabase("CrudApp", MODE_PRIVATE, null);
            String sql = "INSERT INTO pessoas (nome) VALUES(?)";
            SQLiteStatement statement = bancoDados.compileStatement(sql);
            statement.bindString(1, "Pessoa 1");
            statement.executeInsert();
            statement.bindString(1, "Pessoa 2");
            statement.executeInsert();
            statement.bindString(1, "Pessoa 3");
            statement.executeInsert();
            bancoDados.close();
    }catch (Exception e){
            e.printStackTrace();
        }
    }



    private void listarDados() {
        try {
            bancoDados = openOrCreateDatabase("CrudApp", MODE_PRIVATE, null);
            Cursor cursor = bancoDados.rawQuery("SELECT id, nome FROM pessoas",null);//Criação de cursor
            ArrayList <String> linhas = new ArrayList<>();
            ArrayAdapter <String>adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, linhas);
            listView.setAdapter(adapter);
            cursor.moveToFirst();
            while (cursor!=null){
                    linhas.add(cursor.getString(1));
                    cursor.moveToNext();
            }

        }catch (Exception exception){
            exception.printStackTrace();

        }
    }
}