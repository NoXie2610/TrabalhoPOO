import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationPage {
    public RegistrationPage() {
        JFrame frame = new JFrame("Registro de Jogadores");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel nameLabel = new JLabel("Nome:");
        JTextField nameField = new JTextField();
        JLabel ageLabel = new JLabel("Idade:");
        JTextField ageField = new JTextField();
        JLabel genderLabel = new JLabel("Gênero:");
        JTextField genderField = new JTextField();

        JButton submitButton = new JButton("Registrar");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String age = ageField.getText();
                String gender = genderField.getText();

                if (name.isEmpty() || age.isEmpty() || gender.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Here you can add code to handle the registration logic
                    JOptionPane.showMessageDialog(frame, "Jogador registrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(ageLabel);
        panel.add(ageField);
        panel.add(genderLabel);
        panel.add(genderField);
        panel.add(new JLabel()); // Empty cell
        panel.add(submitButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegistrationPage());
    }
}