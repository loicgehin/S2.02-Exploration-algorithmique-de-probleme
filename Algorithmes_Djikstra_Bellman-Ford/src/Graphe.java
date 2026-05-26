import java.util.List;

public interface Graphe {

    List<String> getnoeudCible();

    Arcs getArcs(String noeudCible, double poids);

}
