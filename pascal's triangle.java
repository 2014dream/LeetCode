/* Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]*/

public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if(0>=numRows)
            return result;
        for(int row=0;row<numRows;++row){
            ArrayList<Integer> curRow=new ArrayList<Integer>();
            for(int i=0;i<=row;++i){
                if(0==i)
                    curRow.add(1);
                else if(i<row)
                    curRow.add(result.get(row-1).get(i)+result.get(row-1).get(i-1));
                else if(i==row)
                    curRow.add(1);
            }
            result.add(curRow);
        }
        return result;
    }
}

/* Follow up: Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?8?

