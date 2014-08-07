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
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.*/

