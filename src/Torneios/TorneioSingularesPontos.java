package Torneios;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import Partidas.PartidaSingulares;
import Pessoas.Jogador;

/**
 * The TorneioSingularesPontos class represents a singles tournament where players earn points.
 * It extends the TorneioSingulares class.
 */
public class TorneioSingularesPontos extends TorneioSingulares {
    
    /**
     * The name of the tournament.
     */
    private String nome;
    
    /**
     * The location of the tournament.
     */
    private String localizacao;
    
    /**
     * The points of each player in the tournament.
     */
    private int[] pontosJogador;
    
    /**
     * The gender of the tournament participants.
     */
    private char genero;
    
    /**
     * Constructs a new TorneioSingularesPontos object.
     *
     * @param partidas    The list of singles matches in the tournament.
     * @param jogadores   The list of players in the tournament.
     * @param nome        The name of the tournament.
     * @param localizacao The location of the tournament.
     * @param genero      The gender of the tournament participants.
     */
    public TorneioSingularesPontos(ArrayList<PartidaSingulares> partidas, ArrayList<Jogador> jogadores, String nome,
            String localizacao, char genero) {
        super(partidas, jogadores);
        this.nome = nome;
        this.localizacao = localizacao;
        this.pontosJogador = new int[jogadores.size()];
        this.genero = genero;
    }

    /**
     * Gets the name of the tournament.
     *
     * @return The name of the tournament.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets the name of the tournament.
     *
     * @param nome The new name of the tournament.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Gets the location of the tournament.
     *
     * @return The location of the tournament.
     */
    public String getLocalizacao() {
        return localizacao;
    }

    /**
     * Sets the location of the tournament.
     *
     * @param localizacao The new location of the tournament.
     */
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    /**
     * Gets the gender of the tournament participants.
     *
     * @return The gender of the tournament participants.
     */
    public char getGenero() {
        return genero;
    }

    /**
     * Gets the points of each player in the tournament.
     *
     * @return An array of points for each player.
     */
    public int[] pontosJogador() {
        return pontosJogador;
    }

    /**
     * Sets the points of each player in the tournament.
     *
     * @param pontosJogador An array of points for each player.
     */
    public void setpontosJogador(int[] pontosJogador) {
        this.pontosJogador = pontosJogador;
    }

    /**
     * Adds a singles match to the tournament.
     *
     * @param partida The singles match to be added.
     */
    @Override
    public void adicionarPartida(PartidaSingulares partida) {
        if (partida != null) {
            if ((partida.getJogador1().getGenero() == this.genero) && (partida.getJogador2().getGenero() == this.genero)) {
                getPartidas().add(partida);
            } else {
                System.err.println("Jogadores com género não compatível com o torneio.");
            }
        } else {
            System.out.println("Erro ao adicionar partida!");
        }
    }

    /**
     * Determines the winner of the singles tournament.
     */
    @Override
    public void determinarVencedorTorneioSingulares() {
        if (getJogadores().size() == 0) {
            System.err.println("Não existe jogadores para determinar um vencedor");
        } else if (getJogadores().size() == 1) {
            System.out.println("O vencedor do torneio é : " + getJogadores().get(0).getNome() + ". Muitos parabéns!!");
        } else {
            for (PartidaSingulares partida : getPartidas()) {
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
            for (int i = 0; i < this.pontosJogador.length; i++) {
                if (max < this.pontosJogador[i]) {
                    max = this.pontosJogador[i];
                    maxIndex = i;
                }
            }
            Jogador vencedorTorneio = getJogadores().get(maxIndex);
            System.out.println("o jogador " + vencedorTorneio.getNome() + " ganhou com " + max + " pontos.");
        }
        determinarRanking();
    }

    /**
     * Determines the ranking of the players in the tournament.
     */
    public void determinarRanking() {
        for (Jogador jogador : getJogadores()) {
            jogador.setRanking(jogador.getRanking() + 5);
        }
        File file = new File("rankings.txt");
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
            PrintWriter printWriter = new PrintWriter(file);
            for (Jogador jogador : getJogadores()) {
                printWriter.println(jogador.getNome() + ":" + jogador.getRanking());
            }
            printWriter.close();
        } catch (IOException e) {
            System.err.println("erro");
        }
    }
}
        file.delete();
    }
    try {
        file.createNewFile();
        PrintWriter printWriter = new PrintWriter(file);
        for(Jogador jogador : getJogadores()){
            printWriter.println(jogador.getNome()+":"+jogador.getRanking());
        }
        printWriter.close();
    } catch (IOException e) {
        System.err.println("erro");
    }
    
  
  }
            
}
 
