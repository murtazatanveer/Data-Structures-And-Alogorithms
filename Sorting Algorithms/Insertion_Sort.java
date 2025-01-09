import java.util.Arrays;

public class Insertion_Sort {
    
    void insertionSort(int [] arr){
        if (arr==null) {
            System.out.println("Empty Array");
            return;
        }

        for (int i = 0; i < arr.length-1; i++) {

            for (int j = i+1; j > 0; j--) {

                if (arr[j-1]>arr[j]) {

                    int temp=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                }
                else{
                    break;
                }
            }
        }

    }

    public static void main(String[] args) {
        Insertion_Sort ob = new  Insertion_Sort();

        int []arr = {5,4,3,2,1,1,2,5,4,2,3,4,1,5}; //{20,5,50,15,2,25,50,5,7,35};
        
        ob.insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
