import java.util.Arrays;
import java.util.ArrayList;
public class Main
{
	public static void main(String[] args) {
	   int num =36;
	   System.out.println(Arrays.asList(Main.factorOfNumber(36)));
	}
	public static ArrayList<Integer> factorOfNumber(int n)
	{
	    ArrayList<Integer> factorList = new ArrayList<>();
	    for(int i=1;i<Math.sqrt(n);i++)
	    {
	        if(n%i==0)
	        {
	            factorList.add(i);
	            if(i != n/i)//this case is for in order to avoid same number added twice. if i is a perfect square
	            {
	                factorList.add(n/i);
	            }
	        }
	    }
	    return factorList;
	}
}
