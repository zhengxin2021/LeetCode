package codingInterviewDay_2.day19;

import utils.TreeNode;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-10
 */
public class Solution03 {
    /**
     * 剑指 Offer 68 - II. 二叉树的最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    private TreeNode ans;
    /**
     * 剑指 Offer 68 - II. 二叉树的最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean inLeft = dfs(root.left, p, q);
        boolean inRight = dfs(root.right, p, q);
        if ((inLeft && inRight) || ((root == p || root == q) && (inLeft || inRight))) {
            ans = root;
        }
        return inLeft || inRight || root == p || root == q;
    }
}
