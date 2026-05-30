import java.util.ArrayList;

public class MainDjikstra {
    public static void main(String []args){
        GrapheListe graphe = new GrapheListe();

        graphe.ajouterNoeud("A");
        graphe.ajouterNoeud("B");
        graphe.ajouterNoeud("C");
        graphe.ajouterNoeud("D");
        graphe.ajouterNoeud("E");

        graphe.ajouterArc("A","B",12.0);
        graphe.ajouterArc("A","D",87.0);
        graphe.ajouterArc("B","E",11.0);
        graphe.ajouterArc("C","A",19.0);
        graphe.ajouterArc("D","B",23.0);
        graphe.ajouterArc("D","C",10.0);
        graphe.ajouterArc("E","D",43.0);

        String depart = "A";
        String arrivee = "C";

        Djikstra dj = new Djikstra();
        Valeurs res = dj.resoudre(graphe, depart);
        for (String noeuds : graphe.getNoeuds()){
            double distance = res.getValeur(noeuds);
            if (distance == Double.MAX_VALUE){
                System.out.println("pas de chemin vers "+ noeuds);
            } else {
                System.out.println("pour aller a "+noeuds+" distance : "+distance+"\n");
            }
        }
        //affichage du chemin
        ArrayList<String> chemin = res.calculerChemin(arrivee);
        System.out.println("chemin : ");
        for (String s : chemin){
            System.out.println(s);
            if(s != arrivee){
                System.out.println(" -> ");
            }
        }


    }
}
