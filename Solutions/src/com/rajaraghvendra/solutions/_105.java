package com.rajaraghvendra.solutions;

import java.util.HashMap;
import java.util.Map;

import com.rajaraghvendra.common.classes.TreeNode;

public class _105 {

    public static class Solution1 {
        /**
         * credit: https://discuss.leetcode.com/topic/29838/5ms-java-clean-solution-with-caching use
         * HashMap as the cache so that accessing inorder index becomes O(1) time Note: The first
         * element of preorder array is the root!
         */
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            Map<Integer, Integer> inorderMap = new HashMap();
            for (int i = 0; i < inorder.length; i++) {
                inorderMap.put(inorder[i], i);
            }

            /**At the beginning, both start from 0 to nums.length-1*/
            return buildTree(preorder, 0, preorder.length - 1, inorderMap, 0, inorder.length - 1);
        }

        private TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                                   Map<Integer, Integer> inorderMap, int inStart, int inEnd) {
            if (preStart > preEnd || inStart > inEnd) {
                return null;
            }

            TreeNode root = new TreeNode(preorder[preStart]);
            int inRoot = inorderMap.get(preorder[preStart]);
            int numsLeft = inRoot - inStart;

            /**It's easy to understand and remember:
             * for the indices of inorder array:
             * root.left should be inStart and inRoot-1 as new start and end indices
             * root.right should be inRoot+1 and inEnd as new start and end indices
             *
             * since inRoot is being used already in this recursion call, that's why we use inRoot-1 and inRoot+1
             * this part is the same for both Leetcode 105 and Leetcode 106.*/
            root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorderMap, inStart, inRoot - 1);
            root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorderMap, inRoot + 1, inEnd);
            return root;
        }
    }
}
