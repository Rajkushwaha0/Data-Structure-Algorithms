class Solution
{
	boolean isSumTree(Node root)
	{
             // Your code here
             boolean ans=true;
            return solve(root).getKey();
            
            
	}
	Pair<Boolean,Integer> solve(Node root){
	    if(root==null){
            Pair<Boolean,Integer> p = new Pair<Boolean,Integer>(true,0);
            return p;
        }


        Pair<Boolean,Integer> left = solve(root.left);
        Pair<Boolean,Integer> right = solve(root.right);

        Boolean leftans = left.getKey();
        Boolean rightans=right.getKey();
        Boolean check = left.getValue()+right.getValue()==root.data;
        int sum = left.getValue()+right.getValue()+root.data;

        // if(leftans && rightans && check){
        //     Pair<Boolean,Integer> ans = new Pair<>(true,left.getValue()+right.getValue()+root.data);
        //     return ans;
        // }
        // Pair<Boolean,Integer> ans = new Pair<>(false,left.getValue()+right.getValue()+root.data);
        // return falseans;
        Pair<Boolean,Integer> ans = new Pair<>(check,sum);
        return ans;
	    
	}
}
