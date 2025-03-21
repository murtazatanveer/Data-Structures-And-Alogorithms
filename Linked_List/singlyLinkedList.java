package Linked_List;
class node {

    int digit;
    node next;
    
    public node(int digit){
        this.digit=digit;
        next=null;
    }
    
        
    }
    
    
    public class singlyLinkedList{
    
        node head;
    
        public singlyLinkedList(){
            head=null;
        }
    
       public void addAnElement(int digit){
    
            node newDigit = new node(digit);
    
            if (head==null) {
                head=newDigit;
                return;
            }
    
                node move = head;
    
                while (move.next!=null){
                    move=move.next;
                }
    
            move.next=newDigit;
         
        }
    
        public void displayAllDigits(){
    
            if (head==null) {
                System.out.println("Error : Empty List");
                return;
            }
            
    
                node move=head;
    
              //  System.out.print("\nAll Digits are : ");
    
                while (move!=null) {
                    System.out.print(move.digit+" --> ");
                    move=move.next;               
            }
           // System.out.println("\n");
        }
    
        public void addAtStart(int digit){
            node newdigit = new node(digit);
    
            if (head==null) {
                head=newdigit;
                return;
            }
                newdigit.next=head;
                head=newdigit;
            
        }
    
        
    
        public int size(){
    
            if (head==null) {
                return 0;
            }
            
            node move = head;
            int count=0;
    
            while (move!=null) {
                move=move.next;
                count++;
            }
            return count;
    
        }
    
        public void delete(int index){
    
            if (head==null) {
                System.out.println("Error : Empty List");
                
            }
    
            else if (index<0 || index>=size()){
                System.out.println("Error : Linked list index out of bounds");
                
            }
    
            else if(index==0){
                head=head.next;
            }
    
    
            else{

                node move = findNode(index-1);
                node temp=move.next;
                move.next=move.next.next;
                temp.next=null;
                temp=null;
                move=null;

        } 
    
    }
    
    public void addDigitAtIndex(int index,int digit){
    
            if (head==null) {
                System.out.println("Error : Empty List");
                return;
            }
    
            else if (index<0 || index>=size()){
                System.out.println("Error : Linked list index out of bounds");
                
            }
    
            else{
                   
            node move=findNode(index);

            move.digit=digit;
         }

        }
    
        public void deleteFromEnd(){
    
            if (head==null) {
                System.out.println("Error : Empty List");
                return;
            }
    
            node move = findNode(size()-2);
 
           move.next=null;
    
        }

        public void deleteFromStart(){
            if (head==null) {
                System.out.println("Error : Empty List");
                return;
            }
           head=head.next;

        }
    
        public void insertAfterIndex(int index , int digit){
    
            if (head==null) {
                System.out.println("Error : Empty List");
                
            }
    
            else if (index<0 || index>=size()){
                System.out.println("Error : Linked list index out of bounds");
                
            }
    
            else{
    
                node move=findNode(index);
                node newDigit = new node(digit);                

                newDigit.next=move.next;
                    move.next=newDigit;                      
                    move=move.next;               
        
             }           
    
        }

        public int getDigit(int index){

            if (head==null) {
                System.out.println("Error : Empty List");
                return Integer.MAX_VALUE;
                
            }
    
             else if (index<0 || index>=size()){
                System.out.println("Error : Linked list index out of bounds");
                return Integer.MAX_VALUE;
            }

            node move = findNode(index);

            return move.digit;
        }

        public int getDigitFromStart(){

            if (head==null) {
                System.out.println("Error : Empty List");
                return Integer.MAX_VALUE;
                
            }
            return head.digit;

        }

        private node findNode(int index){

            node move = head;

            for(int i=0;i<index;i++){
                move=move.next;
            }
            return move;
        }

        
    
    }
