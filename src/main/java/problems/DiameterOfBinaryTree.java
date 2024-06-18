package problems;

import util.TreeNode;

/**
 * @author VeselovND <br>
 * created at 18.06.2024 <br>
 * <a href="https://leetcode.com/problems/diameter-of-binary-tree/description/">Diameter OfBinary Tree</a>
 */
public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4), new TreeNode(5)),
                new TreeNode(3));
        System.out.println(diameterOfBinaryTree(treeNode));

        System.out.println(diameterOfBinaryTreeOptimized(treeNode, new HeightUtil()));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //считаем высоту левой и правой ветки рекурсивно
        int left = height(root.left);
        int right = height(root.right);
        //считаем диаметр левой и правой ветки
        int leftDiam = diameterOfBinaryTree(root.left);
        int rightDiam = diameterOfBinaryTree(root.right);
        //максимальный диаметр составит - либо уже посчитанный диам, либо текущую длину веток
        return Math.max(left + right, Math.max(leftDiam, rightDiam));
    }

    public static int diameterOfBinaryTreeOptimized(TreeNode root, HeightUtil height) {
        //держим высоту дерева глобально, и передаем его параметром
        if (root == null) {
            height.val = 0;
            return 0;
        }
        HeightUtil leftH = new HeightUtil();
        HeightUtil rightH = new HeightUtil();
        int leftDiam = diameterOfBinaryTreeOptimized(root.left, leftH);
        int rightDiam = diameterOfBinaryTreeOptimized(root.right, rightH);

        height.val = Math.max(leftH.val, rightH.val) + 1; //определяем макс высоту
        return Math.max(leftH.val + rightH.val, Math.max(leftDiam, rightDiam));
    }

    public static class HeightUtil {
        int val;
    }

    public static int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return (1 + Math.max(height(node.left), height(node.right)));
    }
}
