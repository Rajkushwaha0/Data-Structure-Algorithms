//Even Better
// TC O(C(n, k) · k)
//SC O(k + C(n, k) · k) IF EXCLUDING OUTPUT O(k)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if(n<k) return ans;

        int i = 1;
        solve(i,n,k,new ArrayList<>(),ans);
        return ans;
    }

    public void solve(int start, int n, int k, List<Integer> temp,List<List<Integer>> ans){
        int listSize = temp.size();
        if(listSize==k){
            ans.add(new ArrayList<>(temp));
            return ;
        }

        for (int i = start; i <= n - (k - listSize) + 1; i++) {
            temp.add(i);
            solve(i + 1, n, k, temp, ans);
            temp.remove(temp.size() - 1);
        }
        return ;
    }
}

// TC ~O(C(n, k) · k)
//SC O(k + C(n, k) · k) IF EXCLUDING OUTPUT O(k)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if(n<k) return ans;

        int i = 1;
        solve(i,n,k,new ArrayList<>(),ans);
        return ans;
    }

    public void solve(int i, int n, int k, List<Integer> temp,List<List<Integer>> ans){
        int listSize = temp.size();
        if(listSize==k){
            ans.add(new ArrayList<>(temp));
            return ;
        }

        //optimization
        if (n - i + 1 < k - listSize) {
            return;
        }
        //i used
        //if(i>n){
        //  return ;
        //}

        temp.add(i);
        solve(i+1,n,k,temp,ans);
        temp.remove(temp.size()-1);
        solve(i+1,n,k,temp,ans);

        return ;
    }
}
