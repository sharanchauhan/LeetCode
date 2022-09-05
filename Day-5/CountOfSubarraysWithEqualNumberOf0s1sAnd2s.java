import java.util.*;

class Main {

    public static int solution(int[] arr) {
        // write your code here
        HashMap<String,Integer> map=new HashMap<>();
        map.put(0+"#"+0,1);
        int no_one=0,no_zero=0,no_two=0,count=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==1)
            {
                no_one++;
            }
            else if(arr[i]==0)
            {
                no_zero++;
            }
            else
            {
                no_two++;
            }
            String diff=(no_one-no_zero)+"#"+(no_two-no_one);
            if(map.containsKey(diff))
            {
                count+=map.get(diff);
                map.put(diff,map.get(diff)+1);
            }
            else
            {
                map.put(diff,1);
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
        scn.close();
    }

}
