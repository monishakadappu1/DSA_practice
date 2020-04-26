static int flatlandSpaceStations(int n, int[] c) {
        int total = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            int mindiff = Integer.MAX_VALUE;
            for(int j=0;j<c.length;j++)
            {
                int diff = Math.abs(i-c[j]);
                mindiff = Math.min(mindiff,diff);
            }
            total = Math.max(total,mindiff);
        }
        return total;
    }
