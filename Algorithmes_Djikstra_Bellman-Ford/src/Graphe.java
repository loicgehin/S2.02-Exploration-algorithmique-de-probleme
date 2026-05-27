import java.util.List;

/**
 * interface Graphe
 */
public interface Graphe {
    /**
     * retourne la liste des noeuds du graphe
     * @return
     */
    List<String> getNoeuds();

    /**
     * retourne les arcs du graphe au noeud cible
     * @param noeudCible
     * @param poids
     * @return liste des arcs au noeud cible
     */
    Arcs getArcs(String noeudCible, double poids);

}