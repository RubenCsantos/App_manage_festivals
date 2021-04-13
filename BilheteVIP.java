package projetopoo;

import java.io.Serializable;

public class BilheteVIP implements Serializable{
    
    
    private double custo;
    private String NomeComprador;

    
    public BilheteVIP(double custo,String NomeComprador){
        this.NomeComprador = NomeComprador;
        this.custo= custo;
    }

   
    public double getCusto(){      return custo;       }

    public void setCusto(double custo){     this.custo = custo;     }
    
    public String getNomeComprador(){       return NomeComprador;       }

    public void setNomeComprador(String NomeComprador){     this.NomeComprador = NomeComprador;     }
    
    public Object clone(){
        
        BilheteVIP X = new BilheteVIP(this.custo, this.NomeComprador);
        
        return X;
    }
    
}