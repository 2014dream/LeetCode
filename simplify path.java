/* Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".*/

public class Solution {
    public String simplifyPath(String path) {
        StringBuilder result=new StringBuilder();
        if(null==path || 0==path.length())
            return result.toString();
        Stack<String> stack=new Stack<String>();
        String[] str=path.split("/");
        for(String s:str){
            if(0==s.length() || s.equals("."))
                continue;
            else if(s.equals("..")){
                if(!stack.isEmpty())
                    stack.pop();
            }
            else
                stack.push(s);
        }
        if(stack.isEmpty())
            result.append("/");
        else{
            while(!stack.isEmpty()){
                result.insert(0,stack.pop());
                result.insert(0,"/");
            }
        }
        return result.toString();
    }
}
