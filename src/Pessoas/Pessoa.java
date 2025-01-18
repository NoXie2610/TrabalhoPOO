package Pessoas;

/**
 * A class representing a person with a name, age, and gender.
 */
public abstract class Pessoa {
    private String nome;
    private int idade;
    private char genero;

    /**
     * Constructs a new Pessoa with the specified name, age, and gender.
     *
     * @param nome the name of the person
     * @param idade the age of the person
     * @param genero the gender of the person
     */
    public Pessoa(String nome, int idade, char genero) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
    }

    /**
     * Returns the name of the person.
     *
     * @return the name of the person
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets the name of the person.
     *
     * @param nome the new name of the person
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Returns the age of the person.
     *
     * @return the age of the person
     */
    public int getIdade() {
        return idade;
    }

    /**
     * Sets the age of the person.
     *
     * @param idade the new age of the person
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * Returns the gender of the person.
     *
     * @return the gender of the person
     */
    public char getGenero() {
        return genero;
    }

    /**
     * Sets the gender of the person.
     *
     * @param genero the new gender of the person
     */
    public void setGenero(char genero) {
        this.genero = genero;
    }
}
