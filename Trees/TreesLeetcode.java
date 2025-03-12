package Trees;

import java.util.*;


 // Definition for a binary tree node.
  class TreeNode {
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
public class TreesLeetcode {
  
 // Leetcode Problem No 102.
 //Binary Tree Level Order Traversal
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

    // Leetcode Problem No 100 : Same Tree

    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        Queue<TreeNode> q1 = new LinkedList<>(); 
        Queue<TreeNode> q2 = new LinkedList<>();
        
        if (p!=null) {
            q1.add(p);
        }

        if (q!=null) {
            q2.add(q);
        }
        
        while(!q1.isEmpty()||!q2.isEmpty()){

            if (q1.size()!=q2.size()) {
                return false;
            }

            TreeNode r1 = q1.remove();
            TreeNode r2 = q2.remove();

            boolean r1Right=false;
            boolean r1Left=false;
            boolean r2Left=false;
            boolean r2Right=false;

            if (r1.val!=r2.val) {
                return false;
            }
            
            if (r1.left!=null) {
                q1.add(r1.left);
                r1Left = true;
            }

            if (r1.right!=null) {
                q1.add(r1.right);
                r1Right=true;
            }

            if (r2.left!=null) {
                q2.add(r2.left);
                r2Left=true;
            }

            if (r2.right!=null) {
                q2.add(r2.right);
                r2Right=true;
            }
            
            if (r1Left != r2Left || r1Right != r2Right) return false;
                                 
        } 
        return true;
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

    // Leetcode Problem No 116. Populating Next Right Pointers in Each Node
   
        class Node {
            public int val;
            public Node left;
            public Node right;
            public Node next;
        
            public Node() {}
            
            public Node(int _val) {
                val = _val;
            }
        
            public Node(int _val, Node _left, Node _right, Node _next) {
                val = _val;
                left = _left;
                right = _right;
                next = _next;
            }
        }

        public Node connect(Node root) {
          
            if (root==null) {
                return root;
            }
    
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
    
                int size = q.size();
                Node removed = null;
                Node prev=null;
                Node curr=null;

                for (int i = 1; i <= size; i++) {
    
                     removed = q.remove();
                    prev=curr;
                    if (prev!=null) prev.next=removed;
                    curr=removed;
                    
                    if (removed.left!=null) {
                        q.add(removed.left);
                    } 
                    if (removed.right!=null) {
                        q.add(removed.right);
                    }
    
                }
                removed.next=null;
            }    
          return root;
        }
    

    // Leetcode Problem No 110. Balanced Binary Tree
    public boolean isBalanced(TreeNode root) { // Post Order Traversal (Left-Right-Node)
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

    public int diameterOfBinaryTree(TreeNode root) { // Post Order Traversal (Left-Right-Node)
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

    // Leetcode Problem No 226 : Invert Binary Tree
    public TreeNode invertTree(TreeNode root) { // Post Order Traversal (Left-Right-Node)
        invert(root);
        return root;
    }

    private void invert(TreeNode root){

        if (root==null) return;
        
        invert(root.left);
        invert(root.right);

        TreeNode temp = root.left;
        root.left=root.right;
        root.right=temp;
        
    }

    // Leetcode Problem No 104 : Maximum Depth of Binary Tree
    public int maxDepth(TreeNode root) { // Post Order Traversal (Left-Right-Node)
        
        if (root==null) return 0;
        
        int left = maxDepth(root.left);
            
        int right = maxDepth(root.right);

       return Math.max(left, right)+1;

    }

     // Leetcode Problem No 111 : Minimum Depth of Binary Tree

     public int minDepth(TreeNode root) {
        
        if (root==null) return 0;
        
        int left = minDepth(root.left);
            
        int right = minDepth(root.right);

        if ((left!=0&&right!=0) || (left==0&&right==0)) return Math.min(left, right);

        if (left!=0) return left+1; 

        return right+1;
        
     }

    // Leeetcode Problem No 236 : Lowest Common Ancestor of a Binary Tree
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root==null || root==p || root==q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left!=null && right!=null) return root; 
            
        return right!=null ? right : left;

    }

    // Leetcode Problem No 230 : Kth Smallest Element in a BST
        
        public int kthSmallest(TreeNode root, int k) {

            int [] count = new int[1];
        int [] ans = new int[1];
        inorder(root, k, count , ans);
        return ans[0];

        }
    
        private void inorder(TreeNode root, int k , int count[] , int ans[]) {
            if (root == null || count[0]>k) return;
    
            inorder(root.left, k, count, ans);
    
            count[0]++;
            if (count[0] == k) {
                ans[0] = root.val;
                return;
            }
    
            inorder(root.right, k, count, ans);
        }
    

    // leetcode Problem No 112: Path Sum 
    public boolean hasPathSum(TreeNode root, int targetSum) {

        targetSum=Math.abs(targetSum);
        return sum(root, targetSum, new int[1]);

}

    private boolean sum(TreeNode root, int targetSum,int sum[]){

        if (root==null) return false;

        sum[0]+=root.val;

        if (sum[0]==targetSum && root.left==null && root.right==null) return true;

         boolean left = sum(root.left, targetSum, sum);
         boolean right = sum(root.right, targetSum, sum);
      
            if (!left&&!right){
             sum[0]-=root.val;
             return false;
        }
      
        return true;

}

// Leetcode Problem No 129 : Sum Root to Leaf Numbers
public int sumNumbers(TreeNode root) {

        int totalSum[]=new int[1];
        sum(root, totalSum,0);
        return totalSum[0];
}

private void sum(TreeNode root , int [] totalSum , int digit){

    if(root==null) return;

    digit = (digit*10) + root.val;
    sum(root.left, totalSum, digit);
    sum(root.right, totalSum, digit);

    if (root.left==null && root.right==null) totalSum[0]+=digit;
        
    }

    // Leetcode Problem No 124 : Binary Tree Maximum Path Sum

    static class Solution {

        int max=Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
     
            pathSum(root);
            return max;
        }

        private int pathSum(TreeNode root){

            if (root == null) return 0; 

            int left = Math.max(0, pathSum(root.left));  
            int right = Math.max(0, pathSum(root.right));

            max = Math.max(max, left + right + root.val);

            left+=root.val;
            right+=root.val;         

          if (left>=right && left>=root.val) {
            return left;
          }
          if (right>=left && right>=root.val) {
            return right;
          }
          return root.val;
        }
    }
   
    // Leetcode Problem No : 257. Binary Tree Paths
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> paths = new ArrayList<>();
        treePaths(root,"", paths);
        return paths;
    }
    private void treePaths(TreeNode root , String p , List<String> paths){

        if(root==null) return;
    
        p+=root.val+"->";
        treePaths(root.left,p,paths);
        treePaths(root.right,p,paths);
    
        if (root.left==null && root.right==null) paths.add(p.substring(0, p.length() - 2));
            
        }

    // Leetcode Problem No 98 : Validate Binary Search Tree
    
    public boolean isValidBST(TreeNode root) {
        boolean flag[] = new boolean[1];
        int index[] = new int[1];
        flag[0]=true;
        ArrayList<Integer> list = new ArrayList<>();
        inorderTraversal(root, list, flag,index);
        return flag[0];
    }

    private void inorderTraversal(TreeNode root , ArrayList<Integer> list , boolean [] flag , int index[]){

        if (root==null || !flag[0]) return;

        inorderTraversal(root.left, list, flag, index);

        list.add(root.val);
        

        if(list.size()>1 && !(list.get(index[0])>list.get(index[0]-1)))flag[0] = false;

        index[0]++;

        inorderTraversal(root.right, list, flag, index);

    }

    // Leetcode Problem No 538 : Convert BST to Greater Tree

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
            
        ReverseInorderTraversal(root);
        return root;
    }

    private void ReverseInorderTraversal(TreeNode root){

        if (root==null) return;

        ReverseInorderTraversal(root.right);
        sum+=root.val;
        root.val=sum;
        ReverseInorderTraversal(root.left);      
        
    }
        
    // Leetcode Problem No 404 : Sum of Left Leaves
    int s=0;
    public int sumOfLeftLeaves(TreeNode root) {
        sumLeftLeaves(root);
        return s;
    }

    private void sumLeftLeaves(TreeNode root){

        if (root==null) return;
            
        if (root.left!=null && root.left.left==null && root.left.right==null) {
            s+=root.left.val;
        }

        sumLeftLeaves(root.left);
        sumLeftLeaves(root.right);
    }

    // Leetcode Problem No 173 : Binary Search Tree Iterator
    class BSTIterator {

        TreeNode root;
        Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {

            this.root=root;
            stack=new Stack<>();

            while (root!=null) {
                stack.push(root);
                root=root.left;
            }
        }
        
        public int next() {
            
            TreeNode removed =  stack.pop();
            update(removed.right);
            return removed.val;
        }
        
        public boolean hasNext() {
            return !stack.isEmpty();
        }
        
        private void update(TreeNode root){

            if (root==null) return;
                
            while (root!=null) {
                stack.push(root);
                root=root.left;
            }

        }
        
    }
    
    /**
     * Your BSTIterator object will be instantiated and called as such:
     * BSTIterator obj = new BSTIterator(root);
     * int param_1 = obj.next();
     * boolean param_2 = obj.hasNext();
     */


     //Leetcode Problem No 297 : Serialize and Deserialize Binary Tree
    //  public class Codec {

    //     // Encodes a tree to a single string.
    //     public String serialize(TreeNode root) {
            
    //         if(root==null) return "";

    //         Queue<TreeNode> q = new LinkedList<>();
    //         q.add(root);

    //         String result="["+root.val+",";

    //         while (!q.isEmpty()) {

    //             TreeNode removed = q.remove();

    //             if (removed.left!=null) {
    //                 result+=removed.val+",";
    //                 q.add(removed.left);
    //             }else{
    //                 result+="null,";
    //             }

    //             if (removed.right!=null) {
    //                 result+=removed.val+",";
    //                 q.add(removed.right);
    //             }
    //             else{
    //                 result+="null,";
    //             }
                
    //         }
    //         return removeTrailingNulls(result) + "]";
    //     }
    
    //     // Decodes your encoded data to tree.
    //     public TreeNode deserialize(String data) {

    //         if(data==null || data.isEmpty()) return null;

    //         data = data.replace("[", "").replace("]", "").replace(",", " ");

    //         String d = "";
    //         int i=0;
            

    //         while(i<data.length() && ((data.charAt(i)>='0'&&data.charAt(i)<='9') || (data.charAt(i)=='-') )){
    //             d+=data.charAt(i);
    //             i++;
    //         }

    //         TreeNode root = new TreeNode(Integer.parseInt(d));
    //         TreeNode ptr  = root;
    //         int index=i+1;

    //         while (index<data.length()) {
    //             TreeNode 
    //             if (data.charAt(index)>='a' && data.charAt(index)<='z') {
                    
    //             }
    //         }
    //         return root;
    //     }

    //     private  String removeTrailingNulls(String str) {
    //         return str.replaceAll("(,null)*$", ""); // Removes trailing ",null"
    //     }
    // } // Incomplete

    // Leetcode Problem No 113 : Path Sum II.
    List<List<Integer>> paths = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        sum2(root, targetSum, new ArrayList<>());
        return paths;
    }

    private void sum2(TreeNode root, int targetSum,List<Integer> list){

        if (root==null) return;
 
        targetSum-=root.val;
        list.add(root.val);

         if (targetSum==0 && root.left==null && root.right==null) {

            ArrayList<Integer> temp = new ArrayList<>();
            temp.addAll(list);
            paths.add(temp);
        
        }
        else{
          sum2(root.left, targetSum, list);
          sum2(root.right, targetSum, list);
        }
                  
              list.remove(list.size()-1);
  
     }

     // Leetcode Problem No 2331 : Evaluate Boolean Binary Tree
     public boolean evaluateTree(TreeNode root) {
        return checkTree(root)==1 ? true : false;
     }

     private int checkTree(TreeNode root){

        if (root.left==null && root.right==null) return root.val;

        int left = checkTree(root.left);
        int right = checkTree(root.right);

        if (left==1 && right==1) return 1;
        if (left==0 && right==0) return 0;
       
        return root.val==2 ? 1 : 0;
        
     }
    
     // Leetcode Problem No 222. Count Complete Tree Nodes
     int counter = 0;
     public int countNodes(TreeNode root) {
        traversal(root);
        return counter;
     }

     void traversal(TreeNode root){ // Postorder Traversal
        if(root==null) return;
        traversal(root.left);
        traversal(root.right);
        counter++;
     }

     // Leetcode Problem No : 99 Recover Binary Search Tree

        TreeNode first = null , second =null , prev = null;

      public void recoverTree(TreeNode root) {

        recover(root);
        int temp = first.val;
        first.val=second.val;
        second.val=temp;

     }
     private void recover(TreeNode root){

        if (root == null) return;

        recover(root.left);

        
        if (prev != null && root.val < prev.val) {
            if (first == null) {
                first = prev;  
            }
            second = root;  
        }

        prev = root; 
        recover(root.right);
    } 

   // Leetcode Problem No 700 : Search in a Binary Search Tree

   public TreeNode searchBST(TreeNode root, int val) {

        if (root==null || root.val==val) return root;
        
        return val>root.val ? searchBST(root.right, val) : searchBST(root.left, val);
   }

   // Leetcode Problem No 513 : Find Bottom Left Tree Value

   public int findBottomLeftValue(TreeNode root) {

    Queue<TreeNode> q = new LinkedList<>();
    LinkedList<Integer> list = new LinkedList<>();

    q.add(root);
 
    while (!q.isEmpty()) {

        int size = q.size();

        for (int i = 1; i <= size; i++) {

            TreeNode removed = q.remove();
            if (i==1) list.add(removed.val);            

            if (removed.left!=null) {
                q.add(removed.left);
            } 
            if (removed.right!=null) {
                q.add(removed.right);
            }

        }
        
    }    
   
    return list.get(list.size()-1);

   }

   

}

