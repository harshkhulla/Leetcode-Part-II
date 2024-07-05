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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
       ListNode prev = head;
       ListNode curr = head.next;
       int[] ans = {-1,-1};
       int prevPos = -1; int currPos = -1; int firstPos= -1; int pos = 0;
       while(curr.next !=null){
        if ((curr.val < prev.val && curr.val < curr.next.val) || (curr.val > prev.val && curr.val > curr.next.val)) {
            prevPos = currPos;
            currPos = pos;
            if(firstPos == -1){
                firstPos = pos;
            }  
            if(prevPos != -1){
                if(ans[0] == -1) ans[0] = currPos - prevPos;
                else ans[0] = Math.min(ans[0] , currPos - prevPos);
                ans[1]  = pos - firstPos;
            } 
        }
       pos++;
       prev = curr;
       curr = curr.next; 
      
       }
    return ans;
       
    }
}