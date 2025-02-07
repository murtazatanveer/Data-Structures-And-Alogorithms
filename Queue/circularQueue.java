package Queue;

public class circularQueue {

     int front=0;
     int end=0;
    int []arr;

    circularQueue(int initialSize){
        arr=new int[initialSize];
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
        end=(end%arr.length);

    }

    int dequeue() {

        if (isQueueEmpty()) {
            System.out.println("ERROR! Queue is Empty");
            return Integer.MIN_VALUE;
        }

        int temp = arr[front];
        arr[front++]=Integer.MIN_VALUE;
        front=front%arr.length;
        return temp;

    }

    int peek(){
        if (isQueueEmpty()) {
            System.out.println("ERROR! Queue is Empty");
            return Integer.MIN_VALUE;
        }

        return arr[front];
    }

    boolean isQueueFull(){

        return(front==end && arr[front]!=Integer.MIN_VALUE && arr[end]!=Integer.MIN_VALUE);

    }

    boolean isQueueEmpty(){

        return(front==end && arr[front]==Integer.MIN_VALUE && arr[end]==Integer.MIN_VALUE);

    }



}

class dynamicCircularQueue extends circularQueue{

    dynamicCircularQueue(int initialSize){
        super(initialSize);
    }

    @Override
    void enqueue(int num) {

        if (isQueueFull()) {

            int [] temp = new int[arr.length*2];
            
            for (int i = 0; i < arr.length; i++) {
                temp[i]=arr[(i+front)%arr.length];
            }
            for(int i=arr.length;i<temp.length;i++){
                temp[i]=Integer.MIN_VALUE;
            }

            front=0;
            end=arr.length;
            arr=temp;

        }

        arr[end++]=num;
        end=(end%arr.length);

        
    }

}
