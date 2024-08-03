class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<String> names = new ArrayList<>();
        for(int i=0;i<orders.size();i++){
            String n = orders.get(i).get(2);
            if(!names.contains(n)) names.add(n);
        } 
        Collections.sort(names);
        names.add(0,"Table");
        List<List<String>> ans = new ArrayList<>();
        TreeMap<Integer,HashMap<String,Integer>> hm = new TreeMap<>();
        HashMap<String,Integer> temp = new HashMap<>();
        for(int i=0;i<orders.size();i++){
            String table = orders.get(i).get(1);
            int tableint = Integer.parseInt(table);
            String dish = orders.get(i).get(2);
            if(hm.containsKey(tableint)){
                temp = hm.get(tableint);
                temp.put(dish,temp.getOrDefault(dish,0)+1);
                hm.put(tableint,temp);
            }
            else{
                hm.put(tableint,new HashMap<>());
                temp = hm.get(tableint);
                temp.put(dish,1);
                hm.put(tableint,temp);
            }
        }
        ans.add(names);
        for(int m : hm.keySet()){
            List<String> fill = new ArrayList<>();
            fill.add(m+"");
            for(int i=1;i<names.size();i++){
                if(hm.get(m).containsKey(names.get(i))){
                    fill.add(hm.get(m).get(names.get(i))+"");
                }
                else{
                    fill.add("0");
                }
            }
            ans.add(fill);
        }
        return ans;

        
    }
}
