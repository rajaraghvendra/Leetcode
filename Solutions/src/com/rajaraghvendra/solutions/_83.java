package com.rajaraghvendra.solutions;

import com.rajaraghvendra.common.classes.ListNode;

public class _83 {
    public static class Solution1 {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode ret = new ListNode(-1);
            ret.next = head;
            while (head != null) {
                while (head.next != null && head.next.val == head.val) {
                    head.next = head.next.next;
                }
                head = head.next;
            }
            return ret.next;
        }
    }

    public static class Solution2 {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode curr = head;
            while (curr != null && curr.next != null) {
                if (curr.val == curr.next.val) {
                    curr.next = curr.next.next;
                } else {
                    curr = curr.next;
                }
            }
            return head;
        }
    }
}
