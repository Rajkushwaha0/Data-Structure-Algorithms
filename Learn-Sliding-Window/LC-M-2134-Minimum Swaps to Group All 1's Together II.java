O(2*n)  O(1)
class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length;
        int totalOne=0;
        for(int i=0;i<n;i++){
            if(i<n && nums[i]==1){
                totalOne++;
            }
        }
        
        int currOne=0;
        int ans = Integer.MAX_VALUE;
        ans = solve(nums,n,ans,totalOne);
        return ans;
    }
    public int solve(int[] nums,int n,int ans,int totalOne){
        int i=0;
        int currOne = 0;
        for(int j=0;j<2*n;j++){
            if(nums[j%n]==1) currOne++;
            if(j-i+1 > totalOne){
                currOne -= nums[i%n];
                i++;
            }
            if(j-i+1 == totalOne){
                ans = Math.min(ans,totalOne-currOne);
            }
        }
        return ans;
    }
}
//More optimized 👆👆👆

O(2*n) O(2*n)
class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length;
        int totalOne=0;
        ArrayList<Integer> l = new ArrayList<>();
        for(int i=0;i<2*n;i++){
            if(i<n && nums[i]==1){
                totalOne++;
            }
            l.add(nums[i%n]);
        }
        
        int currOne=0;
        int ans = Integer.MAX_VALUE;
        ans = solve(l,2*n,ans,totalOne);
        return ans;
    }
    public int solve(ArrayList<Integer> l,int n,int ans,int totalOne){
        int i=0;
        int currOne = 0;
        for(int j=0;j<n;j++){
            if(l.get(j)==1) currOne++;
            if(j-i+1 > totalOne){
                if(l.get(i)==1) currOne--;
                i++;
            }
            if(j-i+1 == totalOne){
                ans = Math.min(ans,totalOne-currOne);
            }
        }
        return ans;
    }
}
