import java.util.*;

public class MergeSort {
    
    int [] mergeSort(int [] arr){

        if (arr.length==1) return arr;
        
        int [] left = mergeSort(Arrays.copyOfRange(arr, 0, arr.length/2));
        int [] right = mergeSort(Arrays.copyOfRange(arr, arr.length/2, arr.length));

        return merge(left, right);
        
    }

    private int [] merge(int arr1[] , int arr2[]){

        int result[] = new int[arr1.length+arr2.length];

        int i = 0;
        int j = 0;
        int k=0;

        while (i<arr1.length && j<arr2.length){

            if (arr1[i]<arr2[j]) {
                result[k++]=arr1[i++];
            }
            else if(arr1[i]>arr2[j]){
                result[k++]=arr2[j++];
            }
            else{
                result[k++]=arr1[i++];
                result[k++]=arr2[j++];
            }
        }

        if (i==j) return result;

        if (i==arr1.length) {

            for (int index = k; index < result.length; index++,j++) {
                result[index] = arr2[j];
            }

        }else{

            for (int index = k; index < result.length; index++,i++) {
                result[index] = arr1[i];
            }

        }
        return result;
    }

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();

       System.out.println( Arrays.toString(sort.mergeSort(new int[]{35,15,45,30,5,20,70,60,10})));
    }
}
