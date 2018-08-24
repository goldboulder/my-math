/*

 */
package MyMath;

/**
 *
 * @author Nathan
 */
public class MyMath {
    
    /**
     * returns the factorial of a number (as a double because the numbers get
     * big fast)
     * @param num
     * @return (num)!
     */
    public static double fact(int num){
        double ans = 1;
        for (int i = 2; i <= num; i++){
            ans *= i;
        }
        return ans;
    }
    
    public static long nCr(int n, int r){
        long num = 1;
        for (int i = n; i >= n - r + 1; i --){
            num *= i;
        }
        return num/(long)fact(r);
    }
    
    
    
    
}
