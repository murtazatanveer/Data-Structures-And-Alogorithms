package Recursion;

import java.util.ArrayList;
import java.util.List;

public class BackTracking {
    
    // Leetcode Problem No 17 : Letter Combinations of a Phone Number
    List<String> com = new ArrayList<>();
    public List<String> letterCombinations(String digits) {

        if(digits==null || digits.isEmpty()) return com;
        combinations(digits, 0, "");
        return com;
    }

    private void combinations(String digit , int index , String combination){

            if (index==digit.length()) {com.add(combination); return;}
                
            switch (digit.charAt(index)) {

                case '2':
                combinations(digit, index+1, combination+"a");
                combinations(digit, index+1, combination+"b");
                combinations(digit, index+1, combination+"c");
                break;
                
                case '3':
                combinations(digit, index+1, combination+"d");
                combinations(digit, index+1, combination+"e");
                combinations(digit, index+1, combination+"f");
                break;

                case '4':
                combinations(digit, index+1, combination+"g");
                combinations(digit, index+1, combination+"h");
                combinations(digit, index+1, combination+"i");
                break;

                case '5':
                combinations(digit, index+1, combination+"j");
                combinations(digit, index+1, combination+"k");
                combinations(digit, index+1, combination+"l");
                break;

                case '6':
                combinations(digit, index+1, combination+"m");
                combinations(digit, index+1, combination+"n");
                combinations(digit, index+1, combination+"o");
                break;

                case '7':
                combinations(digit, index+1, combination+"p");
                combinations(digit, index+1, combination+"q");
                combinations(digit, index+1, combination+"r");
                combinations(digit, index+1, combination+"s");
                break;

                case '8':
                combinations(digit, index+1, combination+"t");
                combinations(digit, index+1, combination+"u");
                combinations(digit, index+1, combination+"v");
                break;

                default:
                combinations(digit, index+1, combination+"w");
                combinations(digit, index+1, combination+"x");
                combinations(digit, index+1, combination+"y");
                combinations(digit, index+1, combination+"z");
                break;
            }
            
    }

    // Leetcode Problem No 77 : Combinations
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

        addCombinations(new ArrayList<>(), 1, n, k);
        return lists;
    }

    private void addCombinations(List<Integer> comb , int index , int n , int k){
 
        if (comb.size()==k) {
            lists.add(new ArrayList<>(comb));
            return;
        }

        for (;index <= n; index++) {
            comb.add(index);
            addCombinations(comb,index+1, n, k);
            comb.remove(comb.size()-1);
        }

    }

}
