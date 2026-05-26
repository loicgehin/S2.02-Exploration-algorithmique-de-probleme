/**
 * Classe Arc
 */
public class Arc {
    /**
     * noeudCible : le noeud cible de l'arc
     * poids : le poids de l'arc
     */
    protected String noeudCible;
    protected double poids;

    /**
     * Constructeur de l'arc
     * @param noeudCible
     * @param poids
     */
    public Arc(String noeudCible, double poids){
        this.noeudCible = noeudCible;
        if (poids<0) throw new Error ("erreur poids");
        this.poids = poids;
    }


}
