package com.example.duda.trabalho;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

public class DetalheActivity extends AppCompatActivity {
    TextView origemVoo;
    ImageView imagem;
    TextView destinoVoo;
    TextView horarioVoo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        Intent intent = getIntent();
        Serializable obj = intent.getSerializableExtra(SegundaTela.VOOSELECIONADO);
        Voo voo = (Voo)obj;
        setupViews(voo);

    }

    private void setupViews(Voo voo) {

        origemVoo = (TextView)findViewById(R.id.voo_origem);
        origemVoo.setText(voo.getOrigem());

        imagem = (ImageView)findViewById(R.id.voo_imagem);
        Drawable drawable = Util.getDrawable(this, voo.getImagem());
        imagem.setImageDrawable(drawable);

        destinoVoo = (TextView)findViewById(R.id.voo_destino);
        destinoVoo.setText(voo.getDestino());
        horarioVoo= (TextView)findViewById(R.id.txt_voo_horario);
        horarioVoo.setText(voo.getHorario());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detalhe, menu);
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
}
