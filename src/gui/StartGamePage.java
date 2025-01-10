import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartGamePage {
    public StartGamePage() {
        JFrame frame = new JFrame("Iniciar Jogo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));
        
        JLabel player1Label = new JLabel("Selecionar Jogador 1:");
        JComboBox<String> player1ComboBox = new JComboBox<>();
        JLabel player2Label = new JLabel("Selecionar Jogador 2:");
        JComboBox<String> player2ComboBox = new JComboBox<>();
        
        JLabel gameParametersLabel = new JLabel("Parâmetros do Jogo:");
        JTextField gameParametersField = new JTextField();
        
        JButton startGameButton = new JButton("Iniciar Jogo");
        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String player1 = (String) player1ComboBox.getSelectedItem();
                String player2 = (String) player2ComboBox.getSelectedItem();
                String parameters = gameParametersField.getText();
                
                // Logic to start the game with selected players and parameters
                JOptionPane.showMessageDialog(frame, "Jogo iniciado entre " + player1 + " e " + player2 + " com parâmetros: " + parameters);
            }
        });
        
        panel.add(player1Label);
        panel.add(player1ComboBox);
        panel.add(player2Label);
        panel.add(player2ComboBox);
        panel.add(gameParametersLabel);
        panel.add(gameParametersField);
        panel.add(new JLabel()); // Empty cell
        panel.add(startGameButton);
        
        frame.add(panel);
        frame.setVisible(true);
    }
}