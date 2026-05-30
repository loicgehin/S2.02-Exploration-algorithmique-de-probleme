import java.util.ArrayList;

public class Djikstra {

    protected ArrayList<String> listeNoeuds;
    protected ArrayList<String> Q;

    /**
     * resoudre le graphe en attrivant les distances et les parents
     * @param g
     * @param depart
     * @return res
     */
    Valeurs resoudre(Graphe g, String depart){
        Valeurs res = new Valeurs();
        this.listeNoeuds = g.getNoeuds();

        //initialisation
        this.Q = new ArrayList<>();
        for(String noeuds : this.listeNoeuds) {
            res.setValeur(noeuds, Double.MAX_VALUE);
            res.setParent(noeuds, null);
            this.Q.add(noeuds);
        }
        res.setValeur(depart,0.0);

        //boucle principale
        while (!this.Q.isEmpty()){
            // on cherche la plus petite distance
            String u = this.Q.get(0);
            for (String noeuds : this.Q){
                if(res.getValeur(noeuds) < res.getValeur(u)){
                    u = noeuds;
                }
            }
            //on retire u de Q
            this.Q.remove(u);

            Arcs liaison = g.getArcs(u);
            for(Arc arc : liaison.getArcs()){
                String cible = arc.noeudCible;
                double poids = arc.poids;
                double distanceDeU = res.getValeur(u);
                double distenceCible = res.getValeur(cible);
                // si le suivant est encore dans Q et qu'on trouve un chemin plus court
                if(this.Q.contains(cible)&& distanceDeU != Double.MAX_VALUE && (distanceDeU + poids < distenceCible)){
                    res.setValeur(cible,distanceDeU + poids);
                    res.setParent(cible, u);
                }
            }

        }
        return res;
    }

}
