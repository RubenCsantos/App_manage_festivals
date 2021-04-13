package projetopoo;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Objects;
import java.io.*;

public class Espetaculo implements Serializable {

    private LocalDate Data;
    private static int numeroSerie;
    private int nmrSerie;
    private String Nome;
    private String Local;
    private int nArtistas;
    private int capacidade_maximo;
    private double custoBilhete;
    private double custoBilheteVIP;
    private int bilhetesVendidosNormal;  //
    private int bilhetesVendidosVIP;  //
    private double montante; //
    private int horas_espetaculo;
    private int minutos_esptaculo;
    private int durH;
    private int durM;
    private double TotalCustoArtistas; //
    private ArrayList<Artista> Artistas; //
    private ArrayList<Parceria> Parcerias;
    private ArrayList<Bilhete> Bilhetes;
    private ArrayList<BilheteVIP> BilhetesVIP;
    private double lucro; //

    public Espetaculo(LocalDate Data, int nArtistas, String Nome, String Local, int capacidade_maximo, int horas_espetaculo, int minutos_esptaculo, int durH, int durM, ArrayList<Artista> Artistas, ArrayList<Parceria> Parcerias, double custoBilhete, double custoBilheteVIP, ArrayList<Bilhete> Bilhetes, ArrayList<BilheteVIP> BilhetesVIP) {
        this.nArtistas = nArtistas;
        this.Nome = Nome;
        this.Local = Local;
        this.capacidade_maximo = capacidade_maximo;
        this.horas_espetaculo = horas_espetaculo;
        this.minutos_esptaculo = minutos_esptaculo;
        this.durH = durH;
        this.durM = durM;
        this.Parcerias = (ArrayList<Parceria>)Parcerias.clone();//alteraddo
        this.Data = Data;
        this.custoBilhete = custoBilhete;
        this.custoBilheteVIP = custoBilheteVIP;

        this.bilhetesVendidosNormal = 0;
        this.bilhetesVendidosVIP = 0;
        this.lucro = 0;
        this.montante = 0;
        this.TotalCustoArtistas = 0;
        this.Artistas = (ArrayList<Artista>)Artistas.clone();//alterado
        this.Bilhetes = (ArrayList<Bilhete>)Bilhetes.clone();//alterado
        this.BilhetesVIP = (ArrayList<BilheteVIP>)BilhetesVIP.clone();//alterado
        numeroSerie += 1;
        this.nmrSerie = numeroSerie;
    }

    public Espetaculo(LocalDate d, String n, String l, double cB, double cBV, ArrayList<Artista> Artistas, ArrayList<Parceria> Parcerias, int h, int m) {
        this.Data = d;
        this.Nome = n;
        this.Local = l;
        this.custoBilhete = cB;
        this.custoBilheteVIP = cBV;
        this.Artistas = (ArrayList<Artista>)Artistas.clone();
        this.Parcerias = (ArrayList<Parceria>)Parcerias.clone();
        this.horas_espetaculo = h;
        this.minutos_esptaculo = m;
                
        this.nArtistas = 0;
        this.capacidade_maximo = 0;
        this.durH = 0;
        this.durM = 0;
        this.bilhetesVendidosNormal = 0;
        this.bilhetesVendidosVIP = 0;
        this.lucro = 0;
        this.montante = 0;
        this.TotalCustoArtistas = 0;
        custoArtistas(Artistas);
        //this.Artistas = Artistas; --> esta linha já estava na linha 65(apagar)
        this.Bilhetes = new ArrayList<Bilhete>();//no codigo antigo estava assigment to itself(apagar)
        this.BilhetesVIP = new ArrayList<BilheteVIP>();//no codigo antigo estava assigment to itself(apagar)
        numeroSerie += 1;
        this.nmrSerie = numeroSerie;
        
        
    }
    

    public LocalDate getData(){    return Data;    }

    public void setData(LocalDate Data){    this.Data = Data;   }

    public int getnArtistas(){  return nArtistas;   }

    public void setnArtistas(int nArtistas){    this.nArtistas = nArtistas;     }

    public String getNome(){    return Nome;    }

    public void setNome(String Nome){   this.Nome = Nome;   }

    public String getLocal(){   return Local;   }

    public void setLocal(String Local){     this.Local = Local;     }

    public int getCapacidade_maximo(){      return capacidade_maximo;       }

    public void setCapacidade_maximo(int capacidade_maximo){    this.capacidade_maximo = capacidade_maximo;     }

    public double getCustoBilhete(){   return custoBilhete;    }

    public void setCustoBilhete(double custoBilhete){   this.custoBilhete = custoBilhete;   }

    public double getCustoBilheteVIP(){    return custoBilheteVIP;     }

