package Linear_Search;
import java.util.*;


class linerSearch{

int givenElementIndex(int []arr,int target){

    if(arr.length==0||arr==null){return -1;}

    for(int i=0;i<arr.length;i++){
        if(target==arr[i]){
            return i;
        }
    }


    return -1;// Returns -1 if element doesnot exist in arr or arr is empty or null.
}

boolean isElementExist(int []arr , int target){

    if(arr.length==0||arr==null){return false;}

    for (int i = 0; i < arr.length; i++) {
        if(target==arr[i]){return true;}
        
    }
    return false;

}

int indexOfMaxElement(int []arr){

    if(arr.length==0||arr==null){return -1;}

    int index=0;
    int max=arr[0];

    for (int i = 0; i < arr.length; i++) {
        if(arr[i]>max){
            max=arr[i];
            index=i;
        }
    }
    return index;

}

boolean isCharExist(String str,char ch){

    if(str==null || str.length()==0){return false;}

    for (int i = 0; i < str.length(); i++) {

        if(ch==str.charAt(i)){return true;}
        
    }

    return false;

}

// Linear search in 2D arrays

int [] elementIndex(int [][] arr,int target){


    if(arr==null || arr.length==0){
        return new int[]{-1,-1};
    }

    for (int i = 0; i < arr.length; i++) {

        for (int j = 0; j < arr[i].length; j++) {

             if(target==arr[i][j]){return new int[]{i,j};}          
        }       
    }
 
    return new int[]{-1,-1};
    
}

/*  Given an array nums of integers, return how many of them contain an even number of digits.

 

Example 1:

Input: nums = [12,345,2,6,7896]
Output: 2
Explanation: 
12 contains 2 digits (even number of digits). 
345 contains 3 digits (odd number of digits). 
2 contains 1 digit (odd number of digits). 
6 contains 1 digit (odd number of digits). 
7896 contains 4 digits (even number of digits). 
Therefore only 12 and 7896 contain an even number of digits.
Example 2:

Input: nums = [555,901,482,1771]
Output: 1 
Explanation: 
Only 1771 contains an even number of digits. */

int findNumbers(int[] nums) {

    int count=0;

    for (int i = 0; i < nums.length; i++) {
        if(isNumHasEvenDigits(nums[i])){
            count++;
        }
    }
    return count;
}


private boolean isNumHasEvenDigits(int num){

    if(num==0){return false;}

    num = num < 0 ? (num * -1) : num;

    int count=0;

    while (num>0){
        num /= 10;
        count++;       
    }

    return count % 2 == 0;

}

/*  You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the i​​​​​​​​​​​th​​​​ customer has in the j​​​​​​​​​​​th​​​​ bank. Return the wealth that the richest customer has.

A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the customer that has the maximum wealth.

 

Example 1:

Input: accounts = [[1,2,3],[3,2,1]]
Output: 6
Explanation:
1st customer has wealth = 1 + 2 + 3 = 6
2nd customer has wealth = 3 + 2 + 1 = 6
Both customers are considered the richest with a wealth of 6 each, so return 6.
Example 2:

Input: accounts = [[1,5],[7,3],[3,5]]
Output: 10
Explanation: 
1st customer has wealth = 6
2nd customer has wealth = 10 
3rd customer has wealth = 8
The 2nd customer is the richest with a wealth of 10.
Example 3:

Input: accounts = [[2,8,7],[7,1,3],[1,9,5]]
Output: 17 */

