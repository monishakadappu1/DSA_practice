class Solution:
    def intervalIntersection(self, A: List[List[int]], B: List[List[int]]) -> List[List[int]]:
        result = []
        if len(A)==0 or len(B)==0:
            return []    
        i=0
        j=0
        while(i<len(A) and j<len(B)):
            if A[i][0]>B[j][1]:
                j+=1
                continue
            elif(B[j][0]>A[i][1]):
                i+=1
                continue
            subres = []
            subres.append(max(A[i][0],B[j][0]))
            subres.append(min(A[i][1],B[j][1]))
            result.append(subres)
            if i+1<len(A):
                overlap = []
                if A[i+1][0]==B[j][1]:
                    overlap.append(A[i+1][0])
                    overlap.append(B[j][1])
                    result.append(overlap)
            if j+1<len(B):
                overlap = []
                if A[i][1]==B[j+1][0]:
                    overlap.append(A[i][1])
                    overlap.append(B[j+1][0])
                    result.append(overlap)
            if i+1<len(A) and (B[j][1]>A[i+1][0]):
                i+=1
            elif j+1<len(B) and (A[i][1]>B[j+1][0]):
                j+=1
            else:                    
                i+=1
                j+=1
        return result
