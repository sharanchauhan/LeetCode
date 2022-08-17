import java.util.*;

public class Main {

	public static int solution(int[] arr) {
		// write your code here
		HashMap<Integer,Integer> map=new HashMap<>();
		map.put(0,1);
		int count=0,sum=0;
		for(int val:arr)
		{
			sum+=val;
			Integer freq=map.get(sum);
			if(freq!=null)
			{
				count+=freq;
				map.put(sum,freq+1);
			}
			else
			{
				map.put(sum,1);
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));

	}

}
