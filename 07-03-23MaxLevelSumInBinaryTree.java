//Max Level Sum in Binary Tree

class Solution {
    public static int height(Node root)
    {
        if(root == null)
        return 0;
        int l = height(root.left) + 1;
        int r = height(root.right) + 1;
        return Math.max(l,r);
    }
    public static void calc(Node root, int[] sum, int level)
    {
        if(root == null)
        return;
        sum[level] += root.data;
        calc(root.right, sum, level + 1);
        calc(root.left, sum, level + 1);
    }
    public int maxLevelSum(Node root) {
        // add code here.
        int h = height(root);
        int[] sum = new int[h];
        //Arrays.fill(sum, Integer.MIN_VALUE);
        calc(root, sum, 0);
        int ans =  Integer.MIN_VALUE;
        for(int ele: sum)
        {
            //System.out.println(ele);
            if (ans < ele)
            ans = ele;
        }
        return ans;
    }
    
}
