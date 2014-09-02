/* Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.*/

public class Solution {
    public List<String> anagrams(String[] strs) {
        ArrayList<String> result=new ArrayList<String>();
        if(null==strs || 0==strs.length)
            return result;
        HashMap<String,ArrayList<String>> map=new HashMap<String,ArrayList<String>>();
        for(String s:strs){
            char[] c=s.toCharArray();
            Arrays.sort(c);
            String key=new String(c);
            if(map.containsKey(key))
                map.get(key).add(s);
            else{
                ArrayList<String> tmpList=new ArrayList<String>();
                tmpList.add(s);
                map.put(key,tmpList);
            }
        }
        for(ArrayList<String> list:map.values()){
            if(list.size()>1){
                for(String s:list){
                    result.add(s);
                }
            }
        }
        return result;
    }
}
