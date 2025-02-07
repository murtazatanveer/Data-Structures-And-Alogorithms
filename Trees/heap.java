package Trees;
import java.util.*;

//Building MIN-HEAP
public class heap {

     private node root;
   private ArrayList<node> list = new ArrayList<>();

    heap(){
        list.add(null);
        
    }

    class node{

        node left;
        node right;  
        int data;
    
        node(int data){
            this.data=data;
        }
     }
     
     void insert(int data){

        node newNode = new node(data);

        if (root==null) {
            root=newNode;
            list.add(newNode);
            return;
        }

        list.add(newNode);
        node parent = list.get((list.size()-1)/2);
        
        if (parent.left==null) {
            parent.left=newNode;
        }else{
            parent.right=newNode;
        }
       
        MIN_HEAPIFY(newNode);
       
     }

     private void MIN_HEAPIFY(node newNode){

        int index = list.size()-1;

        while (list.get(index/2)!=null && (newNode.data<list.get(index/2).data)) {

            int temp = list.get(index/2).data;
            list.get(index/2).data=newNode.data;
            newNode.data=temp;

            index=index/2;
            newNode=list.get(index);
        }
     }

     boolean delete(int data){

        int size = list.size();

        for (int i = 1; i < list.size(); i++) {

            if (list.get(i).data==data) {

                
                boolean flag = list.get(i).data==list.get(size-1).data;

                list.get(i).data=list.get(size-1).data;
                if (list.get((size-1)/2).right==list.get(size-1)) {
                    list.get((size-1)/2).right=null;
                }else{
                    list.get((size-1)/2).left=null;
                }
                list.remove(size-1);

                if (flag) {
                    return true;
                }

                if (list.get(i/2)!=null && list.get(i).data<list.get(i/2).data){

                    int index = i;
                    node newNode = list.get(i);

                    while (list.get(index/2)!=null && (newNode.data<list.get(index/2).data)) {

                        int temp = list.get(index/2).data;
                        list.get(index/2).data=newNode.data;
                        newNode.data=temp;

                        index=index/2;
                        newNode=list.get(index);
                    }
                    
                }
                else if (list.get(i).right!=null || list.get(i).left!=null){

                    boolean right = list.get(i).right!=null;
                    boolean left = list.get(i).left!=null;
                    node n = list.get(i);
                    int index = i;

                    do{
                        if (left&&right) {
                            
                            if (list.get(index*2).data>list.get((index*2)+1).data) {
                                int temp=n.data;
                                n.data=list.get((index*2)+1).data;
                                list.get((index*2)+1).data=temp;
                                index=(index*2)+1;
                                n=list.get(index);
                                 right = list.get(index).right!=null;
                                 left = list.get(index).left!=null;
                            }else if (list.get(index*2).data<list.get((index*2)+1).data) {
                                int temp=n.data;
                                n.data=list.get((index*2)).data;
                                list.get((index*2)).data=temp;
                                index=index*2;
                                n=list.get(index);
                                right = list.get(index).right!=null;
                                 left = list.get(index).left!=null;
                            }

                        }else if (left) {
                            if (n.data>n.left.data) {
                                int temp=n.data;
                                n.data=n.left.data;
                                n.left.data=temp;
                                n=n.left;
                                index=index*2;
                                right = list.get(index).right!=null;
                                 left = list.get(index).left!=null;
                            }
                        }
                       
                    }while(right&&left);
                    
                }
                return true;
            }
        }
        return false;
     }

     void levelOrderTraversal(){
        
        if (root==null) {
            System.out.println("Empty Tree");
            return;
        }

        Queue<node> q = new LinkedList<>();
        node temp = root;

        q.add(temp);

        while (!q.isEmpty()) {
            temp=q.remove();
            System.out.print(temp.data+" --> ");
            if (temp.right!=null) {
                q.add(temp.right);
            }
            if (temp.left!=null) {
                q.add(temp.left);
            }

        }

        System.out.print("END\n");
        

    }

    // We suppose that the list is in Assending Order.
    node Heapify(ArrayList<node> list){

        Stack <node>s1 = new Stack<>();
        Stack <node>s2 = new Stack<>();

        int size = list.size();

        for (int i = (size/2)-1; i >=0 ; i--) {
            s1.push(list.get(i));
        }

        for (int i = size-1; i > 0; i--) {
            s2.push(list.get(i));
        }
        node root = s1.pop();
        node temp = root;

        for (int i = 0; i < size/2 ; i++) {
            if (i==(size/2)-1 && size%2==0) {
                temp.right=s2.pop();
                break;
            }
                temp.right=s2.pop();
                temp.left=s2.pop();

                if (i!=(size/2)-1) {
                    temp=s1.pop(); 
                }
                
                           
        }
        return root;
     }

     public static void main(String[] args) {

       heap tree =new heap();

        tree.insert(13);
        tree.insert(21);
        tree.insert(16);
        tree.insert(24);
        tree.insert(31);
        tree.insert(19);
        tree.insert(68);
        tree.insert(65);
        tree.insert(26);
        tree.insert(32);
        tree.insert(14);
        tree.insert(15);
       
        tree.delete(13);

        tree.levelOrderTraversal();

        


     }

}
