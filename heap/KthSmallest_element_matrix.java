class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k,Collections.reverseOrder());
        int count = 0;
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix.length;j++)
            {
                if(count<k)
                {
                    pq.add(matrix[i][j]);
                }
                else{
                    int temp = pq.peek();
                    if(temp>matrix[i][j])
                    {
                        pq.poll();
                        pq.add(matrix[i][j]);
                    }
                }
                count++;
            }
        }
        return pq.peek();
    }
}
