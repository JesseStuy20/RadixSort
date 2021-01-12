public class RadixSort {

  public static int nth(int n, int col) {
    int divisor = (int) Math.pow(10,col+1) ;
    int returnValue = n % divisor ;
    return (returnValue / (divisor/10)) ;
  }

  public static int length(int n) {
    int returnValue = 1 ;
    for (int i=n; i>10; i=i/10) {
      returnValue++ ;
    }
    return returnValue ;
  }

}
