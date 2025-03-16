package Recursion;

import java.util.ArrayList;

public class recursion {
    public static void main(String[] args) {
        recursion ob = new recursion();

    //     System.out.println(ob.BinarySearch(new int[]{5,10,15,20,25,30,35,40,45,50}, 0, 9, 20));

         int []arr = {6,7,8,10,11,3,4,5};

    //     ob.bubbleSort(arr, 9);
    //   System.out.println(Arrays.toString(arr));

    //   System.out.println(ob.reverseNumber(12345,0));
    //   System.out.println(ob.sumFromStartToEnd(5, 100));
    //   System.out.println(ob.productFromStartToEnd(5, 10));
    //   System.out.println(ob.sumOfDigits(12345));
    //   System.out.println(ob.productOfDigits(12345));
    //   System.out.println(ob.isPalindrome(new int[]{1,5,9,9,5,1}, 0, 5));

    // System.out.println(ob.countZeros(905600200, 0));
    //System.out.println(ob.isArraySorted(new int[] {1}, 0, 0));
    //System.out.println(ob.linearSearch(arr, 4, 0));
    System.out.println(ob.rotatedBinarySearch(arr, 0, arr.length-1, 7));

    }

    void printNumbers(int start , int end){

        if (start>end) {
            return;
        }

        System.out.println(start);
        printNumbers(start+1, end);
    }

    int reverseNumber(int num ,int rev){

        if (num==0) {
            return rev;
        }

        return reverseNumber(num/10,(rev*10)+(num%10));

     }
   
    int BinarySearch(int []arr , int start , int end , int target){

        if (start>end) {
            return -1;
        }

        int mid = (start+end)/2;

        if (target>arr[mid]) {
            return BinarySearch(arr, mid+1, end, target);
        }else if(target<arr[mid]){
            return BinarySearch(arr, start, mid-1, target);
        }   
            return mid;
                  
     }

     void bubbleSort(int []arr , int i){

        if (i==0) {
            return;
        }

        for (int j = 1; j <= i; j++) {
            if (arr[j-1]>arr[j]) {

                int temp= arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
            }
        }

        bubbleSort(arr, i-1);
     }


     int sumFromStartToEnd(int start , int end){

        if (start>=end) {
            return end;
        }

        return start+sumFromStartToEnd(start+1, end);
     }

     int productFromStartToEnd(int start , int end){

        if (start>=end) {
            return end;
        }

        return start*productFromStartToEnd(start+1, end);
     }

     int sumOfDigits(int num){

        if (num==0) {
            return 0;
        }

        return (num%10)+sumOfDigits(num/10);
     }

     int productOfDigits(int num){

        if (num==0) {
            return 1;
        }
        
        return (num%10)*productOfDigits(num/10);
     }


     boolean isPalindrome(int [] arr , int start , int end){

       if (start>=end) {
        return true;
       }

       else if(arr[start]==arr[end]){
        return isPalindrome(arr, start+1, end-1);
       }

       return false;

     }

     int countZeros(int num , int count){

        if (num==0)return count;
        
        return num%10==0 ? countZeros(num/10, count+1) : countZeros(num/10, count);

     }

     // Leetcode Problem No 1342. Number of Steps to Reduce a Number to Zero

     public int numberOfSteps(int num) {
        return helperNumberOfSteps(num, 0);
     }

     private int helperNumberOfSteps(int num , int count){

        if (num==0) {
            return count;
        }

        return num%2==0 ?  helperNumberOfSteps(num/2, count+1) : helperNumberOfSteps(num-1, count+1);

     }


     // Check if the array is sorted in assending order or not

     boolean isArraySorted(int [] arr , int start , int end){

        if (start>end || arr.length==1) {
            return true;
        }

        if (arr[start+1]>=arr[start] && arr[end]>=arr[end-1]) {
            return isArraySorted(arr, start+1, end-1);
        }
        
        return false;
     }

     // Linear Search 

     int linearSearch(int arr[] , int target , int index){

        if (index==arr.length) {
            return -1;
        }

        if (arr[index]==target) {
            return index;
        }

        return linearSearch(arr, target, index+1);

     }

     ArrayList<Integer> multipleOccurrencesLinearSearch(int []arr , int target){

        ArrayList<Integer> list = new ArrayList<>();
        return helperLinearSearch(arr , target , 0 , list);
     }

     private ArrayList<Integer> helperLinearSearch(int [] arr , int target , int index , ArrayList<Integer> list){

        if (index==arr.length) {
            return list;
        }

        if (arr[index]==target) {
            list.add(index);
        }

        return helperLinearSearch(arr, target, index+1, list);

     }

     // Rotated Binary Search

    int rotatedBinarySearch(int [] arr , int start , int end , int target){

        if (start>end) return -1;

        int mid = (start+end)/2;

        if(arr[mid]==target) return mid;

        if (arr[start]<=arr[mid]) {
            
            if (target>=arr[start] && target<=arr[mid]) {
                return rotatedBinarySearch(arr, start, mid-1, target);
            }else{
            return rotatedBinarySearch(arr, mid+1, end, target);
            }
        }
        else{
            if (target>=arr[mid]&&target<=arr[end]) {
            return rotatedBinarySearch(arr, mid+1, end, target);
            }
            else{
                return rotatedBinarySearch(arr, start, mid-1, target);
            }
        }
    }
}
