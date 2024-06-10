package problems;

/**
 * @author VeselovND <br>
 * created at 10.06.2024 <br>
 * <a href="https://leetcode.com/problems/balanced-binary-tree/description/"> Balanced Binary Tree</a>
 */
public class BalancedBinaryTree {

    public static void main(String[] args) {
        TreeNode rootTrue = new TreeNode(3,
                new TreeNode(9, null, null),
                new TreeNode(20,
                        new TreeNode(15, null, null),
                        new TreeNode(7, null, null)));
        System.out.println(isBalanced(rootTrue));
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3,
                                new TreeNode(4, null, null),
                                new TreeNode(4, null, null)),
                        new TreeNode(3, null, null)),
                new TreeNode(2, null, null));
        System.out.println(isBalanced(root));
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        TreeNode left = root.left;
        TreeNode right = root.right;

        if (left == null && right == null) return true;
        //для каждой ноды проверяем длину веток, если больше 1, то фолс
        if (Math.abs(height(left) - height(right)) > 1) return false;

        return isBalanced(left) && isBalanced(right);
    }

    public static int height(TreeNode root) {
        //поиск длины ветки (максимальный)
        if (root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right) + 1;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
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
