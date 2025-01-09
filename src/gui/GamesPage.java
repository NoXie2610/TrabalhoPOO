import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamesPage {
    private JFrame frame;
    private JList<String> gamesList;
    private DefaultListModel<String> listModel;

    public GamesPage() {
        frame = new JFrame("Jogos do Torneio de Xadrez");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        listModel = new DefaultListModel<>();
        gamesList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(gamesList);
        
        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(e -> {
            frame.dispose(); // Close the games page
            new HomePage(); // Return to the home page
        });

        loadGames(); // Load games into the list

        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(backButton, BorderLayout.SOUTH);
        
        frame.setVisible(true);
    }

    private void loadGames() {
        // Sample data for demonstration purposes
        ArrayList<String> games = new ArrayList<>();
        games.add("Jogo 1: Jogador A vs Jogador B");
        games.add("Jogo 2: Jogador C vs Jogador D");
        games.add("Jogo 3: Jogador E vs Jogador F");
        
        for (String game : games) {
            listModel.addElement(game);
        }
    }
}