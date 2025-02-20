package Linked_List;

class ListNode {
    int val;
    ListNode next;
  ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class leetCode {
    
    /* 
     19. Remove Nth Node From End of List
Medium
Topics
Companies
Hint
Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]
 

Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 
     */

     

      ListNode removeNthFromEnd(ListNode head, int n) {
        
        
        int size=size(head);

        if (size==1) {
            head=null;
            return head;
        }

        else if(size==n){
            head=head.next;
            return head;
        }

        ListNode move =head;

        for (int i = 1; i < (size-n); i++) {
            move=move.next;
        }

        move.next=move.next.next;
        
        return head;


     }

     private int size(ListNode head){
    
        if (head==null) {
            return 0;
        }
        
        ListNode move = head;
        int count=0;

        while (move!=null) {
            move=move.next;
            count++;
        }
        return count;

    }

    /*
     Given the head of a linked list, rotate the list to the right by k places.


Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
Example 2:


Input: head = [0,1,2], k = 4
Output: [2,0,1]
 

Constraints:

The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 109
     */

     public ListNode rotateRight(ListNode head, int k) {
        
        int size =size(head);

        if(head==null || size==1){
            return head;
        }
        k%=size;
        ListNode move;

        for (int i = 1; i <=k; i++) {

            move=head;

            for(int j=1;j<size-1;j++){
                move=move.next;
               }

            move.next.next=head;
            head=move.next;
            move.next=null;
        }
        return head;

    }

    // LeetCode Problem No 83. Remove Duplicates from Sorted List

    public ListNode deleteDuplicates(ListNode head) {

        if (head==null) {
            return head;
        }

        ListNode move = head;

        while (move.next!=null) {

            while (move.next.val==move.val) {
                if (move.next.next!=null) {
                    move.next=move.next.next;
                }else{
                    move.next=null;
                    return head;
                }
            }
            move=move.next;
        }
        return head;
    }

    // Leetcode Problem No 141. Linked List Cycle

    public boolean hasCycle(ListNode head) {
        
        if (head==null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;

        do {

            if (slow.next!=null) {
                slow=slow.next;
            }else{
                return false;
            }

            if (fast.next!=null && fast.next.next!=null) {
                fast=fast.next.next;
            }else{
                return false;
            }
            
        } while (slow!=fast);

        return true;

    }

    // Leetcode Problem No : 142. Linked List Cycle II

    // public ListNode detectCycle(ListNode head) {
        
    // }

    // Leetcode Problem No : 876. Middle of the Linked List

    public ListNode middleNode(ListNode head) {
        
        if (head==null) {
            return head;
        }
            ListNode fast = head;
            ListNode slow = head;

            while (fast.next!=null) {
                slow=slow.next;

                if (fast.next.next!=null) {
                    fast=fast.next.next;                   
                }else{
                    return slow;
                }
            }

            return slow;

    }

    // Leetcode Problem No : 206. Reverse Linked List

    public ListNode reverseList(ListNode head) {

        if (head==null || head.next==null) {
            return head;
        }
        
        ListNode curr = head , prev = null , next=head;

        while (next!=null) {
            curr=next;
            next=next.next;
            curr.next=prev;
            prev=curr;
        }
        return curr;
    }

    // Leetcode Problem No : 92. Reverse Linked List II 

    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if (left==right) {
            return head;
        }

        ListNode prev=null , curr=null , next=null , temp = null , ptr=null;

        ptr=head;

        if (left==1) {
            temp=head;
            prev=null;
            next=head;
            curr=head;
        }else{

            for (int i = 1; i <= left-2; i++) {
                ptr=ptr.next;
            }
            temp=ptr.next;
            prev=ptr;
            curr=ptr.next;
            next=ptr.next;
        }

        for (int i = left; i <= right; i++) {

            curr=next;
            next=next.next;
            curr.next=prev;
            prev=curr;

        }

        if (ptr!=temp) {
            ptr.next=curr;
            temp.next=next;
        }else{
            ptr.next=next;
        }

        return ptr != temp ? head : curr;

    }

    //  Leetcode Problem No : 25 Reverse Nodes in k-Group

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head.next==null || k==1) {
            return head;
        }
        
        // Counting the number of nodes in LL

        ListNode front = head;
        ListNode back = head;
        int count=1;

            while (front.next!=null) {
                if (front.next.next!=null) {
                    front=front.next.next;
                }
                else{
                    break;
                }
                back=back.next;
                count++;
            }

           count =  front.next==null ? (count*2)-1 : count*2; 

           int size = (count/k)==0 ? 1 : count/k;

           front=head;
           back=null;
           ListNode next = head;
           ListNode curr = head;
           ListNode prev = null;

           for (int i = 1; i <= size; i++) {
                for (int j = 1; j <= k; j++) {
                    curr=next;
                    next=next.next;
                    curr.next=prev;
                    prev=curr;
                }

                if (next!=null) {
                    front.next=next; 
                }        
                if (back!=null) {
                    back.next=curr;
                }
                if(i==1)head=curr;

                back=front;
                curr=next;
                prev=null;
                front=next;

           }

           return head;
    }

    // Leetcode Problem No : 143. Reorder List

    public void reorderList(ListNode head) {

        if (head.next==null||head.next.next==null) {
            return;
        }

        ListNode fast = head , slow = head;

        while (fast.next!=null) {
            
            if (fast.next.next!=null) {
                fast=fast.next.next;
            }else{
                break;
            }
            slow=slow.next;
        }

        ListNode curr = slow.next;
        slow.next=null;
        slow=curr;
        ListNode next = curr;
        ListNode prev = null;

        while (next!=null) {
            curr=next;
            next=next.next;
            curr.next=prev;
            prev=curr;
        }


        ListNode l1 = head , l2 = curr , n1=head , n2=curr;

        do {
            n1=n1.next;
            n2=n2.next;
            l1.next=l2;
            l2.next=n1;
            l1=n1;
            l2=n2;
            
        } while (n1!=null && n2!=null);

    }

}


