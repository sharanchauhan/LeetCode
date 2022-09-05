import java.util.*;
class Main {

	public static String solution(String s1, String s2){
		HashMap<Character,Integer> omap=new HashMap<>();
		for(int k=0;k<s2.length();k++)
		{
			char c=s2.charAt(k);
			int f=omap.getOrDefault(c,0);
			omap.put(c,f+1);
		}
		int oc=s2.length();
		int i=0,j=0,min=Integer.MAX_VALUE,si=0,li=0,count=0;
		boolean flag=true;
		HashMap<Character,Integer> map=new HashMap<>();
		while(flag)
		{
			flag=false;
			// acquire
			if(count!=oc && j<s1.length())
			{
				flag=true;
				char c=s1.charAt(j);
				int f=map.getOrDefault(c,0);
				map.put(c,f+1);
				// count
				if(omap.containsKey(c))
				{
					if(f+1<=omap.get(c)) count++;
				}
				j++;
			}

			// release
			if(count==oc && i<s1.length())
			{
				flag=true;
				if(j-i<min)
				{
					min=j-i;
					si=i;
					li=j;
				}
				char ch=s1.charAt(i);
				int f=map.get(ch);
				if(f==1) map.remove(ch);
				else map.put(ch,f-1);
				if(omap.containsKey(ch))
				{
					if(f-1<omap.get(ch)) count--;
				}
				i++;
			}
		}
		return s1.substring(si,li);
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1,s2));
        scn.close();
	}

}
