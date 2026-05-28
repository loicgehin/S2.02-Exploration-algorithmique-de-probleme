import java.util.ArrayList;
import java.util.List;

/**
 * interface Graphe
 */
public interface Graphe {
    /**
     * retourne la liste des noeuds du graphe
     * @return liste des noeuds
     */
    ArrayList<String> getNoeuds();

    /**
     * retourne les arcs du graphe au noeud cible
     * @param noeudCible
     * @return liste des arcs au noeud cible
     */
    Arcs getArcs(String noeudCible);

}