import javax.swing.*;

import Pessoas.Jogador;
import Torneios.TorneioDoubles;
import Torneios.TorneioSingulares;
import Torneios.TorneioSingularesEliminatorias;
import Torneios.TorneioSingularesPontos;
import Campeonato.Campeonato;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

public class RegistrationPage {
    private Campeonato campeonato;
    private TorneioDoubles torneioDoubles;
    private TorneioSingularesEliminatorias torneioSingularesEliminatorias;
    private TorneioSingularesPontos torneioSingularesPontos;
    public RegistrationPage(Campeonato campeonato, TorneioDoubles torneioDoubles, TorneioSingularesEliminatorias torneioSingularesEliminatorias, TorneioSingularesPontos torneioSingularesPontos) {
        this.torneioDoubles = torneioDoubles;
        this.torneioSingularesEliminatorias = torneioSingularesEliminatorias;
        this.torneioSingularesPontos = torneioSingularesPontos;
        JFrame frame = new JFrame("Registro de Jogadores");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel nameLabel = new JLabel("Nome:");
        JTextField nameField = new JTextField();
        JLabel ageLabel = new JLabel("Idade:");
        JTextField ageField = new JTextField();
        JLabel genderLabel = new JLabel("Gênero (M ou F):");
        JTextField genderField = new JTextField();
        JLabel nationalityLabel = new JLabel("Nacionalidade:");
        JTextField nationalityField = new JTextField();
        JButton submitButton = new JButton("Registrar");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String age = ageField.getText();
                String gender = genderField.getText();
                String nationality = nationalityField.getText();
                if (name.isEmpty() || age.isEmpty() || gender.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (!gender.equals("M") && !gender.equals("F")) {
                        JOptionPane.showMessageDialog(frame,"Por favor, preencha os campos pretendidos de forma correta.");
                    }
                }
                int playerAge = 0;
                try {
                    playerAge = Integer.parseInt(age);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame,"A idade necessita de ser um número.");
                }
                if (playerAge < 0) {
                    JOptionPane.showMessageDialog(frame,"A idade precisa de ser superior a 0");
                    return;
                }
                int playerRaking = 0;
                int gamesPlayed = 0;
                
                Jogador jogador = new Jogador(name, playerAge, gender.charAt(0), nationality, playerRaking, gamesPlayed);
                torneioDoubles.getJogadores().add(jogador);
                torneioSingularesEliminatorias.getJogadores().add(jogador);
                torneioSingularesPontos.getJogadores().add(jogador);
                campeonato.getAllPlayers().add(jogador);
                addJogadorToFile(jogador);
                JOptionPane.showMessageDialog(frame, "Jogador registrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            }
            
        });

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(ageLabel);
        panel.add(ageField);
        panel.add(genderLabel);
        panel.add(genderField);
        panel.add(nationalityLabel);
        panel.add(nationalityField);
        panel.add(new JLabel());
        panel.add(submitButton);

        frame.add(panel);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        TorneioDoubles torneioDoubles = new TorneioDoubles(new ArrayList<>(), new ArrayList<>(), "teste", "1231", 'M');
    }




    private void addJogadorToFile(Jogador jogador){
        PrintWriter printWriter = new PrintWriter(new File("rankings.txt"));

        printWriter.println(jogador);

        printWriter.close();
    }
}