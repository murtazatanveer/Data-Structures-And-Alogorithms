package Two_Pointers_and_Sliding_Window;

public class twoPointers {
    
    // Leetcode Problem No : 1768 Merge Strings Alternately

    public String mergeAlternately(String word1, String word2) {

        int i = 0 , j =0;

        boolean flag = true;

        String result="";

        while(i<word1.length()&&j<word2.length()){

            if(flag){
                result+=word1.charAt(i++);
                flag=false;
            }else{
                result+=word2.charAt(j++);
                flag=true;
            }
        }
        if (i==word1.length()&&j==word2.length()) return result;
        
        if (i==word1.length()) {
            for (;j < word2.length(); j++) {
                result+=word2.charAt(j);
            }
        }else{
            for (;i < word1.length(); i++) {
                result+=word1.charAt(i);
            }
        }
        return result;
    }
    
    // Leetcode Problem No 125 : Valid Palindrome
    public boolean isPalindrome(String s) {
        
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int end = s.length()-1;
        int start = 0;

        while (start<=end) {
            if (s.charAt(start++)!=s.charAt(end--)) {
                return false;
            }           
        }

        return true;

    }

    // Leetcode Problem No 26 : Remove Duplicates from Sorted Array
    public  int removeDuplicates(int[] nums) {
        if (nums.length==1) return 1;

        int f = 0;
        int s = 1;

        for (; s < nums.length; s++) {

            if (nums[f]!=nums[s]) {
                f++;
                nums[f]=nums[s];
            }
        }
        return f+1;
    }

   // Leetcode Problem No : 977 Squares of a Sorted Array
    public static int[] sortedSquares(int[] nums) { // Bubble Sort


        for (int i = nums.length-1; i >= 1; i--) {

            int j=1;

            for(;j<=i;j++){

                if((int)Math.pow(nums[j-1], 2)>(int)Math.pow(nums[j], 2)){
                    int temp = nums[j];
                    nums[j]=nums[j-1];
                    nums[j-1]=temp;
                }

            }
            nums[j-1]=(int)Math.pow(nums[j-1], 2);
        }
        nums[0]=(int)Math.pow(nums[0], 2);
        
        return nums;
    }

    public static void main(String []str){

        int arr [] = sortedSquares(new int[]{-4,-1,0,3,10});

    }
}
