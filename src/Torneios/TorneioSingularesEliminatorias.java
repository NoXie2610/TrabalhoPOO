package Torneios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import Partidas.PartidaSingulares;
import Pessoas.Arbitro;
import Pessoas.Jogador;

/**
 * The TorneioSingularesEliminatorias class represents a single elimination tournament for singles matches.
 * It extends the TorneioSingulares class and includes additional attributes such as the tournament name,
 * location, winners, and gender.
 */
public class TorneioSingularesEliminatorias extends TorneioSingulares {
    
    /**
     * The name of the tournament.
     */
    private String nome;
    
    /**
     * The location of the tournament.
     */
    private String localizacao;
    
    /**
     * The list of winners in the tournament.
     */
    private ArrayList<Jogador> vencedores;
    
    /**
     * The gender of the participants in the tournament.
     */
    private char genero;
    
    /**
     * Constructs a new TorneioSingularesEliminatorias object with the specified matches, players, name, location, and gender.
     *
     * @param partidas the list of singles matches in the tournament
     * @param jogadores the list of players in the tournament
     * @param nome the name of the tournament
     * @param localizacao the location of the tournament
     * @param genero the gender of the participants in the tournament
     */
    public TorneioSingularesEliminatorias(ArrayList<PartidaSingulares> partidas, ArrayList<Jogador> jogadores,
            String nome, String localizacao, char genero) {
        super(partidas, jogadores);
        this.nome = nome;
        this.localizacao = localizacao;
        this.vencedores = new ArrayList<>();
        this.genero = genero;
    }
    
    /**
     * Returns the list of winners in the tournament.
     *
     * @return the list of winners
     */
    public ArrayList<Jogador> getVencedores() {
        return vencedores;
    }

    /**
     * Sets the list of winners in the tournament.
     *
     * @param vencedores the new list of winners
     */
    public void setVencedores(ArrayList<Jogador> vencedores) {
        this.vencedores = vencedores;
    }

    /**
     * Returns the name of the tournament.
     *
     * @return the name of the tournament
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets the name of the tournament.
     *
     * @param nome the new name of the tournament
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Returns the location of the tournament.
     *
     * @return the location of the tournament
     */
    public String getLocalizacao() {
        return localizacao;
    }

    /**
     * Sets the location of the tournament.
     *
     * @param localizacao the new location of the tournament
     */
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    /**
     * Returns the gender of the participants in the tournament.
     *
     * @return the gender of the participants
     */
    public char getGenero() {
        return genero;
    }

    /**
     * Adds a singles match to the tournament if the players' genders match the tournament's gender.
     *
     * @param partida the singles match to be added
     */
    @Override
    public void adicionarPartida(PartidaSingulares partida) {
        // Implementation here
    }

    /**
     * Determines the winner of the singles tournament.
     * If there are no players, an error message is displayed.
     * If there is only one player, that player is declared the winner.
     * Otherwise, the matches are played and the winners are determined.
     */
    @Override
    public void determinarVencedorTorneioSingulares() {
        // Implementation here
    }

    /**
     * Determines the ranking of the players based on their performance in the tournament.
     * The rankings are saved to a file named "rankings.txt".
     */
    public void determinarRanking() {
        // Implementation here
    }
}
                    Arbitro arbitro = new Arbitro("Jessica", 26, 'F', "Odivelas");
                    PartidaSingulares partidas = new PartidaSingulares(vencedores.get(i), vencedores.get(i+1),arbitro);
                        adicionarPartida(partidas);
                }
            }
            determinarRanking();

            getJogadores().clear(); 
            getJogadores().addAll(vencedores);
        }    
        
  }
    public void determinarRanking(){
    for(Jogador jogador : vencedores){
        jogador.setRanking(jogador.getRanking()+5);
    }
    File file = new File("rankings.txt");
    if(file.exists()){
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

