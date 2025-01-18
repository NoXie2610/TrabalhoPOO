package Partidas;

import Pessoas.Jogador;

/**
 * Interface ControloPartida define os métodos necessários para controlar uma partida.
 */
public interface ControloPartida {

    /**
     * Método para iniciar a partida.
     */
    public void inicioPartida();

    /**
     * Método para obter as regras da partida.
     *
     * @return Uma string contendo as regras da partida.
     */
    public String regras();

    /**
     * Método para determinar o vencedor da partida.
     *
     * @return Um objeto Jogador representando o vencedor da partida.
     */
    public Jogador determinarVencedor();

    /**
     * Método para obter o tempo da partida.
     *
     * @return Um valor double representando o tempo da partida.
     */
    public double tempoPartida();
}