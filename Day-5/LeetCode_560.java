class Solution {
    public int subarraySum(int[] arr, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
		map.put(0,1);
		int count=0,sum=0;
		for(int num:arr)
		{
			sum+=num;
			int val = sum - k;
            if(map.containsKey(val))
            {
                count += map.get(val);                
            }
            map.put(sum,map.getOrDefault(sum, 0) + 1); 
		}
		return count;
    }
}