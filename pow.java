/* Implement pow(x, n).*/

public class Solution {
    public double pow(double x, int n) {
        if(0==n)
            return 1;
        if(2==n)
            return x*x;
        if(0==n%2)
            return pow(pow(x,n/2),2);
        else{
            if(n>0)
                return x*pow(pow(x,n/2),2);
            else
                return 1.0/x*pow(pow(x,n/2),2);
        }
    }
}


public class Solution {
    public double pow(double x, int n) {
        if(n>0)
            return power(x,n);
        else
            return 1.0/power(x,-n);
    }
    public double power(double x, int n){
        if(0==n)
            return 1;
        double half=power(x,n/2);
        if(0==n%2)
            return half*half;
        else
            return x*half*half;
    }
}
