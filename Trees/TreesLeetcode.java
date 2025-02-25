package Trees;

import java.util.*;

public class TreesLeetcode {

  
 // Leetcode Problem No 102.
 //Binary Tree Level Order Traversal


 // Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
         this.right = right;
      }
 }
 
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> list = new ArrayList<>();

        if (root==null) {
            return list;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
     
        while (!q.isEmpty()) {

            int size = q.size();
            List<Integer> currList = new ArrayList<>();

            for (int i = 1; i <= size; i++) {

                TreeNode removed = q.remove();
                currList.add(removed.val);

                if (removed.left!=null) {
                    q.add(removed.left);
                } 
                if (removed.right!=null) {
                    q.add(removed.right);
                }

            }
            list.add(0,currList);
        }    
       return list;
    }

    // Leetcode Problem No 637.
    // Average of Levels in Binary Tree.

    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> list = new ArrayList<>();

        if (root==null) {
            return list;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
     
        while (!q.isEmpty()) {

            int size = q.size();
            double sum=0;

            for (int i = 1; i <= size; i++) {

                TreeNode removed = q.remove();
               
                sum+=removed.val;

                if (removed.left!=null) {
                    q.add(removed.left);
                } 
                if (removed.right!=null) {
                    q.add(removed.right);
                }

            }
          list.add(sum/size);
        }    
       return list;
    }

    // Google Interview Question
    // Level-Order Successor of a node

    public int levelOrderSuccueeor(TreeNode root,int num){

        if (root==null) {
            return -1;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
     
        while (!q.isEmpty()) {

                TreeNode removed = q.remove();

                if (removed.left!=null) {
                    q.add(removed.left);
                } 
                if (removed.right!=null) {
                    q.add(removed.right);
                }
                
                if (removed.val==num) {
                    break;
                }
            }
       
            return q.isEmpty() ? -1 : q.peek().val;
           
        }

        /* 103. Binary Tree Zigzag Level Order Traversal
            Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
            (i.e., from left to right, then right to left for the next level and alternate between). */

            public List<List<Integer>> zigzagLevelOrder(TreeNode root) {


                List<List<Integer>> list = new ArrayList<>();

                if (root==null) {
                    return list;
                }

                LinkedList<TreeNode> queue = new LinkedList<>();

                boolean flag=true;

                queue.add(root);
                
                while (!queue.isEmpty()) {

                    int size=queue.size();

                    List<Integer> currList = new ArrayList<>();

                    if (flag) {
                        
                        for(int i=1;i<=size;i++){

                        TreeNode removed = queue.removeFirst();
                        currList.add(removed.val);

                        if (removed.left!=null) {
                            queue.addLast(removed.left);
                        } 
                        if(removed.right!=null){
                            queue.addLast(removed.right);
                        }
                       
                        
                        }

                        flag=false;

                    }else{

                        for(int i=1;i<=size;i++){

                            TreeNode removed = queue.removeLast();
                            currList.add(removed.val);

                            if(removed.right!=null){
                                queue.addFirst(removed.right);
                            }

                            if (removed.left!=null) {
                                queue.addFirst(removed.left);
                            }

                        }

                        flag=true;
                    }
                    list.add(currList);
                }
                return list;
    }

    //Leet Code Problem 199. Binary Tree Right Side View

    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();

        if (root==null) {
            return list;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {

            int size = q.size();
            TreeNode removed=null;

            for (int i = 1; i <= size; i++) {

                removed=q.remove();

                if (removed.left!=null) {
                    q.add(removed.left);
                } 
                if(removed.right!=null){
                    q.add(removed.right);
                }
            }

            list.add(removed.val);
            
        }
        return list;
    }    

    // Leetcode Problem No 993. Cousins in Binary Tree

    public boolean isCousins(TreeNode root, int x, int y) {

        if (root==null) {
            return false;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        boolean findX = false , findY = false;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 1; i <= size; i++) {

                TreeNode removed = q.remove();
            
                if (removed.left!=null) {
                    q.add(removed.left);
                } 
                if (removed.right!=null) {
                    q.add(removed.right);
                }

                if ((removed.left!=null && removed.right!=null) && ((removed.left.val== x && removed.right.val==y) ||
                (removed.left.val==y && removed.right.val==x))) {
                    return false;
                }
                
                if (removed.val==x) {
                    findX=true;
                }

                if (removed.val==y) {
                    findY=true;
                }

            }

            if (findX!=findY) {
                return false;
            }
        }
        return true;
    }

    /* Leetcode Problem No 101. Symmetric Tree
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center). */

    public boolean isSymmetric(TreeNode root) {

        if ((root==null) || (root!=null && (root.left==null&&root.right==null))) {
            return true;
        }

        Queue<TreeNode> q = new LinkedList<>();

        if (root.left!=null) {
            q.add(root.left);
        }else{
            return false;
        }

        if(root.right!=null){
            q.add(root.right);
        }else{
            return false;
        }

        while (!q.isEmpty()) {

            int size = q.size();
            TreeNode removed=null;

            if (size<2) {
                return false;
            }

            Stack<Integer> nums = new Stack<>();
            Stack<Character> chars = new Stack<>();

            for (int i = 1; i <= size/2; i++) {

                removed=q.remove();
                nums.push(removed.val);

                if (removed.left!=null) {
                    q.add(removed.left);
                    chars.push('l');
                }else{
                    chars.push(' ');
                }

                if(removed.right!=null){
                    q.add(removed.right);
                    chars.push('r');

                }else{
                    chars.push(' ');

                }
                
            }

            for (int i = 1; i <= size/2; i++) {

                removed=q.remove();

                if (removed.val==nums.peek()) {
                    nums.pop();
                }else{
                    return false;
                }

                if (removed.left!=null) {
                    q.add(removed.left);
                    char c = chars.peek();
                    if (c=='r' && c!='l') {
                        chars.pop();
                    }else{
                        return false;
                    }

                }else{
                    if (chars.peek()==' ') {
                        chars.pop();
                    }
                    else{
                        return false;
                    }
                }

                if(removed.right!=null){
                    q.add(removed.right);
                    char c = chars.peek();
                    if (c=='l' && c!='r') {
                        chars.pop();
                    }else{
                        return false;
                    }
                }else{
                    if (chars.peek()==' ') {
                        chars.pop();
                    }
                    else{
                        return false;
                    }
                }
                
            }
      
            
        }
        return true;
    }

    // Leetcode Problem No 110. Balanced Binary Tree
    public boolean isBalanced(TreeNode root) {
        return checkBalance(root)!=-1;
    }

    private int checkBalance(TreeNode root){

        if (root==null) {
            return 0;
        }

        int left = checkBalance(root.left);
        if (left==-1) return -1;     
        int right = checkBalance(root.right);
        if (right==-1) return -1;
            
        if (Math.abs(left-right)>1) {
            return -1;
        }

        if (left>right) {
            return ++left;
        }
        return ++right;
    }

    // Leetcode Problem No 543 : Diameter of Binary Tree

    public int diameterOfBinaryTree(TreeNode root) {
        int max [] = new int[1];
         diameter(root , max);
         return max[0];
    }

    private int diameter(TreeNode root , int [] max){

        if (root==null) return 0;
        
        int left = diameter(root.left , max);
            
        int right = diameter(root.right , max);

        max[0]=Math.max(max[0],left+right);

       return Math.max(left, right)+1;

    }

    

}

