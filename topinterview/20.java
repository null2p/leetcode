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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        Deque <ListNode> deque = new ArrayDeque<ListNode>();
        int size = 0;

        if(node.next == null){
            return null;
        }


        while(node!= null){
            if(deque.size() >= n+1){
                deque.pop();
            }
            deque.add(node);
            node = node.next;
            size +=1; 
        }

        if(size == n){
            return head.next;
        }

        ListNode prevNode = deque.pop();
        ListNode curNode = prevNode.next;
        ListNode nextNode = curNode.next;

        prevNode.next = nextNode;

        return head;
    }
}
