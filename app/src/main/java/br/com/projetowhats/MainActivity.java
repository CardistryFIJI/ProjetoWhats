package br.com.projetowhats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText telefone;
    private TextInputEditText mensagem;
    private Button enviar;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        telefone = findViewById(R.id.textInputl_Telefone);
        mensagem = findViewById(R.id.textInput_Mensagem);
        enviar = findViewById(R.id.button_Enviar);

        enviar.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {

                        String cel = telefone.getText().toString();
                        String msg = mensagem.getText().toString();
                        msg = msg.replaceAll(" ", "%20");

                        Uri webpage = Uri.parse("https://wa.me/5541"+cel+"?text="+msg);
                        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

                    startActivity(webIntent);
                    }

        });
    }
}