    public void setCustoBilheteVIP(double custoBilheteVIP){    this.custoBilheteVIP = custoBilheteVIP;     }

    public int getBilhetesVendidosNormal(){    return bilhetesVendidosNormal;      }

    public void setBilhetesVendidosNormal(int bilhetesVendidosNormal){     this.bilhetesVendidosNormal = bilhetesVendidosNormal;   }

    public int getBilhetesVendidosVIP(){   return bilhetesVendidosVIP;     }

    public void setBilhetesVendidosVIP(int bilhetesVendidosVIP){   this.bilhetesVendidosVIP = bilhetesVendidosVIP;     }

    public double getMontante(){   return montante;    }

    public void setMontante(double montante){      this.montante = montante;       }

    public int getHoras_espetaculo(){      return horas_espetaculo;    }

    public void setHoras_espetaculo(int horas_espetaculo) {     this.horas_espetaculo = horas_espetaculo;   }

    public int getMinutos_esptaculo(){  return minutos_esptaculo;   }

    public void setMinutos_esptaculo(int minutos_esptaculo){   this.minutos_esptaculo = minutos_esptaculo;     }

    public int getDurH(){   return durH;    }

    public void setDurH(int durH){  this.durH = durH;   }

    public int getDurM(){   return durM;    }

    public void setDurM(int durM){  this.durM = durM;   }

    public double getTotalCustoArtistas(){  return TotalCustoArtistas;  }

    public void setTotalCustoArtistas(double TotalCustoArtistas){   this.TotalCustoArtistas = TotalCustoArtistas;   }

    public ArrayList<Artista> getArtistas(){    return Artistas;    }

    public void setArtistas(ArrayList<Artista> Artistas){   this.Artistas = (ArrayList<Artista>)Artistas.clone();   }

    public ArrayList<Parceria> getParcerias(){     return Parcerias;    }

    public void setParcerias(ArrayList<Parceria> Parcerias){    this.Parcerias = (ArrayList<Parceria>)Parcerias.clone();     }

    public double getLucro(){     return lucro;     }

    public void setLucro(double lucro){     this.lucro = lucro;     }

    public ArrayList<Bilhete> getBilhetes(){    return Bilhetes;    }

    public void setBilhetes(ArrayList<Bilhete> Bilhetes){   this.Bilhetes = (ArrayList<Bilhete>)Bilhetes.clone();   }

    public ArrayList<BilheteVIP> getBilhetesVIP(){  return BilhetesVIP;     }

    public void setBilhetesVIP(ArrayList<BilheteVIP> BilhetesVIP){      this.BilhetesVIP = (ArrayList<BilheteVIP>)BilhetesVIP.clone();     }

    public static int getNumeroSerie(){     return numeroSerie;     }

    public static void setNumeroSerie(int numeroSerie){    Espetaculo.numeroSerie = numeroSerie;   }

    public int getNmrSerie() {   return nmrSerie;   }

    public void setNmrSerie(int nmrSerie) {  this.nmrSerie = nmrSerie;    }
    
    
    public int tamanho_Bilhete()
    {
       return Bilhetes.size();
    }
    public int tamanho_BilheteVip()
    {
        return BilhetesVIP.size();
    }
    
    

    public void duracaoTotal(int n) {
        int soma = 0, aux;
        for (int i = 0; i < n; i++) {
            soma += Artistas.get(i).duracao();
        }
        durH = soma / 3600;
        aux = soma % 3600;
        durM = aux / 60;
    }

    public void comprarBilheteNormal(int x, String[] nomeX) throws EspetaculoCheio{
        
        if(bilhetesVendidosNormal+bilhetesVendidosVIP >= capacidade_maximo)
            throw new EspetaculoCheio("ERRO! Espetaculo esgotado");
        
        
        else{
            if(bilhetesVendidosNormal+bilhetesVendidosVIP+x > capacidade_maximo)
                throw new EspetaculoCheio("ERRO! Só estão disponíveis " + (capacidade_maximo-(bilhetesVendidosNormal+bilhetesVendidosVIP)) + " bilhetes.");
            
            else
                for (int i = 0; i < x; i++) {
                    Bilhete X = new Bilhete(this.custoBilhete, nomeX[i]);
                    Bilhetes.add(X);
                    this.bilhetesVendidosNormal += 1;
                }
        }
        
        
    }
    
