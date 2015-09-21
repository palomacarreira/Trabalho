package com.example.duda.trabalho;

import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by DUDA on 20/09/2015.
 */


public class Especialista {
    public static final ArrayList<Voo> voos = cadastroVoos();


    private Voo buscarNome(String nome) {
        for (Voo passagem : voos) {
            if (nome.equals(passagem.getOrigem())) {
                return passagem;
            }
        }
        return null;
    }
    public TreeSet<Voo> lista(String origem, String destino)
    {
        TreeSet<Voo> array = new TreeSet<>();
        if(destino.length() > 0 && origem.length() > 0)
        {
            array = buscaTodas(origem, destino);
        }
        else if(destino.length() > 0)
        {
            array = buscaDestino(destino);
        }else if(origem.length() > 0)
        {
            array = buscaOrigem(origem);
        }

        return array;
    }

    public TreeSet<Voo> buscaTodas(String origem, String destino){
        TreeSet<Voo> lista = new TreeSet<Voo>();
        for(Voo array : voos)
        {
            if(origem.equals(array.getOrigem()) && destino.equals(array.getDestino()))
                lista.add(array);
        }
        return lista;
    }


    public TreeSet<Voo> buscaDestino(String destino){
        TreeSet<Voo> lista = new TreeSet<Voo>();
        for(Voo array : voos)
        {
            if(destino.equals(array.getDestino()))
                lista.add(array);
        }
        return lista;
    }


    public TreeSet<Voo> buscaOrigem(String origem){
        TreeSet<Voo> lista = new TreeSet<Voo>();
        for(Voo array : voos)
        {
            if(origem.equals(array.getOrigem()))
                lista.add(array);
        }
        return lista;
    }

    private static ArrayList<Voo> cadastroVoos(){
        ArrayList<Voo> cadaVoo = new ArrayList<>();
        cadaVoo.add(new Voo("São Paulo","Rio","11hrs","foto01"));
        cadaVoo.add(new Voo("São Paulo","Rio","12hrs","foto01"));
        cadaVoo.add(new Voo("São Paulo","Brasilia","13hrs","foto02"));
        cadaVoo.add(new Voo("São Paulo", "Fortaleza", "23hs","foto03"));
        cadaVoo.add(new Voo("São Paulo", "Fortaleza", "15hs","foto03"));
        cadaVoo.add(new Voo("São Paulo", "Fortaleza", "21hs","foto03"));
        cadaVoo.add(new Voo("São Paulo", "Fortaleza", "18hs","foto03"));
        return cadaVoo;
    }
}
