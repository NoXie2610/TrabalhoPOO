    package Torneios;

    import java.util.ArrayList;
    import java.util.Random;

    import Partidas.PartidaDoubles;
    import Pessoas.Jogador;

    /**
     * A class representing a doubles tournament.
     */
    public class TorneioDoubles {
        private ArrayList<PartidaDoubles> partidas;
        private ArrayList<Jogador> jogadores;
        private ArrayList<ArrayList<Jogador>> equipas;
        private String nome;
        private String localizacao;
        private int[] pontosEquipas;

        /**
         * Sets the list of matches.
         * 
         * @param partidas the list of matches
         */
        public void setPartidas(ArrayList<PartidaDoubles> partidas) {
            this.partidas = partidas;
        }

        /**
         * Gets the list of players.
         * 
         * @return the list of players
         */
        public ArrayList<Jogador> getJogadores() {
            return jogadores;
        }

        /**
         * Sets the list of players.
         * 
         * @param jogadores the list of players
         */
        public void setJogadores(ArrayList<Jogador> jogadores) {
            this.jogadores = jogadores;
        }

        /**
         * Gets the list of teams.
         * 
         * @return the list of teams
         */
        public ArrayList<ArrayList<Jogador>> getEquipas() {
            return equipas;
        }

        /**
         * Sets the list of teams.
         * 
         * @param equipas the list of teams
         */
        public void setEquipas(ArrayList<ArrayList<Jogador>> equipas) {
            this.equipas = equipas;
        }

        /**
         * Gets the name of the tournament.
         * 
         * @return the name of the tournament
         */
        public String getNome() {
            return nome;
        }

        /**
         * Sets the name of the tournament.
         * 
         * @param nome the name of the tournament
         */
        public void setNome(String nome) {
            this.nome = nome;
        }

        /**
         * Gets the location of the tournament.
         * 
         * @return the location of the tournament
         */
        public String getLocalizacao() {
            return localizacao;
        }

        /**
         * Sets the location of the tournament.
         * 
         * @param localizacao the location of the tournament
         */
        public void setLocalizacao(String localizacao) {
            this.localizacao = localizacao;
        }

        /**
         * Gets the points of the teams.
         * 
         * @return the points of the teams
         */
        public int[] getPontosEquipas() {
            return pontosEquipas;
        }

        /**
         * Sets the points of the teams.
         * 
         * @param pontosEquipas the points of the teams
         */
        public void setPontosEquipas(int[] pontosEquipas) {
            this.pontosEquipas = pontosEquipas;
        }

        /**
         * Constructor for the TorneioDoubles class.
         * 
         * @param partidas the list of matches
         * @param jogadores the list of players
         * @param nome the name of the tournament
         * @param localizacao the location of the tournament
         */
        public TorneioDoubles(ArrayList<PartidaDoubles> partidas, ArrayList<Jogador> jogadores, String nome, String localizacao) {
            this.partidas = partidas;
            this.jogadores = jogadores;
            this.nome = nome;
            this.localizacao = localizacao;
            this.equipas = new ArrayList<>();
            this.pontosEquipas = new int[jogadores.size() / 2]; 
        }

        /**
         * Gets the list of matches.
         * 
         * @return the list of matches
         */
        public ArrayList<PartidaDoubles> getPartidas() {
            return partidas;
        }

        /**
         * Adds a match to the list of matches.
         * 
         * @param partida the match to add
         */
        public void adicionarPartida(PartidaDoubles partida){
            this.partidas.add(partida);
        }

        /**
         * Forms teams from the list of players.
         */
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

        /**
         * Determines the winner of the doubles tournament.
         */
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
            System.out.println("A equipa vencedora do torneio é: " + equipaVencedora.get(0).getNome() + " e " + equipaVencedora.get(1).getNome() + " com " + max + "pontos, parabéns!");

        }
    }
