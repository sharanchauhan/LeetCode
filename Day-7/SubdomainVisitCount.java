import java.util.*;
class Main {
    
	public static List<String> subdomainVisits(String[] s) {
		HashMap<String,Integer> map=new HashMap<>();
		List<String> ans=new ArrayList<>();
		for(String ss:s)
		{
			String[] str=ss.split(" ");
			int vc=Integer.parseInt(str[0]);
			String domain=str[1];
			String[] dom=domain.split("\\."); // does'nt split by only using "."
			StringBuilder sb=new StringBuilder();
			for(int i=dom.length-1;i>=0;i--)
			{
				String sD=dom[i];
				if(i==dom.length-1) 
				{
					sb.append(sD);
				}
				else
				{
					sb.insert(0,".");
					sb.insert(0,sD);
				}
				String sss=sb.toString();
				map.put(sss,map.getOrDefault(sss,0)+vc);
			}
		}
		for(String k:map.keySet())
		{
			StringBuilder nsb=new StringBuilder();
			nsb.append(map.get(k));
			nsb.append(" ");
			nsb.append(k);
			ans.add(nsb.toString());
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = Integer.parseInt(s.nextLine());
		String[] cpd = new String[n];
		for (int i = 0; i < cpd.length; i++) {
			cpd[i] = s.nextLine();
		}
		List<String> ans = subdomainVisits(cpd);
		Collections.sort(ans);
		for(String str:ans)
		{
			System.out.println(str);
		}
		s.close();
	}

}
