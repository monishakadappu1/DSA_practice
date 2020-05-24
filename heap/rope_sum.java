/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

public class Heap{
    int[] heaparr;
    int capacity;
    int count;
    public Heap(int[] arr)
    {
        heaparr = arr;
        capacity = heaparr.length;
        count = capacity-1;
    }

    public int findleftchild(int indx)
    {
        int lindex = 2*indx+1;
        return lindex;
        
    }

    public int findrightchild(int indx)
    {
        int rindex = 2*indx+2;
        return rindex;
    }

    public int findparent(int indx)
    {
    
        
        int pindx = (int)Math.ceil((indx-1)/2);
        return pindx;

    }

    public void percaptulate_up(int indx)
    {
        int child = indx;
        int parentindx = findparent(indx);
        if(parentindx>-1 && heaparr[child]<heaparr[parentindx])
        {
            int temp = heaparr[child];
            heaparr[child] = heaparr[parentindx];
            heaparr[parentindx] = temp;
            //System.out.println("parent indx now");
            //System.out.println(parentindx);
            percaptulate_up(parentindx);
        }
        
    }

    public void percaptulate_down(int indx)
    {
        int parent = indx;
        int lc = findleftchild(parent);
        int rc = findrightchild(parent);
        int largest = indx;
        if(lc<=count && heaparr[parent]>heaparr[lc])
        {
                largest = lc;
        }
        if(rc<=count && heaparr[parent]>heaparr[rc])
        {
            largest = rc;
        }

        if(largest!=indx)
        {
            int temp = heaparr[largest];
            heaparr[largest]=heaparr[parent];
            heaparr[parent]=temp;
            percaptulate_down(largest);

        }
        
    }

    public void delete(int indx)
    {
        int delind=indx;
        int templast = heaparr[count];
        heaparr[count]=heaparr[delind];
        count--;
        heaparr[delind]=templast;
        percaptulate_down(delind);
    }

    public void insert(int element)
    {
        count = count+1;
        if(count<capacity)
        {
            heaparr[count] = element;
            percaptulate_up(count);
        }
    }

    public void heapify(){

        while(count>=0)
        {
            delete(0);
        }
    }

    public void display(){
        for(int i=0;i<capacity;i++)
        {
            System.out.print(heaparr[i] + " ");
        }
        System.out.println("\n");
    }
    
    public void buildheap(){
        for(int i=(count-1)/2;i>=0;i--)
        {
            percaptulate_down(i);
        }
    }
}
class GFG {
    
    public int ropesum(int[] arr)
    {
        Heap h = new Heap(arr);
        int mincost = 0;
        while(h.count!=0)
        {
            h.buildheap();
            System.out.println("after heap and first delete");
            //h.display();
            int min1 = h.heaparr[0];
            h.delete(0);
            h.buildheap();
            //h.display();
            //System.out.println("after min2");
            int min2 = h.heaparr[0];
            h.delete(0);
            h.buildheap();
            //h.display();
            //System.out.println(h.count);
            int sum = min1+min2;
            //System.out.println(sum);
            mincost = mincost+sum;
            h.insert(sum);
            //System.out.println(h.count);
        }
        return mincost;
    }
    
	public static void main (String[] args) {
		GFG g1 = new GFG();
		int[] ropes = {4,3,2,6};
		System.out.println(g1.ropesum(ropes));
	}
}
