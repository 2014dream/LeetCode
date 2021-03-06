/* Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and 
right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when 
necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly 
between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]*/

public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        ArrayList<String> result=new ArrayList<String>();
        if(null==words || 0==words.length)
            return result;
        int count=0;
        int last=0;
        for(int i=0;i<words.length;++i){
            if(count+words[i].length()+i-last>L){
                result.add(curStr(words,L,i,count,last));
                count=0;
                last=i;
            }
            count+=words[i].length();
        }
        StringBuilder sb=new StringBuilder();
        for(int i=last;i<words.length;++i){
            sb.append(words[i]);
            if(sb.length()<L)
                sb.append(" ");
        }
        for(int i=sb.length();i<L;++i){
            sb.append(" ");
        }
        result.add(sb.toString());
        return result;
    }
    public String curStr(String[] words,int L,int i,int count,int last){
        int spaceNum=0;
        int extraNum=0;
        if(i-last-1>0){
            spaceNum=(L-count)/(i-last-1);
            extraNum=(L-count)%(i-last-1);
        }
        StringBuilder sb=new StringBuilder();
        for(int j=last;j<i;++j){
           sb.append(words[j]);
           if(j<i-1){
               for(int k=0;k<spaceNum;++k){
                   sb.append(" ");
               }
               if(extraNum>0)
                    sb.append(" ");
                extraNum--;
           } 
        }
        for(int j=sb.length();j<L;++j){
            sb.append(" ");
        }
        return sb.toString();
    }
}
