class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1==null || s2==null || s1.length()>s2.length())
        {
            return false;
        }
        int char_count[] = new int[26];
        for(int i=0;i<s1.length();i++)
        {
            char_count[s1.charAt(i)-'a']++;
        }
        int left=0;
        int right = 0;
        int count = s1.length();
        while(right<s2.length())
        {
            if(char_count[s2.charAt(right)-'a']>=1)
            {
                count--;
            }
            char_count[s2.charAt(right)-'a']--;
            right++;
            if(count==0)
            {
                return true;
            }
            if(right-left==s1.length())
            {
                if(char_count[s2.charAt(left)-'a']>=0)
                {
                    count+=1;
                }                
                char_count[s2.charAt(left)-'a']+=1;
                left+=1;
            }
        }
        return false;
    }
}
