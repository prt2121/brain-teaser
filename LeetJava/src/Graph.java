import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by pt2121 on 12/21/15.
 */
public class Graph {

  private Node root;
  private ArrayList<Node> nodes = new ArrayList<>();
  private int[][] edges;
  int size;

  public void setRoot(Node n) {
    root = n;
  }

  public Node getRoot() {
    return root;
  }

  public void addNode(Node n) {
    nodes.add(n);
  }

  public void addEdge(Node start, Node end) {
    if (edges == null) {
      size = nodes.size();
      edges = new int[size][size];
    }

    int startIndex = nodes.indexOf(start);
    int endIndex = nodes.indexOf(end);
    edges[startIndex][endIndex] = 1;
    edges[endIndex][startIndex] = 1;
  }

  public String bfs() {
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    root.visited = true;
    StringBuilder builder = new StringBuilder();
    builder.append(root.val);
    builder.append(" ");

    while (!q.isEmpty()) {
      Node n = q.remove();
      Node child;
      while ((child = getUnvisitedChild(n)) != null) {
        child.visited = true;
        q.add(child);
        builder.append(child.val);
        builder.append(" ");
      }
    }
    clearVisitedFlag();
    return builder.toString().trim();
  }

  public String dfs() {
    Stack<Node> stack = new Stack<>();
    stack.push(root);
    root.visited = true;
    StringBuilder builder = new StringBuilder();
    builder.append(root.val);
    builder.append(" ");

    while (!stack.empty()) {
      Node n = stack.peek();
      Node child = getUnvisitedChild(n);
      if (child != null) {
        child.visited = true;
        stack.push(child);
        builder.append(child.val);
        builder.append(" ");
      } else {
        stack.pop();
      }
    }

    clearVisitedFlag();
    return builder.toString().trim();
  }

  private Node getUnvisitedChild(Node n) {
    int index = nodes.indexOf(n);
    int j = 0;
    while (j < size) {
      if (edges[index][j] == 1 && !(nodes.get(j)).visited) {
        return nodes.get(j);
      }
      j++;
    }
    return null;
  }

  private void clearVisitedFlag() {
    int i = 0;
    while (i < size) {
      Node n = nodes.get(i);
      n.visited = false;
      i++;
    }
  }

  public static class Node<T> {
    public T val;
    public boolean visited;

    public Node(T val) {
      this.val = val;
    }
  }

}
