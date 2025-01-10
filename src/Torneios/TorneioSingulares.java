package Torneios;

import java.util.ArrayList;

import Partidas.PartidaSingulares;
import Pessoas.Jogador;

public abstract class TorneioSingulares {
    private ArrayList<PartidaSingulares> partidas;
    private static ArrayList<Jogador> jogadores;
    
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


    

