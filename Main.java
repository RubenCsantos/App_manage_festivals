package projetopoo;

import java.io.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        boolean f = true;
        ArrayList<Espetaculo> listaEsp = new ArrayList();
        ArrayList<Artista> listaArt = new ArrayList();
        ArrayList<Parceria> listaPar = new ArrayList();

        ObjectInputStream isEsp;
        ObjectOutputStream osEsp = null;
        ObjectInputStream isArt;
        ObjectOutputStream osArt = null;
        ObjectInputStream isPar;
        ObjectOutputStream osPar = null;

        try {
            isEsp = new ObjectInputStream(new FileInputStream("Espetaculos.dat"));
            listaEsp = (ArrayList<Espetaculo>) isEsp.readObject();
            isArt = new ObjectInputStream(new FileInputStream("Artistas.dat"));
            listaArt = (ArrayList<Artista>) isArt.readObject();
            isPar = new ObjectInputStream(new FileInputStream("Parcerias.dat"));
            listaPar = (ArrayList<Parceria>) isPar.readObject();
        } catch (IOException e) {
            System.out.println("Ficheiros Vazios");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        try {
            osEsp = new ObjectOutputStream(new FileOutputStream("Espetaculos.dat"));
            osArt = new ObjectOutputStream(new FileOutputStream("Artistas.dat"));
            osPar = new ObjectOutputStream(new FileOutputStream("Parcerias.dat"));
        } catch (IOException e) {
            System.out.println("Erro lmaoooo2");
            System.out.println(e);
        }
                                    //REINICIAR O PROGRAMA FAZ COM QUE FIQUE NA BASE DE DADOS O PRIMEIRO ELEMENTO QUE VOCES ESCREVEM
                                    //ÁS VEZES AO REINICIAR O PROGRAMA ELE PERDE OS DADOS
        do {
            System.out.println("---------- MENU : Principal ----------");
            System.out.println("1- Gerenciar Espétaculos"); //Só falta Parceria,Artistas,DATA (ESPECIALMENTE A DATA)
            System.out.println("2- Comprar Bilhete");   //Tudo errado,nem dá pra ler o nome de um espetáculo
            System.out.println("3- Gerenciar Artistas"); //Testado e mudado, sem exceções
            System.out.println("4- Gerenciar Parcerias");//Testado e mudado, sem exceções
            System.out.println("5- EXIT");

            int n = Ler.umInt();
            switch (n) {
                case 1:
                    boolean f1 = true;
                    do {
                        System.out.println("---------- MENU : Espétaculo ----------");;
                        System.out.println("1- Criar Espetáculo"); // funciona
                        System.out.println("2- Remover Espetáculo"); // done
                        System.out.println("3- Mostrar Espetálos"); //done
                        System.out.println("4- Estatisticas Espetáculos"); //toda mal
                        System.out.println("5- BACK"); //done

                        int n1 = Ler.umInt();
                        switch (n1) {
                            case 1:
                                int year = Calendar.getInstance().get(Calendar.YEAR),month = Calendar.getInstance().get(Calendar.MONTH),day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH),ano,mes,dia;
                                LocalDate data;
                                Espetaculo esp;
                                boolean algo_mal= false;
                                ArrayList<Parceria> listaParEsp = new ArrayList();
                                ArrayList<Artista> listaArtEsp = new ArrayList();
                                System.out.println("Insira o Nome do espetáculo:");
                                String nome = Ler.umaString();
                                System.out.println("Insira o Local do epetáculo:");
                                String local = Ler.umaString();
                               do{
                                do{  System.out.print("Insira a Data. Dia:");
                                    dia = Ler.umInt();
                                    if(dia < 1 || dia > 31)
                                        System.out.println("Insira um dia válido.");
                                    else break;
                                }while(true);
                                    
                                do{  System.out.print("Insira a Data. Mês:");
                                    mes = Ler.umInt();
                                    if(mes < 1 || mes > 12)
                                        System.out.println("Insira um mês válido");
                                    else break;
                                }while(true);
                                do{  System.out.print("Insira a Data. Ano:");
                                   ano = Ler.umInt();
                                   if(ano <= year)
                                        System.out.println("Insira um ano válido");
                                   else break;
                                }while(true);
                                data = LocalDate.of(ano, mes, dia);
                                if(data.isAfter(LocalDate.of(year, month , day))) break;
                                else System.out.println("Insira uma data válida");
                               }while(true);
                                System.out.println("Insira uma capacidade máxima para o Espetáculo");
                                int capacidade_maxima = Ler.umInt();
                                System.out.println("Insira o custo do bilhete normal e do bilhete VIP, respectivamente:");
                                double cB = Ler.umDouble();
                                double cBV = Ler.umDouble();
                                System.out.println("Quantos artistas quer no espetáculo:");
                                int nA = Ler.umInt();                      
                                for (int i = 0; i < nA; i++) {
                                    System.out.println("Insira o nome do Artista #[" + (i + 1) + "] :");
                                    String nomeArt = Ler.umaString();
                                    if(listaArt.size()==0)
                                    {
                                        System.out.println("Não há artistas na 'base de dados' para serem adicionadas ao espetáculo");
                                        algo_mal = true;
                                        break;
                                    }
                                    for (int k = 0; k < listaArt.size(); k++) {
                                        if (listaArt.get(k).getNome().equals(nomeArt)) {
                                            listaArtEsp.add(listaArt.get(k));
                                            System.out.println("Artista reconhecido e adicionado.");
                                            break;
                                        }else if(((k+1) ==listaArt.size()) && (!(listaArt.get(k).getNome().equals(nomeArt)))){
                                            int auxk0 = i;
                                            System.out.println("Este Artista não existe.");
                                            i = auxk0-1;
                                        }
                                    }
                                }
                                if(algo_mal) break;
                                System.out.println("Quantas Parcerias estão dispostas a fazer negócio consigo?");
                                int nP = Ler.umInt();
                                if(nP > 0 && listaPar.size()==0){
                                    System.out.println("Não há Parcerias na 'base de dados' para adicionar ao espetáculo.");
                                    break;
                                }
                                for (int i = 0; i < nP; i++) {
                                    System.out.println("Nome Parceria #[" + (i + 1) + "] :");
                                    String nomePar = Ler.umaString();
                                    for (int k = 0; k < listaPar.size(); k++) {
                                        if (listaPar.get(k).getNome().equals(nomePar)) {
                                            listaParEsp.add(listaPar.get(k));
                                            System.out.println("Parceria reconhecida e adicionada.");
                                            break;
                                        }else if(((k+1) ==listaPar.size()) && (!(listaPar.get(k).getNome().equals(nomePar)))){
                                            int auxk = i;
                                            System.out.println("Esta Parceria não existe.");
                                            i = auxk-1;
                                        }
                                    }
                                }
                                int hE,mE;
                                do{
                                System.out.println("Inicio do Espetáculo, Horas:");
                                hE = Ler.umInt();
                                if(hE > 24 || hE < 0) System.out.println("Insira umas Horas Válidas.");
                                else break;
                                }while(true);
                                do{System.out.println("Inicio do Espetáculo, Minutos:");
                                mE = Ler.umInt();
                                if(mE > 60 || mE < 0) System.out.println("Insira uns Minutros Válidos.");
                                else break;
                                }while(true);
                                esp = new Espetaculo(data, nome, local, cB, cBV, listaArtEsp, listaParEsp, hE, mE);
                                esp.setnArtistas(nA);
                                esp.setCapacidade_maximo(capacidade_maxima);
                                listaEsp.add(esp);
                                System.out.println("Espetáculo criado com sucesso.");
                                listaArtEsp.clear();
                                listaParEsp.clear();
                                try {
                                    osEsp.writeObject(listaEsp);
                                    osEsp.flush();
                                } catch (IOException e) {
                                    System.out.println(e);
                                }
                                break;
                            case 2:
                                if(listaEsp.size()==0)
                                {System.out.println("Não existem Espetáculos");break;}
                                boolean f12 = true;
                                do {System.out.println("---------- SUBMENU : REMOVER ----------");
                                    System.out.println("1- Remover só um Espetaculo");
                                    System.out.println("2- Remover Todos");
                                    System.out.println("3- BACK");

                                    int n2 = Ler.umInt();
                                    switch (n2) {
                                        case 1:
                                            System.out.println("Insira o Número de Criação(Nº do Espetáculo desde a criação deste programa):");
                                            int nS = Ler.umInt();
                                            for (int i = 0; i < listaEsp.size(); i++) {
                                                if (listaEsp.get(i).getNumeroSerie() == nS) {
                                                    listaEsp.remove(i);
                                                }
                                            }
                                            System.out.println("Espetáculo removido.");  
                                            break;
                                        case 2:
                                            listaEsp.clear();
                                            System.out.println("Lista de espetáculos completamente limpa!");
                                            break;
                                        case 3:
                                                f12 = false;
                                            break;
                                        default:
                                            System.out.println("Insira uma das opções.");
                                            break;
                                    }
                                    try {
                                        osEsp.writeObject(listaEsp);
                                    } catch (IOException e) {
                                        System.out.println(e);
                                    }
                                } while (f12);
                                break;
                            case 3:
                                if(listaEsp.size()==0)
                                {System.out.println("Não existem Espetáculos");break;}
                                boolean f13 = true;
                                do {System.out.println("---------- SUBMENU : Espétaculo ----------");
                                    System.out.println("1- Mostrar Espetáculos atráves do Nome"); //done
                                    System.out.println("2- Mostrar Espetáculos atráves da Local"); //done
                                    System.out.println("3- Mostrar Espetáculos atráves da Data"); //done
                                    System.out.println("4- Mostar Espetáculo atráves do Número de Criação (Nº do Espetáculo desde a Criação deste programa)"); //done
                                    System.out.println("5- Mostrar Todos os Espetáculos"); //done
                                    System.out.println("6- BACK");//done

                                    int n3 = Ler.umInt();
                                    switch (n3) {
                                        case 1:
                                            System.out.println("Insira o Nome do Espetáculo que deseja visualizar:");
                                            String nEP = Ler.umaString();
                                            System.out.println("Espetáculos com o Nome: " + nEP + ".");
                                            for (int i = 0; i < listaEsp.size(); i++) {
                                                if (listaEsp.get(i).getNome().equals(nEP)) {
                                                    System.out.println(listaEsp.get(i));
                                                }
                                            }
                                            break;
                                        case 2:
                                            System.out.println("Insira o Local do Espetáculo que deseja visualizar:");
                                            String nL = Ler.umaString();
                                            System.out.println("Espetáculos em " + nL + ".");
                                            for (int i = 0; i < listaEsp.size(); i++) {
                                                if (listaEsp.get(i).getLocal().equals(nL)) {
                                                    System.out.println(listaEsp.get(i));
                                                }
                                            }
                                            break;
                                        case 3:
                                            System.out.println("Insira a Data do Espetáculo que deseja visualizar:");
                                            int dd = Ler.umInt();
                                            int mm = Ler.umInt();
                                            int aa = Ler.umInt();
                                            LocalDate dma = LocalDate.of(aa, mm, dd);
                                            System.out.println("\n Espetáculos em " + dma + ":");
                                            for (int i = 0; i < listaEsp.size(); i++) {
                                                if (listaEsp.get(i).getData() == dma) {
                                                    System.out.println(listaEsp.get(i));
                                                }
                                            }
                                            break;
                                        case 4:
                                            System.out.println("Insira o Número de Criação do espetáculo que deseja visualizar:");
                                            int nserie = Ler.umInt();
                                            System.out.println("Espetáculo com o número de Criação " + nserie + ".");
                                            for (int i = 0; i < listaEsp.size(); i++) {
                                                if (listaEsp.get(i).getNumeroSerie() == nserie) {
                                                    System.out.println(listaEsp.get(i));
                                                }
                                            }
                                            break;
                                        case 5:System.out.println("Espetáculos existentes:");
                                            for (int i = 0; i < listaEsp.size(); i++) {
                                                System.out.println("Nome: " + listaEsp.get(i).getNome() + " Data:" + listaEsp.get(i).getData() + " Local:" + listaEsp.get(i).getLocal() + " Número de Série:" + listaEsp.get(i).getNmrSerie());
                                            }
                                            break;
                                        case 6:
                                            f13 = false;
                                            break;
                                        default:
                                            System.out.println("Insira uma das opções.");
                                            break;
                                    }
                                } while (f13);

                                break;
                            case 4:
                                    if(listaEsp.size()==0)
                                {System.out.println("Não existem Espetáculos");break;}
                                boolean f14 = true;
                                do {System.out.println("---------- MENU: ESTATÍSTICA ----------");
                                    System.out.println("Insira o Número de Criação (Nº do Espetáculo desde a Criação deste programa): ");
                                    int nSer = Ler.umInt();
                                    System.out.println("1- Lucro"); //done
                                    System.out.println("2- Montante Parcerias"); //done
                                    System.out.println("3- Gastos Artistas"); //done
                                    System.out.println("4- Total Bilhetes Vendidos (VIP e Normal)"); //done
                                    System.out.println("5- Total Bilhetes Normais"); //done
                                    System.out.println("6- Total Bilhetes VIP"); //done
                                    System.out.println("7- Lucro só de Bilhetes"); //done
                                    System.out.println("8- Parcerias Espetáculo"); //done
                                    System.out.println("9- Artistas do Espetáculo"); //done
                                    System.out.println("10- Duração do Espetáculo"); //done
                                    System.out.println("11- BACK"); //done

                                    int n14 = Ler.umInt();
                                    switch (n14) {
                                        case 1:

                                            for (int i = 0; i < listaEsp.size(); i++) {
                                                if (listaEsp.get(i).getNmrSerie() == nSer) {
                                                    listaEsp.get(i).dinheiroParcerias(listaEsp.get(i).getParcerias());
                                                    listaEsp.get(i).custoArtistas(listaEsp.get(i).getArtistas());
                                                    listaEsp.get(i).lucroEspectaculo();
                                                    double lucro = listaEsp.get(i).getLucro();
                                                    System.out.println("O lucro do espetáculo " + listaEsp.get(i).getNome() + " foi: " + lucro + "€");
                                                }
                                            }
                                            break;
                                        case 2:
                                            for (int i = 0; i < listaEsp.size(); i++) {
                                                if (listaEsp.get(i).getNmrSerie() == nSer) {
                                                    listaEsp.get(i).dinheiroParcerias(listaEsp.get(i).getParcerias());
                                                    System.out.println("O montante referente ás parcerias " + listaEsp.get(i).getNome() + " foi: " +  listaEsp.get(i).getMontante() + "€");
                                                }
                                            }
                                            break;
                                        case 3:
                                            for (int i = 0; i < listaEsp.size(); i++) {
                                                if (listaEsp.get(i).getNmrSerie() == nSer) {
                                                    listaEsp.get(i).custoArtistas(listaEsp.get(i).getArtistas());
                                                    double custoArt = listaEsp.get(i).getTotalCustoArtistas();
                                                    System.out.println("O montante gasto com os artistas no " + listaEsp.get(i).getNome() + " foi: " + custoArt + "€");
                                                }
                                            }
                                            break;
                                        case 4:
                                            for (int i = 0; i < listaEsp.size(); i++) {
                                                if (listaEsp.get(i).getNmrSerie() == nSer) { 
                                                    System.out.println("O número total de bilhetes vendidos (VIP e Normal) do " + listaEsp.get(i).getNome() + " foi: " + (listaEsp.get(i).tamanho_Bilhete() + listaEsp.get(i).tamanho_BilheteVip()));
                                                }
                                            }
                                            break;
                                        case 5:
                                            for (int i = 0; i < listaEsp.size(); i++) {
                                                if (listaEsp.get(i).getNmrSerie() == nSer) {
                                                    System.out.println("O número total de bilhetes vendidos normais do " + listaEsp.get(i).getNome() + " foi: " + listaEsp.get(i).tamanho_Bilhete() );
                                                }
                                            }
                                            break;
                                        case 6:
                                               
                                            for (int i = 0; i < listaEsp.size(); i++) {
                                                if (listaEsp.get(i).getNmrSerie() == nSer) {
                                                    System.out.println("O número total de bilhetes vendidos VIP do " + listaEsp.get(i).getNome() + " foi: " + listaEsp.get(i).tamanho_BilheteVip());
                                                }
                                            }
                                            break;
                                        case 7:
                                            for (int i = 0; i < listaEsp.size(); i++) {
                                                if (listaEsp.get(i).getNmrSerie() == nSer) {
                                                    System.out.println("O montante ganho com os bilhetes no" + listaEsp.get(i).getNome() + " foi: " + ((listaEsp.get(i).getBilhetesVendidosNormal() * listaEsp.get(i).getCustoBilhete()) + (listaEsp.get(i).getBilhetesVendidosVIP() * listaEsp.get(i).getCustoBilheteVIP())) + "€");
                                                }
                                            }
                                            break;
                                        case 8:
                                            for (int i = 0; i < listaEsp.size(); i++) {
                                                if (listaEsp.get(i).getNmrSerie() == nSer) {
                                                        System.out.println(listaEsp.get(i).getParcerias());
                                                   
                                                }
                                            }
                                            break;
                                        case 9:
                                            for (int i = 0; i < listaEsp.size(); i++) {
                                                if (listaEsp.get(i).getNmrSerie() == nSer) {
                                                    for (int j = 0; j < listaEsp.get(i).getArtistas().size(); j++) {
                                                        System.out.println(listaEsp.get(i).getArtistas().get(j));
                                                    }
                                                }
                                            }
                                            break;
                                        case 10:
                                            for (int i = 0; i < listaEsp.size(); i++) {
                                                if (listaEsp.get(i).getNmrSerie() == nSer) {
                                                    listaEsp.get(i).duracaoTotal(listaEsp.get(i).getnArtistas());
                                                    int durH = listaEsp.get(i).getDurH();
                                                    int durM = listaEsp.get(i).getDurM();
                                                    System.out.println("A duração do espetáculo " + listaEsp.get(i).getNome() + " foi de: " + durH + "hh " + " e " + durM + " mm ");
                                                }
                                            }
                                            break;
                                        case 11:
                                            f14 = false;
                                            break;
                                        default:
                                            System.out.println("Insira uma das opções!");
                                            break;
                                    }
                                } while (f14);
                                break;
                            case 5:
                                f1 = false;
                                break;
                            default:
                                System.out.println("Insira uma das opcoes!");
                                break;
                        }
                    } while (f1);
                    break;
                case 2:
                    if(listaEsp.size()==0)
                        {System.out.println("Não existem Espetáculos");break;}
                    boolean f2 = true;
                    String s, aux;
                    int i, choice = 0;

                    do {System.out.println("---------- SUBMENU :: Bilheteira ----------");
                        System.out.println("1- Escolher espetáculo");
                        System.out.println("2- Listar Espetáculos");
                        System.out.println("3- BACK");

                        choice = Ler.umInt();

                        switch (choice) {

                            case 1:

                                System.out.println("Qual o nome do espetáculo: ");
                                s = Ler.umaString();

                                for (i = 0; i < listaEsp.size(); i++) {
                                    if (s.equals(listaEsp.get(i).getNome())) {
                                        break;
                                    }
                                }

                                if (i >= listaEsp.size()) {
                                    System.out.println("ERRO! Espetáculo não existe");
                                } else {
                                    int subC1;

                                    System.out.println("1- Comprar Bilhete");
                                    System.out.println("2- Comprar Bilhete VIP");
                                    System.out.println("3- BACK");

                                    subC1 = Ler.umInt();

                                  

                                        switch (subC1) {

                                            case 1:
                                                String[] nome;
                                                int qtd;

                                                System.out.print("Quantos bilhetes quer comprar? ");
                                                qtd = Ler.umInt();
                                                nome = new String[qtd];

                                                for (int o = 0; o < qtd; o++) {

                                                    System.out.println("Insira o nome no bilhete #[" + (o + 1) + "] : ");
                                                    nome[o] = Ler.umaString();
                                                }

                                                try {

                                                    listaEsp.get(i).comprarBilheteNormal(qtd, nome);
                                                    osEsp.writeObject(listaEsp);
                                                            
                                                } catch (EspetaculoCheio e) {
                                                    System.out.println(e);
                                                } catch (IOException e) {
                                                    System.out.println(e);
                                                }
                                                break;

                                            case 2:
                                                String nomeV[];
                                                int qtdV;

                                                System.out.print("Quantos bilhetes VIPs quer comprar? ");
                                                qtdV = Ler.umInt();
                                                nomeV = new String[qtdV];

                                                for (int o = 0; o < qtdV; o++) {

                                                    System.out.println("Insira o nome do bilhete #[" + (o + 1) + "] : ");
                                                    nomeV[o] = Ler.umaString();
                                                }

                                                try {

                                                    listaEsp.get(i).comprarBilheteVIP(qtdV, nomeV);
                                                    osEsp.writeObject(listaEsp);
                                                } catch (EspetaculoCheio e) {
                                                    System.out.println(e);
                                                } catch (IOException e) {
                                                    System.out.println(e);
                                                }
                                                break;

                                            case 3:
                                                break;
                                            default:
                                                System.out.println("Insira uma das opções.");
                                                break;
                                        }

                                }
                                break;
                            case 2:
                                if(listaEsp.size()==0)
                                {System.out.println("Não existem Espetáculos");break;}
                                System.out.println("Espétáculos existentes:");
                                for (int j = 0; j < listaEsp.size(); j++) {
                                        System.out.println((j+1) + " - " + listaEsp.get(j).getNome());
                                }
                                break;
                            case 3:
                                f2 = false;
                                break;
                            default:
                                System.out.println("Insira uma das opções.");
                                break;
                                
                        }
                    } while (f2);
                    break;
                case 3:
                    boolean f3 = true;
                    do {
                        System.out.println("---------- SUBMENU :: Artistas ----------");
                        System.out.println("1- Criar Artista"); //Cada vez que criam vários artistas só fica guardado o primeiro que criaram
                        System.out.println("2- Remover Artista"); // " " eliminam " " só elimina o primeiro que escreveram
                        System.out.println("3- Mostar Artista"); //done
                        System.out.println("4- Mostar Musicas de um Artista"); //done
                        System.out.println("5- Mostar Todos os Artistas"); //done
                        System.out.println("6- BACK"); //done

                        int m = Ler.umInt();
                        switch (m) {
                            case 1:
                                ArrayList<Musica> Musicas = new ArrayList();
                                int br = 1;
                                System.out.println("Insira o nome do artista");
                                String nome_artista = Ler.umaString();
                                for (int j = 0; j < listaArt.size(); j++) {

                                    if (listaArt.get(j).getNome().equals(nome_artista)) {
                                        System.out.println("Já existe um artista com esse nome.");
                                        System.out.println(listaArt.get(j).toString());
                                        br = 0;
                                        break;
                                    }
                                }
                                if (br == 0) {
                                    break;
                                }
                                System.out.println("Insira as músicas do artista");
                                do {
                                    System.out.println("Insira o nome da música. Escreva FIM quando inserir todas as músicas.");
                                    String musica_a = Ler.umaString();
                                    if (musica_a.equals("FIM")) {
                                        break;
                                    }
                                    int minutos,segundos;
                                do{
                                    System.out.println("Minutos da música:");                                
                                    minutos = Ler.umInt();
                                    if(minutos < 0)
                                        System.out.println("Insira um valor válido.");
                                    else break;
                                }while(true);
                                do{    
                                    System.out.println("Segundos da música:");
                                    segundos = Ler.umInt();
                                    if(segundos > 60 || segundos < 0)
                                        System.out.println("Insira um valor valido.");
                                    else break;
                                }while(true); 
                                    Musica musica_artista = new Musica(musica_a, minutos, segundos);
                                    Musicas.add(musica_artista);
                                } while (true);
                                System.out.println("Insira o custo do respectivo artista.");
                                double custo_artista = Ler.umDouble();
                                Artista a = new Artista(nome_artista, Musicas, custo_artista);
                                listaArt.add(a);
                                try {
                                    osArt.writeObject(listaArt);
                                        osArt.flush();
                                } catch (IOException e) {
                                    System.out.println(e);
                                }
                                System.out.println("Feito!");
                                break;
                            case 2:
                                if(listaArt.size()==0)
                                    {System.out.println("Não existem Artistas.");break;}
                                System.out.println("Deseja remover UM artista ou TODOS os artistas?\n1-UM artista\n2-TODOS os artistas");
                                int decc = Ler.umInt();
                            do{    
                                if(decc == 1)
                                {
                                System.out.println("Insira o nome do artista que deseja remover");
                                String nome_artista2 = Ler.umaString();
                                int numero_artistas = 0;
                                for (int j = 0; j < listaArt.size(); j++) {
                                    if (listaArt.get(j).getNome().equals(nome_artista2)) {
                                        numero_artistas++;
                                    }
                                }

                                if (numero_artistas == 0) {
                                    System.out.println("Nao existe nenhum artista com esse nome.");
                                    System.out.println("Aqui tem a lista dos Nomes dos artistas");
                                    for (int j = 0; j < listaArt.size(); j++) {
                                        System.out.println(listaArt.get(j).getNome());
                                    }
                                } else {
                                    for (int j = 0; j < listaArt.size(); j++) {
                                        if (listaArt.get(j).getNome().equals(nome_artista2)) {
                                            listaArt.remove(j);
                               
                                        }
                                    }
                                    try {
                                        osArt.writeObject(listaArt);
                                        osArt.flush();
                                    } catch (IOException e) {
                                        System.out.println(e);
                                    }
                                    System.out.println("Artista removido.");
                                    
                                }
                                break;
                                }
                                else if (decc == 2)
                                {
                                    listaArt.clear();
                                    System.out.println("Lista de artistas completamente limpa");
                                    try {
                                        osArt.writeObject(listaArt);
                                        osArt.flush();
                                    } catch (IOException e) {
                                        System.out.println(e);
                                    }
                                    break;
                                }
                                else System.out.println("Insira uma das opções");
                                }while(true); 
                                break;
                            case 3:
                                if(listaArt.size()==0)
                                    {System.out.println("Não existem Artistas.");break;}
                                int existe2=0;
                                System.out.println("Insira o nome do artista que quer procurar.");
                                String nome_artista3 = Ler.umaString();
                                for (int j = 0; j < listaArt.size(); j++) {
                                    if (listaArt.get(j).getNome().equals(nome_artista3)) {
                                        System.out.println("Informações sobre o artista " + listaArt.get(j).getNome() + ":");
                                        System.out.println(listaArt.get(j).toString());existe2++;
                                    }
                                }
                                if(existe2 == 0)
                                    System.out.println("Não existe nenhum artista com esse nome.\n");
                                break;
                            case 4:
                                if(listaArt.size()==0)
                                    {System.out.println("Não existem Artistas.");break;}
                                int existe=0;
                                System.out.println("Insira o nome do artista que quer procurar");
                                String nome_artista4 = Ler.umaString();
                                for (int j = 0; j < listaArt.size(); j++) {
                                    if (listaArt.get(j).getNome().equals(nome_artista4)) {
                                        System.out.println("Informações sobre o set de músicas do artista " + listaArt.get(j).getNome() + ":");
                                        System.out.println(listaArt.get(j).getSetM());
                                        existe++;
                                    }
                                }
                                if(existe == 0)
                                    System.out.println("Não existe nenhum artista com esse nome.\n");
                                break;
                            case 5:
                                if(listaArt.size()==0)
                                    {System.out.println("Não existem Artistas.");break;}
                                System.out.println("Aqui estão todos os artistas presentes na 'base de dados'.");
                                for (int j = 0; j < listaArt.size(); j++) {
                                    System.out.println(listaArt.get(j).getNome());
                                }
                                System.out.println("");
                                break;
                            case 6:
                                f3 = false;
                                try {
                                        osArt.writeObject(listaArt);
                                        osArt.flush();
                                    } catch (IOException e) {
                                        System.out.println(e);
                                    }
                                break;
                            default:
                                System.out.println("Insira uma das opções.");
                                break;
                        }
                        try {
                                        osArt.writeObject(listaArt);
                                        osArt.flush();
                                    } catch (IOException e) {
                                        System.out.println(e);
                                    }
                    } while (f3);
                    break;
                case 4:
                    boolean f4 = true;
                    do {
                        System.out.println("---------- SUBMENU :: Parcerias ----------");
                        System.out.println("1- Criar Parcerias");//Cada vez qese criam várias, só fica a primeira na base de dados
                        System.out.println("2- Remover Parcerias");//Cada vez que elinam várias(sem ser tudlo),só fica a primeira na base de dados
                        System.out.println("3- Mostrar Parcerias por Range de Preço");
                        System.out.println("4- Mostrar Todas as Parecerias");
                        System.out.println("5- Mostar Parceria com maior Valor Fornecido");
                        System.out.println("6- BACK");

                        int m = Ler.umInt();
                        switch (m) {
                            case 1:
                                boolean br2 = false;
                                System.out.println("Insira o nome da Parceria:");
                                String nome_parceria = Ler.umaString();
                                for (int j = 0; j < listaPar.size(); j++) {
                                    if (listaPar.get(j).getNome().equals(nome_parceria)) {
                                        System.out.println("Já existe uma parceria com este nome");
                                        br2 = true;
                                    }
                                }
                                if (br2) {
                                    break;
                                }
                                System.out.println("Insira o valor fornecido da respetiva Parceria");
                                double valor_fornecido = Ler.umDouble();
                                Parceria A = new Parceria(nome_parceria, valor_fornecido);
                                if(listaPar.add(A)) System.out.println("Parceria adicionada na Lista");
                                else System.out.println("Erro ao adicionar Parceria");
                                try {
                                    osPar.writeObject(listaPar);
                                    osPar.flush();
                                } catch (IOException e) {
                                    System.out.println(e);
                                }
                                break;
                            case 2:
                                    if(listaPar.size() == 0)
                                    { System.out.println("Não existem Parcerias.");break;}
                                
                                do {
                                    System.out.println("Deseja remover todas ou apenas algumas?");
                                    System.out.println("1 - Todas\n2 - Uma");
                                    int d = Ler.umInt();
                                    int z = 0;
                                    if (d == 1) {
                                        listaPar.clear();
                                        System.out.println("Lista de Parcerias completamente limpa!");
                                        try {
                                            osPar.writeObject(listaPar);
                                            osPar.flush();
                                        } catch (IOException e) {
                                            System.out.println(e);
                                        }
                                        break;
                                    } else if (d == 2) {                                  
                                            System.out.println("Insira o nome da Pareceria que deseja remover:");
                                            String nome_parceria2 = Ler.umaString();
                                            for (int j = 0; j < listaPar.size(); j++) {
                                                if (listaPar.get(j).getNome().equals(nome_parceria2)) {
                                                    listaPar.remove(j);
                                                    System.out.println("Parceria Removida!");
                                                }
                                                else if((j+1) == listaPar.size() && (!(listaPar.get(j).getNome().equals(nome_parceria2))))
                                                {
                                                    System.out.println("Não existe essa Parceria.");
                                                }
                                            }
                                            try {
                                                osPar.writeObject(listaPar);
                                                osPar.flush();
                                            } catch (IOException e) {
                                                System.out.println(e);
                                            }
                                            break;
                                    }
                                    else{
                                            System.out.println("Insira uma das opções.");
                                        }
                                    }
                                while (true);
                                break;
                            case 3:
                                if(listaPar.size() == 0)
                                { System.out.println("Não existem Parcerias.");break;}
                                System.out.println("Defina o intervalo de valor fornecido que deseja");
                                System.out.print("Min: ");
                                double min = Ler.umDouble();
                                System.out.print("\nMax: ");
                                double max = Ler.umDouble();
                                System.out.println("Aqui estão as Parcerias que ofereceram entre " + min + "€ e " + max + "€.\n");
                                for (int j = 0; j < listaPar.size(); j++) {
                                    if ((listaPar.get(j).getValor_fornecido() >= min) && (listaPar.get(j).getValor_fornecido() <= max)) {
                                        System.out.println(listaPar.get(j).getNome());
                                    }
                                }
                                break;
                            case 4:
                                if(listaPar.size() == 0)
                                { System.out.println("Não existem Parcerias.");break;}
                                System.out.println("Aqui está o nome de todas as parcerias existentes na 'base de dados'.");
                                for (int aa = 0; aa < listaPar.size(); aa++) {
                                    System.out.println(listaPar.get(aa).getNome() + "->" + listaPar.get(aa).getValor_fornecido() + "€.");
                                }
                                System.out.println();
                                break;
                            case 5: 
                                    if(listaPar.size() == 0)
                                    { System.out.println("Não existem Parcerias.");break;}
                                    double maiorValor = listaPar.get(0).getValor_fornecido();
                                    System.out.println("A(s) Parceria(s) com maior Valor Fornecido será(ão): ");
                                    for (int j = 0; j < listaPar.size(); j++) {
                                        if(maiorValor < listaPar.get(j).getValor_fornecido())
                                        {
                                            maiorValor = listaPar.get(j).getValor_fornecido();
                                        }
                                    }
                                    for (int k = 0; k < listaPar.size(); k++) {
                                        if(maiorValor == listaPar.get(k).getValor_fornecido())
                                        {
                                            System.out.println(listaPar.get(k).getNome() + " -> " + listaPar.get(k).getValor_fornecido() + "€.");
                                        }
                                    }                                                               
                                    System.out.println("");
                                break;
                            case 6:
                                f4 = false;
                                try {
                                        osPar.writeObject(listaPar);
                                        osPar.flush();
                                    } catch (IOException e) {
                                        System.out.println(e);
                                    }
                                break;
                            default:
                                System.out.println("Insira uma das opções.");
                                break;
                        }
                    } while (f4);
                    break;
                case 5:
                    try {
                osEsp.writeObject(listaEsp);
                osEsp.flush();
                osArt.writeObject(listaArt);
                osArt.flush();
                osPar.writeObject(listaPar);
                osPar.flush();
            } catch (IOException e) {
                System.out.println(e);
            }
                   
                    f = false;   
                    break;
                default:
                    System.out.println("Insira uma das opções.");
                    break;
            }
                      try {
                osEsp.writeObject(listaEsp);
                osEsp.flush();
                osArt.writeObject(listaArt);
                osArt.flush();
                osPar.writeObject(listaPar);
                osPar.flush();
            } catch (IOException e) {
                System.out.println(e);
            }
        } while (f);
    }

}


