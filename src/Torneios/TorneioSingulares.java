package Torneios;

import java.util.ArrayList;

import Partidas.PartidaSingulares;
import Pessoas.Jogador;

/**
 * The TorneioSingulares class represents a tournament of singles matches.
 * It is an abstract class that provides the basic structure and functionality
 * for managing a tournament, including storing and retrieving matches and players.
 */
public abstract class TorneioSingulares {
    /**
     * A list of singles matches in the tournament.
     */
    private ArrayList<PartidaSingulares> partidas;

    /**
     * A list of players participating in the tournament.
     */
    private ArrayList<Jogador> jogadores;

    /**
     * Constructs a new TorneioSingulares with the specified matches and players.
     *
     * @param partidas  the list of singles matches
     * @param jogadores the list of players
     */
    public TorneioSingulares(ArrayList<PartidaSingulares> partidas, ArrayList<Jogador> jogadores) {
        this.partidas = partidas;
        this.jogadores = jogadores;
    }

    /**
     * Returns the list of players participating in the tournament.
     *
     * @return the list of players
     */
    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    /**
     * Sets the list of players participating in the tournament.
     *
     * @param jogadores the new list of players
     */
    public void setJogadores(ArrayList<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    /**
     * Returns the list of singles matches in the tournament.
     *
     * @return the list of singles matches
     */
    public ArrayList<PartidaSingulares> getPartidas() {
        return partidas;
    }

    /**
     * Sets the list of singles matches in the tournament.
     *
     * @param partida the new list of singles matches
     */
    public void setPartida(ArrayList<PartidaSingulares> partida) {
        this.partidas = partida;
    }

    /**
     * Adds a new singles match to the tournament.
     *
     * @param partida the singles match to be added
     */
    public abstract void adicionarPartida(PartidaSingulares partida);

    /**
     * Determines the winner of the singles tournament.
     */
    public abstract void determinarVencedorTorneioSingulares();
}
        public TorneioSingulares(ArrayList<PartidaSingulares> partidas, ArrayList<Jogador> jogadores) {
            this.partidas = partidas;
            this.jogadores = jogadores;
        }
    
        public ArrayList<Jogador> getJogadores() {
            return jogadores;
        }
    
        public void setJogadores(ArrayList<Jogador> jogadores) {
            this.jogadores = jogadores;
        }
        
        public ArrayList<PartidaSingulares> getPartidas() {
            return partidas;
        }
    
        public void setPartida(ArrayList<PartidaSingulares> partida) {
            this.partidas = partida;
        }
        public abstract void adicionarPartida (PartidaSingulares partida);
    
        public abstract void determinarVencedorTorneioSingulares();
    }