 int maximumWealth(int[][] accounts){

    if(accounts.length==1){return sumofElements(accounts[0]);}

    int max = sumofElements(accounts[0]);

    for (int i = 1; i < accounts.length; i++) {

        if(sumofElements(accounts[i])>max){
            max = sumofElements(accounts[i]);
        }
        
    }

    return max;

}

private int sumofElements(int []arr){

    if(arr==null || arr.length==0){return 0;}

    int sum=0;

    for (int i = 0; i < arr.length; i++) {sum += arr[i];}

    return sum;
}

/* Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

Return the kth positive integer that is missing from this array.

 

Example 1:

Input: arr = [2,3,4,7,11], k = 5
Output: 9
Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9. */

// Solution

int findKthPositive(int[] arr, int k) {
   
    ArrayList<Integer> arrCopy = new ArrayList<>(1);
    
    boolean isExist=false;
    
    for (int i = 1;k>arrCopy.size(); i++) {
      
        for (int j = 0; j < arr.length; j++) {

        if(arr[j]>i){
            break;
        }
            
        if(arr[j]==i){
            isExist=true;
            break;}    
        
    }
    if(!isExist){arrCopy.add(i);}
    isExist=false;
    
}

return arrCopy.get(k-1);
    
}

/* Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4 */

 int searchInsert(int[] nums, int target) {

    int i; 

    for (i= 0; i < nums.length; i++) {

        if(target==nums[i]){
            return i;
        }

        if(target < nums[i]){
            return i;
        }
        
    }

    return i;      
}


/*  You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

 

Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10 */

public int singleNonDuplicate(int[] nums) {

    if(nums.length==1){return nums[0];}

    if(nums[0]!=nums[1]){
        return nums[0];
    }

    if(nums[nums.length-1]!=nums[nums.length-2]){
        return nums[nums.length-1];
    }

    for (int i = 1; i < nums.length-1; i++) {

        if( (nums[i]!=nums[i+1] ) && (nums[i]!=nums[i-1]) ){
            return nums[i];
        }
        
    }

    return Integer.MAX_VALUE;
        
}

/*  Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

Return the running sum of nums.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [1,3,6,10]
Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
Example 2:

Input: nums = [1,1,1,1,1]
Output: [1,2,3,4,5]
Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
Example 3:

Input: nums = [3,1,2,10,1]
Output: [3,4,6,16,17]
 

Constraints:

1 <= nums.length <= 1000
-10^6 <= nums[i] <= 10^6 */

  int[] runningSum(int[] nums) {

    int []arr = new int[nums.length];

    int sum=0;

     for (int i = 0; i < nums.length; i++) {

            sum += nums[i];
            arr[i]=sum;

     }

     return arr;
        
    }

    /*  You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

 
Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104 */

boolean searchMatrix(int[][] matrix, int target) {

    if(matrix.length==1){

        for (int i = 0; i < matrix[0].length; i++) {

            if(matrix[0][i]>target){return false;}

            if(target==matrix[0][i]){return true;}
            
        }
    }

    if(target<matrix[0][0] || target>matrix[matrix.length-1][matrix[(matrix.length-1)].length-1]){return false;}


    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {

             if(matrix[i][j]>target){return false;}

            if(matrix[i][j]==target){return true;}
            
        }
               
    }
    return false;
        
    }

    /*  Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
 

Example 1:


Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true
Example 2:


Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
Output: false
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= n, m <= 300
-109 <= matrix[i][j] <= 109
All the integers in each row are sorted in ascending order.
All the integers in each column are sorted in ascending order.
-109 <= target <= 109
 */

     boolean searchMatrix2(int[][] matrix, int target) {
        
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }

        if(matrix.length==1){

            for (int i = 0; i < matrix[0].length; i++) {
    
                if(matrix[0][i]>target){return false;}
    
                if(target==matrix[0][i]){return true;}
                
            }
        }
    
        if(target<matrix[0][0] || target>matrix[matrix.length-1][matrix[(matrix.length-1)].length-1]){return false;}
    
    
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
    
                 if(matrix[i][j]>target){break;}
    
                if(matrix[i][j]==target){return true;}
                
            }
                   
        }
        return false;

    }

    /*  There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
 

Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104 */

int search(int[] nums, int target) {

    if(nums==null || nums.length<1){return -1;}

    for(int i = 0;i<nums.length;i++){
        if(target==nums[i]){return i;}
    }

    return -1;
        
}

/* 34. Find First and Last Position of Element in Sorted Array
Medium
Topics
Companies
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109 */

