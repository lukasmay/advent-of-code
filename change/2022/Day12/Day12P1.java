import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.HashMap;

public class Day12P1 {

  public static class Edge {
    int from, to, cost;

    public Edge(int from, int to, int cost) {
      this.from = from;
      this.to = to;
      this.cost = cost;
    }
  }

  private int n;
  private Integer[] prev;
  private List<List<Edge>> graph;

  public Day12P1(List<List<Edge>> graph) {
    if (graph == null) throw new IllegalArgumentException("Graph can not be null");
    n = graph.size();
    this.graph = graph;
  }

  /**
   * Reconstructs the path (of nodes) from 'start' to 'end' inclusive. If the edges are unweighted
   * then this method returns the shortest path from 'start' to 'end'
   *
   * @return An array of nodes indexes of the shortest path from 'start' to 'end'. If 'start' and
   *     'end' are not connected then an empty array is returned.
   */
  public List<Integer> reconstructPath(int start, int end) {
    bfs(start);
    List<Integer> path = new ArrayList<>();
    for (Integer at = end; at != null; at = prev[at]) path.add(at);
    Collections.reverse(path);
    if (path.get(0) == start) return path;
    path.clear();
    return path;
  }

  // Perform a breadth first search on a graph a starting node 'start'.
  private void bfs(int start) {
    prev = new Integer[n];
    boolean[] visited = new boolean[n];
    Deque<Integer> queue = new ArrayDeque<>(n);

    // Start by visiting the 'start' node and add it to the queue.
    queue.offer(start);
    visited[start] = true;

    // Continue until the BFS is done.
    while (!queue.isEmpty()) {
      int node = queue.poll();
      List<Edge> edges = graph.get(node);

      // Loop through all edges attached to this node. Mark nodes as visited once they're
      // in the queue. This will prevent having duplicate nodes in the queue and speedup the BFS.
      for (Edge edge : edges) {
        if (!visited[edge.to]) {
          visited[edge.to] = true;
          prev[edge.to] = node;
          queue.offer(edge.to);
        }
      }
    }
  }

  // Initialize an empty adjacency list that can hold up to n nodes.
  public static List<List<Edge>> createEmptyGraph(int n) {
    List<List<Edge>> graph = new ArrayList<>(n);
    for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
    return graph;
  }

  // Add a directed edge from node 'u' to node 'v' with cost 'cost'.
  public static void addDirectedEdge(List<List<Edge>> graph, int u, int v, int cost) {
    graph.get(u).add(new Edge(u, v, cost));
  }

  // Add an undirected edge between nodes 'u' and 'v'.
  public static void addUndirectedEdge(List<List<Edge>> graph, int u, int v, int cost) {
    addDirectedEdge(graph, u, v, cost);
    addDirectedEdge(graph, v, u, cost);
  }

  // Add an undirected unweighted edge between nodes 'u' and 'v'. The edge added
  // will have a weight of 1 since its intended to be unweighted.
  public static void addUnweightedUndirectedEdge(List<List<Edge>> graph, int u, int v) {
    addUndirectedEdge(graph, u, v, 1);
  }

  /* BFS example. */

  public static void main(String[] args) {
    String line = "";
    char[][] stringMap = new char[5][8];
    Integer[][] intMap = new Integer[5][8];
    HashMap<Character, Integer> alphebet = new HashMap<>();
    Character[] alphabetchar = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    for (int i = 0; i < 26; i++){
      alphebet.put(alphabetchar[i], i+1);
    }

    int a = 0;
    int rE,cE,rS,cS = 0;
    try {
      Scanner scanner = new Scanner(new File("2022/input/day12.txt"));
      while (scanner.hasNextLine()) {
          line = scanner.nextLine();
          stringMap[a] = line.toCharArray();
          int i = 0;
          for (char letter : stringMap[a]){
              if (letter == 'S'){
                  rS = a;
                  cS = i;
                  intMap[a][i] = 0;
              } else if (letter == 'E'){
                  rE = a;
                  cE = i;
                  intMap[a][i] = -1;
              } else {
                intMap[a][i] = alphebet.get(letter);
              }

              i++;
          }
          a++;
      }
      scanner.close();
  } catch (FileNotFoundException e) {
      e.printStackTrace();
  }
    
    final int n = 25;
    final int columbNumber = 5;
    final int rowNumber = 5;
    final int[] directionC = {-1, 1, 0, 0};
    final int[] directionR = {0, 0, 1, -1};     
    List<List<Edge>> graph = createEmptyGraph(n);
  /* //Go through all the edge checks with the for loops and then the rest with the four loops. In each case need to check if the things is posible if so add it to the edge list
    for (int i = 0; i < columbNumber; i++){
      for (int node = 0; a < rowNumber; a++){
        //i == 0 || a == 0 || i == columbNumber-1 || a == rowNumber-1
        if (i == 0 && a == 0){
          if ()
          addUnweightedUndirectedEdge(graph, i-1, a);
          addUnweightedUndirectedEdge(graph, i, a-1);
        } else if (i == columbNumber-1 && a == 0) {
          addUnweightedUndirectedEdge(graph, i, a);
          addUnweightedUndirectedEdge(graph, i, a-1);
        } else if (i == 0 && a == rowNumber-1) {
          addUnweightedUndirectedEdge(graph, i-1, a);
          addUnweightedUndirectedEdge(graph, i, a-1);
        } else if (i == columbNumber-1 && a == rowNumber-1){
          addUnweightedUndirectedEdge(graph, i-1, a);
          addUnweightedUndirectedEdge(graph, i, a-1);
        } else if (i == 0) {
          for (int dir = 0; dir < 3; dir++){
            
          }
        }
        for (int dir = 0; dir < 4; dir++){

        }
      }
    }
    */
    addUnweightedUndirectedEdge(graph, 0, 7);
    addUnweightedUndirectedEdge(graph, 0, 9);
    addUnweightedUndirectedEdge(graph, 0, 11);
    addUnweightedUndirectedEdge(graph, 7, 11);
    addUnweightedUndirectedEdge(graph, 7, 6);
    addUnweightedUndirectedEdge(graph, 7, 3);
    addUnweightedUndirectedEdge(graph, 6, 5);
    addUnweightedUndirectedEdge(graph, 3, 4);
    addUnweightedUndirectedEdge(graph, 2, 3);
    addUnweightedUndirectedEdge(graph, 2, 12);
    addUnweightedUndirectedEdge(graph, 12, 8);
    addUnweightedUndirectedEdge(graph, 8, 1);
    addUnweightedUndirectedEdge(graph, 1, 10);
    addUnweightedUndirectedEdge(graph, 10, 9);
    addUnweightedUndirectedEdge(graph, 9, 8);
    addUnweightedUndirectedEdge(graph, 10, 5);

    Day12P1 solver;
    solver = new Day12P1(graph);

    int start = 10, end = 5;
    List<Integer> path = solver.reconstructPath(start, end);
    System.out.printf("The shortest path from %d to %d is: [%s]\n", start, end, formatPath(path));
    // Prints:
    // The shortest path from 10 to 5 is: [10 -> 9 -> 0 -> 7 -> 6 -> 5]

  }

  private static String formatPath(List<Integer> path) {
    return String.join(
        " -> ", path.stream().map(Object::toString).collect(java.util.stream.Collectors.toList()));
  }
}