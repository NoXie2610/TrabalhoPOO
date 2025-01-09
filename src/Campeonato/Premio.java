package Campeonato;

public class Premio {
    private String prémio;
    private int valor;
    public Premio(String prémio, int valor) {
        this.prémio = prémio;
        this.valor = valor;
    }
    public String getPrémio() {
        return prémio;
    }
    public void setPrémio(String prémio) {
        this.prémio = prémio;
    }
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public void premio(){
        System.out.println("O prémio é: " + prémio + " e um valor monetário de: " + valor + " euros ");
    }
}
