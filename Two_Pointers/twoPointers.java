package Two_Pointers;

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
    

}
