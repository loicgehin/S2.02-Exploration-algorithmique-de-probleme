import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LireReseau {

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
            if (ligne2.length() >=3 ){
                res.ajouterArc(bout2[0], bout2[1], Double.parseDouble(bout2[2]));
            }
        }
        br2.close();
        return res;
    }
}
