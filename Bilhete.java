package projetopoo;

import java.io.Serializable;


public class Bilhete implements Serializable{
    
    private double custo;
    private String NomeComprador;

    
    public Bilhete(double custo, String NomeComprador){
        this.NomeComprador = NomeComprador;
        custo= 0;
    }
    
    public double getCusto(){       return custo;       }

    public void setCusto(double custo){     this.custo = custo;     }


    public String getNomeComprador(){   return NomeComprador;   }

    public void setNomeComprador(String NomeComprador){     this.NomeComprador = NomeComprador;     }
    
    public Object clone(){
        
        Bilhete X = new Bilhete(this.custo, this.NomeComprador);
        
        return X;
    }
    
    
}
