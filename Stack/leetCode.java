package Stack;
import java.util.Stack;

public class leetCode {
    
/* 20. Valid Parentheses
Easy
Topics
Companies
Hint
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true

 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'. */

public boolean isValid(String s) {

    if (s.length()==1) {
        return false;
    }

    Stack<Character> charStack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
    
        if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
            charStack.push(s.charAt(i));
        }
        else{

            if (charStack.isEmpty()) {
                return false;
            }
           
            if ( (s.charAt(i)==')' && charStack.peek()=='(') || (s.charAt(i)=='}' && charStack.peek()=='{') ||  (s.charAt(i)==']' && charStack.peek()=='['))  {
                charStack.pop();
            }
            else{
                return false;
            }
        }

    }

    if (!charStack.isEmpty()) {
        return false;
    }
        return true;
}

/* 234. Palindrome Linked List
Easy
Topics
Companies
Given the head of a singly linked list, return true if it is a 
palindrome
 or false otherwise.

 

Example 1:


Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false
 

Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9
 

Follow up: Could you do it in O(n) time and O(1) space? */


 // Definition for singly-linked list.
  public class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
  boolean isPalindrome(ListNode head) {

    int size = size(head);

    if (size==1) {
        return true;
    }

    Stack<Integer> stack = new Stack<>();
    ListNode move = head;

    if (size%2==0) {
        for (int i = 1; i <= size; i++) {
            if (i<=(size/2)){
                stack.push(move.val);
                move=move.next;
            }else{
                if (move.val==stack.peek()) {
                    stack.pop();
                    move=move.next;
                }else{
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }else{

        for (int i = 1; i <= size; i++) {

            if (i==(size/2)+1) {
                move=move.next;
                continue;
            }

            if (i<=(size/2)){
                stack.push(move.val);
                move=move.next;
            }else{
                if (move.val==stack.peek()) {
                    stack.pop();
                    move=move.next;
                }else{
                    return false;
                }
            }
        }

        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

}

private int size(ListNode head){
 
    ListNode move = head;
    int count=0;

    while (move!=null) {
        move=move.next;
        count++;
    }
    return count;
}

/* Infix Notataion to PostFix Notation */

public String infixToPostfix(String exp){

    if (exp==null) {
        System.out.println("Empty Expression");
        return null;
    }

    String result = "";
    Stack<Character> s = new Stack<>();

    for (int i = 0; i < exp.length(); i++){

        String num="";
        
        boolean flag=false;

        while ((exp.charAt(i)>='0'&&exp.charAt(i)<='9') || ((exp.charAt(i)>='a' && exp.charAt(i)<='z') || (exp.charAt(i)>='A'&&exp.charAt(i)<='Z'))){
            flag=true;
            num+=(exp.charAt(i));
            i++;
            if (i>=exp.length()){break;}
        }

        if(flag){result+=(" "+num+" ");}

        if (i>=exp.length()){break;}
        
        if (exp.charAt(i)=='(' || exp.charAt(i)==')') {
            if (exp.charAt(i)=='(') {
                s.push('(');
            }else{
                while (s.peek()!='(') {
                    result += s.pop(); 
                }
                s.pop();
            }
        }

        else {
            char precedence = precedence(exp.charAt(i));
            
            while (!s.isEmpty() && precedence <= precedence(s.peek()) && s.peek()!='(') {
                result+=s.pop();
            }
            s.push(exp.charAt(i));
        }

    }

    while (!s.isEmpty()) {
        result+=s.pop();
    }

    return result;

}  

private char precedence(char op){

   if (op=='^') {
    return 'c';
   }
   else if(op=='+' || op=='-'){
    return 'a';
   }
    return 'b';   
}

/* 32. Longest Valid Parentheses
Hard
Topics
Companies
Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses 
substring
.

 

Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
Example 3:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 3 * 104
s[i] is '(', or ')'. */

//  int longestValidParentheses(String s) {

//     if (s.isEmpty() || s==null) {
//         return 0;
//     }

//     Stack<Character> stack = new Stack<Character>();
//     stack.push(s.charAt(0));
//     int len = 0;
//     for (int i = 1; i < s.length(); i++) {
//         if (s.charAt(i)==')' && !stack.isEmpty() && stack.peek()=='(' ){
//             stack.pop();
//             len+=2;
//         }else{
//             stack.push(s.charAt(i));
//         }
//     }
//     return len;
// }
// incomplete


/* 921. Minimum Add to Make Parentheses Valid
Medium
Topics
Companies
A parentheses string is valid if and only if:

It is the empty string,
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.

For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
Return the minimum number of moves required to make s valid.

 

Example 1:

Input: s = "())"
Output: 1
Example 2:

Input: s = "((("
Output: 3
 

Constraints:

1 <= s.length <= 1000
s[i] is either '(' or ')'. */

public int minAddToMakeValid(String s) {
    
    if (s.length()==1) {
        return 1;
    }
    
    Stack<Character> charStack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
        
        if (!charStack.isEmpty() && (s.charAt(i)==')' && charStack.peek()=='(')) {

            charStack.pop();

        }else{
            charStack.push(s.charAt(i));
        }
    }
    return charStack.size();
}


/* 2390. Removing Stars From a String
Medium
Topics
Companies
Hint
You are given a string s, which contains stars *.

In one operation, you can:

Choose a star in s.
Remove the closest non-star character to its left, as well as remove the star itself.
Return the string after all stars have been removed.

Note:

The input will be generated such that the operation is always possible.
It can be shown that the resulting string will always be unique.
 

Example 1:

Input: s = "leet**cod*e"
Output: "lecoe"
Explanation: Performing the removals from left to right:
- The closest character to the 1st star is 't' in "leet**cod*e". s becomes "lee*cod*e".
- The closest character to the 2nd star is 'e' in "lee*cod*e". s becomes "lecod*e".
- The closest character to the 3rd star is 'd' in "lecod*e". s becomes "lecoe".
There are no more stars, so we return "lecoe".
Example 2:

Input: s = "erase*****"
Output: ""
Explanation: The entire string is removed, so we return an empty string. */

public String removeStars(String s) {
    
    Stack<Character> st = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i)=='*') {
            st.pop();
        }else{
            st.push(s.charAt(i));
        }
    }
    
    int stackSize=st.size();
    char [] chrs = new char[stackSize];

    for (int i = stackSize-1; i >= 0; i--) {
        chrs[i]=st.pop();
    }
    return new String(chrs);
}

public static void main(String[] args) {
    leetCode ob = new leetCode();
    System.out.println(ob.removeStars("leet**cod*e"));
}

}
