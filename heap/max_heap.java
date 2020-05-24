
import java.util.*;
import java.lang.*;

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
        //System.out.println("child index came in");
        //System.out.println(indx);
        float normal = (indx-1)/2;
        //System.out.println("Normally");
        //System.out.println(normal);
        int pindx = (int)Math.ceil((indx-1)/2);
        //System.out.println("After ceil");
        //System.out.println(pindx);
        return pindx;

    }

    public void percaptulate_up(int indx)
    {
        int child = indx;
        int parentindx = findparent(indx);
        //System.out.println(parentindx);
        if(parentindx>-1 && heaparr[child]>heaparr[parentindx])
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
        if(lc<=count && heaparr[parent]<heaparr[lc])
        {
                largest = lc;
        }
        if(rc<=count && heaparr[parent]<heaparr[rc])
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
    
    public static void main(String[] args)
    {
    int arr[] = {6,4,1,5,2,7};
    Heap hp = new Heap(arr);
    //hp.percaptulate_up(arr.length-1);
    //hp.percaptulate_down(0);
    //hp.display();
    //System.out.println()
    //hp.heapify();
    hp.buildheap();
    hp.display();
    }

}


