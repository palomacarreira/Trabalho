package com.example.duda.trabalho;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    Spinner spinnerOrigem;
    Spinner spinnerDestino;
    String origem = "";
    String destino = "";
    Button botão;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        spinnerDestino = (Spinner) findViewById(R.id.spinnerDestino);
        spinnerDestino.setOnItemSelectedListener(new DestinoSelecionado());
        spinnerOrigem = (Spinner) findViewById(R.id.spinnerOrigem);
        spinnerOrigem.setOnItemSelectedListener(new OrigemSelecionada());
        botão = (Button) findViewById(R.id.button);
    }

    private class OrigemSelecionada implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            origem = (String) parent.getItemAtPosition(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private class DestinoSelecionado implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            destino = (String) parent.getItemAtPosition(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // constante static para identificar a mensagem
    public final static String ORIGEM = "br.usjt.ORIGEM";
    public final static String DESTINO = "br.usjt.DESTINO";

    //será chamado quando o usuário clicar em enviar
    public void consultar(View view) {

        String pOrigem = this.origem.equals("Escolha a origem") ? "" : origem;
        String pDestino = this.destino.equals("Escolha o destino") ? "" : destino;

        Intent intent = new Intent(Principal.this, SegundaTela.class);
        intent.putExtra(ORIGEM, pOrigem);
        intent.putExtra(DESTINO, pDestino);
        startActivity(intent);

    }
}
