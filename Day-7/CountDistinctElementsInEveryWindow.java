// https://practice.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1

import java.util.ArrayList;
import java.util.HashMap;

class Solution
{
    ArrayList<Integer> countDistinct(int arr[], int n, int k)
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        ArrayList<Integer> result=new ArrayList<>();
        for(int i=0;i<k;i++)
        {
            if(map.containsKey(arr[i]))
            {
                map.put(arr[i],map.get(arr[i])+1);
            }
            else
            {
                map.put(arr[i],1);
            }
        }
        result.add(map.size());
        for(int i = k; i < n; i++)
        {
            int release = arr[i - k];
            int acquire = arr[i];
            if(map.get(release) == 1)
            {
                map.remove(release);
            }
            else 
            {
                map.put(release, map.get(release) - 1);
            }
            if(map.containsKey(acquire) == true)
            {
                map.put(acquire, map.get(acquire) + 1);
            }
            else 
            {
                map.put(acquire, 1);
            }
            result.add(map.size());
        }
        return result;
    }
}