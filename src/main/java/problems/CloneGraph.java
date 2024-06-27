package problems;

import util.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;

/**
 * @author VeselovND <br>
 * created at 27.06.2024 <br>
 */
public class CloneGraph {

    public static void main(String[] args) {
        //int[][] adjList = new int[][]{{2, 4}, {1, 3}, {2, 4}, {1, 3}};

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors = List.of(node2, node4);
        node2.neighbors = List.of(node1, node3);
        node3.neighbors = List.of(node2, node4);
        node4.neighbors = List.of(node1, node3);
        System.out.println(cloneGraph(node1));
    }

    public static Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        HashMap<Integer, Node> visitedMap = new HashMap<>();
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(node);

        //Сначала копируем все значения нод в отдельную хешмапу, и в каждую новую ноду пока сажаем старых соседей
        while (!deque.isEmpty()) {
            Node nodeFromDeq = deque.poll();
            if (!visitedMap.containsKey(nodeFromDeq.val)) {
                Node newNode = new Node(nodeFromDeq.val);
                newNode.neighbors = nodeFromDeq.neighbors;
                deque.addAll(nodeFromDeq.neighbors);
                visitedMap.put(newNode.val, newNode);
            }
        }
        //Далее проходимся по всей мапе и на места соседей присоединяем новый копии нод
        visitedMap.values()
                .forEach(v -> {
                    ArrayList<Node> clones = new ArrayList<>();
                    v.neighbors.forEach(n ->
                            clones.add(visitedMap.get(n.val)));
                    v.neighbors = clones;
                });

        return visitedMap.get(1);
    }
}
