import java.util.*;
public class Main
{
	public static void main(String[] args)
	{
	    int arr[] = {0,1,8,6,3,4,2,5};
	    int current_node =1;
	    for(int i =1;i<Math.log(arr.length);i++)
	    {
	       current_node = heapify(arr,arr.length-1,current_node);
	    }
		System.out.println(Arrays.toString(arr));
	}
  // logic blow ..
	public static int heapify(int arr[], int size, int curr_node_index)
	{
	    int left = 2*curr_node_index;
	    int right = (2*curr_node_index)+1;
	    int index = curr_node_index;
	    
	    if(left > size)
	    {
	        return size;
	    }
	    if(right > size && arr[left]>arr[curr_node_index])
	    {
	        index = left;
	    }
	    else if(arr[left]>arr[right])
	    {
	        index = left;
	    }
	    else if(arr[left]<arr[right])
	    {
	        index = right;
	    }
	    
	    if(index != curr_node_index)
	    {
	        swap(arr,index,curr_node_index);
	    }
	    System.out.println(index);
	    return index;
	}
	public static void swap(int arr[], int a, int b)
	{
	    int temp = arr[a];
	    arr[a] = arr[b];
	    arr[b] = temp;
	}
}
