package com.example.duda.trabalho;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SegundaTela extends AppCompatActivity {
    ListView listView ;
    Voo[] listaDeVoos;
    Activity atividade;
    public final static String VOOSELECIONADO = "br.usjt.VOOSELECIONADO";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);
        atividade = this;

        Especialista especialista= new Especialista();

        Intent intent = getIntent();
        String origem = intent.getStringExtra(Principal.ORIGEM);
        String destino = intent.getStringExtra(Principal.DESTINO);

        listaDeVoos = especialista.lista(origem, destino).toArray(new Voo[0]);
        String[] lista = null;

            lista = new String[listaDeVoos.length];

            for (int i = 0; i < listaDeVoos.length; i++) {
                lista[i] = listaDeVoos[i].getHorario();
            }

    listView = (ListView)findViewById(R.id.view_lista_cerveja);
    BaseAdapter adapter;
    adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1, lista);
    listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent intent = new Intent(atividade, DetalheActivity.class);
                intent.putExtra(VOOSELECIONADO, listaDeVoos[position]);
                startActivity(intent);
            }

        });

    };

}