int[] searchRange(int[] nums, int target) {

    if(nums==null | nums.length<1){return new int[]{-1,-1};}

    else{

    for (int i = 0; i < nums.length && nums[i]<=target; i++) {

        if(target==nums[i]){
            
            return new int[]{i,similarNums(nums,i,target)};
        }
        
    }

}

    return new int[]{-1,-1};
        
}

private int similarNums(int nums[],int index,int target){
    

    for (int i = index+1; i < nums.length && nums[i]<=target; i++) {
        
        if(nums[i]==target){index ++;}               
    }
    return index;

}


/*  41. First Missing Positive
Hard
Topics
Companies
Hint
Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.

You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

 

Example 1:

Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.
 

Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1 */

public int firstMissingPositive(int[] nums) {

    int check=1;

    while(true){

        if(contains(nums,check)){
            check++;
        }
        else{
            return check;
        }
    }
        
}

private boolean contains(int []arr,int check){

    for (int i = 0; i < arr.length; i++) {
        if(check==arr[i]){
            return true;
        }
    }
    return false;
}

// private int maxNum(int arr[]){

//     int max = arr[0];
    
//     for (int i = 1; i < arr.length; i++){

//         if(max<arr[i]){
//             max=arr[i];
//         }
       
//     }

//     return max;
// }

// private int minNum(int arr[]){

//     int min = arr[0];
    
//     for (int i = 1; i < arr.length; i++){

//         if(min>arr[i]){
//             min=arr[i];
//         }
       
//     }

//     return min;
// }


/* 1. Two Sum
Easy
Topics
Companies
Hint
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109 */

int[] twoSum(int[] nums, int target) {
        
    for (int i = 0; i < nums.length-1; i++){

        for (int j = i+1; j < nums.length; j++) {

            if(nums[i]+nums[j]==target){ return new int[]{i,j};}
            
        }
        
    }

    return new int[]{-1,-1};
    
}

/*  167. Two Sum II - Input Array Is Sorted

Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.

 

Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 

Constraints:

2 <= numbers.length <= 3 * 104
-1000 <= numbers[i] <= 1000
numbers is sorted in non-decreasing order.
-1000 <= target <= 1000
The tests are generated such that there is exactly one solution. */

public int[] twoSum2(int[] numbers, int target) {

    for (int i = 0; i < numbers.length-1; i++){

        for (int j = i+1; j < numbers.length && numbers[i]+numbers[j]<=target ; j++) {

            if(numbers[i]+numbers[j]==target){ return new int[]{i,j};}
            
        }
        
    }

    return new int[]{-1,-1}; 
}



/* 520. Detect Capital

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Given a string word, return true if the usage of capitals in it is right.

 

Example 1:

Input: word = "USA"
Output: true
Example 2:

Input: word = "FlaG"
Output: false
 

Constraints:

1 <= word.length <= 100
word consists of lowercase and uppercase English letters.*/


public boolean detectCapitalUse(String word) {

    int count=0;
    
    for (int i = 0; i < word.length(); i++) {
        if(word.charAt(i)>=65 && word.charAt(i)<=90){
            count++;}
    }

    if(count==word.length() || count==0){return true;}

    if(word.charAt(0)>=65 && word.charAt(0)<=95 && count==1){return true;}

    return false;
    
}


/* Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal 
substring
 consisting of non-space characters only.

 

Example 1:

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.
Example 2:

Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.
Example 3:

Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.
 

Constraints:

1 <= s.length <= 104
s consists of only English letters and spaces ' '.
There will be at least one word in s */

public int lengthOfLastWord(String s) {

    int i = s.length()-1;
    int count=0;
  while(s.charAt(i)==32){ i--;}

  
  for (int j = i; j>=0&&s.charAt(j)!=32; j--) {
    count++;
  }
   
  
return count;
        
}

/* 66. Plus One
Easy
Topics
Companies
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

 

Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].
Example 3:

Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].*/

