class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        if(n==0||n==1)
        {
            return 0;
        }
        int begin = 0;
        int end = n-1;
        int maxArea = 0;
        while(begin<end)
        {
            int area = Math.min(height[begin],height[end]) * (end-begin);
            maxArea = Math.max(maxArea,area);
            if(height[begin]>height[end])
            {
                end--;
            }
            else{
                begin++;
            }
        }
        return maxArea;
    }
}
