/**
 * Classe Arc
 */
public class Arc {
    /**
     * noeudCible : le noeud cible de l'arc
     * poids : le poids de l'arc
     */
    protected String noeudCible;
    protected Double poids;

    /**
     * Constructeur de l'arc
     * @param noeudCible
     * @param poids
     */
    public Arc(String noeudCible, Double poids){
        this.noeudCible = noeudCible;
        if (poids<0) throw new Error ("erreur poids");
        this.poids = poids;
    }


}