public int[] plusOne(int[] digits) {


   for (int i = digits.length-1; i >= 0; i--) {
    if(digits[i]<9){
        digits[i]++;
        return digits;
    }
    digits[i]=0;
   }
    digits=new int[digits.length+1];
    digits[0]=1;
    for(int i=1;i<digits.length;i++){
        digits[i]=0;
    }
    
    return digits;
    
}

/* 414. Third Maximum Number

Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.

 

Example 1:

Input: nums = [3,2,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2.
The third distinct maximum is 1.
Example 2:

Input: nums = [1,2]
Output: 2
Explanation:
The first distinct maximum is 2.
The second distinct maximum is 1.
The third distinct maximum does not exist, so the maximum (2) is returned instead.
Example 3:

Input: nums = [2,2,3,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2 (both 2's are counted together since they have the same value).
The third distinct maximum is 1.
 

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1 */


     int thirdMax(int[] nums) {

        if(nums.length==1){return nums[0];}

        else if(nums.length==2){
          return  nums[0]>=nums[1] ? nums[0] : nums[1]; 
        }

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){

            if(nums[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } 
            else if(max1>nums[i] && nums[i]>max2) {
                max3 = max2;
                max2 = nums[i];
            }
             else if(max2>nums[i] && nums[i]>max3) {
                max3=nums[i];
            }
        }
        
        return max3 != Long.MIN_VALUE ?  max3 :  max1;
        
    }

  


/*  2000. Reverse Prefix of Word

Given a 0-indexed string word and a character ch, reverse the segment of word that starts at index 0 and ends at the index of the first occurrence of ch (inclusive). If the character ch does not exist in word, do nothing.

For example, if word = "abcdefd" and ch = "d", then you should reverse the segment that starts at 0 and ends at 3 (inclusive). The resulting string will be "dcbaefd".
Return the resulting string.


Example 1:

Input: word = "abcdefd", ch = "d"
Output: "dcbaefd"
Explanation: The first occurrence of "d" is at index 3. 
Reverse the part of word from 0 to 3 (inclusive), the resulting string is "dcbaefd".
Example 2:

Input: word = "xyxzxe", ch = "z"
Output: "zxyxxe"
Explanation: The first and only occurrence of "z" is at index 3.
Reverse the part of word from 0 to 3 (inclusive), the resulting string is "zxyxxe".
Example 3:

Input: word = "abcd", ch = "z"
Output: "abcd"
Explanation: "z" does not exist in word.
You should not do any reverse operation, the resulting string is "abcd".
 

Constraints:

1 <= word.length <= 250
word consists of lowercase English letters.
ch is a lowercase English letter. */

String reversePrefix(String word, char ch) {

    String result = "";

   for(int i=0;i<word.length();i++){

    if(ch==word.charAt(i)){

        for (int j = i; j>=0; j--) {

            result +=word.charAt(j);
                      
        }

        for (int j = i+1; j < word.length(); j++) {
            result += word.charAt(j);
            
        }
        return result;
    }
   }

   return word;
        
}

/* 136. Single Number
Easy
Topics
Companies
Hint
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

 

Example 1:

Input: nums = [2,2,1]
Output: 1
Example 2:

Input: nums = [4,1,2,1,2]
Output: 4
Example 3:

Input: nums = [1]
Output: 1
 

Constraints:

1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
Each element in the array appears twice except for one element which appears only once. */

 int singleNumber(int[] nums) {

    int count=0;

    for (int i = 0; i < nums.length; i++) {
        for (int j = 0; j < nums.length; j++) {
            if(nums[i]==nums[j]){
                count++;
            }
        }
        if(count<2){
            return nums[i];
        }
        count=0;
    }
    return 0;
        
}

/*  389. Find the Difference

You are given two strings s and t.

String t is generated by random shuffling string s and then add one more letter at a random position.

Return the letter that was added to t.

 

Example 1:

Input: s = "abcd", t = "abcde"
Output: "e"
Explanation: 'e' is the letter that was added.
Example 2:

Input: s = "", t = "y"
Output: "y"
 

Constraints:

0 <= s.length <= 1000
t.length == s.length + 1
s and t consist of lowercase English letters. */

