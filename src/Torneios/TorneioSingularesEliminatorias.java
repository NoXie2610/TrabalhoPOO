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

public class TorneioSingularesEliminatorias extends TorneioSingulares {
    private String nome;
    private String localizacao;
    private ArrayList <Jogador> vencedores;
    private char genero;
    
    public TorneioSingularesEliminatorias(ArrayList<PartidaSingulares> partidas, ArrayList<Jogador> jogadores,
         String nome, String localizacao, char genero) {
        super(partidas, jogadores);
        this.nome = nome;
        this.localizacao = localizacao;
        this.vencedores = new ArrayList<>();
        this.genero = genero;
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

    public char getGenero() {
        return genero;
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
            if( (partida.getJogador1().getGenero()==this.genero) && (partida.getJogador2().getGenero()==this.genero)){
                getPartidas().add(partida);
            }else{
                System.err.println("Jogadores com género não compatível com o torneio.");
            }

        } else {
            System.out.println("Erro ao adicionar partida!");
        }
    }

    @Override
    public void determinarVencedorTorneioSingulares(){
        if(getJogadores().size() == 0){
            System.err.println("Não existe jogadores para determinar um vencedor");
        } 
        else if (getJogadores().size() == 1) {
            System.out.println("O vencedor do torneio é : " + getJogadores().get(0).getNome() + ". Muitos parabéns!!");     
        }else{
            vencedores.clear();
            for (PartidaSingulares partida : getPartidas()) {
                System.out.println(partida.regras());
                partida.inicioPartida();
                Jogador winner = partida.determinarVencedor();
                partida.getJogador1().adicionarPartidaJogada();
                partida.getJogador2().adicionarPartidaJogada();
                vencedores.add(winner);
                System.out.println("O jogador " + winner.getNome() + " é o vencedor!");
            }  
        
            getPartidas().clear();
            for (int i = 0; i < vencedores.size(); i+=2){
                if (i + 1 < vencedores.size()) {
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

