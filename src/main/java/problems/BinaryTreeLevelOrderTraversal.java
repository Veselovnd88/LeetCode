package problems;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * @author VeselovND <br>
 * created at 25.06.2024 <br>
 * <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/description/">Binary Tree Level Order Traversal</a>
 */
public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3,
                new TreeNode(9, null, null),
                new TreeNode(20,
                        new TreeNode(15, null, null),
                        new TreeNode(7, null, null)));
        //     System.out.println(levelOrder(tree));
        TreeNode tree2 = new TreeNode(1, new TreeNode(2, null, null), null);
        //      System.out.println(levelOrder(tree2));

        TreeNode tree3 = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4, null, null),
                        null),
                new TreeNode(3, null,
                        new TreeNode(5, null, null)));
        System.out.println(levelOrder(tree3));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        Deque<Integer> level = new ArrayDeque<>(); //это список в котором хранятся номера уровней
        List<List<Integer>> result = new ArrayList<>();
        deque.add(root);
        level.add(1);

        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            int currLevel = level.poll();

            List<Integer> levelList;
            //отслеживаем каждый уровень, если текущий уровень больше количества списков в результате, значит мы начинаем обход новго уровня
            //и Добавляем новый список, если нет, то используем список соответствующий уровню
            //одновременно работают две очереди, мы берем ноду - и номер ее уровня из другой очереди, сравниваем, если нода находится уровне где уже есть список
            //то добавляем значение в список того уровня, если для этого уровня списка еще нет, то добавляесяся новый список
            if (result.size() < currLevel) {
                levelList = new ArrayList<>();
                result.add(levelList);
            } else {
                levelList = result.get(currLevel - 1);
            }
            levelList.add(node.val);
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (left != null) {
                deque.add(left);
                level.add(currLevel + 1);
            }
            if (right != null) {
                deque.add(right);
                level.add(currLevel + 1);
            }
        }
        return result;
    }
}
