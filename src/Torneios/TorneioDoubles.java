    package Torneios;

    import java.util.ArrayList;
    import java.util.Random;

    import Partidas.PartidaDoubles;
    import Pessoas.Jogador;

    public class TorneioDoubles {
        private ArrayList<PartidaDoubles> partidas;
        private ArrayList<Jogador> jogadores;
        private ArrayList<ArrayList<Jogador>> equipas;
        private String nome;
        private String localizacao;
        private int[] pontosEquipas;
        private char genero;
    
        public void setPartidas(ArrayList<PartidaDoubles> partidas) {
            this.partidas = partidas;
        }

        public ArrayList<Jogador> getJogadores() {
            return jogadores;
        }

        public void setJogadores(ArrayList<Jogador> jogadores) {
            this.jogadores = jogadores;
        }

        public ArrayList<ArrayList<Jogador>> getEquipas() {
            return equipas;
        }

        public void setEquipas(ArrayList<ArrayList<Jogador>> equipas) {
            this.equipas = equipas;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getLocalizacao() {
            return localizacao;
        }

        public void setLocalizacao(String localizacao) {
            this.localizacao = localizacao;
        }

        public int[] getPontosEquipas() {
            return pontosEquipas;
        }

        public void setPontosEquipas(int[] pontosEquipas) {
            this.pontosEquipas = pontosEquipas;
        }

        public char getGenero() {
            return genero;
        }

        public void setGenero(char genero) {
            this.genero = genero;
        }

        public TorneioDoubles(ArrayList<PartidaDoubles> partidas, ArrayList<Jogador> jogadores, String nome, String localizacao, char genero) {
            this.partidas = partidas;
            this.jogadores = jogadores;
            this.nome = nome;
            this.localizacao = localizacao;
            this.equipas = new ArrayList<>();
            this.genero = genero;
            this.pontosEquipas = new int[jogadores.size() / 2]; 
        }

        public ArrayList<PartidaDoubles> getPartidas() {
            return partidas;
        }

        public void adicionarPartida(PartidaDoubles partida){
            this.partidas.add(partida);
        }

        public void formarEquipas(){
            if (jogadores.size() % 2 != 0) {
                System.out.println("É necessario um número par de jogadores para formar equipas");  
            }
            for (int i = 0; i < jogadores.size(); i += 2 ) {
                ArrayList<Jogador>equipa = new ArrayList<>();
                equipa.add(jogadores.get(i));
                equipa.add(jogadores.get(i+1));
                equipas.add(equipa);
            }
            for (int i = 0; i < equipas.size(); i++){
                System.out.println("Equipa número " + (i + 1) + ": " + equipas.get(i).get(0).getNome() + " e " + equipas.get(i).get(1).getNome());
            }
        }

        public void determinarVencedorTorneioDoubles(){
            for (PartidaDoubles partida : getPartidas()){
                Jogador winner = partida.determinarVencedor();
                partida.getJogador1Eq1().adicionarPartidaJogada();
                partida.getJogador1Eq2().adicionarPartidaJogada();
                partida.getJogador2Eq1().adicionarPartidaJogada();
                partida.getJogador2Eq2().adicionarPartidaJogada();
                int pontosWinner = 3;
                double gametime = partida.tempoPartida();
                if (gametime < 20) {
                    pontosWinner = 4;
                }
                for (int i = 0; i < equipas.size(); i++){
                    if (equipas.get(i).contains(winner)) {
                        pontosEquipas[i] += pontosWinner;
                    }
                }
            }
            int max = 0;
            int maxIndex = 0;
            for(int i = 0; i < pontosEquipas.length; i++ ){
                if (max < pontosEquipas[i]) {
                    max = pontosEquipas[i];
                    maxIndex = i;
                }
            }

            ArrayList<Jogador> equipaVencedora = equipas.get(maxIndex);
            System.out.println("A equipa vencedora do torneio é: " + equipas.get(maxIndex).get(0).getNome() + " e " + equipas.get(maxIndex).get(1).getNome() + " com " + max + "pontos, parabéns!");

        }

    }
