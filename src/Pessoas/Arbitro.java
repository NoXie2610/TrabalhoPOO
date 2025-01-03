package Pessoas;
public class Arbitro extends Pessoa {
    private String nacionalidade;

    public Arbitro(String nome,int idade, char genero, String nacionalidade) {
        super(nome, idade, genero);
        this.nacionalidade = nacionalidade;
    }
    
    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
}    
    