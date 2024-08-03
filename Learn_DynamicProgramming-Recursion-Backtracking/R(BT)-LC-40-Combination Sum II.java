class Solution {
    public void solve(int i,int[] arr,int t , List<List<Integer>> ans, List<Integer> ds){
            if(i==arr.length){
                if(t==0){
                    if(!ans.contains(ds)){
                        ans.add(new ArrayList<>(ds));
                    }
                }
                return;
            }
            if(t>=arr[i]){
                ds.add(arr[i]);
                solve(i+1,arr,t-arr[i],ans,ds);
                ds.remove(ds.size()-1);
            }
            int j = i+1;
            while(j<arr.length && arr[j]==arr[j-1]){
                j+=1;
            }
            solve(j,arr,t,ans,ds);
    }
    public List<List<Integer>> combinationSum2(int[] c, int t) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        Arrays.sort(c);
        solve(0,c,t,ans,ds);
        return ans;
    }
}
