package mz.ac.isutc.i33.deggusta_pocket;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import mz.ac.isutc.i33.deggusta_pocket.databinding.ActivityTelaCadastroBinding;
import mz.ac.isutc.i33.deggusta_pocket.databinding.ActivityTelaLoginBinding;

public class TelaCadastro extends AppCompatActivity {

    private ActivityTelaCadastroBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        binding = ActivityTelaCadastroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TelaCadastro.this
                        , TelaLogin.class));
                Toast toast = Toast.makeText(getApplicationContext(), "Efectue um Login Com suas credenciais", Toast.LENGTH_SHORT);
                toast.show();

            }
        });

    }
}