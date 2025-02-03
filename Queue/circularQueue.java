package Queue;



public class circularQueue {

    int front=0;
    int end=0;
    int []arr;

    circularQueue(int size){
        arr=new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=Integer.MIN_VALUE;
        }
    }

    void enqueue(int num) {

        if (isQueueFull()) {
            System.out.println("ERROR! Queue is Full");
            return;
        }

        arr[end++]=num;

    }

    int dequeue() {

        if (isQueueEmpty()) {
            System.out.println("ERROR! Queue is Empty");
            return Integer.MIN_VALUE;
        }

        int temp = arr[front];
        arr[front++]=Integer.MIN_VALUE;

        return temp;

    }

    boolean isQueueFull(){

        setFront();
        setEnd();
        return(front==end && arr[front]!=Integer.MIN_VALUE && arr[end]!=Integer.MIN_VALUE);

    }

    boolean isQueueEmpty(){

        setFront();
        setEnd();
        return(front==end && arr[front]==Integer.MIN_VALUE && arr[end]==Integer.MIN_VALUE);

    }

    private void setFront(){
        front=(front%arr.length);
    }

    private void setEnd(){
        end=(end%arr.length);
    }
   
}
