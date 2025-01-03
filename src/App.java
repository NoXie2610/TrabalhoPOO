import java.lang.reflect.Array;
import java.util.ArrayList;

import Partidas.PartidaSingulares;
import Pessoas.Arbitro;
import Pessoas.Jogador;
import Torneios.TorneioSingulares;
import Torneios.TorneioSingularesEliminatorias;
import Torneios.TorneioSingularesPontos;


public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<PartidaSingulares> partidas = new ArrayList<>();
        ArrayList<Jogador> jogadores = new ArrayList<>();
        jogadores.add((new Jogador("Tiago", 20, 'M', "x", 800, 0)));
        jogadores.add((new Jogador("yuyu", 20, 'M', "x", 500, 0)));
        jogadores.add((new Jogador("Diogo", 20, 'M', "x", 1200, 0)));
        jogadores.add((new Jogador("dsadasdasiogo", 240, 'M', "x", 1, 0)));
        Arbitro arbitro = new Arbitro("Jessica", 26, 'F', "Odivelas");
        partidas.add(new PartidaSingulares(jogadores.get(0), jogadores.get(1), arbitro));
        partidas.add(new PartidaSingulares(jogadores.get(2), jogadores.get(3), arbitro));
        TorneioSingularesEliminatorias torneio = new TorneioSingularesEliminatorias(partidas, jogadores, "Torneop", "tuda");
        torneio.determinarVencedorTorneioSingulares();   
    }
}
