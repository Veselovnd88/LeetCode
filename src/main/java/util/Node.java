package util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author VeselovND <br>
 * created at 27.06.2024 <br>
 */
public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", neighbors=" + neighbors +
                '}';
    }
}
