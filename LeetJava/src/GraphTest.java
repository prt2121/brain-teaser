import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by pt2121 on 12/21/15.
 */
public class GraphTest {

  Graph g = new Graph();

  @Before
  public void setup() {
    //Lets create nodes as given as an example in the article
    Graph.Node<Character> nA = new Graph.Node<>('A');
    Graph.Node<Character> nB = new Graph.Node<>('B');
    Graph.Node<Character> nC = new Graph.Node<>('C');
    Graph.Node<Character> nD = new Graph.Node<>('D');
    Graph.Node<Character> nE = new Graph.Node<>('E');
    Graph.Node<Character> nF = new Graph.Node<>('F');

    g.addNode(nA);
    g.addNode(nB);
    g.addNode(nC);
    g.addNode(nD);
    g.addNode(nE);
    g.addNode(nF);
    g.setRoot(nA);

    g.addEdge(nA, nB);
    g.addEdge(nA, nC);
    g.addEdge(nA, nD);
    g.addEdge(nB, nE);
    g.addEdge(nB, nF);
    g.addEdge(nC, nF);
  }

  @Test
  public void testBfs() {
    Assert.assertEquals("A B C D E F", g.bfs());
  }

  @Test
  public void testDfs() {
    Assert.assertEquals("A B E F C D", g.dfs());
  }
}
