class Solution {
    HashMap<String,Boolean> mp = new HashMap<String,Boolean>();
    public boolean isScramble(String s1, String s2) {
        // if(s1.length()==0 && s2.length()==0)
        // {
        //     return true;
        // }
        // if(s1.length()!=s2.length())
        // {
        //     return false;
        // }
        if(s1.equals(s2))
        {
            return true;
        }
        if(s1.length()<=1)
        {
            return false;
        }
        String key = s1 + " "+s2;
        if(mp.containsKey(key))
        {
            return mp.get(key);
        }
        int n=s1.length();
        Boolean flag = false;
        for(int i=0;i<n-1;i++)
        {
            boolean first = (isScramble(s1.substring(0,i),s2.substring(n-i,n))) && (isScramble(s1.substring(i,n),s2.substring(0,n-i)));
            boolean sec = (isScramble(s1.substring(0,i),s2.substring(0,i))) && (isScramble(s1.substring(i,n),s2.substring(i,n)));
            if(first || sec)
            {
                flag = true;
                break;
            }
        }
        mp.put(key,flag);
        return flag;
    }
}
//code doesnt work , but get the idea
