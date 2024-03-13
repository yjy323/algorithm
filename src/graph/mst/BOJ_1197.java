package graph.mst;

import java.io.*;
import java.util.*;

public class BOJ_1197 {

  static class Edge {

    int src;
    int dst;
    int weight;

    public Edge(int src, int dst, int weight) {
      this.src = src;
      this.dst = dst;
      this.weight = weight;
    }
  }

  static class Subset {

    int parent;
    int rank;

    public Subset(int parent, int rank) {
      this.parent = parent;
      this.rank = rank;
    }
  }

  static Edge[] edgeList;
  static Subset[] subsetList;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());

    edgeList = new Edge[E];
    subsetList = new Subset[V + 1];
    for (int i = 0; i < subsetList.length; i++) {
      subsetList[i] = new Subset(i, 0);
    }

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(bf.readLine());
      int src = Integer.parseInt(st.nextToken());
      int dst = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());
      edgeList[i] = new Edge(src, dst, weight);
    }

    /*
      new Comparator<Edge>() {
        @Override public int compare(Edge o1, Edge o2)
        {
          return o1.weight - o2.weight;
        }
      }
    * */
    Arrays.sort(edgeList, ((o1, o2) -> {
      return o1.weight - o2.weight;
    }));

    int numOfEdges = 0;
    int idxOfEdges = 0;
    int sumOfWeights = 0;
    while (numOfEdges < V - 1) {
      Edge edge = edgeList[idxOfEdges];
      int x = find(edge.src);
      int y = find(edge.dst);

      if (x != y) {
        union(x, y);
        sumOfWeights += edge.weight;
        numOfEdges++;
      }
      idxOfEdges++;
    }
    System.out.println(sumOfWeights);
  }

  private static void union(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);

    if (subsetList[rootX].rank < subsetList[rootY].rank) {
      subsetList[rootX].parent = rootY;
    } else if (subsetList[rootY].rank < subsetList[rootX].rank) {
      subsetList[rootY].parent = rootX;
    } else {
      subsetList[rootX].parent = rootY;
      ++subsetList[rootY].rank;
    }
  }

  private static int find(int v) {
    if (subsetList[v].parent == v) {
      return subsetList[v].parent;
    } else {
      return subsetList[v].parent = find(subsetList[v].parent);
    }
  }
}
