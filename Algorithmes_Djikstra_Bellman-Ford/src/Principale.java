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
        graphe.ajouterArc("A","B",12);
        graphe.ajouterArc("A","D",87);
        graphe.ajouterArc("B","E",11);
        graphe.ajouterArc("C","A",19);
        graphe.ajouterArc("D","B",23);
        graphe.ajouterArc("D","C",10);
        graphe.ajouterArc("E","D",43);

        System.out.println(graphe);
    }
}
