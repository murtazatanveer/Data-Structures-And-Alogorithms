package Trees;

import java.lang.reflect.Array;
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
            list.add(currList);
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

}

