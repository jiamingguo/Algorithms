package Medium.SortList;

import Medium.SortList.ListNode;
/**
 * Created by gjm19_000
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * 使用merge sort的算法来完成。但是空间复杂度貌似不是constant
 * 如果使用bottom up的方法来merge sort可能空间复杂度就是constant了。
 * 这里仅先给出了时间复杂度不是constant的merge sort
 */
public class Solution {

    public ListNode sortList(ListNode head) {

        if (head==null || head.next==null) return head;

        // merge sort
        // step 1. split the list in half
        ListNode slow = head, fast = head;
        while(fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // step 2. sort each half recursively
        ListNode l1 = sortList(slow.next);

        // 接下来的这一步非常重要。它是把整个list分成两半的核心操作
        slow.next = null; //very very important. this is the key to split the list into two parts

        ListNode l2 = sortList(head);

        // step 3. merge the 2 sorted list
        return merge(l1,l2);
    }

    public ListNode merge(ListNode l1, ListNode l2){

        ListNode dummyHead = new ListNode(-1);
        ListNode dummy = dummyHead;

        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                dummy.next = l1;
                l1 = l1.next;
            } else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }

        if(l1!=null){
            dummy.next = l1;
        } else {
            dummy.next = l2;
        }

        return dummyHead.next;
    }
}
