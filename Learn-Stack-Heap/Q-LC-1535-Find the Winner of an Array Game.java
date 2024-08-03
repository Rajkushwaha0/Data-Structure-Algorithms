class Solution {
    public int getWinner(int[] arr, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int ans = 0;
        if (k == 1) {
            return Math.max(arr[0], arr[1]);
        }
        Deque<Integer> q = new LinkedList<>();
        for(int i:arr){
            q.add(i);
            ans=Math.max(i,ans);
        }
        if(k>=arr.length) return ans;
        while(true){
            int a = q.poll();
            int b = q.poll();
            if(a>=b){
                hm.put(a,hm.getOrDefault(a,0)+1);
                if(hm.get(a)==k) {
                    ans=a;
                    break;
                }
                q.addFirst(a);
                q.addLast(b);
            }
            else{
                hm.put(b,hm.getOrDefault(b,0)+1);
                if(hm.get(b)==k) {
                    ans=b;
                    break;
                }
                q.addFirst(b);
                q.addLast(a);
            }

        }
        return ans;
    }
}
