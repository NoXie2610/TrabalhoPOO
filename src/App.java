import javax.swing.SwingUtilities;

import Campeonato.Campeonato;

/**
 * The App class serves as the entry point for the application.
 * It initializes a Campeonato object and launches the HomePage GUI.
 * 
 * <p>This class contains the main method which is the starting point of the Java application.</p>
 * 
 * Usage:
 * <pre>
 * {@code
 * public static void main(String[] args) {
 *     Campeonato campeonato = new Campeonato();
 *     SwingUtilities.invokeLater(() -> new HomePage());
 * }
 * }
 * </pre>
 * 
 * @see Campeonato
 * @see HomePage
 */
public class App {
    public static void main(String[] args) {

        Campeonato campeonato = new Campeonato();
        SwingUtilities.invokeLater(() -> new HomePage());

    }
}


