package mz.ac.isutc.i33.deggusta_pocket;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import mz.ac.isutc.i33.deggusta_pocket.databinding.ActivityTelaLoginBinding;

public class TelaLogin extends AppCompatActivity {


    private ActivityTelaLoginBinding binding ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTelaLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tvCriar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TelaLogin.this,
                        TelaCadastro.class));
            }
        });
    }
}