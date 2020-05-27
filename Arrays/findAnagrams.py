class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        result =[]
        if(len(s)==0):
            return result
        char_count = [0]*26
        for char in p:
            indx = ord(char)-ord('a')           
            char_count[indx]+=1
        left = 0
        right=0
        count = int(len(p))             
        
        while(right<len(s)):   
            rindx = ord(s[right]) - ord('a')  
            #print(char_count)
            if(char_count[rindx]>=1):  
                count-=1;                 
            char_count[rindx]-=1
            right+=1;                    
            if(count==0):       
                result.append(left)   
            if(right-left == len(p)):
                if(char_count[ord(s[left])-ord('a')]>=0):  
                    count+=1
                char_count[ord(s[left])-ord('a')]+=1     
                left+=1            
                                
        return result
    
#s: "abab" p: "ab"
        
