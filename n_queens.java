/* The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an 
empty space respectively.*/

public class Solution {
    public List<String[]> solveNQueens(int n) {
        ArrayList<String[]> result=new ArrayList<String[]>();
        int[] loc=new int[n];
        dfs(n,0,loc,result);
        return result;
    }
    public void dfs(int n, int cur, int[] loc, ArrayList<String[]> result){
        if(cur==n){
            print2string(loc,n,result);
            return ;
        }
        else{
            for(int i=0;i<n;++i){
                loc[cur]=i;
                if(isValid(loc,cur))
                    dfs(n,cur+1,loc,result);
            }
        }
    }
    public void print2string(int[] loc, int n,ArrayList<String[]> result){
        String[] cur=new String[n];
        for(int i=0;i<n;++i){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<n;++j){
                if(j==loc[i])
                    sb.append("Q");
                else
                    sb.append(".");
            }
            cur[i]=sb.toString();
        }
        result.add(cur);
    }
    public boolean isValid(int[] loc,int cur){
        for(int i=0;i<cur;++i){
            if(loc[i]==loc[cur] || Math.abs(loc[i]-loc[cur])==cur-i)
                return false;
        }
        return true;
    }
}

/* Follow up:
Now, instead outputting board configurations, return the total number of distinct solutions.*/

public class Solution {
    int result;
    public int totalNQueens(int n) {
        result=0;
       int[] loc=new int[n];
       dfs(n,0,loc);
       return result;
    }
    public void dfs(int n, int cur, int[] loc){
        if(cur==n){
            result++;
            return;
        }
        else{
            for(int i=0;i<n;++i){
                loc[cur]=i;
                if(isValid(loc,cur))
                    dfs(n,cur+1,loc);
            }
        }
    }
    public boolean isValid(int[] loc, int cur){
        for(int i=0;i<cur;++i){
            if(loc[i]==loc[cur] || Math.abs(loc[i]-loc[cur])==cur-i)
                return false;
        }
        return true;
    }
}

/* another way to solve the second quesion:*/

public class Solution {
    int result,upper;
    public int totalNQueens(int n) {
        result=0;
        upper=(1<<n)-1;
       helper(0,0,0);
       return result;
    }
    public void helper(int row, int ld, int rd){
        int pos,p;
        if(row!=upper){
           pos=upper&(~(row|ld|rd));
           while(pos!=0){
               p=pos&(-pos);
               pos=pos-p;
               helper(row+p,(ld+p)<<1,(rd+p)>>1);
           }
        }
        else
            result++;
    }
}
