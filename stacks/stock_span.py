class StockSpanner:

    def __init__(self):
        self.stack = []

    def next(self, price: int) -> int:
        ans = 1
        if len(self.stack)==0:
            cur = [price,ans]
            self.stack.append(cur)
        else:
            while(len(self.stack)!=0 and price>=self.stack[-1][0]):
                prev = self.stack.pop();
                ans = ans+ prev[1]                
                    
            self.stack.append([price,ans])
        return ans


# Your StockSpanner object will be instantiated and called as such:
# obj = StockSpanner()
# param_1 = obj.next(price)
