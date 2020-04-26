    static void miniMaxSum(int[] arr) {
        long minsum = 0;
        long maxsum = 0;
        int size = arr.length;
        Arrays.sort(arr);
        for(int i=0;i<size-1;i++)
        {
            minsum = minsum + arr[i];
        }
        for(int i=1;i<size;i++)
        {
            maxsum = maxsum + arr[i];
        }
        System.out.println(minsum + " " + maxsum);

    }
