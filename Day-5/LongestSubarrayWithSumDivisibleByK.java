import java.util.*;

public class Main {

    public static int solution(int[] arr, int k) {
        // write your code here
        HashMap<Integer,Integer> map=new HashMap<>();
		map.put(0,-1);
		int count=0,sum=0,len=0;
		for(int i=0;i<arr.length;i++)
		{
			sum+=arr[i];
            int rem=sum%k;
            if(rem < 0)
            {
                rem+=k;
            }
			if(map.containsKey(rem))
			{
                len=Math.max(len,i-map.get(rem));
			}
            else
            {
                map.put(rem,i);
            }
		}
		return len;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println(solution(arr, k));
    }

}
