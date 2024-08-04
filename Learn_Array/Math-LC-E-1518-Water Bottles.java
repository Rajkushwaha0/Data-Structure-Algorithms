class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans= numBottles;
        while(numBottles>=numExchange){
            int m = numBottles/numExchange;
            int n = numBottles%numExchange;
            ans+=m;
            numBottles = m+n;
        }
        return ans;
    }
}
