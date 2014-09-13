/* Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such
that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.*/

/* The problem can be sovled by using BFS, we use two queues to store the possible word and the length. Once we found 
the match, we return the lenght. It must be the minimum length.*/

public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        if(null==dict || start.length()!=end.length())
            return 0;
        Queue<String> words=new LinkedList<String>();
        Queue<Integer> lengths=new LinkedList<Integer>();
        words.add(start);
        lengths.add(1);
        while(!words.isEmpty()){
            String word=words.poll();
            int len=lengths.poll();
            if(word.equals(end))
                return len;
            for(int i=0;i<word.length();++i){
                char[] arr=word.toCharArray();
                for(char c='a';c<='z';++c){
                    if(arr[i]==c)
                        continue;
                    arr[i]=c;
                    String tmp=String.valueOf(arr);
                    if(dict.contains(tmp)){
                        words.add(tmp);
                        lengths.add(len+1);
                        dict.remove(tmp);
                    }
                }
            }
        }
        return 0;
    }
}

/* Follow up: Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, 
such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]*/
  
  
  public class Solution {
    public static ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
        HashMap<String, ArrayList<String>> preSet = new HashMap<String, ArrayList<String>>();
        dict.remove(start);
        dict.remove(end);
        LinkedList<String> queue1 = new LinkedList<String>();
        queue1.add(start);
        while (!queue1.isEmpty()) {
            LinkedList<String> queue2 = new LinkedList<String>();
            boolean finished = false;
            while (!queue1.isEmpty()) {
                String top = queue1.pop();
                for (int i = 0; i < top.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (top.charAt(i) == c)
                            continue;
                        char[] charTop = top.toCharArray();
                        charTop[i] = c;
                        String newTop = new String(charTop);
                        if (newTop.equals(end)) {
                            finished = true;
                            ArrayList<ArrayList<String>> oneResult = getAllPath(top, preSet, start);
                            for (ArrayList<String> list : oneResult) {
                                list.add(newTop);
                            }
                            results.addAll(oneResult);
                            
                        }
                        if (dict.contains(newTop)) {
                            if (!queue2.contains(newTop))
                            	queue2.add(newTop);
                            if (preSet.containsKey(newTop)) {
                                preSet.get(newTop).add(top);
                            } else {
                                preSet.put(newTop, new ArrayList<String>(Arrays.asList(top)));
                            }
                        }
                    }
                }   
            }
            if (finished) {
                return results;
            }
            dict.removeAll(queue2);
            queue1 = queue2;
        }
        return results;
    }
    
    public static ArrayList<ArrayList<String>> getAllPath(String str, HashMap<String, ArrayList<String>> preSet, String begin) {
        ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
        if (preSet.get(str) == null) {
        	ArrayList<String> result = new ArrayList<String>(Arrays.asList(str));
        	results.add(result);
        	return results;
        }
        for (String pre : preSet.get(str)) {
            ArrayList<ArrayList<String>> result = getAllPath(pre, preSet, begin);
            for (ArrayList<String> list : result) {
                list.add(str);
                results.add(list);
            }
        }
        return results;
    }
}
