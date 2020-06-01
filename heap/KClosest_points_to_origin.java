class Solution {
    public class Points{
        int first;
        int second;
        int dist;
        public Points(int a,int b)
        {
            first = a;
            second = b;
            dist = first*first + second*second;
        }
    }
    
    public class Dist_comp implements Comparator<Points>
    {
        @Override
        public int compare(Points f,Points s)
        {
            return (s.dist - f.dist);
        }
    }
    
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Points> qp = new PriorityQueue<Points>(K,new Dist_comp());
        int[][] res = new int[K][2];
        for(int i=0;i<points.length;i++)
        {
            if(i<K)
            {
                qp.add(new Points(points[i][0],points[i][1]));
                
            }
            else{
                Points pdist = new Points(points[i][0],points[i][1]);
                Points temp = qp.peek();
                if(temp.dist>pdist.dist)
                {
                    qp.poll();
                    qp.add(pdist);
                }
            }
        }
        for(int i=0;i<K;i++)
        {
            
            Points temp = qp.poll();
            res[i][0] = temp.first;
            res[i][1] = temp.second;
            
        }
        return res;
    }
}
