class Solution {
    public int[][] fourdir(int[][] image, int sr, int sc, int color,int newColor)
    {
        int rowlength = image.length;   //sr=1,sc=2
        int collength = image[0].length;   //rowlength =2,col = 3
        //System.out.println(rowlength);
        //System.out.println(collength);
        //System.out.println("/////////////////");
        if(sr>=rowlength || sc>=collength || sr<0 || sc<0)
        {
            return image;
        }
        if(image[sr][sc] == color) // image[1][0]=0
        {
           image[sr][sc]=newColor;
            image = fourdir(image,sr-1,sc,color,newColor);  //sr=0
            image = fourdir(image,sr+1,sc,color,newColor);    //sr=2
            image = fourdir(image,sr,sc-1,color,newColor);   //
            image = fourdir(image,sr,sc+1,color,newColor);
            return image;
        }
        else{
            return image;
        }
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc]; //1
        //System.out.println(color);
        //System.out.println(newColor);
        if(color == newColor)
        {
            return image;
        }
        image = fourdir(image,sr,sc,color,newColor);
        return image;
    }
}
