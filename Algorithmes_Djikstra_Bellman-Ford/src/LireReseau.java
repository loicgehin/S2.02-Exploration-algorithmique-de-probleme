import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * classe LireReseau
 */
public class LireReseau {

    /**
     * lire un fichier de reseau
     * @param fichier_stations
     * @param fichier_connexions
     * @return Graphe complete a base des fichiers
     * @throws IOException
     */
    public static Graphe lire(String fichier_stations, String fichier_connexions) throws IOException {
        //lecture des stations
        GrapheListe res = new GrapheListe();
        BufferedReader br = new BufferedReader(new FileReader(fichier_stations));
        String ligne;
        while ((ligne = br.readLine())!=null){
            //découpe la ligne par ';' en un tableau
            String[] bout = ligne.split(";");
            res.ajouterNoeud(bout[0]);
        }
        br.close();

        //lecture des connexions
        BufferedReader br2 = new BufferedReader(new FileReader(fichier_connexions));
        String ligne2;
        while ((ligne2 = br2.readLine())!=null){
            String[] bout2 = ligne2.split(";");
            if (bout2.length >=3 ){
                res.ajouterNoeud(bout2[0]);
                res.ajouterNoeud(bout2[1]);
                res.ajouterArc(bout2[0], bout2[1], Double.parseDouble(bout2[2]));
                //pour les arcs en sens inverse
                res.ajouterArc(bout2[1], bout2[0], Double.parseDouble(bout2[2]));
            }
        }
        br2.close();
        return res;
    }
}
