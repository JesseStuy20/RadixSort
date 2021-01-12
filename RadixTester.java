public class RadixTester {
  public static void main(String[] args) {
    int a = 123456789 ;
    for (int i=0; i<9; i++) {
      System.out.println(RadixSort.nth(a,i)) ;
    }
    System.out.println(RadixSort.length(a)) ;
  }
}
