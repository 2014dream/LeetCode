List<List<Integer>> func(int n) {
     List<List<Integer>> result= new ArrayList<List<>>();
     List<Integer> cur=new ArrayList<>();
     get(n,2,cur,result);
     return result;
}

public get(int target,int start,List<Integer> cur,List<List<Integer>> result
) {
    if(target==1) {
             result.add(new ArrayList<Integer>(cur));
             return;
    }
     for(int i=start;i<=target;i++) {
            if(target%i==0) {
                   cur.add(i);
                   get(target/i,i,cur,result);
                   cur.remove(cur.size()-1);
            }
     }
}
