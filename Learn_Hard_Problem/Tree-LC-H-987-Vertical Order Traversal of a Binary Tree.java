class Tuple{
    TreeNode node;
    int row;
    int col;

    public Tuple(TreeNode node, int row , int col){
        this.node= node;
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Tuple> que = new LinkedList<>();
        TreeMap<Integer,ArrayList<Integer>> map = new TreeMap<>();

        que.offer(new Tuple(root,0,0));

        while(!que.isEmpty()){
            Tuple tuple= que.poll();
            TreeNode node =tuple.node;
            int vertical=tuple.row;
            int level =tuple.col;

            if(!map.containsKey(vertical)){
                map.put(vertical , new ArrayList<Integer>());
            }
            // if(!map.get(vertical).containsKey(level)){
            //     map.get(vertical).put(level , new PriorityQueue<>());
            // }
            map.get(vertical).add(node.val);

            if(node.left!=null){
                que.offer(new Tuple(node.left,vertical-1,level+1));

            }
            if(node.right!=null){
                que.offer(new Tuple(node.right,vertical+1,level+1));

            }
        }
        List<List<Integer>> list = new ArrayList<>();

        for(ArrayList<Integer> ys : map.values()){
            List<Integer> bharo = new ArrayList<>();
          
                // while(!ys.isEmpty()){
                // bharo.add(ys.poll());
                // }
                for(int h : ys){
                    bharo.add(h);
                }
            list.add(bharo);

        } 
        return list;
        
    }
}
