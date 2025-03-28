package Linked_List;

import java.math.BigInteger;
import java.util.*;

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

    // Leetcode Problem No 23 : Merge k Sorted Lists

    PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists==null) return null;

          for (int i = 0; i < lists.length; i++) {
            addInHeap(lists[i]);
          }

          if (heap.isEmpty()) return null;
            
          
          ListNode head = heap.poll();
            ListNode prev = head;
            
            while (!heap.isEmpty()) {
               
                prev.next=heap.poll();
                prev=prev.next;
            }
            prev.next=null;
        return head;
    }

    private void addInHeap(ListNode head){
        
        while (head!=null) {
            heap.add(head);
            head=head.next;
        }
    }

    // Leetcode Problem No 2 : Add Two Numbers

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
         BigInteger num1 = new BigInteger(digitLinkedList(l1, ""));

        BigInteger num2 = new BigInteger(digitLinkedList(l2, ""));

        BigInteger sum = num1.add(num2);


        ListNode head = new ListNode(sum.mod(BigInteger.TEN).intValue());
        sum = sum.divide(BigInteger.TEN);

        ListNode temp = head;

        while (!sum.equals(BigInteger.ZERO)) {

            temp.next = new ListNode(sum.mod(BigInteger.TEN).intValue());

            sum = sum.divide(BigInteger.TEN);

            temp = temp.next;
        }

        return head;
        
    }

    private String digitLinkedList(ListNode head , String num){

        if (head==null) return num;
        
        return digitLinkedList(head.next, head.val+num);
    }

    // Leetcode Problem No 24 : Swap Nodes in Pairs

    public ListNode swapPairs(ListNode head) {

        if (head==null || head.next==null) return head;

        ListNode temp = head ,temp2 = head.next , prev = null , curr = head , next=head;

        while (true) {

            curr=next;
            temp=next;
            prev=null;

            for (int i = 1; i <=2; i++) {
                curr=next;
                next=next.next;
                curr.next=prev;
                prev=curr;
            }

            if(next==null) break;

            if (next.next!=null) temp.next=next.next;

            else {
                temp.next=next;
                break;
            }
            
        }

        return temp2;
    }

    // Leetcode Problem No : 86 Partition List
    public static ListNode partition(ListNode head, int x) {

        if(head==null || head.next==null) return head;

        ListNode minHead = null , maxHead = null , min=null , max=null;

        while (head!=null) {

            if (head.val>=x) {
                if (maxHead==null) {
                    maxHead = head;
                    max=head;
                   
                }else{
                    max.next=head;                   
                    max=max.next;
                }
            }else{
                if (minHead==null) {
                    minHead = head;
                    min=head;
                    
                }else{
                    min.next=head;
                    min=min.next;
                }
            }
            head=head.next;
        }

        if (min!=null && max!=null) {
            min.next=maxHead;
            max.next=null;
        }
        else{
            return min==null&&max!=null ? maxHead : minHead;           
        }

        return minHead;
    }

    // Leetcode Problem No 82 : Remove Duplicates from Sorted List II
     ListNode deleteDuplicates2(ListNode head) {

        if (head==null || head.next==null) return head;

        ListNode p1 = head , p2 = head.next , prev=null;

        while (p1!=null && p2!=null) {
            if (p1.val!=p2.val) {
                prev=p1;
                p1=p2;
                p2=p2.next;
            }else{
                int val = p1.val;
                 ListNode temp=p1;
                while (p1!=null&&p1.val==val) {
                    temp=p1;
                    p1=p1.next;
                }
                if (prev==null && p1==null) {
                    return null;
                }
                if (p1==null && prev!=null) {
                    prev.next=null;
                    continue;
                }
                if (prev==null && p1!=null) {
                    head=p1;
                    temp.next=null;
                    p2=p1.next;
                    continue;
                }
                prev.next=p1;
                p2=p1.next;
            }
        }

        return head;

    }

    // Leetcode Problem No 21 : Merge Two Sorted Lists

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode curr = new ListNode();
        ListNode temp = curr;

        while (list1!=null && list2!=null) {

            if (list1.val<list2.val) {

                curr.next=list1;
                list1=list1.next;
                curr=curr.next;

            }
            else if (list2.val<list1.val) {

                curr.next=list2;
                list2=list2.next;
                curr=curr.next;

            }else{

                curr.next=list1;
                list1=list1.next;
                curr=curr.next;
                curr.next=list2;
                list2=list2.next;
                curr=curr.next;
            
            }
        }

        curr.next=(list1==null && list2!=null) ? list2 : list1;

        return temp.next;
    }

   // Leetcode Problem No : 203. Remove Linked List Elements
   public ListNode removeElements(ListNode head, int val) {

        ListNode curr = head , prev = null;

        while (curr!=null) {

            if (curr.val==val) {
                if (prev!=null) {
                    ListNode temp = curr;
                    while (curr!=null && curr.val==val) {
                        temp=curr;
                        curr=curr.next;
                    }
                    prev.next=curr;
                    curr=temp;
                    
                }else{
                    head=head.next;
                    curr=head;
                    continue;
                }
            }
            prev=curr;
            curr=curr.next;
        }
        return head;
   }

   // Leetcode Problem No : 328 Odd Even Linked List
   public static ListNode oddEvenList(ListNode head) {
       if(head==null || head.next==null) return head;
       
       ListNode even = new ListNode();
       ListNode odd = new ListNode();
        ListNode evenHead=even;
       ListNode ptr = head;
        int count=0;

       boolean isOdd = true;
       

       while (ptr!=null) {
            if (isOdd) {
                odd.next=ptr;                      
                odd=odd.next;
                isOdd=false;
            }else{
                even.next=ptr;            
                even=even.next;
                isOdd=true;
            }
            ptr=ptr.next;
            count++;
       }
       
       odd.next=evenHead.next;
       
       if (count%2!=0) even.next=null;
       
        return head;
   }

   // Leetcode Problem No 445 : Add Two Numbers II
   public  ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

    ListNode ptr = new ListNode();
    ListNode head = ptr; 

   
    String ans = getDigit(l1, BigInteger.ZERO).add(getDigit(l2, BigInteger.ZERO)) + "";

    
    for (int i = 0; i < ans.length(); i++) {
        ptr.next = new ListNode(ans.charAt(i) - '0');
        ptr = ptr.next; 
    }

    return head.next;
}

 BigInteger getDigit(ListNode head, BigInteger digit) {
    if (head == null) return digit;
    return getDigit(head.next, digit.multiply(BigInteger.TEN).add(BigInteger.valueOf(head.val)));
}

    // Leetcode Problem No 2095 : Delete the Middle Node of a Linked List
    public ListNode deleteMiddle(ListNode head) {
        if (head==null || head.next==null) return null;
        
            ListNode fast = head;
            ListNode slow = head;
            ListNode prev = null;
        
            while (fast.next!=null) {

                prev=slow;
                slow=slow.next;
                        
                if (fast.next.next!=null) {
                    fast=fast.next.next;                   
                }else{
                    prev.next=slow.next;
                    return head;
                }
            }
            
            prev.next=slow.next;
            return head;
    }

    // Leetcode Problem No : 2487 Remove Nodes From Linked List

    public ListNode removeNodes(ListNode head) {

        if (head==null || head.next==null) return head;

        Stack<ListNode> s = new Stack<>();
        s.push(head);

        ListNode ptr = head.next;

        while (ptr!=null) {
            
            if (ptr.val>s.peek().val) {
                while (!s.isEmpty() && ptr.val>s.peek().val) {
                    s.pop();
                }

                if (s.isEmpty()) {
                    s.push(ptr);
                    head=ptr;
                    ptr=ptr.next;
                    continue;
                    
                }
            }
              
            s.peek().next=ptr;
            s.push(ptr);               
            ptr=ptr.next;
        }
        
        return head;
        
    }

    // Leetcode Problem No 1669 : Merge In Between Linked Lists

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        
        ListNode left = null , right = null;
        ListNode ptr = list1; 

        for (int i = 0; i < a-1; i++) {
            ptr=ptr.next;
        }
        left=ptr;

        for (int i = a-1; i < b+1; i++) {
            ptr=ptr.next;
        }
        right=ptr;

        ListNode temp = list2;

        while (temp.next!=null) {
            temp=temp.next;
        }

        temp.next=right;

        if (a==0) return list2;

        left.next=list2;
        return list1;
        
    }

    // Leetcode Problem No : 2807 Insert Greatest Common Divisors in Linked List
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head==null || head.next==null) return head;
            
        ListNode curr = head.next;
        ListNode prev = head;

        while (curr!=null) {

            ListNode internal = new ListNode(gcd(prev.val,curr.val));
            prev.next=internal;
            internal.next=curr;
            prev=curr;
            curr=curr.next;

        }
        
        return head;
    }

    private int gcd(int num1 , int num2){

        int gcd = 1;

        for (int i = 1; i <= num1 && i<=num2; i++) {
            gcd = num1%i==0 && num2%i==0 ? i : gcd;
        }

        return gcd;
    }

}


