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
     * ajoute un noeud avec une liste d'arc
     * @param noeud
     */
    public void ajouterNoeud (String noeud){
        if (!this.noeuds.contains(noeud)){
            this.noeuds.add(noeud);
            this.adjacence.add(new Arcs());
        }
    }
}
