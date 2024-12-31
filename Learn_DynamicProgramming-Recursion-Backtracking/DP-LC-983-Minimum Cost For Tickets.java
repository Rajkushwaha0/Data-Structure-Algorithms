//Asked in google
//recur -> 3^O(N)
//memo -> O(N)
//O(N)+O(N)
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        // int[] dp = new int[n+1];
        // Arrays.fill(dp,-1);
        // return recur(days,costs,0,n,dp);
        if(n==0) return 0;
        if(n==1) return costs[0];
        Set<Integer> s = new HashSet<>();
        int lastDay=-1;
        for(int i :days){
            s.add(i);
            lastDay=Math.max(lastDay,i);
        }
        return bottom(costs,s,lastDay);
    }
    public int recur(int[] days,int[] costs,int i,int n,int[] dp){
        if(i>=n){
            return 0;
        }
        if(dp[i]!=-1) return dp[i];
        int oneDay = costs[0] + recur(days,costs,i+1,n,dp);

        int j=i;
        int maxDay = days[i]+7;
        while(j<n && days[j]<maxDay){
                j++;
        }
        int sevenDay = costs[1] + recur(days,costs,j,n,dp);
        j=i;
        maxDay = days[i]+30;
        while(j<n && days[j]<maxDay){
            j++;
        }
        int thirtyDay = costs[2] + recur(days,costs,j,n,dp);

        return dp[i]=Math.min(oneDay,Math.min(sevenDay,thirtyDay));
    }
    public int bottom(int[] costs,Set<Integer> s,int lastDay){
        int[] dp = new int[lastDay+1];
        for(int i=1;i<=lastDay;i++){
            if(!s.contains(i)){
                dp[i]=dp[i-1];
                continue;
            }
            int oneDay = costs[0]+dp[Math.max(i-1,0)];
            int sevenDay =costs[1]+dp[Math.max(i-7,0)];
            int thirtyDay = costs[2]+dp[Math.max(i-30,0)];
            dp[i]=Math.min(oneDay,Math.min(sevenDay,thirtyDay));
        }
        return dp[lastDay];
    }
}
