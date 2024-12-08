 package Trees;

import java.util.Stack;

import org.w3c.dom.Node;

class node{

    node left;
    node right;  
    int data;

    node(int data){
        this.data=data;
    }
 }

public class binarySearchTrees {

    node root;

    void insert(int data){

        node newNode = new node(data);

        if (root==null) {
            root=newNode;
            return;
        }
        

        node temp = root;
        node parent=temp;

        while (temp!=null) {
            parent=temp;
            temp = newNode.data>temp.data ? temp.right : temp.left;
        }
        if (newNode.data>parent.data) {
            parent.right=newNode;
        }else{
            parent.left=newNode;
        }
    }


    void inorderTraversal(){

        if (root==null) {
            System.out.println("Empty Tree");
            return;
        }

        node temp = root;
        Stack<node> s = new Stack<>();

        System.out.print("\nIn-Order Traversal : ");


        do {
            
            while (temp!=null) {
                s.push(temp);
                temp=temp.left;
            }

            temp=s.pop();
            System.out.print(temp.data+" --> ");
            temp=temp.right;

        } while (!s.isEmpty() || temp!=null);

        System.out.print("END");

    }

    void postorderTraversal(){
        
        if (root==null) {
            System.out.println("Empty Tree");
            return;
        }
        node temp = this.root;

        Stack<node> s = new Stack<node>();

        boolean flag = true;

        System.out.print("\nPost-Order Traversal : ");

        do {
            while (temp!=null && flag) {
                s.push(temp);
                temp=temp.left;
            }

            if (s.peek().right==temp) {
                temp=s.pop();
                System.out.print(temp.data+" --> ");
                flag=false;
            }else{
                temp=s.peek().right;
                flag=true;
            }

        } while (!s.isEmpty());

        System.out.print("END");
       
    }

    void preorderTraversal(){

        if (root==null) {
            System.out.println("Empty Tree");
            return;
        }

        node temp = this.root;

        Stack<node> s = new Stack<node>();

        boolean flag = true;

        System.out.print("\nPre-Order Traversal : ");

        do {
            while (temp!=null && flag) {
                s.push(temp);
                System.out.print(temp.data+" --> ");
                temp=temp.left;
            }

            if (s.peek().right==temp) {
                temp=s.pop();
                flag=false;
            }else{
                temp=s.peek().right;
                flag=true;
            }

        } while (!s.isEmpty());

        System.out.print("END");
       
    }

    node maxNode(){

        if (root==null) {
            System.out.println("Empty Tree");
            return null;
        }

        node temp = root;

        while (temp.left!=null) {
            temp=temp.left;
        }

        return temp;

    }

    node minNode(){

        if (root==null) {
            System.out.println("Empty Tree");
            return null;
        }

        node temp = root;

        while (temp.right!=null) {
            temp=temp.right;
        }

        return temp;

    }

    boolean isExist(int data){

        if (root==null) {
            System.out.println("Tree is Empty");
            return false;
        }

        node temp = root;

        while (temp!=null) {

            if (temp.data==data) {
                return true;
            }

            if (data>temp.data) {
                temp=temp.right;
            }else if(data<temp.data){
                temp=temp.left;
            }
        }
        return false;
    }

    boolean delete(int data){

        if (!isExist(data)) {
            return false;
        }
        
        node temp = root;
        node parent = temp;

        while (true) {

            if (temp.data==data) {              
        
                if(temp.left==null && temp.right!=null){

                    if (parent.right==temp) {
                        parent.right=temp.right;
                    }else{
                        parent.left=temp.right;
                    }
                    
            }else if (temp.right==null && temp.left!=null) {


                if (parent.right==temp) {
                    parent.right=temp.left;
                }else{
                    parent.left=temp.left;
                }
                
            }

            else if(temp.left==null && temp.right==null){
                if (parent==temp) {
                    root=null;
                }
              else if (parent.left==temp) {
                parent.left=null;
              }else{
                parent.right=null;
              }  
            }

            else{

                node sucessor = temp.right;

                parent=sucessor;

                while (sucessor.left!=null) {
                    parent=sucessor;
                    sucessor=sucessor.left;
                }
                temp.data=sucessor.data;
            
                if (sucessor.right==null) {
                    if (sucessor==parent) {
                        temp.right=null;
                    }else{
                        parent.left=null;
                    }
                    
                }else{
                    if (sucessor==parent) {
                        temp.right=sucessor.right;
                    }else{
                        parent.left=sucessor.right;
                    }
                    
                }
               }
               break;
            }
            else if (data>temp.data) {
                parent=temp;
                temp=temp.right;
            }else{
                parent=temp;
                temp=temp.left;
            }
        }
        return true;
    }

   

    

    public static void main(String[] args) {
        
        binarySearchTrees tree = new binarySearchTrees();

        tree.insert(75);
        tree.insert(13);
        tree.insert(29);
        tree.insert(50);
        tree.insert(95);
        tree.insert(78);
        tree.insert(43);
        tree.insert(10);
        tree.insert(63);
        tree.insert(26);
        tree.insert(85);
        tree.insert(90);
        tree.insert(80);
        tree.insert(87);

  
        // tree.preorderTraversal();
        // tree.postorderTraversal();
        tree.inorderTraversal();
        System.out.println("\n"+tree.delete(13));
   
        tree.inorderTraversal();

        // System.out.println(tree.minNode().data);
        // System.out.println(tree.maxNode().data);

        // System.out.println(tree.isExist(88));
    }
}
    
    
