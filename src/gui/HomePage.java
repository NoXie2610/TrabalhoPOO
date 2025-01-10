import javax.swing.*;

import Torneios.TorneioDoubles;
import Torneios.TorneioSingularesEliminatorias;
import Torneios.TorneioSingularesPontos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HomePage {
    public HomePage() {
        TorneioDoubles torneioDoubles = new TorneioDoubles(new ArrayList<>(), new ArrayList<>(), "Doubles", "1231", 'M');
        TorneioSingularesEliminatorias torneioSingularesEliminatorias = new TorneioSingularesEliminatorias(new ArrayList<>(), new ArrayList<>(), "Torneio Singulares eliminatorias", "Portugal", 'F');
        TorneioSingularesPontos torneioSingularesPontos = new TorneioSingularesPontos(new ArrayList<>(), new ArrayList<>(), "Torneio Singulares por Pontos", "Portugal", 'F');
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
                new RegistrationPage(torneioDoubles, torneioSingularesEliminatorias, torneioSingularesPontos); // Opens the registration page
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