import java.util.*;

public class Main {
	
	public static int solution(int[] arr) {
		// write your code here
		HashMap<Integer,Integer> map=new HashMap<>();
		int sum=0;
		int len=0;
		map.put(0,-1);
		for(int i=0;i<arr.length;i++)
		{
			sum+=arr[i];
			if(map.containsKey(sum))
			{
				len=Math.max(len,i-map.get(sum));
			}
			else
			{
				map.put(sum,i);
			}
		}
		return len;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}

}
