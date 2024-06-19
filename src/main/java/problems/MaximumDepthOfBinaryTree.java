package problems;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author VeselovND <br>
 * created at 19.06.2024 <br>
 * <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/description/">Maximum Depth Of Binary Tree</a>
 */
public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(3,
                new TreeNode(9), new TreeNode(20,
                new TreeNode(15), new TreeNode(7)));
        TreeNode head2 = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4), null),
                new TreeNode(3, new TreeNode(5), null));
        //System.out.println(heightWithStack(head));
        System.out.println(heightWithStack(head2));
    }

    public static int maxDepth(TreeNode root) {
        return height(root);
    }

    private static int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = height(node.left);
        int right = height(node.right);
        return Math.max(left, right) + 1;
    }

    private static int heightWithStack(TreeNode node) {
        if (node == null) {
            return 0;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(node); //помещаем в хвост, и считаем уровни
        int depth = 0;

        while (!deque.isEmpty()) {
            int size = deque.size(); //количество нод

            for (int i = 0; i < size; i++) {
                TreeNode pop = deque.poll();
                if (pop.left != null) {
                    deque.offer(pop.left);
                }
                if (pop.right != null) {
                    deque.offer(pop.right);
                }
            }
            depth++;
        }
        return depth;

    }


}
