import java.util.ArrayList;

public class MainBellmanFord {
    public static void main(String[] args){
        GrapheListe graphe = new GrapheListe();

        graphe.ajouterNoeud("A");
        graphe.ajouterNoeud("B");
        graphe.ajouterNoeud("C");
        graphe.ajouterNoeud("D");
        graphe.ajouterNoeud("E");

        graphe.ajouterArc("A","B",4.0);
        graphe.ajouterArc("A","C",2.0);
        graphe.ajouterArc("B","C",3.0);
        graphe.ajouterArc("B","D",1.0);
        graphe.ajouterArc("C","D",2.0);
        graphe.ajouterArc("D","E",3.0);

        String depart="A";
        String arrivee="E";

        BellmanFord bf =new BellmanFord();
        Valeurs res=bf.resoudre(graphe, depart);

        for (String noeud : graphe.getNoeuds()) {
            double dist = res.getValeur(noeud);
            if (dist == Double.MAX_VALUE) {
                System.out.println("pas de chemin");
            } else{
                System.out.println("pour aller a "+ noeud+ ", distance: "+dist+"\n");
            }

        }
        //ArrayList correspondant au chemin
        ArrayList<String> chemin= res.calculerChemin(arrivee);
        if (chemin.isEmpty()) System.out.println("pas de chemin");
        else {
            System.out.println("chemin: ");
            //affiche le chemin
            for (String s : chemin) {
                System.out.print(s );
                //n'affiche pas la fleche si on est sur la derniere destination
                if (s!=arrivee) System.out.print(" -> ");
            }
        }
    }
}
