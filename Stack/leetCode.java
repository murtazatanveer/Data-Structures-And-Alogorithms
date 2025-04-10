package Stack;
import java.util.*;

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

   if (head.next==null) {
        return true;
   }

   Stack<ListNode> st = new Stack<>();

   ListNode fast = head;
   ListNode slow = head;

   while (fast.next!=null) {

    st.push(slow); 

       if (fast.next.next!=null) {
           fast=fast.next.next;                   
       }else{
            break;
       }

       slow=slow.next;     
   }

   while (slow.next!=null) {
        slow=slow.next;
        if (slow.val==st.peek().val) {
            st.pop();
        }
        else{
            return false;
        }
   }

   return st.isEmpty() ? true : false;

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

// Leetcode Problem No 150 : Evaluate Reverse Polish Notation
public int evalRPN(String[] tokens) {

    Stack<Integer> s = new Stack<>();
        
    for (int i = 0; i < tokens.length; i++) {

        if (tokens[i].length()==1 && (tokens[i].charAt(0)=='-'||tokens[i].charAt(0)=='+'||
        tokens[i].charAt(0)=='/'||tokens[i].charAt(0)=='*')) {

            int num2 = s.pop();
            int num1 = s.pop();

            switch (tokens[i].charAt(0)) {

                case '+':
                s.push(num1+num2);
                break;

                case '-':
                s.push(num1-num2);
                break;

                case '/':
                s.push(num1/num2);
                break;

                case '*':
                s.push(num1*num2);
                break;
            
            }
            
        }else{
            s.push(Integer.parseInt(tokens[i]));
        }
    }

    return s.pop();
   }

   

/* 225. Implement Stack using Queues
Easy
Topics
Companies
Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

Implement the MyStack class:

void push(int x) Pushes element x to the top of the stack.
int pop() Removes the element on the top of the stack and returns it.
int top() Returns the element on the top of the stack.
boolean empty() Returns true if the stack is empty, false otherwise.
Notes:

You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
 

Example 1:

Input
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 2, 2, false]

Explanation
MyStack myStack = new MyStack();
myStack.push(1);
myStack.push(2);
myStack.top(); // return 2
myStack.pop(); // return 2
myStack.empty(); // return False
 

Constraints:

1 <= x <= 9
At most 100 calls will be made to push, pop, top, and empty.
All the calls to pop and top are valid.
 

Follow-up: Can you implement the stack using only one queue? */

class MyStack {

    Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>(); 
    }
    
    public void push(int x) {
        q.add(x);
        for (int i = 1; i < q.size(); i++) {
            q.add(q.remove());
        }
    }
    
    public int pop() {
        return q.remove();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

// Leetcode Problem No 735 : Asteroid Collision
public int[] asteroidCollision(int[] asteroids) {
        
    Stack<Integer> s = new Stack<>();
    
    
    for (int i = 0; i < asteroids.length; i++) {
        if (asteroids[i]>0) {
            s.push(asteroids[i]);
        }else{

            int element = asteroids[i];
            boolean flag=true;
            while (!s.isEmpty() && s.peek()>0 && element<0) {     

                if(s.peek()==Math.abs(element)){
                    s.pop();
                    flag=false;
                    break;
                }              
                element = s.peek() > Math.abs(element) ? s.peek() : element;
                s.pop();

            }
            
           if (flag) {
            s.push(element);
           }
        }
    }
    
    int temp[] = new int[s.size()];

    for (int i = temp.length-1; i>=0; i--) {
        temp[i]=s.pop();
    }
    return temp;
}

// Leetcode Problem No 71 : Simplify Path
public static String simplifyPath(String path) {

    String[] components = path.split("/");

    Stack<String> st = new Stack<>();

    for (String com : components) {

        if (com.equals(".") || com.isEmpty()) {
            continue;
        }

        if (com.equals("..")) {
            if(!st.isEmpty())st.pop();
            continue;
        }
        st.push(com);
    }

    int size = st.size();
   
    String result = "";

   while (!st.isEmpty()) {
    result="/"+st.pop()+result;
   }
           
    return size==0 ? "/" : result;
}

public static void main(String[] args) {
    simplifyPath("/.../a/../b/c/../d/./");
}

}

// Leetcode Problem No 155. Min Stack

class MinStack {

    Stack<Integer> st;

    public MinStack() {
        st=new Stack<>();
     
    }
    
    public void push(int val) {
        
            st.push(val);
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {

        int min=st.get(0);

        for (int i = 1; i < st.size(); i++) {
            if (st.get(i)<=min) {
                min=st.get(i);
            }
        }
        return min;
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */


 // Leetcode Problem No 2296. Design a Text Editor

 class TextEditor {

    Stack<Character> left;
    Stack<Character> right;

    public TextEditor() {
        left=new Stack<>();
        right=new Stack<>();
    }
    
    public void addText(String text) {
        for (Character ch : text.toCharArray()) {
            left.push(ch);
        }
    }
    
    public int deleteText(int k) {

        int count=0;
        if (left.isEmpty()) {
            return count;
        }

        for (int i = 1; i <= k && !left.isEmpty(); i++) {
            left.pop();
            count++;
        }

        return count;
    }
    
    public String cursorLeft(int k) {

        if (left.isEmpty()) {
            return "";
        }

        for(int i=1;i<=k && !left.isEmpty();i++){
            right.push(left.pop());
        }

        return getLast10();

    }
    
    public String cursorRight(int k) {
        if (right.isEmpty()) {
            return getLast10();
        }

        for(int i=1;i<=k && !right.isEmpty();i++){
            left.push(right.pop());
        }
        return getLast10();
    }

    private String getLast10(){

        String res="";
        int index = left.size()-1;

        for (int i = 0; i < 10 && index>=0; i++) {
            res = (left.get(index)+"")+res;
            index--;
        };
        return res;
    }
}


/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */


