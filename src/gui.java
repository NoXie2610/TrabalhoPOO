import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui {
    public gui() {
        JFrame frame = new JFrame("Torneio de Xadrez");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        JLabel tournamentTypeLabel = new JLabel("Tipo de Torneio:");
        String[] tournamentTypes = {"Masculino Individual", "Feminino Individual", "Duplas Mista"};
        JComboBox<String> tournamentTypeComboBox = new JComboBox<>(tournamentTypes);

        JLabel player1Label = new JLabel("Jogador 1:");
        JTextField player1Field = new JTextField();
        JLabel player2Label = new JLabel("Jogador 2:");
        JTextField player2Field = new JTextField();
        JLabel resultLabel = new JLabel("Resultado:");
        JTextField resultField = new JTextField();

        JButton submitButton = new JButton("Submeter");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tournamentType = (String) tournamentTypeComboBox.getSelectedItem();
                String player1 = player1Field.getText();
                String player2 = player2Field.getText();
                String result = resultField.getText();
                // Aqui você pode adicionar o código para salvar os resultados do jogo
                JOptionPane.showMessageDialog(frame, "Resultado salvo: " + tournamentType + " - " + player1 + " vs " + player2 + " - " + result);
            }
        });

        panel.add(tournamentTypeLabel);
        panel.add(tournamentTypeComboBox);
        panel.add(player1Label);
        panel.add(player1Field);
        panel.add(player2Label);
        panel.add(player2Field);
        panel.add(resultLabel);
        panel.add(resultField);
        panel.add(new JLabel()); // empty cell
        panel.add(submitButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new gui();
    }
}
