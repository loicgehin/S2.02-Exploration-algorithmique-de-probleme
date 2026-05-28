import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MainTransport {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.exit(1);
        }
        try {
            String fichier_stations = "../stan.nodes.txt";
            String fichier_connexions = "../stan.edges.txt";

            Graphe reseauStan = LireReseau.lire(fichier_stations, fichier_connexions);
            String regex = "\\[|\\]";
            String depart = args[0];
            String arrivee = args[1];
            depart = depart.split(regex)[1];
            arrivee = arrivee.split(regex)[1];


            //bellmanFord
            long debut = System.nanoTime();
            BellmanFord bf = new BellmanFord();
            Valeurs resBf = bf.resoudre(reseauStan, depart);
            long fin = System.nanoTime();
            long tempsBF = (fin - debut)/1000000;
            ArrayList<String> cheminBf;
            try {
                cheminBf= resBf.calculerChemin(arrivee);
            }catch (Throwable e){
                cheminBf = new ArrayList<>();
                cheminBf.add(depart);
            }
            String resPy = "";
            for (int i = 0; i < cheminBf.size(); i++) {
                resPy += cheminBf.get(i);
                //';' aprés chaque noeud sauf le dernier
                if (i != cheminBf.size() - 1) resPy += ";";
            }
            System.out.print(resPy);

            //TODO : ajouter Dijkstra

            //comparaison temps dans un txt generer pour ne pas faire bugger l'interface python, true permet d'ajouter au fichier
            FileWriter fw = new FileWriter("temps.txt",true);
            fw.write("Depart : "+depart+" ");
            fw.write("Arrivee : "+arrivee+" ");
            fw.write("chemin : "+resPy+"\n");
            fw.write("BellmanFord : "+tempsBF + "\n");
            //TODO : ajouter les temps de Dijkstra
//            fw.write("Dijkstra : "+ tempsDj + "\n");
            fw.close();
        } catch (Throwable e) {
            System.exit(1);
        }

    }
}
