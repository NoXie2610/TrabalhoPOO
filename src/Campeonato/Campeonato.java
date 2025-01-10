package Campeonato;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Pessoas.Jogador;
import Torneios.TorneioDoubles;
import Torneios.TorneioSingularesEliminatorias;
import Torneios.TorneioSingularesPontos;

public class Campeonato {
    protected static Object getAllPlayers;
    private ArrayList<Jogador>allPlayers;
    private ArrayList<TorneioDoubles> torneioDoubles;
    private ArrayList<TorneioSingularesEliminatorias> torneioSingularesEliminatorias;
    private ArrayList<TorneioSingularesPontos> torneioSingularesPontos;

    public Campeonato(){
        this.torneioDoubles = new ArrayList<>();
        this.torneioSingularesEliminatorias = new ArrayList<>();
        this.torneioSingularesPontos = new ArrayList<>();
        this.allPlayers = fetchFromFile();                   
    }                   


    public ArrayList<Jogador> getAllPlayers() {
        return allPlayers;
    }

    private ArrayList<Jogador> fetchFromFile(){
        ArrayList<Jogador> todosJogadores = new ArrayList<>();

        try {
            Scanner fileReader = new Scanner(new File("rankings.txt"));
            while(fileReader.hasNext()){
                String[] detalhesJogador = fileReader.nextLine().split(":");
                Jogador toAdd = new Jogador(detalhesJogador[0], Integer.parseInt(detalhesJogador[1]), detalhesJogador[2].charAt(0), detalhesJogador[3], Integer.parseInt(detalhesJogador[4]), Integer.parseInt(detalhesJogador[5]));
                todosJogadores.add(toAdd);
            }

            fileReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("Ficheiro não encontrado");
        }
        

        return todosJogadores;
    }

    public void addPlayer(Jogador player){
        if (!allPlayers.contains(player)) {
            allPlayers.add(player);  
        } else {
            System.out.println("Jogador já está nos rankings");
        }
    }
    public void addTorneioSingularesEliminatorias(TorneioSingularesEliminatorias torneioSingularesEliminatorias){
        this.torneioSingularesEliminatorias.add(torneioSingularesEliminatorias);
    }
    public void addTorneioSingularesPontos(TorneioSingularesPontos torneioSingularesPontos){
        this.torneioSingularesPontos.add(torneioSingularesPontos);
    }
    public void addTorneioDoubles(TorneioDoubles torneioDoubles){
        this.torneioDoubles.add(torneioDoubles);
    }

    public void medalharVencedores(){
        for (TorneioDoubles torneio : torneioDoubles){
            torneio.determinarVencedorTorneioDoubles();
            Premio premio = new Premio("Os vencedores levam para casa um Ford Fiesta", 5000);
            premio.premio();
        }
        for (TorneioSingularesEliminatorias torneio : torneioSingularesEliminatorias){
            torneio.determinarVencedorTorneioSingulares();
            Premio premio = new Premio("O vencedor leva para casa um Fiat Punto", 3000);
            premio.premio();
        }
        for (TorneioSingularesPontos torneio : torneioSingularesPontos){
            torneio.determinarVencedorTorneioSingulares();
            Premio premio = new Premio("O vencedor leva para casa um Fiat Punto", 3000);
            premio.premio();
        }
    }

    public void showRanking(){
        for(Jogador jogador : allPlayers){
            System.out.println(jogador);
        }
    }

    public ArrayList<Jogador> melhoresEPiorJogadores(){
        ArrayList<Jogador> jogadores = new ArrayList<>();
        Jogador melhorJogadorMasculino = null;
        Jogador piorJogadorMasculino = null;
        Jogador melhorJogadorFeminino = null;
        Jogador piorJogadorFeminino = null;
        for(Jogador jogador : allPlayers){
            if(jogador.getGenero()=='M'){
                if(melhorJogadorMasculino==null){
                    melhorJogadorMasculino = jogador;
                    piorJogadorMasculino = jogador;
                }else{
                    if(jogador.getRanking()>melhorJogadorMasculino.getRanking()){
                        melhorJogadorMasculino = jogador;
                    }
                    if(jogador.getRanking()<piorJogadorMasculino.getRanking()){
                        piorJogadorMasculino = jogador;
                    }
                }
            }else{
                if(melhorJogadorFeminino==null){
                    melhorJogadorFeminino = jogador;
                    piorJogadorFeminino = jogador;
                }else{
                    if(jogador.getRanking()>melhorJogadorFeminino.getRanking()){
                        melhorJogadorFeminino = jogador;
                    }
                    if(jogador.getRanking()<piorJogadorFeminino.getRanking()){
                        piorJogadorFeminino = jogador;
                    }
                }
            }
        }

        jogadores.add(melhorJogadorMasculino);
        jogadores.add(piorJogadorMasculino);
        jogadores.add(melhorJogadorFeminino);
        jogadores.add(piorJogadorFeminino);

        return jogadores;
    }

}


