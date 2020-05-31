class Solution(object):
    
    
    def countBits(self, num):
        """
        :type num: int
        :rtype: List[int]
        """
        #count = [0]*num+1
        count = [0 for x in range(num+1)]
        count = self.binary(count,num)
        return count
    
    def binary(self,count,num):
        if num==0:
            return count
        count = self.binary(count,num-1)
        rem = num%2
        count[num] = rem + count[num//2]
        return count
        
        
