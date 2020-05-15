// { Driver Code Starts
//Initial Template for Java


//Contributed by Sudarshan Sharma
import java.util.*;
import java.io.*;
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}


class GfG{
    
    public static void main(String[] args)throws IOException{
        //Scanner sc=new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t=Integer.parseInt(br.readLine());
       
        while(t > 0)
           {
               Queue<Node> q = new LinkedList<>();
        
            int n = Integer.parseInt(br.readLine());
            String input[] = br.readLine().trim().split(" ");
            
            Node root = null;
            int j=0;
            while(n > 0){
            int a1 = Integer.parseInt(input[j]);
            int a2 = Integer.parseInt(input[j+1]);
            char lr = input[j+2].charAt(0);
            j+=3;
            
            if(root == null)
            {
                root = new Node(a1);
                q.add(root);
            }
            
            Node pick = q.peek();
            
            q.remove();
            
            if(lr=='L'){
                pick.left = new Node(a2);
                q.add(pick.left);
            }
            a1 = Integer.parseInt(input[j]);
            a2 = Integer.parseInt(input[j+1]);
            lr = input[j+2].charAt(0);
            j += 3;
            
            if(lr=='R'){
                pick.right = new Node(a2);
                q.add(pick.right);
            }
            
            n-=2;
        }
            new View().topView(root);
            System.out.println();
            t--;
        }
    }
}

   


// } Driver Code Ends


//User function Template for Java



/*class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/

class View
{
    static class pair{
        int first;
        int second;
        pair(){}
        pair(int i,int j){
            first = i;
            second = j;
        }
    }
    static HashMap<Integer,pair> m;
    
    static void fillMap(Node root,int level,int dist)
    {
        if(root==null)
        {
            return;
        }
        if(m.get(dist)==null)
        {
            m.put(dist,new pair(root.data,level));
        }
        else if(m.get(dist).second>level)
        {
            m.put(dist,new pair(root.data,level));
        }
        fillMap(root.left,level+1,dist-1);
        fillMap(root.right,level+1,dist+1);
        
    }
    // function should print the topView of the binary tree
    static void topView(Node root)
    {
        //countrt=new HashMap<Integer,Integer>();
        m=new HashMap<>();
        fillMap(root,0,0);
        // for(Map.Entry<Integer,pair> entry:m.entrySet())
        // {
        //     System.out.print(entry.getValue().first + " "); 
        // }
        int minrt = Collections.min(m.keySet());
        int maxrt = Collections.max(m.keySet());
        int i=minrt;
        while(i<=maxrt)
        {
            System.out.print(m.get(i).first + " ");
            i++;
        }
    }
    
    
}
