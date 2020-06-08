class WordDictionary {
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
    Ctrie dummy;
    /** Initialize your data structure here. */
    public WordDictionary() {
        dummy =new Ctrie(' ',0);
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
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
        return;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchstr(dummy,word,0);
    }
    
    public boolean searchstr(Ctrie root, String word, int i)
    {
        
        int n = word.length();
        if(i>=n)
        {
            return false;
        }
        char cur = word.charAt(i);
        int pos = cur - 'a';
        if(cur!='.')
        {
            root = root.chartie[pos];
           
            if(root!=null)
            {
                
                if(root.eol==1 && i==n-1)
                {
                    return true;
                }
                return searchstr(root, word, i+1);
            }
            else{
                return false;
            }            
        }
        else{
            
            for(int j=0;j<26;j++)
            {
                boolean res = false;
                if(root.chartie[j]!=null)
                {
                    
                    if(root.chartie[j].eol==1 && i==n-1)
                    {
                        return true;
                    }
                    res = searchstr(root.chartie[j],word,i+1);
                    if(res==true)
                    {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
