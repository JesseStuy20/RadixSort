public class Radix {

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

  public static void merge(SortableLinkedList original, SortableLinkedList[] buckets) {
    SortableLinkedList a = new SortableLinkedList() ;
    a = buckets[0] ;
    for (int i=1; i<10; i++) {
      a.extend(buckets[i]) ;
    }
    original.extend(a) ;
  }

}
