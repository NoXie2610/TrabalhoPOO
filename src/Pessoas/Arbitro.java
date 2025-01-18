package Pessoas;
/**
 * A class representing an Arbitro (Referee) which extends the Pessoa (Person) class.
 * This class includes additional attributes specific to a referee, such as nationality.
 * 
 * @see Pessoa
 */
public class Arbitro extends Pessoa {
    private String nacionalidade;

    /**
     * Constructs an Arbitro object with the specified name, age, gender, and nationality.
     * 
     * @param nome the name of the referee
     * @param idade the age of the referee
     * @param genero the gender of the referee
     * @param nacionalidade the nationality of the referee
     */
    public Arbitro(String nome, int idade, char genero, String nacionalidade) {
        super(nome, idade, genero);
        this.nacionalidade = nacionalidade;
    }

    /**
     * Gets the nationality of the referee.
     * 
     * @return the nationality of the referee
     */
    public String getNacionalidade() {
        return nacionalidade;
    }

    /**
     * Sets the nationality of the referee.
     * 
     * @param nacionalidade the new nationality of the referee
     */
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
}
    