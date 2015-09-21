package com.example.duda.trabalho;

import java.io.Serializable;

public class Voo implements Comparable<Voo>, Serializable {

    private String origem;
    private String destino;
    private String horario;
    private String imagem;

    public Voo(String origem, String destino, String horario, String imagem)
    {
        setOrigem(origem);
        setDestino(destino);
        setHorario(horario);
        setImagem(imagem);
    }
    public String getImagem() {
        return imagem;
    }

    public void setImagem(String img) {
        this.imagem = img;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String toString() {
        return "br.usjt.cursoandroid2015.aeronaveprojeto.Passagem{" +
                "origem='" + origem + '\'' +
                ", destino='" + destino + '\'' +
                ", horarioSaida='" + horario + '\'' +
                '}';
    }

    @Override
    //só funciona com o ultimo return pegando uma variavel que seria diferencial
    public int compareTo(Voo passagem) {
        if (origem.equals(passagem.getOrigem())
                && destino.equals(passagem.getDestino())
                && horario.equals(passagem.getHorario())) {
            return 0;
        }
        return this.getHorario().compareTo(passagem.getHorario());
    }
}
