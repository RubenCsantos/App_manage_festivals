package projetopoo;

import java.io.Serializable;
import java.util.Objects;

public class Musica implements Serializable {
    
    private String nome;
    private int minutos;
    private int segundos;

    public Musica(String nome, int minutos, int segunndos) {
        this.nome = nome;
        this.minutos = minutos;
        this.segundos = segunndos;
    }

    public String getNome(){    return nome;    }

    public void setNome(String nome){   this.nome = nome;   }

    public int getMinutos(){    return minutos;     }

    public void setMinutos(int minutos){    this.minutos = minutos;     }

    public int getSegundos(){  return segundos;  }

    public void setSegundos(int segunndos){    this.segundos = segundos;     }

    public String toString() {      return  "Nome Música: " + nome + "\tDuração: " + minutos + ":" + segundos;     }
    
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Musica other = (Musica) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (this.minutos != other.minutos) {
            return false;
        }
        if (this.segundos != other.segundos) {
            return false;
        }
        return true;
    }
    
    public Musica clone(){
        
        Musica X = new Musica(this.nome, this.minutos, this.segundos);
        
        return X;
    }
    
   
    
    
    
    
    
}
