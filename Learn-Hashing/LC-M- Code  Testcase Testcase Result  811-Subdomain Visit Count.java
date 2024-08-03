class Solution {
    public List<String> subdomainVisits(String[] cp) {
        
        List<String> ans = new ArrayList<>();
        HashMap<String,Integer> hm = new HashMap<>();
        for(int i=0;i<cp.length;i++){
            String[] arr = cp[i].split(" ");
            int k = Integer.parseInt(arr[0]);
            String m = '.'+arr[1];
            String f ="";
            for(int j=m.length()-1;j>=0;j--){
                char ch = m.charAt(j);
                if(ch=='.'){
                    hm.put(f,hm.getOrDefault(f,0)+k);
                }
                f=ch+f;
            }
        }
        for(String s : hm.keySet()){
            String insert = hm.get(s)+" "+s;
            ans.add(insert);
        }   
        return ans;
    }
}
