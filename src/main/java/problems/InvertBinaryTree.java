package problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author VeselovND <br>
 * created at 06.06.2024 <br>
 * <a href="https://leetcode.com/problems/invert-binary-tree/">Invert Binary Tree</a>
 */
public class InvertBinaryTree {

    public static void main(String[] args) {
        System.out.println(invertTree(new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1, null, null), new TreeNode(3, null, null)),
                new TreeNode(7,
                        new TreeNode(6, null, null), new TreeNode(9, null, null))
        )));

        System.out.println(invertTree(new TreeNode(2,
                new TreeNode(1, null, null),
                new TreeNode(3, null, null))));


        System.out.println(invertTree(new TreeNode(1, new TreeNode(2, null, null), null)));
    }

    public static TreeNode invertTree(TreeNode root) {
        //проверка на налл
        if (root == null) {
            return null;
        }
        //складывает ноды в стек
        Deque<TreeNode> treeNodeDeque = new ArrayDeque<>();
        treeNodeDeque.push(root);
        // добавляем ноду в стек, берем каждую ноду, меняем ее ветки местами
        while (!treeNodeDeque.isEmpty()) {
            TreeNode node = treeNodeDeque.pop();
            if (node.left != null) {
                treeNodeDeque.push(node.left);
            }
            if (node.right != null) {
                treeNodeDeque.push(node.right);
            }
            replaceNodes(node);
        }
        return root;
    }

    private static void replaceNodes(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
