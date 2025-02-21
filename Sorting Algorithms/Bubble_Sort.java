
import java.util.Arrays;

class bubbleSort{

    void basicBubbleSort(int []arr){

        for (int i = arr.length-1; i >= 1; i--) {

            for(int j = 1;j<=i;j++){

                if(arr[j-1]>arr[j]){

                    int temp = arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;

                }
            }
        }

    }
}

public class Bubble_Sort{
    public static void main(String[] args) {

        bubbleSort ob = new bubbleSort();

        int []arr = {5,4,3,2,1,1,2,5,4,2,3,4,1,5};//{20,5,50,15,2,25,50,5,7,35};
        ob.basicBubbleSort(arr);
        System.out.println(Arrays.toString(arr));

        
    }
}