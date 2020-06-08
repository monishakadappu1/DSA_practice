class ctrie:
    def __init__(self,char,end):
        self.char = char
        self.eol = end
        self.ctriearr = [None]*26

class Trie:    

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.dummy = ctrie(' ',0)
        

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        n = len(word)
        cur = self.dummy
        i=0
        for char in word:
            pos = ord(char) - ord('a')
            if i!=n-1:
                if cur.ctriearr[pos]==None:
                    cur.ctriearr[pos] = ctrie(char,0)
                    #print(cur.ctriearr[pos].char)
                cur = cur.ctriearr[pos]
                i+=1
            else:
                if cur.ctriearr[pos]!=None:
                    if cur.ctriearr[pos].eol!=1:
                        cur.ctriearr[pos].eol=1
                elif cur.ctriearr[pos]==None:
                    cur.ctriearr[pos] = ctrie(char,1)
        return
                
            

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        # listw = list(word)
        # print(listw)
        n = len(word)
        cur = self.dummy
        i=0
        for char in word:
            pos = ord(char) - ord('a')
            cur = cur.ctriearr[pos]
            if i!=n-1:
                #print(cur.char)
                if cur==None:
                    return False
                i+=1
            else:
                if cur!=None:
                    if cur.eol==0:
                        return False     
                if cur==None:
                    return False
                    
        return True
                

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        n = len(prefix)
        cur = self.dummy
        i=0
        for char in prefix:
            pos = ord(char) - ord('a')
            cur = cur.ctriearr[pos]
            if cur==None:
                return False
        return True
            
        
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
