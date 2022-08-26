import java.util.*;

class Main {
  public static int traverse(HashMap<String,HashSet<String>> tree,String manager,HashMap<String,Integer> ans)
  {
    HashSet<String> empList=tree.get(manager);
    if(empList==null)
    {
      ans.put(manager,0);
      return 1;
    }
    int size=0;
    for(String emp:empList)
    {
      size+=traverse(tree,emp,ans);
    }
    ans.put(manager,size);
    return size+1;
  }
  public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    HashMap<String,HashSet<String>> mp=new HashMap<>();
    String ceo="";
    for(int i=1;i<=n;i++)
    {
      String employee=s.next();
      String manager=s.next();
      if(employee.equals(manager))
      {
        ceo+=manager;
        continue;
      }
      if(mp.containsKey(manager))
      {
        HashSet<String> hs=mp.get(manager);
        hs.add(employee);
        mp.put(manager,hs);
      }
      else
      {
        HashSet<String> hs=new HashSet<>();
        hs.add(employee);
        mp.put(manager,hs);
      }
    }
    HashMap<String,Integer> ans=new HashMap<>();
    traverse(mp,ceo,ans);
    for(String manager : ans.keySet())
    {
      int freq = ans.get(manager);
      System.out.println(manager+" "+freq);
    }
    s.close();
  }

}