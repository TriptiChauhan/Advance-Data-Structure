class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();  // space complixity = O(n)

        for(int i=0;i<nums.length;i++){ // Time complexity = O(n)
            int remaining=target-nums[i];

            //agar remaining element present h map me to whi index return kro
            if(map.containsKey(remaining)){
                return new int[]{map.get(remaining),i};
            }

            // map me store kro value with index
            map.put(nums[i],i);
        }

        return new int[]{};
    }
}