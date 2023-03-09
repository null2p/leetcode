/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head, fast = head;
        
        while(true){
            fast = fast.next;
            //even number
            if(fast == null){
                break;
            }
            fast = fast.next;
            //odd number
            if(fast==null){
                break;
            }
            slow = slow.next;
        }
        
        fast = sortList(slow.next);
        slow.next = null;
        slow = sortList(head);
        
        return merge(slow,fast);
    }

    private ListNode merge(ListNode slow, ListNode fast){
        ListNode result = new ListNode();
        ListNode head = result;

        while(true){
            if(slow.val < fast.val){
                head.next = slow;
                head = head.next;
                if(slow.next == null){
                    head.next = fast;
                    break;
                }
                slow = slow.next;
            }
            else{
                head.next = fast;
                head = head.next;
                if(fast.next == null){
                    head.next = slow;
                    break;
                }
                fast = fast.next;
            }
        }
        return result.next;
    }
}
