package Pessoas;
public class Jogador extends Pessoa {
    private String nacionalidade;
    private int ranking;
    private int partidasJogadas;
    public Jogador(String nome, int idade, char genero, String nacionalidade, int ranking, int partidasJogadas) {
        super(nome, idade, genero);
        this.nacionalidade = nacionalidade;
        this.ranking = ranking;
        this.partidasJogadas = partidasJogadas;
    }
    public String getNacionalidade() {
        return nacionalidade;
    }
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
    public int getRanking() {
        return ranking;
    }
    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
    public int getPartidasJogadas() {
        return partidasJogadas;
    }
    public void setPartidasJogadas(int partidasJogadas) {
        this.partidasJogadas = partidasJogadas;
    }

    public void adicionarPartidaJogada(){
        this.partidasJogadas += 1;
    }
    @Override
    public String toString() {
        return this.getNome()+":"+this.getIdade()+":"+this.getGenero()+":"+this.getNacionalidade()+":"+this.getRanking()+":"+this.getPartidasJogadas();
    }
    
}
