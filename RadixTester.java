public class RadixTester {
  public static void main(String[] args) {
    int a = 123456789 ;
    for (int i=0; i<9; i++) {
      System.out.println(Radix.nth(a,i)) ;
    }
    System.out.println(Radix.length(a)) ;
    SortableLinkedList nums = new SortableLinkedList() ;
    nums.add(910) ;
    nums.add(847) ;
    nums.add(871) ;
    nums.add(214) ;
    nums.add(741) ;
    nums.add(13) ;
    nums.add(619) ;
    nums.add(526) ;
    SortableLinkedList[] test = new SortableLinkedList[2] ;
    for (int i=0; i<2; i++) {
      test[i] = new SortableLinkedList() ;
    }
    System.out.println(test[1].size()) ;
    Radix.merge(nums,test) ;
    System.out.println(nums.toString()) ;
    System.out.println(nums.size()) ;
    Radix.radixSortSimple(nums) ;
    System.out.println(nums.toString()) ;
  }

}
