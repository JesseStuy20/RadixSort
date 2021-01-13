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
    SortableLinkedList[] test = new SortableLinkedList[3] ;
    for (int i=0; i<3; i++) {
      test[i] = new SortableLinkedList() ;
    }
    test[0].add(0) ;
    test[1].add(2) ;
    test[2].add(142) ;
    Radix.merge(nums,test) ;
    System.out.println(Radix.length(910)) ;
    System.out.println(nums.toString()) ;
    Radix.radixSortSimple(nums) ;
    System.out.println(nums.toString()) ;
    int c = -910 ;
    System.out.println(Radix.length(c)) ;
    System.out.println(c) ;
    System.out.println(Radix.nth(c,2)) ;
    for (int i=0; i<nums.size(); i++) {
      nums.set(i, nums.get(i)*-1) ;
    }
    System.out.println("------------------------") ;
    System.out.println(nums.toString()) ;
    System.out.println(nums.size()) ;
    Radix.radixSort(nums) ;
    System.out.println(nums.toString()) ;
    SortableLinkedList rand = new SortableLinkedList() ;
    for (int i=0; i<20; i++) {
      double temp = (Math.random() * 1000) ;
      if (Math.random() > 0.5) temp = temp * -1 ;
      rand.add((int) temp) ;
    }
    System.out.println(rand.toString()) ;
    Radix.radixSort(rand) ;
    System.out.println(rand.toString()) ;
  }

}
