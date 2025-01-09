import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage {
    public HomePage() {
        JFrame frame = new JFrame("Torneio de Xadrez - Página Inicial");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        JButton registrationButton = new JButton("Registrar Jogador");
        JButton gamesButton = new JButton("Ver Jogos");
        JButton startGameButton = new JButton("Iniciar Jogo");

        registrationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistrationPage(); // Opens the registration page
                frame.dispose(); // Closes the home page
            }
        });

        gamesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GamesPage(); // Opens the games page
                frame.dispose(); // Closes the home page
            }
        });

        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StartGamePage(); // Opens the start game page
                frame.dispose(); // Closes the home page
            }
        });

        frame.add(registrationButton);
        frame.add(gamesButton);
        frame.add(startGameButton);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HomePage());
    }
}