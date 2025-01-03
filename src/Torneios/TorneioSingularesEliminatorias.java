package Torneios;

import java.util.ArrayList;

import Partidas.PartidaSingulares;
import Pessoas.Arbitro;
import Pessoas.Jogador;

public class TorneioSingularesEliminatorias extends TorneioSingulares {
    private String nome;
    private String localizacao;
    private ArrayList <Jogador> vencedores;
    
    public TorneioSingularesEliminatorias(ArrayList<PartidaSingulares> partidas, ArrayList<Jogador> jogadores,
         String nome, String localizacao) {
        super(partidas, jogadores);
        this.nome = nome;
        this.localizacao = localizacao;
        this.vencedores = new ArrayList<>();
    }
    
    public ArrayList<Jogador> getVencedores() {
        return vencedores;
    }

    public void setVencedores(ArrayList<Jogador> vencedores) {
        this.vencedores = vencedores;
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

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    @Override
    public void adicionarPartida (PartidaSingulares partida){
        if (partida != null) {
            getPartidas().add(partida);
        } else {
            System.out.println("Erro ao adicionar partida!");
        }
    }
    @Override
    public void determinarVencedorTorneioSingulares(){ 
        ArrayList<Jogador> perdedores = new ArrayList<>();
        while (getJogadores().size() > 1) {
            vencedores.clear();
            perdedores.clear();
            for (PartidaSingulares partida : getPartidas()) {
                partida.regras();
                partida.inicioPartida();
                Jogador player1 = partida.getJogador1();
                Jogador player2 = partida.getJogador2();
                Jogador winner = partida.determinarVencedor();
                partida.getJogador1().adicionarPartidaJogada();
                partida.getJogador2().adicionarPartidaJogada();
                vencedores.add(winner);
                System.out.println("O jogador " + winner.getNome() + " é o vencedor!");
            if (winner == player1) {
                perdedores.add(player2);     
            }    else {
                perdedores.add(player1);
            }
            }  
     
            getJogadores().removeAll(perdedores);
            getPartidas().clear();
            for (int i = 0; i < vencedores.size(); i+=2){
                if (i + 1 < vencedores.size()) {
                    Arbitro arbitro = new Arbitro("Jessica", 26, 'F', "Odivelas");
                    PartidaSingulares partidas = new PartidaSingulares(vencedores.get(i), vencedores.get(i+1),arbitro);
                     adicionarPartida(partidas);
                }
            }
            getJogadores().clear(); 
            getJogadores().addAll(vencedores);   
        }            
     if (getJogadores().size() == 1) {
        System.out.println("O vencedor do torneio é : " + getJogadores().get(0).getNome() + ". Muitos parabéns!!");     
    }              
  }
}  
                      
