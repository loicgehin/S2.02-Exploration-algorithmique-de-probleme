import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * on fait des test pour verifier si tout va bien
 */
public class testGrapheListe {

    private GrapheListe graphe;

    @BeforeEach
    public void init(){
        graphe = new GrapheListe();
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
    }

    // test pour le graphe
    @Test
    public void testNombreNoeuds() {
        assertEquals(5, graphe.getNoeuds().size());
    }

    @Test
    public void testArcsDeA(){
        assertEquals(2, graphe.getArcs("A").getArcs().size());
    }

    @Test
    public void testNoeudsInconnu(){
        assertThrows(Error.class, ()-> graphe.getArcs("V"));
    }

    //test pour Bellmanford
    @Test
    public void testBellmanFordDistances(){
        BellmanFord bf = new BellmanFord();
        Valeurs res = bf.resoudre(graphe, "A");
        assertEquals(0.0, res.getValeur("A"));
        assertEquals(12.0, res.getValeur("B"));
        assertEquals(76.0, res.getValeur("C"));
    }

    @Test
    public void  testBellmanFordParents(){
        BellmanFord bf = new BellmanFord();
        Valeurs res = bf.resoudre(graphe, "A");
        assertEquals("A", res.getParent("B"));
        assertEquals("D", res.getParent("C"));
    }

    //test pour Djikstra
    @Test
    public void testDjikstraDistances(){
        Djikstra dj = new Djikstra();
        Valeurs res = dj.resoudre(graphe, "A");
        assertEquals(0.0, res.getValeur("A"));
        assertEquals(12.0, res.getValeur("B"));
        assertEquals(76.0, res.getValeur("C"));
    }

    @Test
    public void  testDjikstraParents(){
        Djikstra dj = new Djikstra();
        Valeurs res = dj.resoudre(graphe, "A");
        assertEquals("A", res.getParent("B"));
        assertEquals("D", res.getParent("C"));
    }


}
