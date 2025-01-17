import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import Partidas.*;
import Pessoas.*;
import Torneios.*;

public class HomePage {
    private JFrame frame;
    private ArrayList<Jogador> jogadores = new ArrayList<>();
    private ArrayList<PartidaSingulares> partidasSingulares = new ArrayList<>();
    private ArrayList<PartidaDoubles> partidasDoubles = new ArrayList<>();

    public HomePage() {
        frame = new JFrame("Gestão de Torneios");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
    
        // Menu superior (como você tem)
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        // ... (configuração do menu)
    
        // Adicionando botões principais na tela inicial
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 2)); // ou outro layout que prefira
    
        JButton btnRegistarJogador = new JButton("Registar Jogador");
        btnRegistarJogador.addActionListener(e -> abrirRegistoJogador());
    
        JButton btnRegistarArbitro = new JButton("Registar Árbitro");
        btnRegistarArbitro.addActionListener(e -> abrirRegistoArbitro());
    
        JButton btnGerarTorneio = new JButton("Gerar/Controlar Torneio");
        btnGerarTorneio.addActionListener(e -> abrirGerarTorneio());
    
        JButton btnVisualizarRanking = new JButton("Visualizar Ranking");
        btnVisualizarRanking.addActionListener(e -> abrirVisualizarRanking());
    
        // Adicionando os botões ao painel principal
        mainPanel.add(btnRegistarJogador);
        mainPanel.add(btnRegistarArbitro);
        mainPanel.add(btnGerarTorneio);
        mainPanel.add(btnVisualizarRanking);
    
        // Adicionando o painel principal à janela
        frame.add(mainPanel, BorderLayout.CENTER);
    
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }

    private void abrirRegistoJogador() {
        JFrame registoFrame = new JFrame("Registar Jogador");
        registoFrame.setSize(400, 300);
        registoFrame.setLayout(new GridLayout(5, 2));

        JLabel nomeLabel = new JLabel("Nome:");
        JTextField nomeField = new JTextField();
        JLabel idadeLabel = new JLabel("Idade:");
        JTextField idadeField = new JTextField();
        JLabel generoLabel = new JLabel("Genero (M/F):");
        JTextField generoField = new JTextField();
        JLabel nacionalidadeLabel = new JLabel("Nacionalidade:");
        JTextField nacionalidadeField = new JTextField();

        JButton salvarButton = new JButton("Salvar");
        salvarButton.addActionListener(e -> {
            String nome = nomeField.getText();
            int idade = Integer.parseInt(idadeField.getText());
            char genero = generoField.getText().charAt(0);
            String nacionalidade = nacionalidadeField.getText();
            int ranking = 0;
            int partidasjogadas = 0;
            jogadores.add(new Jogador(nome, idade, genero, nacionalidade, ranking, partidasjogadas));
            JOptionPane.showMessageDialog(registoFrame, "Jogador registrado com sucesso!");
            registoFrame.dispose();
        });

        registoFrame.add(nomeLabel);
        registoFrame.add(nomeField);
        registoFrame.add(idadeLabel);
        registoFrame.add(idadeField);
        registoFrame.add(generoLabel);
        registoFrame.add(generoField);
        registoFrame.add(new JLabel());
        registoFrame.add(salvarButton);

        registoFrame.setVisible(true);
    }

    private void abrirRegistoArbitro() {
        JFrame registoFrame = new JFrame("Registar Árbitro");
        registoFrame.setSize(400, 300);
        registoFrame.setLayout(new GridLayout(5, 2));

        JLabel nomeLabel = new JLabel("Nome:");
        JTextField nomeField = new JTextField();
        JLabel idadeLabel = new JLabel("Idade:");
        JTextField idadeField = new JTextField();
        JLabel generoLabel = new JLabel("Gênero (M/F):");
        JTextField generoField = new JTextField();
        JLabel localizacaoLabel = new JLabel("Localização:");
        JTextField localizacaoField = new JTextField();

        JButton salvarButton = new JButton("Salvar");
        salvarButton.addActionListener(e -> {
            String nome = nomeField.getText();
            int idade = Integer.parseInt(idadeField.getText());
            char genero = generoField.getText().charAt(0);
            String localizacao = localizacaoField.getText();
            JOptionPane.showMessageDialog(registoFrame, "Árbitro registrado com sucesso!");
            registoFrame.dispose();
        });

        registoFrame.add(nomeLabel);
        registoFrame.add(nomeField);
        registoFrame.add(idadeLabel);
        registoFrame.add(idadeField);
        registoFrame.add(generoLabel);
        registoFrame.add(generoField);
        registoFrame.add(localizacaoLabel);
        registoFrame.add(localizacaoField);
        registoFrame.add(new JLabel());
        registoFrame.add(salvarButton);

        registoFrame.setVisible(true);
    }

    private void abrirGerarTorneio() {
        JFrame torneioFrame = new JFrame("Gerar Torneio");
        torneioFrame.setSize(400, 200);
        torneioFrame.setLayout(new GridLayout(3, 1));

        JButton singularesButton = new JButton("Torneio Singulares");
        JButton doublesButton = new JButton("Torneio Doubles");

        singularesButton.addActionListener(e -> {
            String[] opcoes = {"Eliminatórias", "Por Pontos"};
            int escolha = JOptionPane.showOptionDialog(torneioFrame, "Escolha o tipo de torneio:", "Tipo de Torneio",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
            if (escolha == 0) {
                // Criar torneio eliminatórias
                TorneioSingularesEliminatorias eliminatorias = new TorneioSingularesEliminatorias(partidasSingulares, jogadores, "Eliminatórias", "Local", 'M');
                JOptionPane.showMessageDialog(torneioFrame, "Torneio eliminatórias criado!");
            } else if (escolha == 1) {
                // Criar torneio por pontos
                TorneioSingularesPontos pontos = new TorneioSingularesPontos(partidasSingulares, jogadores, "Por Pontos", "Local", 'M');
                JOptionPane.showMessageDialog(torneioFrame, "Torneio por pontos criado!");
            }
        });

        doublesButton.addActionListener(e -> {
        TorneioDoubles doubles = new TorneioDoubles(partidasDoubles, jogadores, "Doubles", "Local");
        JOptionPane.showMessageDialog(torneioFrame, "Torneio doubles criado!");
        });

        torneioFrame.add(singularesButton);
        torneioFrame.add(doublesButton);

        torneioFrame.setVisible(true);
    }

    private void abrirVisualizarRanking() {
        JFrame visualizarFrame = new JFrame("Visualizar Campeonato");
        visualizarFrame.setSize(400, 300);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        for (Jogador jogador : jogadores) {
            textArea.append("Jogador: " + jogador.getNome() + ", Ranking: " + jogador.getRanking() + "\n");
        }

        visualizarFrame.add(new JScrollPane(textArea));
        visualizarFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(HomePage::new);
    }
}
