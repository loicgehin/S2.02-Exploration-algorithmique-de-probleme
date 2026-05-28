import java.util.ArrayList;

/**
 * classe BellmanFord
 */
public class BellmanFord {

    protected ArrayList<String> listeNoeuds;

    /**
     * resoudre le graphe en attrivant les distances et les parents
     * @param g
     * @param depart
     * @return Valeurs
     */
    Valeurs resoudre(Graphe g, String depart){
        this.listeNoeuds = g.getNoeuds();
        int nb = this.listeNoeuds.size();
        Valeurs res = new Valeurs();

        //initialisation des distances et precedents
        for (String noeud : this.listeNoeuds) {
            res.setValeur(noeud, Double.MAX_VALUE);
            res.setParent(noeud, null);
        }
        res.setValeur(depart, 0.0);

        //boucle principale d'attribution des distances
        for (int i = 0; i < nb - 1; i++) {
            //si pas de changement, on s'arrete
            boolean changement = false;

            //pour chaque noeud
            for (String noeud : this.listeNoeuds) {
                Arcs liaisons = g.getArcs(noeud);
                //pour chaque arc
                for (Arc arc : liaisons.getArcs()) {
                    String cible = arc.noeudCible;
                    double poids = arc.poids;
                    double distanceNoeud = res.getValeur(noeud);
                    double distanceCible = res.getValeur(cible);
                    //compare les distances et attribue la plus petite, si ne change pas on s'arrete
                    if (distanceNoeud != Double.MAX_VALUE && (distanceNoeud+poids < distanceCible)){
                        res.setValeur(cible, distanceNoeud+poids);
                        res.setParent(cible, noeud);
                        changement=true;
                    }
                }
            }
            if (!changement) break;
        }
        return res;
    }
}
