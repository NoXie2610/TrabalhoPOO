package Pessoas;
/**
 * A class representing a player (Jogador) which extends the Pessoa class.
 * It includes additional attributes such as nationality, ranking, and number of matches played.
 */
public class Jogador extends Pessoa {
    private String nacionalidade;
    private int ranking;
    private int partidasJogadas;

    /**
     * Constructs a new Jogador with the specified details.
     *
     * @param nome the name of the player
     * @param idade the age of the player
     * @param genero the gender of the player
     * @param nacionalidade the nationality of the player
     * @param ranking the ranking of the player
     * @param partidasJogadas the number of matches played by the player
     */
    public Jogador(String nome, int idade, char genero, String nacionalidade, int ranking, int partidasJogadas) {
        super(nome, idade, genero);
        this.nacionalidade = nacionalidade;
        this.ranking = ranking;
        this.partidasJogadas = partidasJogadas;
    }

    /**
     * Gets the nationality of the player.
     *
     * @return the nationality of the player
     */
    public String getNacionalidade() {
        return nacionalidade;
    }

    /**
     * Sets the nationality of the player.
     *
     * @param nacionalidade the new nationality of the player
     */
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    /**
     * Gets the ranking of the player.
     *
     * @return the ranking of the player
     */
    public int getRanking() {
        return ranking;
    }

    /**
     * Sets the ranking of the player.
     *
     * @param ranking the new ranking of the player
     */
    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    /**
     * Gets the number of matches played by the player.
     *
     * @return the number of matches played by the player
     */
    public int getPartidasJogadas() {
        return partidasJogadas;
    }

    /**
     * Sets the number of matches played by the player.
     *
     * @param partidasJogadas the new number of matches played by the player
     */
    public void setPartidasJogadas(int partidasJogadas) {
        this.partidasJogadas = partidasJogadas;
    }

    /**
     * Increments the number of matches played by the player by one.
     */
    public void adicionarPartidaJogada() {
        this.partidasJogadas += 1;
    }

    /**
     * Returns a string representation of the player.
     *
     * @return a string representation of the player in the format "name:age:gender:nationality:ranking:matchesPlayed"
     */
    @Override
    public String toString() {
        return this.getNome() + ":" + this.getIdade() + ":" + this.getGenero() + ":" + this.getNacionalidade() + ":" + this.getRanking() + ":" + this.getPartidasJogadas();
    }
}