    public void comprarBilheteVIP(int x, String[] nomeX) throws EspetaculoCheio{ 
        
        if(bilhetesVendidosNormal+bilhetesVendidosVIP >= capacidade_maximo)
            throw new EspetaculoCheio("ERRO! Espetaculo esgotado");
        
        if(bilhetesVendidosNormal+bilhetesVendidosVIP+x > capacidade_maximo)
            throw new EspetaculoCheio("ERRO! Só estão disponíveis " + (capacidade_maximo-(bilhetesVendidosNormal+bilhetesVendidosVIP)) + " bilhetes.");
        
        for (int i = 0; i < x; i++) {
            BilheteVIP X = new BilheteVIP(this.custoBilheteVIP, nomeX[i]);
            BilhetesVIP.add(X);
            this.bilhetesVendidosVIP += 1;
        }

    }

    public void dinheiroParcerias(ArrayList<Parceria> list) {
        int soma = 0;
        for (int i = 0; i < list.size(); i++) {
            soma += list.get(i).getValor_fornecido();
        }
        this.montante += soma;
    }

    public void custoArtistas(ArrayList<Artista> list) {
        int soma = 0;
        for (int i = 0; i < list.size(); i++) {
            soma += list.get(i).getCusto();
        }
        this.TotalCustoArtistas = soma;
    }

    public void lucroEspectaculo() {
        this.lucro = (this.montante + ((this.custoBilhete * this.bilhetesVendidosNormal) + (this.custoBilheteVIP * this.bilhetesVendidosVIP))) - ( this.TotalCustoArtistas);
    }

    public String toString() {
        return "Espetáculo: " + Nome
                + "\nData: " + Data
                + "\nLocal: " + Local
                + "\nCapacidade Máximo: " + capacidade_maximo
                + "\nEspectadores: " + (bilhetesVendidosNormal + bilhetesVendidosVIP)
                + "\nMontante Angariado: " + montante
                + "\nTempo do espetaculo: " + horas_espetaculo + ":" + minutos_esptaculo
                + "\nParecerias=" + Parcerias;
    }

    public Espetaculo clone() {
        Espetaculo X = new Espetaculo(this.Data, this.nArtistas, this.Nome, this.Local, this.capacidade_maximo, this.horas_espetaculo, this.minutos_esptaculo, this.durH, this.durM, this.Artistas, this.Parcerias, this.custoBilhete, this.custoBilheteVIP, this.Bilhetes, this.BilhetesVIP);

        X.bilhetesVendidosNormal = this.bilhetesVendidosNormal;
        X.bilhetesVendidosVIP = this.bilhetesVendidosVIP;
        X.TotalCustoArtistas = this.TotalCustoArtistas;
        X.montante = this.montante;
        X.lucro = this.lucro;
        X.nmrSerie = this.nmrSerie;
        return X;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Espetaculo other = (Espetaculo) obj;
        if (this.nmrSerie != other.nmrSerie) {
            return false;
        }
        if (this.nArtistas != other.nArtistas) {
            return false;
        }
        if (this.capacidade_maximo != other.capacidade_maximo) {
            return false;
        }
        if (Double.doubleToLongBits(this.custoBilhete) != Double.doubleToLongBits(other.custoBilhete)) {
            return false;
        }
        if (Double.doubleToLongBits(this.custoBilheteVIP) != Double.doubleToLongBits(other.custoBilheteVIP)) {
            return false;
        }
        if (this.bilhetesVendidosNormal != other.bilhetesVendidosNormal) {
            return false;
        }
        if (this.bilhetesVendidosVIP != other.bilhetesVendidosVIP) {
            return false;
        }
        if (Double.doubleToLongBits(this.montante) != Double.doubleToLongBits(other.montante)) {
            return false;
        }
        if (this.horas_espetaculo != other.horas_espetaculo) {
            return false;
        }
        if (this.minutos_esptaculo != other.minutos_esptaculo) {
            return false;
        }
        if (this.durH != other.durH) {
            return false;
        }
        if (this.durM != other.durM) {
            return false;
        }
        if (Double.doubleToLongBits(this.TotalCustoArtistas) != Double.doubleToLongBits(other.TotalCustoArtistas)) {
            return false;
        }
        if (Double.doubleToLongBits(this.lucro) != Double.doubleToLongBits(other.lucro)) {
            return false;
        }
        if (!Objects.equals(this.Nome, other.Nome)) {
            return false;
        }
        if (!Objects.equals(this.Local, other.Local)) {
            return false;
        }
        if (!Objects.equals(this.Data, other.Data)) {
            return false;
        }
        if (!Objects.equals(this.Artistas, other.Artistas)) {
            return false;
        }
        if (!Objects.equals(this.Parcerias, other.Parcerias)) {
            return false;
        }
        if (!Objects.equals(this.Bilhetes, other.Bilhetes)) {
            return false;
        }
        if (!Objects.equals(this.BilhetesVIP, other.BilhetesVIP)) {
            return false;
        }
        return true;
    }

    

    

}
