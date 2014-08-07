/* Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.*/

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack =new Stack<Character>();
        char[] sc=s.toCharArray();
        Map<Character,Character> map=new HashMap<Character,Character>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        for(Character c:sc){
            if(map.keySet().contains(c))
                stack.push(c);
            else if(map.values().contains(c)){
                if(!stack.isEmpty() && map.get(stack.peek())==c)
                    stack.pop();
                else 
                    return false;
            }
        }
        return stack.isEmpty();
    }
}

/* Follow up:
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses 
substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.*/

/*Use stack to record  '('  position, then check current valid length when a ')' come.
then, max length valid Parentheses is decided by two situation
1) stack is not empty, so the current length is current position i- last second position of '(' in stack, we can calculate it
through stack.pop(), then i-stack.peek() and check the length with max
2) stack is empty, then the longest length we can check currently is i-last (last is the position of last invalid ')') */

public class Solution {
    public int longestValidParentheses(String s) {
        if(null==s || 0==s.length())
            return 0;
        int last=-1,maxLen=0;
        Stack<Integer> stack=new Stack<Integer>();
        for(int i=0;i<s.length();++i){
            if('('==s.charAt(i))
                stack.push(i);
            else{
                if(stack.isEmpty())
                    last=i;
                else{
                    stack.pop();
                    if(stack.isEmpty())
                        maxLen=Math.max(maxLen,i-last);
                    else
                        maxLen=Math.max(maxLen,i-stack.peek());
                }
            }
        }
        return maxLen;
    }
}

/* Follow up :
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"*/

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<String>();
        StringBuilder sb=new StringBuilder();
        generate(result,sb,0,0,n);
        return result;
    }
    public void generate(List<String> result, StringBuilder sb, int left, int right, int n){
        if(left==right && right==n){
            result.add(sb.toString());
            return ;
        }
        if(left<right || left>n || right>n)
            return ;
        if(left<n){
            sb.append('(');
            generate(result,sb,left+1,right,n);
            sb.deleteCharAt(sb.length()-1);
        }
        if(right<left){
            sb.append(')');
            generate(result,sb,left,right+1,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

