package Partidas;

import Pessoas.Jogador;

public interface ControloPartida {
    public void inicioPartida();

    public String regras();

    public Jogador determinarVencedor();

    public double tempoPartida();

}