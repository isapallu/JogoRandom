package com.example.jogorandom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText entrada;
    TextView saida;
    int numeroGerado = 0;
    int tentativas = 0;
    Random gerador = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        entrada = findViewById(R.id.entrada);
        saida = findViewById(R.id.saida);
    }
    public void gerar(View v){
        tentativas = 0;
        numeroGerado = gerador.nextInt(100)+1;
    }
    public void confirmar(View v){
        tentativas ++;
        String mensagem = " ";
        int digito = Integer.parseInt(entrada.getText().toString());
        if(tentativas == 5){
            mensagem = "Suas tentativas se esgotaram!\nO número era "+numeroGerado+".";
        }else{if(digito>numeroGerado){
            mensagem = "O número gerado é menor!\nVocê ainda tem "+(5-tentativas)+" tentativas.";
        } else if(digito<numeroGerado){
            mensagem = "O número gerado é maior!\nVocê ainda tem "+(5-tentativas)+" tentativas.";
        }else{
            mensagem = "Parabéns, você acertou!\nForam gastas "+(5-tentativas)+" tentativas.";
        }}
        saida.setText(mensagem);

    }
}