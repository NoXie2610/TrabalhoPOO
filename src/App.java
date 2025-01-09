import Partidas.PartidaSingulares;
import Pessoas.Arbitro;
import Pessoas.Jogador;
import Torneios.TorneioSingularesEliminatorias;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class App {
    public static void main(String[] args) {
        ArrayList<PartidaSingulares> partidas = new ArrayList<>();
        ArrayList<Jogador> jogadores = new ArrayList<>();
        Scanner scanner;
        try {
            scanner = new Scanner(new File("rankings.txt"));
            while (scanner.hasNextLine()) {
                jogadores.add(new Jogador(scanner.nextLine().split(":")[0], 25, 'M', "", Integer.parseInt(scanner.nextLine().split(":")[1]), 0));
            
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        jogadores.add((new Jogador("Tiago", 20, 'M', "x", 800, 0)));
        jogadores.add((new Jogador("yuyu", 20, 'M', "x", 500, 0)));
        jogadores.add((new Jogador("Diogo", 20, 'M', "x", 1200, 0)));
        jogadores.add((new Jogador("dsadasdasiogo", 240, 'M', "x", 1, 0)));
        Arbitro arbitro = new Arbitro("Jessica", 26, 'F', "Odivelas");
        partidas.add(new PartidaSingulares(jogadores.get(0), jogadores.get(2), arbitro));
        partidas.add(new PartidaSingulares(jogadores.get(1), jogadores.get(3), arbitro));
        TorneioSingularesEliminatorias torneio = new TorneioSingularesEliminatorias(partidas, jogadores, "Torneop", "tuda",'M');
        torneio.determinarVencedorTorneioSingulares();


    }
}


