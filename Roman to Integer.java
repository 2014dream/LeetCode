/* Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.*/

public class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> romans=new HashMap<Character,Integer>();
        fillMap(romans);
        int num=0,val=0;
        char[] ss=s.toCharArray();
        for(int i=0;i<ss.length;++i){
            val=romans.get(ss[i]);
            if(i==ss.length-1 || val>=romans.get(ss[i+1]))
                num+=val;
            else
                num-=val;
        }
        return num;
    }
    public void fillMap(Map<Character,Integer> romans){
        romans.put('I',1);
        romans.put('V',5);
        romans.put('X',10);
        romans.put('L',50);
        romans.put('C',100);
        romans.put('D',500);
        romans.put('M',1000);
    }
}

/* Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.*/

public class Solution {
    public String intToRoman(int num) {
        int[] nums={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<nums.length;++i){
            int times=num/nums[i];
            num-=times*nums[i];
            for(;times>0;--times){
                builder.append(strs[i]);
            }
        }
        return builder.toString();
    }
}
