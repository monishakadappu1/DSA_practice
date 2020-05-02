class Solution {
    public int[] sortArrayByParity(int[] A) {
        int n = A.length;
        int arr[]=new int[n];
        int start=0;
        int end = n-1;
        for(int i=0;i<n;i++)
        {
            if(A[i]%2==0)
            {
                arr[start] = A[i];
                start++;
            }
            else{
                arr[end]=A[i];
                end--;
            }
        }
        return arr;
        
    }
}
