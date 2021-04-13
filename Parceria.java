
package projetopoo;

import java.util.Objects;
import java.io.*;


public class Parceria implements Serializable {
    private String nome;
    private double valor_fornecido;

    public Parceria(String nome, double valor_fornecido) {
        this.nome = nome;
        this.valor_fornecido = valor_fornecido;
    }

    public String getNome(){    return nome;    }

    public void setNome(String nome){   this.nome = nome;   }

    public double getValor_fornecido(){     return valor_fornecido;     }

    public void setValor_fornecido(double valor_fornecido){     this.valor_fornecido = valor_fornecido;     }

    public String toString(){   return "Nome da Parceria: " + nome + "\nMontante fornecido: " + valor_fornecido;    }

    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Parceria other = (Parceria) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valor_fornecido) != Double.doubleToLongBits(other.valor_fornecido)) {
            return false;
        }
        return true;
    }
    
    public Object clone(){
        
        Parceria X = new Parceria(this.nome, this.valor_fornecido);
        
        return X;
    }
    
    
    
    
}
