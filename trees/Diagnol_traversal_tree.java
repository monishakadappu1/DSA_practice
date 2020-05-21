Class Solution{
  HashMap<Integer,List<Ineteger>> dp = new Hashmap<>();
  
  public HashMap<Integer,List<Ineteger>> diagnoltraversal(TreeNode root)
  {
      if(root==null)
      {
          return dp;
      }
      dttraversal(root,0);
      return dp;      
  }
  
  public void dttraversal(TreeNode root, int verdist)
  { 
      if(root==null)
      {
          return;
      }
      
      List<Integer> k = dp.get(d);
      if(k==null)
      {
        k = new Arraylist<integer>();
        k.add(root.val);
      }
      else{
        k.add(root.val);
      }
      dp.put(d,k);
      dttraversal(root.left,d+1);
      dttraversal(root.right,d);     
  
  }
}

          0   8
            /    \
      1    3      10
         /      /   \
      2 1      6      14
              / \    /
            4    7  13         

