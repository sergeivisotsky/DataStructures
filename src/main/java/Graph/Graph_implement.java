package Graph;

import java.util.LinkedList;

public class Graph_implement {

    static class Graph {
        int data;
        LinkedList[] adjArray;

        Graph(int data) {
            this.data = data;
            adjArray = new LinkedList[data];

            for (int i = 0; i < data; i++) {
                adjArray[i] = new LinkedList();
            }
        }
    }

    private static void addEdge(Graph graph, int data, int dest) {
        graph.adjArray[data].addFirst(dest);
        graph.adjArray[dest].addFirst(data);
    }

    private static void displayGraph(Graph graph) {
        for (int data = 0; data < graph.data; data++) {
            System.out.println("List of vertexes: " + data);
            System.out.print("head");
            for (Object element :
                    graph.adjArray[data]) {
                System.out.print("\t" + element);
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        int value = 5;
        Graph graph = new Graph(value);
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 4);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 1, 4);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 4);
        displayGraph(graph);
    }
}
