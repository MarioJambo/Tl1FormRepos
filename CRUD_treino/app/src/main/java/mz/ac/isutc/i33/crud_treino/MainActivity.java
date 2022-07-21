package mz.ac.isutc.i33.crud_treino;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase bancoDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        criarBancoDados();
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

    private void listarDados() {

    }
}