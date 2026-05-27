import java.util.ArrayList;
import java.util.List;

/**
 * classe GrapheListe
 */
public class GrapheListe implements Graphe{
    /**
     * noeuds : liste des noeuds du graphe
     * arcs : liste des arcs du graphe
     */
    protected ArrayList<String> noeuds;
    protected ArrayList<Arcs> adjacence;

    /**
     * Constructeur de GrapheListe
     */
    public GrapheListe(){
        this.noeuds=new ArrayList<>();;
        this.adjacence=new ArrayList<>();
    }

    /**
     * getter de la liste des noeuds
     * @return liste des noeuds
     */
    public List<String> getNoeuds() {
        return this.noeuds;
    }

    /**
     * getter des arcs au noeud cible
     * @param noeudCible
     * @param poids
     * @return arcs au noeud cible
     */
    public Arcs getArcs(String noeudCible, double poids) {
        int index = this.noeuds.indexOf(noeudCible);
        if (index != -1) {
            for (Arc arcs : this.adjacence.get(index).getArcs()) {
                //verifie le poids en cas de nom identique
                if (arcs.poids == poids)
                    return this.adjacence.get(index);
            }
        }
        throw new Error("noeud inconnu");
    }

    /**
     * ajoute un arc entre deux noeuds
     * @param noeudSource
     * @param noeudCible
     * @param poids
     */
    public void ajouterArc(String noeudSource, String noeudCible, double poids){
        int i = this.noeuds.indexOf(noeudSource);
        if (i == -1) throw new Error("noeudSource inconnu");
        if (!this.noeuds.contains(noeudCible)) throw new Error("noeudCible inconnu");
        this.adjacence.get(i).ajouterArc(new Arc(noeudCible, poids));
    }

    /**
     * ajoute un noeud avec une liste d'arc comme sur la figure 3
     * @param noeud
     */
    public void ajouterNoeud (String noeud){
        if (!this.noeuds.contains(noeud)){
            this.noeuds.add(noeud);
            this.adjacence.add(new Arcs());
        }
    }

    /**
     * on imprime le graphe de la figure 3 à l"ecran
     * @return
     */
    @Override
    public String toString() {

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < this.noeuds.size() ; i++) {
            sb.append(noeuds.get(i)).append("->");

            ArrayList<Arc> arcs = adjacence.get(i).getArcs();
            for (Arc arc : arcs){
                if(arc.poids == (long) arc.poids){
                    sb.append(arc.noeudCible).append("(").append((long) arc.poids).append(")");
                } else {
                    sb.append(arc.noeudCible).append("(").append(arc.poids).append(")");
                }
            }
            sb.append("\n");
        }
        return sb.toString().trim();
    }
}
