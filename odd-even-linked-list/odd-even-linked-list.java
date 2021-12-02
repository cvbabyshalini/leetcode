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
    public ListNode oddEvenList(ListNode head) {
        int i=1;
        ListNode odd  =  null, oddtail = null, even  = null, eventail = null, temp =  head;
        
        while(temp!=null){
            if(i%2==0){// even 
                if(even==null){
                    even =  temp;
                    eventail =  temp;
                }
                else{
                    eventail.next =  temp;
                    eventail = eventail.next;;
                }
            }
            else{// odd
                if(odd==null){
                    odd =  temp;
                    oddtail =  temp;
                }
                else{
                    oddtail.next = temp;
                    oddtail =  oddtail.next;
                }
            }
            temp =  temp.next;
            i++;
        }
   
        if(eventail!=null)
            eventail.next = null;
        
        if(odd==null){
            return even;
        }
        else{
            oddtail.next =  even;
            return odd;
        }
        
        
    }
}