/* alidate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before 
implementing one.*/

/* regular expression :
http://blog.csdn.net/fightforyourdream/article/details/12900751.*/

public class Solution {
    public boolean isNumber(String s) {
        if(s.trim().isEmpty()){  
            return false;  
        }  
        String regex = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?";  
        return s.trim().matches(regex);
    }
}

/* finite automate machine:
http://xiaqianlin.cn/?p=445 */

public class Solution {
    public enum InputType {
        INVALID,    // 0
        SPACE,      // 1
        SIGN,       // 2
        DIGIT,      // 3
        DOT,        // 4
        EXPONENT,   // 5
        NUM_INPUTS  // 6
    };
 
    public static int[][] transitionTable = new int[][]{
            {-1,  0,  3,  1,  2, -1},     // next states for state 0 Initial
            {-1,  8, -1,  1,  4,  5},     // next states for state 1 digits
            {-1, -1, -1,  4, -1, -1},     // next states for state 2 digits.
            {-1, -1, -1,  1,  2, -1},     // next states for state 3 (+|-) digits
            {-1,  8, -1,  4, -1,  5},     // next states for state 4 digits.digits
            {-1, -1,  6,  7, -1, -1},     // next states for state 5 digits e
            {-1, -1, -1,  7, -1, -1},     // next states for state 6 digits e (+|-)
            {-1,  8, -1,  7, -1, -1},     // next states for state 7 digits e (+|-) digits
            {-1,  8, -1, -1, -1, -1}      // next states for state 8 finish
        };
 
    // public static String isNumber =
    //      "^s*[+-]?(d+|d*.d+|d+.d*)([eE][+-]?d+)?s*$";
 
    public boolean isNumber(String s) {
 
        int state = 0;
        for (int i=0; i<s.length(); i++){
            InputType inputType = InputType.INVALID;
            char c = s.charAt(i);
            if (c == ' ' || c == 't')
                inputType = InputType.SPACE;
            else if (c == '+' || c == '-')
                inputType = InputType.SIGN;
            else if (c >= '0' && c <= '9')
                inputType = InputType.DIGIT;
            else if (c == '.')
                inputType = InputType.DOT;
            else if (c == 'e' || c == 'E')
                inputType = InputType.EXPONENT;
 
            // Get next state from current state and input symbol
            state = transitionTable[state][inputType.ordinal()];
 
            // Invalid input
            if (state == -1){
                return false;
            }
        }
        // If the current state belongs to one of the accepting (final) states,
        // then the number is valid
        return state == 1 || state == 4 || state == 7 || state == 8;
    }
}
