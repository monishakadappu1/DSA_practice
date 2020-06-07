class Trie {
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
    public Trie() {
        dummy = new Ctrie(' ',0);
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
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
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int n = word.length();
        Ctrie cur = dummy;
        for(int i=0;i<n;i++)
        {
            int pos = word.charAt(i)-'a';
            cur = cur.chartie[pos];
            if(i!=n-1)
            {
                if(cur==null)
                {
                    return false;
                }                                  
            }
            else{
               if(cur==null)
                {
                    return false;
                }                                  
                if(cur.eol!=1)
                {
                    return false;
                }  
            }
        }
        return true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        int n = prefix.length();
        Ctrie cur = dummy;
        for(int i=0;i<n;i++)
        {
            int pos = prefix.charAt(i)-'a';
            cur = cur.chartie[pos];
            if(cur==null)
            {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
