import java.util.*;

class Main {

    public static int solution(int[] arr) {
        // write your code here
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int no_one=0,no_zero=0,len=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==1)
            {
                no_one++;
            }
            else
            {
                no_zero++;
            }
            int diff=no_one-no_zero;
            if(map.containsKey(diff))
            {
                len=Math.max(len,i-map.get(diff));
            }
            else
            {
                map.put(diff,i);
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
        System.out.println(solution(arr));
        scn.close();
    }

}
