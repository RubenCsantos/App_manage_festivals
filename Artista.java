package projetopoo;

import java.util.*;
import java.io.*;

public class Artista implements Serializable {

    private String nome;
    private ArrayList<Musica> setM;
    private int horas;
    private int minutos;
    private int segundos;
    private double custo;

    public Artista(String nome, ArrayList<Musica> set, double custo) {
        this.nome = nome;
        this.setM = (ArrayList<Musica>) set.clone();
        this.custo = custo;

        horas = 0;
        minutos = 0;
        segundos = 0;
    }

    public String getNome(){    return nome;    }   

    public void setNome(String nome){   this.nome = nome;   }

    public ArrayList<Musica> getSetM(){     return setM;    }

    public void setSetM(ArrayList<Musica> lista) {

        for (int i = 0; i < setM.size(); i++) {

            setM.set(i, lista.get(i));
        }

    }

    public int getHoras() {

        duracao();

        return horas;
    }

    public void setHoras(int horas){    this.horas = horas;     }

    public int getMinutos(){

        duracao();

        return minutos;
    }

    public void setMinutos(int minutos){    this.minutos = minutos;     }

    public int getSegundos() {

        duracao();

        return segundos;
    }

    public void setSegundos(int segundos){     this.segundos = segundos;   }

    public double getCusto(){   return custo;   }

    public void setCusto(double custo){     this.custo = custo;     }

    //METODO PARA MUDAR APENAS UMA MUSICA
    public void changeSetM(Object nv, int i) {

        if (nv != null && nv.getClass() == setM.get(i).getClass()) {

            Musica nV = (Musica) nv;

            setM.set(i, nV);
        } else {

            System.out.println("Erro!");
        }

        duracao();
    }

    //METODO PARA CALCULAR TEMPO DE ATUAÇÃO
    public double duracao() {

        int sec = 0, aux;

        for (int i = 0; i < setM.size(); i++) {

            sec += setM.get(i).getMinutos() * 60 + setM.get(i).getSegundos();
        }

        horas = sec / 3600;
        aux = sec % 3600;
        minutos = aux / 60;
        segundos = aux % 60;
     
        return sec;
    }

    public String toString() {

        String s = "";

        for (int i = 0; i < setM.size(); i++) {

            s += setM.get(i).toString() + "\n";
        }

        duracao();

        return "Artista: " + nome + "\nTempo de atuação: " + horas + ":" + minutos + ":" + segundos + "\nCusto: " + custo + "€" + "\nSet de músicas:\n" + s;
    }
    public Artista clone()
    {
            Artista X = new Artista(this.nome,this.setM,this.custo);
            X.horas = this.horas;
            X.minutos = this.minutos;
            X.segundos = this.segundos;
        
            return X;
    }
        
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Artista other = (Artista) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.setM, other.setM)) {
            return false;
        }
        if (this.horas != other.horas) {
            return false;
        }
        if (this.minutos != other.minutos) {
            return false;
        }
        if (this.segundos != other.segundos) {
            return false;
        }
        if (Double.doubleToLongBits(this.custo) != Double.doubleToLongBits(other.custo)) {
            return false;
        }
        return true;
    }

}
