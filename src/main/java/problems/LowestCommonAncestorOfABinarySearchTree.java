package problems;

/**
 * @author VeselovND <br>
 * created at 10.06.2024 <br>
 */
public class LowestCommonAncestorOfABinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6,
                new TreeNode(2,
                        new TreeNode(0, null, null),
                        new TreeNode(4,
                                new TreeNode(3, null, null),
                                new TreeNode(5, null, null))),
                new TreeNode(8,
                        new TreeNode(7, null, null),
                        new TreeNode(9, null, null)));
        TreeNode p2 = new TreeNode(2,
                new TreeNode(0, null, null),
                new TreeNode(4,
                        new TreeNode(3, null, null),
                        new TreeNode(5, null, null)));
        TreeNode q8 = new TreeNode(8,
                new TreeNode(7, null, null),
                new TreeNode(9, null, null));
        System.out.println(lowestCommonAncestor(root, p2, q8));

        TreeNode q4 = new TreeNode(4,
                new TreeNode(3, null, null),
                new TreeNode(5, null, null));

        System.out.println(lowestCommonAncestor(root, p2, q4));
        TreeNode root2 = new TreeNode(2, new TreeNode(1, null, null), null);
        TreeNode p21 = new TreeNode(2, new TreeNode(1, null, null), null);
        TreeNode q21 = new TreeNode(1, null, null);

        System.out.println(lowestCommonAncestor(root2, p21, q21));
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cla = root;
        //если оба потомка находятся по обе стороны от предка - то он самый актуальный
        if ((p.val <= cla.val && q.val >= cla.val) || (p.val >= cla.val && q.val <= cla.val)) {
            return root;
        }
        //если нет, то проверяем, в какую ветку пойдем, в левую или правую, и рекурсивно повторяем эти действия
        if (p.val < cla.val) {
            if (cla.left == null) {
                return cla;
            }
            cla = cla.left;
        } else {
            if (cla.right == null) {
                return cla;
            }
            cla = cla.right;
        }
        return lowestCommonAncestor(cla, p, q);

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
