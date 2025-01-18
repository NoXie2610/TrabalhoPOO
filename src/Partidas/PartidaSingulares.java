package Partidas;

import java.util.Random;

import Pessoas.Arbitro;
import Pessoas.Jogador;

/**
 * A class representing a singles match in a game.
 * Implements the ControloPartida interface.
 */
public class PartidaSingulares implements ControloPartida {
    private Jogador jogador1;
    private Jogador jogador2;
    private Arbitro arbitro;

    /**
     * Constructs a new PartidaSingulares with the specified players and referee.
     *
     * @param jogador1 the first player
     * @param jogador2 the second player
     * @param arbitro the referee
     */
    public PartidaSingulares(Jogador jogador1, Jogador jogador2, Arbitro arbitro) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.arbitro = arbitro;
    }

    /**
     * Gets the first player.
     *
     * @return the first player
     */
    public Jogador getJogador1() {
        return jogador1;
    }

    /**
     * Sets the first player.
     *
     * @param jogador1 the first player
     */
    public void setJogador1(Jogador jogador1) {
        this.jogador1 = jogador1;
    }

    /**
     * Gets the second player.
     *
     * @return the second player
     */
    public Jogador getJogador2() {
        return jogador2;
    }

    /**
     * Sets the second player.
     *
     * @param jogador2 the second player
     */
    public void setJogador2(Jogador jogador2) {
        this.jogador2 = jogador2;
    }

    /**
     * Gets the referee.
     *
     * @return the referee
     */
    public Arbitro getArbitro() {
        return arbitro;
    }

    /**
     * Sets the referee.
     *
     * @param arbitro the referee
     */
    public void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }

    /**
     * Starts the match and prints the match details.
     */
    @Override
    public void inicioPartida(){
        System.out.println("Inicio de jogo.");
        System.out.println("Temos : " + jogador1.getNome()+ " contra " + jogador2.getNome());
        System.out.println("O árbitro da partida será: " + arbitro.getNome());
    }

    /**
     * Returns the rules of the match.
     *
     * @return the rules of the match
     */
    @Override
    public String regras(){
        return """
            Regra número 1: Só poderão estar 2 jogadores dentro de campo.
            Regra número 2: O vencedor irá arrecadar 3 pontos pela vitória e somente ganhará 4 pontos se derrotar o adversário em menos de 20 minutos.
            Regra número 3: Para um jogador sagrar-se vencedor terá de ganhar 2 sets.
            """;
    }

    /**
     * Determines the winner of the match based on the players' rankings.
     *
     * @return the winning player
     */
    @Override
    public Jogador determinarVencedor(){
        Random random = new Random();
        if ((jogador1.getRanking() == jogador2.getRanking()) && (jogador1.getRanking() == 0))  {    // 2 jogadores 0 rating --> coinflip
            int coinflip = random.nextInt(2);
            if (coinflip == 0) {
                return jogador1;
            } else {
                return jogador2;
            }
        }
        int roll1 = random.nextInt( 0,jogador1.getRanking());       // roll jogador 1 ate ao rating maximo
        int roll2 = random.nextInt( 0,jogador2.getRanking());       // roll da equipa 2 ate ao rating maximo
        while (roll1 == roll2) {                                           // Se forem iguais dá-se um novo roll 
            roll1 = random.nextInt( 0,jogador1.getRanking());
            roll2 = random.nextInt( 0,jogador2.getRanking());    
        }
        if (roll1 < roll2) {                                               // Vencedor
            return jogador2;
        } else {
            return jogador1;
        }
    }

    /**
     * Determines the duration of the match.
     *
     * @return the duration of the match in minutes
     */
    @Override
    public double tempoPartida(){
        Random time = new Random();
        double tempo = time.nextDouble(60);
        return (int) tempo;
    }
}
