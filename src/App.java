import javax.swing.SwingUtilities;

import Campeonato.Campeonato;



public class App {
    public static void main(String[] args) {

        Campeonato campeonato = new Campeonato();
        SwingUtilities.invokeLater(() -> new HomePage());

    }
}


