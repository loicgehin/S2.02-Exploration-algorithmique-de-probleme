/**
 * class principale qui construit un graphe (figure 1 du sujet)
 */

public class Principale {
    public static void main(String [] args) {

        GrapheListe graphe = new GrapheListe();
        
        /**
         * ajoute des noeuds
         */
        graphe.ajouterNoeud("A");
        graphe.ajouterNoeud("B");
        graphe.ajouterNoeud("C");
        graphe.ajouterNoeud("D");
        graphe.ajouterNoeud("E");

        /**
         * ajoute des arcs
         */
        graphe.ajouterArc("A","B",12.0);
        graphe.ajouterArc("A","D",87.0);
        graphe.ajouterArc("B","E",11.0);
        graphe.ajouterArc("C","A",19.0);
        graphe.ajouterArc("D","B",23.0);
        graphe.ajouterArc("D","C",10.0);
        graphe.ajouterArc("E","D",43.0);

        System.out.println(graphe);
    }
}
