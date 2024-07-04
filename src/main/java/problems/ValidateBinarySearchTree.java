package problems;

import util.TreeNode;

/**
 * @author VeselovND <br>
 * created at 04.07.2024 <br>
 * <a href="https://leetcode.com/problems/validate-binary-search-tree/description/">Validate Binary Tree</a>
 */
public class ValidateBinarySearchTree {

    private static Integer previousValue;

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2,
                new TreeNode(1, null, null),
                new TreeNode(3, null, null));
        //   System.out.println(isValidBST(node1));
        TreeNode node2 = new TreeNode(5,
                new TreeNode(4, null, null),
                new TreeNode(6,
                        new TreeNode(3, null, null),
                        new TreeNode(7, null, null)));
        System.out.println(isValidBST(node2));
    }

    public static boolean isValidBST(TreeNode root) {
        previousValue = null; // трекинг предыдущего значения ноды
        return inOrderTraversal(root);
    }

    //Упорядоченный обход
    private static boolean inOrderTraversal(TreeNode node) {
        if (node == null) {
            return true; // базовый случай
        }

        if (!inOrderTraversal(node.left)) {
            return false;
        }
        // проверяем свойства BST левая нода меньше рута, правая больше рута
        // Предыдущее значение должно быть меньше чем у текущей ноды (т.к. идем по порядку, сначала левая нода, потом рут
        //потом правая
        if (previousValue != null && previousValue >= node.val) {
            return false; // The BST property is violated.
        }
        previousValue = node.val;
        if (!inOrderTraversal(node.right)) {
            return false;
        }
        return true; // All checks passed, it's a valid BST.
    }


}
