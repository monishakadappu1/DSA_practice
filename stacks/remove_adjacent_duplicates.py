class Solution:
    def removeDuplicates(self, S: str) -> str:
        if(len(S)==0 or len(S)==1) :
            return S
        res = []
        for sub in S:
            if len(res)==0:
                res.append(sub)
            else:
                top = res[-1]
                if top==sub:
                    res.pop()
                else:
                    res.append(sub)
        return ''.join(res)
                    
                    
