class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

       List<List<Integer>> result = new ArrayList<>();
        solve(0,candidates,target,result,new ArrayList<>());
        return result;
    }
    void solve(int i,int candidates[],int target, List<List<Integer>> result,List<Integer> list){
        if(target==0){
        result.add(new ArrayList<>(list));
        return;
        }

        if(i==candidates.length|| target <0)
        return;

        list.add(candidates[i]);
        solve(i,candidates,target-candidates[i],result,list);

        list.remove(list.size()-1);
        solve(i+1,candidates,target,result,list);
    }
}