import java.util.ArrayList;

/**
 * classe Arcs
 */
public class Arcs {
    /**
     * arcs : liste des arcs du graphe
     */
    protected ArrayList<Arc> arcs;

    /**
     * Constructeur de Arcs
     */
    public Arcs(){
        arcs=new ArrayList<Arc>();
    }

    /**
     * ajoute un arc au graphe
     * @param arc
     */
    public void ajouterArc(Arc arc){
        arcs.add(arc);
    }

    /**
     * retourne la liste des arcs du graphe
     * @return arcs
     */
    public ArrayList<Arc> getArcs(){
        return arcs;
    }


}
