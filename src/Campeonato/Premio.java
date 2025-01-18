package Campeonato;

/**
 * A class representing a prize in a championship.
 */
public class Premio {

    /**
     * The name of the prize.
     */
    private String prémio;

    /**
     * The monetary value of the prize.
     */
    private int valor;

    /**
     * Constructs a new Premio object with the specified name and value.
     *
     * @param prémio the name of the prize
     * @param valor the monetary value of the prize
     */
    public Premio(String prémio, int valor) {
        this.prémio = prémio;
        this.valor = valor;
    }

    /**
     * Gets the name of the prize.
     *
     * @return the name of the prize
     */
    public String getPrémio() {
        return prémio;
    }

    /**
     * Sets the name of the prize.
     *
     * @param prémio the new name of the prize
     */
    public void setPrémio(String prémio) {
        this.prémio = prémio;
    }

    /**
     * Gets the monetary value of the prize.
     *
     * @return the monetary value of the prize
     */
    public int getValor() {
        return valor;
    }

    /**
     * Sets the monetary value of the prize.
     *
     * @param valor the new monetary value of the prize
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    /**
     * Prints the details of the prize.
     */
    public void premio() {
        System.out.println("O prémio é: " + prémio + " e um valor monetário de: " + valor + " euros ");
    }
}
        System.out.println("O prémio é: " + prémio + " e um valor monetário de: " + valor + " euros ");
    }
}
