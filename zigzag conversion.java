/* The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR". */

/* So inorder to get the final string, we need to scan from the left to right row by row, for the first and last row, the difference
between every two is 2 * nRow – 2, and for the middle say i-th rows, the difference between every two is either 
2 * nRow – 2 – 2 * i or 2 * i in turn. Following this, a linear scan of the original string could give us the final result string by pushing the corresponding character  at specific index into the final resulted string.*/

public class Solution {
    public String convert(String s, int nRows) {
        if(null==s || nRows<2)
            return s;
        int step=2*nRows-2;
        StringBuilder result=new StringBuilder();
        for(int i=0;i<nRows;++i){
            for(int j=i;j<s.length();j+=step){
                result.append(s.charAt(j));
                if(i>0 && i<nRows-1){
                    if(j+step-2*i<s.length()){
                        result.append(s.charAt(j+step-2*i));
                    }
                }
            }
        }
        return result.toString();
    }
}
