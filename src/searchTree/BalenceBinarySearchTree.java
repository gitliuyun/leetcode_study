package searchTree;

import java.util.ArrayList;
import java.util.List;

/**
 * ��������ƽ����
 */
public class BalenceBinarySearchTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode balanceBST(TreeNode root) {
        //�������������
        ArrayList<Integer> list = new ArrayList();
        inorder(root, list);
        TreeNode reRoot = buildTree(list, 0, list.size() - 1);
        //���м�Ԫ����Ϊ���ڵ�ݹ鹹����
        return reRoot;
    }

    private void inorder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    private TreeNode buildTree(ArrayList<Integer> list, int left, int right) {
        if(right < left) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = buildTree(list, left, mid - 1);
        root.right = buildTree(list, mid + 1, right);
        return root;
    }

}



