package Campeonato;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Pessoas.Jogador;
import Torneios.TorneioSingulares;
import Torneios.TorneioDoubles;
import Torneios.TorneioSingularesEliminatorias;
import Torneios.TorneioSingularesPontos;

public class Campeonato {
    private ArrayList<Jogador>allPlayers;
    private ArrayList<TorneioDoubles> torneioDoubles;
    private ArrayList<TorneioSingularesEliminatorias> torneioSingularesEliminatorias;
    private ArrayList<TorneioSingularesPontos> torneioSingularesPontos;

    public Campeonato(ArrayList<TorneioDoubles> torneioDoubles,
                      ArrayList<TorneioSingularesEliminatorias> torneioSingularesEliminatorias,
                      ArrayList<TorneioSingularesPontos> torneioSingularesPontos,
                      ArrayList<Jogador>allPlayers){
    
                        this.torneioDoubles = torneioDoubles;
                        this.torneioSingularesEliminatorias = torneioSingularesEliminatorias;
                        this.torneioSingularesPontos = torneioSingularesPontos;
                        this.allPlayers = new ArrayList();
                        
    }                   


    public void addPlayer(Jogador player){
        if (!allPlayers.contains(player)) {
            allPlayers.add(player);  
        } else {
            System.out.println("Jogador já está nos rankings");
        }
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
        try{
            Scanner fileReader = new Scanner(new File("rankings.txt"));
            while(fileReader.hasNext()){
                String texto = fileReader.nextLine();
                System.out.println(texto);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found");
        }
    }

}


