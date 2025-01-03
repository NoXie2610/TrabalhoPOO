package Partidas;

import java.util.Random;

import Pessoas.Arbitro;
import Pessoas.Jogador;

public class PartidaDoubles implements ControloPartida {
    private Jogador jogador1Eq1;
    private Jogador jogador2Eq1;
    private Jogador jogador1Eq2;
    private Jogador jogador2Eq2;
    private Arbitro arbitro;
    private String resultado;
    
    public PartidaDoubles(Jogador jogador1Eq1, Jogador jogador2Eq1, Jogador jogador1Eq2, Jogador jogador2Eq2,
            Arbitro arbitro, String resultado) {
        this.jogador1Eq1 = jogador1Eq1;
        this.jogador2Eq1 = jogador2Eq1;
        this.jogador1Eq2 = jogador1Eq2;
        this.jogador2Eq2 = jogador2Eq2;
        this.arbitro = arbitro;
        this.resultado = resultado;
    }

    public Jogador getJogador1Eq1() {
        return jogador1Eq1;
    }

    public void setJogador1Eq1(Jogador jogador1Eq1) {
        this.jogador1Eq1 = jogador1Eq1;
    }

    public Jogador getJogador2Eq1() {
        return jogador2Eq1;
    }

    public void setJogador2Eq1(Jogador jogador2Eq1) {
        this.jogador2Eq1 = jogador2Eq1;
    }

    public Jogador getJogador1Eq2() {
        return jogador1Eq2;
    }

    public void setJogador1Eq2(Jogador jogador1Eq2) {
        this.jogador1Eq2 = jogador1Eq2;
    }

    public Jogador getJogador2Eq2() {
        return jogador2Eq2;
    }

    public void setJogador2Eq2(Jogador jogador2Eq2) {
        this.jogador2Eq2 = jogador2Eq2;
    }

    public Arbitro getArbitro() {
        return arbitro;
    }

    public void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    
    @Override
    public void inicioPartida(){
        System.out.println("Inicio de jogo.");
        System.out.println("Temos os jogadores  da equipa número 1 : " + jogador1Eq1.getNome()+ " e " + jogador2Eq1.getNome());
        System.out.println("E os jogadores  da equipa número 2 : " + jogador1Eq2.getNome()+ " e " + jogador2Eq2.getNome());
        System.out.println("O árbitro da partida será: " + arbitro.getNome());
    }

    @Override
    public String regras(){
        return """
        Regra número 1: So poderam estar 4 jogadores dentro de campo.
        Regra número 2: O vencedor irá arrecadar 3 pontos pela vitória e somente ganhará 4 pontos se derrotar o adversário em menos de 20 minutos.
        Regra número 3: Para um jogador sagrar-se vencedor terá de ganhar 2 sets.
        """;
    }


    @Override
    public Jogador determinarVencedor(){
        int equipa1Rating = jogador1Eq1.getRanking() + jogador2Eq1.getRanking();
        int equipa2Rating = jogador1Eq2.getRanking() + jogador2Eq2.getRanking();
        Random random = new Random();
        if ((equipa1Rating == equipa2Rating) && (equipa1Rating == 0))  {    // 2 equipas 0 rating --> coinflip
            int coinflip = random.nextInt(2);
            if (coinflip == 0) {
                return jogador1Eq1;    
            } else {
                return jogador1Eq2;
            }  
        }
        int roll1 = random.nextInt( 0,equipa1Rating);   // roll da equipa 1 ate ao rating maximo
        int roll2 = random.nextInt( 0,equipa2Rating);   // roll da equipa 2 ate ao rating maximo
        while (roll1 == roll2) {                               // Se forem iguais dá-se um novo roll 
            roll1 = random.nextInt( 0,equipa1Rating);
            roll2 = random.nextInt( 0,equipa2Rating);    
        }
        if (roll1 < roll2) {                                   // Vencedor
            return jogador1Eq2;   
        } else {
            return jogador1Eq1;
        } 
    }

    @Override
    public double tempoPartida(){
        Random time = new Random();
        double tempo = time.nextDouble(60);
        return (int) tempo;
    }
    
}
