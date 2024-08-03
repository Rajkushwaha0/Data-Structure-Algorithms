class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode curr=head;
        ListNode prev=null;
        ListNode forw=null;
        int count=0;
        int maxima=-1;
        int minima=1000000;
        int[] res = new int[2];
        ArrayList<Integer> l = new ArrayList<>(); 
        while(curr.next!=null){
            count+=1;
            forw = curr.next;
            if(prev!=null && forw!=null){
                if(prev.val<curr.val && forw.val<curr.val){
                    if(l.size()>0) minima = Math.min(minima,Math.abs(count-l.get(l.size()-1)));
                    l.add(count);
                }
                else if(prev.val>curr.val && forw.val>curr.val){
                    if(l.size()>0) minima = Math.min(minima,Math.abs(count-l.get(l.size()-1)));
                    l.add(count);
                }
            }
            prev=curr;
            curr=curr.next;
           
        }
        if(l.size()<2){
            Arrays.fill(res,-1);
            return res;
        }
        maxima = l.get(l.size()-1)-l.get(0);
        res[0]=minima;
        res[1]=maxima;
        return res;
    }
}
