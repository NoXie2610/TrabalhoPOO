package Torneios;

import java.util.ArrayList;

import Partidas.PartidaSingulares;
import Pessoas.Jogador;

public class TorneioSingularesPontos extends TorneioSingulares {
    private String nome;
    private String localizacao;
    private int[] pontosJogador;
    private char genero;
    
    public TorneioSingularesPontos(ArrayList<PartidaSingulares> partidas, ArrayList<Jogador> jogadores, String nome,
            String localizacao, char genero) {
        super(partidas, jogadores);
        this.nome = nome;
        this.localizacao = localizacao;
        this.pontosJogador = new int[jogadores.size()];
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public char getGenero() {
        return genero;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public int[] pontosJogador() {
        return pontosJogador;
    }

    public void setpontosJogador(int[] pontosJogador) {
        this.pontosJogador = pontosJogador;
    }

    @Override
    public void adicionarPartida(PartidaSingulares partida){
        if (partida != null) {
            getPartidas().add(partida);
        } else {
            System.out.println("Erro ao criar a partida!");
        }
    }

    @Override
    public void determinarVencedorTorneioSingulares(){
        for(PartidaSingulares partida : getPartidas()) {
            Jogador winner = partida.determinarVencedor();
            partida.getJogador1().adicionarPartidaJogada();
            partida.getJogador2().adicionarPartidaJogada();
            int pontosWinner = 3;
            double gameTime = partida.tempoPartida();
            if (gameTime < 20) {
                pontosWinner = 4;
            }
           int indexWinner = getJogadores().indexOf(winner);
           this.pontosJogador[indexWinner] += pontosWinner;
        }
        int max = 0;
        int maxIndex = 0;
        for(int i = 0; i < this.pontosJogador.length; i++) {
            if (max < this.pontosJogador[i]) {
                max = this.pontosJogador[i];
                maxIndex = i;
            }
        } 
        Jogador vencedorTorneio = getJogadores().get(maxIndex);
        System.out.println("o jogador " + vencedorTorneio.getNome() + " ganhou com " + max + " pontos.");

    }
            
}
 
