public class RadixTester {
  public static void main(String[] args) {
    int a = 234567890 ;
    for (int i=0; i<9; i++) {
      System.out.println(RadixSort.nth(a,i)) ;
    }
    System.out.println(RadixSort.nth(a,8)) ;
  }
}
