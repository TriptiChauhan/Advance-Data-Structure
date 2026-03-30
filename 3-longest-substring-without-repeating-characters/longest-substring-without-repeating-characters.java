class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set=new HashSet<>();
        int left=0,right=0,max=0;

        while(right<s.length()){
            char ch=s.charAt(right);
            if(set.add(ch)){ // agar set me nhi h to add kr do
                max=Math.max(max,right-left+1);
                right++;
            }else{
                set.remove(s.charAt(left));  // agar set mealready h to remove kr do left wala
                left++;
            }
        }
        return max;
    }
}