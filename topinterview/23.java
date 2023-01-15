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
    public ListNode mergeKLists(ListNode[] lists) {
        int size = (lists.length);
        if(size == 0){
            return null;
        }
        else if (size == 1){
            return lists[0];
        }

        ListNode result = lists[0];
        ListNode resultHead = result;

        for(int i = 1; i < size ; i ++){
            ListNode listNode = lists[i];
            if(result == null){
                result = listNode;
                resultHead = listNode;
                continue;
            }
            if(listNode == null){
                continue;
            }

            if(listNode.val < result.val){
                ListNode tmp = result;
                result = listNode;
                listNode = tmp;
                resultHead = result;
            }

            while(true){
                ListNode nextResult = result.next;
                ListNode nextNode = listNode.next;

                //nextResult가 null인 경우, nextResult뒤로 listNode를 잇는다
                if(nextResult == null){
                    result.next = listNode;
                    break;
                }

                int resultVal = result.val;
                int nodeVal = listNode.val;
                int nextResultVal = nextResult.val;

                //nextNode가 null인 경우, result에 이을 곳을 계속 찾는다
                if(nextNode == null){
                    if(nodeVal >= resultVal && nodeVal <= nextResultVal){
                        result.next = listNode;
                        listNode.next = nextResult;
                        break;
                    }
                    else{
                        result = nextResult;
                        continue;
                    }
                }

                int nextVal = nextNode.val;

                //nodeVal이 resultVal과 nextVal 사이에 있을 경우 ListNode를 연결한다
                if(nodeVal >= resultVal && nodeVal <= nextResultVal){
                    result.next = listNode;
                    listNode.next = nextResult;

                    result = listNode;
                    listNode = nextNode;
                }
                else{
                    result = nextResult;
                }
            }
            result = resultHead;
        }

        return result;
    }
}
