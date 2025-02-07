package Queue;

class queueLinkedList{

    private node front;
    private node rear;
    int size;

     class node  {

        int data;
        node next;

        node(int data){
            this.data=data;
        }

    }

    queueLinkedList(){
        front=null;
        rear=null;
        size=0;
    }
    
    void enQueue(int num){

        node newNum = new node(num);

        if (front==null && rear==null) {
            front=newNum;
            rear=newNum;
            return;
        }

        rear.next=newNum;
        rear=rear.next;
        size++;

    }

    int deQueue(){
        
        if (isEmpty()) {
            System.out.println("Empty Queue");
            return Integer.MIN_VALUE;
        }
        
        node temp;
        size--;

        if (front==rear) {
            temp=front;
            front=null;
            rear=null;
            return temp.data;
        }
        
        temp=front;
        front=front.next;
        return temp.data;

    }

    int peek(){

        if (isEmpty()) {
            System.out.println("Empty Queue");
            return Integer.MIN_VALUE;
        }

        return front.data;
    }

    boolean isEmpty(){
        return front==null && rear==null ? true : false; 
    }

    void displayQueue(){

        if (isEmpty()) {
            System.out.println("Empty Queue");
            return;
        }

        node temp=front;

        System.out.print("Queue : ");
        while (temp!=null) {
            System.out.print(temp.data+" --> ");
            temp=temp.next;
        }

        System.out.print("END\n"); 
    }

}


class dynamicQueue{

    private int arr[];
    private int end;

    dynamicQueue(int initialSize){
        end=-1;
        arr=new int[initialSize];
    }

    void enQueue(int data){
        if (isArrayFull()) {
            int [] temp = new int[arr.length*2];

            for(int i=0;i<arr.length;i++){
                temp[i]=arr[i];
            }
            arr=temp;
            arr[++end]=data;
            return;
        }
        arr[++end]=data;
    }

    int deQueue(){

        if (isEmpty()) {
            System.out.println("Empty Queue");
            return Integer.MIN_VALUE;
        }

        int temp=arr[0];
        arr[0]=0;

        for (int i = 0; i <= end; i++) {
            if(i==arr.length-1){
                arr[arr.length-1]=0;
                break;
            }
            arr[i]=arr[i+1];
        }
        end--;
        return temp;
    }
    
    int peek(){
        return arr[0];
    }

    boolean isEmpty(){
        return  (end==-1);
    }

    private boolean isArrayFull(){
        return (end+1)==arr.length; 
    }
    
    int size(){
        return end+1;
    }

    void displayQueue(){
        if (isEmpty()) {
            System.out.println("Empty Queue");
            return;
        }
        System.out.print("Queue : ");
        for (int i = 0; i <= end; i++) {
            if (i==end) {
                System.out.print(arr[i]);
                break;
            }
            System.out.print(arr[i]+" <-- ");
        }
        System.out.println();
    }

}