char findTheDifference(String s, String t) {

    int s1=0, s2=0, i;

    for (i = 0; i < s.length(); i++) {

        s1+=s.charAt(i);
        s2+=t.charAt(i);
        
    }
    
     s2+=t.charAt(i);

     return (char)(s2-s1);  
}

/*  3146. Permutation Difference between Two Strings

You are given two strings s and t such that every character occurs at most once in s and t is a permutation of s.

The permutation difference between s and t is defined as the sum of the absolute difference between the index of the occurrence of each character in s and the index of the occurrence of the same character in t.

Return the permutation difference between s and t.

 

Example 1:

Input: s = "abc", t = "bac"

Output: 2

Explanation:

For s = "abc" and t = "bac", the permutation difference of s and t is equal to the sum of:

The absolute difference between the index of the occurrence of "a" in s and the index of the occurrence of "a" in t.
The absolute difference between the index of the occurrence of "b" in s and the index of the occurrence of "b" in t.
The absolute difference between the index of the occurrence of "c" in s and the index of the occurrence of "c" in t.
That is, the permutation difference between s and t is equal to |0 - 1| + |2 - 2| + |1 - 0| = 2.

Example 2:

Input: s = "abcde", t = "edbac"

Output: 12

Explanation: The permutation difference between s and t is equal to |0 - 3| + |1 - 2| + |2 - 4| + |3 - 1| + |4 - 0| = 12.

 

Constraints:

1 <= s.length <= 26
Each character occurs at most once in s.
t is a permutation of s.
s consists only of lowercase English letters. */

int findPermutationDifference(String s, String t) {

    int sum=0;

    for (int i = 0; i < s.length(); i++) {

        for(int j=0;j<t.length();j++){

             if (s.charAt(i)==t.charAt(j)){
                sum+=Math.abs(i-j);
                break;           
        }
    }      
}
return sum;
        
}

/*  415. Add Strings

Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.

You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.

 

Example 1:

Input: num1 = "11", num2 = "123"
Output: "134"
Example 2:

Input: num1 = "456", num2 = "77"
Output: "533"
Example 3:

Input: num1 = "0", num2 = "0"
Output: "0"
 

Constraints:

1 <= num1.length, num2.length <= 104
num1 and num2 consist of only digits.
num1 and num2 don't have any leading zeros except for the zero itself. */

// String addStrings(String num1, String num2) {
    
//     int min,max;

//     if(num1.length()>=num2.length()){
//         max=num1.length();
//         min=num2.length();
//     }else{
//         min=num1.length();
//         max=num2.length();
//     }

//     int r=0;

//     String sum="";

//     for(int i=min-1;i>=0;i--){

//         sum += (((num1.charAt(i)-48) + (num2.charAt(i)-48)) % 10) + r;
//         r=((num1.charAt(i)-48) + (num2.charAt(i)-48))/10;

//     }

// }

    /* 412. Fizz Buzz
Easy
Topics
Companies
Given an integer n, return a string array answer (1-indexed) where:

answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
answer[i] == "Fizz" if i is divisible by 3.
answer[i] == "Buzz" if i is divisible by 5.
answer[i] == i (as a string) if none of the above conditions are true.
 

Example 1:

Input: n = 3
Output: ["1","2","Fizz"]
Example 2:

Input: n = 5
Output: ["1","2","Fizz","4","Buzz"]
Example 3:

Input: n = 15
Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 

Constraints:

1 <= n <= 104 */

List<String> fizzBuzz(int n) {

    List<String> result = new ArrayList<>();

    for (int i = 1; i <= n; i++) {

        if(i%3==0 && i%5==0){
            result.add("FizzBuzz");
        }else if(i%3==0){
            result.add("Fizz");
        }else if(i%5==0){
            result.add("Buzz");
        }else{
            result.add(Integer.toString(i));
        }
    }

    return result;           
}

