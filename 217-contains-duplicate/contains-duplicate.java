class Solution {
    public boolean containsDuplicate(int[] nums) {

        // Brute force
        // Arrays.sort(nums);  //O(n log n)
        // for(int i=0;i<nums.length-1;i++){
        //     if(nums[i]==nums[i+1])
        //     return true;
        // }
        // return false;


        //optimized
        HashSet<Integer> set=new HashSet<>();  // O(n)
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i]))
            return true;

            set.add(nums[i]);
        }
        return false;
    }
}