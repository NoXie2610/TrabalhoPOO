package Campeonato;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Pessoas.Jogador;
import Torneios.TorneioDoubles;
import Torneios.TorneioSingularesEliminatorias;
import Torneios.TorneioSingularesPontos;

/**
 * The Campeonato class represents a championship that manages players and tournaments.
 * It provides methods to add players and tournaments, fetch players from a file,
 * determine winners, and display rankings.
 */
public class Campeonato {

    /**
     * Constructor for Campeonato class.
     * Initializes the tournament lists and fetches players from a file.
     */
    public Campeonato() {
        // Constructor implementation
    }

    /**
     * Gets the list of all players.
     * 
     * @return an ArrayList of Jogador objects representing all players.
     */
    public ArrayList<Jogador> getAllPlayers() {
        // Method implementation
    }

    /**
     * Fetches players from a file and returns them as an ArrayList.
     * 
     * @return an ArrayList of Jogador objects fetched from the file.
     */
    private ArrayList<Jogador> fetchFromFile() {
        // Method implementation
    }

    /**
     * Adds a player to the list of all players if not already present.
     * 
     * @param player the Jogador object to be added.
     */
    public void addPlayer(Jogador player) {
        // Method implementation
    }

    /**
     * Adds a singles elimination tournament to the list.
     * 
     * @param torneioSingularesEliminatorias the TorneioSingularesEliminatorias object to be added.
     */
    public void addTorneioSingularesEliminatorias(TorneioSingularesEliminatorias torneioSingularesEliminatorias) {
        // Method implementation
    }

    /**
     * Adds a singles points tournament to the list.
     * 
     * @param torneioSingularesPontos the TorneioSingularesPontos object to be added.
     */
    public void addTorneioSingularesPontos(TorneioSingularesPontos torneioSingularesPontos) {
        // Method implementation
    }

    /**
     * Adds a doubles tournament to the list.
     * 
     * @param torneioDoubles the TorneioDoubles object to be added.
     */
    public void addTorneioDoubles(TorneioDoubles torneioDoubles) {
        // Method implementation
    }

    /**
     * Awards prizes to the winners of all tournaments.
     */
    public void medalharVencedores() {
        // Method implementation
    }

    /**
     * Displays the ranking of all players.
     */
    public void showRanking() {
        // Method implementation
    }

    /**
     * Determines the best and worst male and female players.
     * 
     * @return an ArrayList of Jogador objects containing the best and worst male and female players.
     */
    public ArrayList<Jogador> melhoresEPiorJogadores() {
        // Method implementation
    }
}
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