/* 2643. Row With Maximum Ones
Easy
Topics
Companies
Hint
Given a m x n binary matrix mat, find the 0-indexed position of the row that contains the maximum count of ones, and the number of ones in that row.

In case there are multiple rows that have the maximum count of ones, the row with the smallest row number should be selected.

Return an array containing the index of the row, and the number of ones in it.

 

Example 1:

Input: mat = [[0,1],[1,0]]
Output: [0,1]
Explanation: Both rows have the same number of 1's. So we return the index of the smaller row, 0, and the maximum count of ones (1). So, the answer is [0,1]. 
Example 2:

Input: mat = [[0,0,0],[0,1,1]]
Output: [1,2]
Explanation: The row indexed 1 has the maximum count of ones (2). So we return its index, 1, and the count. So, the answer is [1,2].
Example 3:

Input: mat = [[0,0],[1,1],[0,0]]
Output: [1,2]
Explanation: The row indexed 1 has the maximum count of ones (2). So the answer is [1,2].
 

Constraints:

m == mat.length 
n == mat[i].length 
1 <= m, n <= 100 
mat[i][j] is either 0 or 1. */

int[] rowAndMaximumOnes(int[][] mat) {

    int max=countOnes(mat[0]);
    int ones;
    int index=0;

        for (int i = 1; i < mat.length; i++) {  
            ones = countOnes(mat[i]);        
            if(ones>max){
                max=ones;
                index=i;
            }
        }

        return new int[]{index,max};
}

private int countOnes(int []arr){
    int count=0;
    
    for (int i = 0; i < arr.length; i++) {
        if (arr[i]==1) {count++;}
    }
    return count;
}

/* 2614. Prime In Diagonal
Easy
Topics
Companies
Hint
You are given a 0-indexed two-dimensional integer array nums.

Return the largest prime number that lies on at least one of the diagonals of nums. In case, no prime is present on any of the diagonals, return 0.

Note that:

An integer is prime if it is greater than 1 and has no positive integer divisors other than 1 and itself.
An integer val is on one of the diagonals of nums if there exists an integer i for which nums[i][i] = val or an i for which nums[i][nums.length - i - 1] = val.


In the above diagram, one diagonal is [1,5,9] and another diagonal is [3,5,7].

 

Example 1:

Input: nums = [[1,2,3],[5,6,7],[9,10,11]]
Output: 11
Explanation: The numbers 1, 3, 6, 9, and 11 are the only numbers present on at least one of the diagonals. Since 11 is the largest prime, we return 11.
Example 2:

Input: nums = [[1,2,3],[5,17,7],[9,11,10]]
Output: 17
Explanation: The numbers 1, 3, 9, 10, and 17 are all present on at least one of the diagonals. 17 is the largest prime, so we return 17.
 

Constraints:

1 <= nums.length <= 300
nums.length == numsi.length
1 <= nums[i][j] <= 4*106 */

public int diagonalPrime(int[][] nums) {

    int size = nums.length%2==0 ? nums.length/2 : (nums.length/2)+1;

    int max = Integer.MIN_VALUE;
    int i;
    for(i=0;i<size;i++){
        for(int j=0;j<nums.length;j++){

            if(i==j || j==(nums.length-1-i)){
                max = isPrime(nums[i][j]) && nums[i][j] > max ? nums[i][j] : max;
            }
            
        }
    }

   

        for(int i1=i;i1<nums.length;i++){
            for(int j=0;j<nums.length;j++){

                 if(i1==j || j==(nums.length-1-i1)){
                    max = isPrime(nums[i1][j]) && nums[i1][j] > max ? nums[i1][j] : max;
                 }
                     
        }
    }

    return max;
}

private boolean isPrime(int num){

    for(int i=2;i<num;i++){
        if(num%i==0){
         return false;
        }
    }
    return true;
    
}


}


