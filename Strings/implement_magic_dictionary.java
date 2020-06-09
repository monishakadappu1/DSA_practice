class MagicDictionary {

    class Ctrie{
        char alpha;
        int eol;
        Ctrie[] chartie;
        
        public Ctrie(char val, int end)
        {
            alpha = val;
            eol = end;
            chartie = new Ctrie[26];
        }
    }
    /** Initialize your data structure here. */
    Ctrie dummy;
    public MagicDictionary() {
        dummy = new Ctrie(' ',0);
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(int j=0;j<dict.length;j++)
        {
            String word = dict[j];
            int n = word.length();
            Ctrie cur = dummy;
            for(int i=0;i<n;i++)
            {
                int pos = word.charAt(i)-'a';
                if(i!=n-1)
                {
                    if(cur.chartie[pos]==null)
                    {
                        cur.chartie[pos] = new Ctrie(word.charAt(i),0);
                    }

                    cur = cur.chartie[pos];
                }
                else{
                    if(cur.chartie[pos]!=null && cur.chartie[pos].eol!=1)
                    {
                        cur = cur.chartie[pos];
                        cur.eol=1;
                    }
                    else if(cur.chartie[pos]==null)
                    {
                        cur.chartie[pos] = new Ctrie(word.charAt(i),1);
                    }

                }
            }
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        int n=word.length();
        for(int i=0;i<n;i++)
        {
            char cur = word.charAt(i);
            for(char c='a';c<='z';c++)
            {
                if(c!=cur)
                {
                    String word2 = word.substring(0,i)+c+word.substring(i+1);
                    if(searchstr(word2)==true){return true;}
                }
            }          
           
        }
        return false;
    }
    
    public boolean searchstr(String word) {
        int n=word.length();
        Ctrie cur = dummy;
        for(int i=0;i<n;i++)
        {
            int pos = word.charAt(i)-'a';
            cur  = cur.chartie[pos];
            if(cur!=null)
            {
                if(i==n-1 && cur.eol==1)
                {
                    return true;
                }
            }
            else{
                return false;
            }
        }
        return false;
    }
    
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
