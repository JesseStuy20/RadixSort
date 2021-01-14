public class Radix {

  public static int nth(int n, int col) {
    // if (n < 0) n = n*-1 ;
    int divisor = (int) Math.pow(10,col+1) ;
    int returnValue = n % divisor ;
    return (returnValue / (divisor/10)) ;
  }

  public static int length(int n) {
    if (n == 0) return 1 ;
    if (n < 0) n *= -1 ;
    return ((int) Math.log10(n) + 1) ;
  }

  public static void merge(SortableLinkedList original, SortableLinkedList[] buckets) {
    for (int i=0; i<buckets.length; i++) {
      original.extend(buckets[i]) ;
    }
  }

  public static void radixSortSimple(SortableLinkedList data) {
    int largestNum = Math.abs(data.get(0)) ;
    SortableLinkedList[] a = new SortableLinkedList[10] ;
    int dataSize = data.size() ;
    for (int i=0; i<10; i++) {
      a[i] = new SortableLinkedList() ;
    }
    for (int i=0; i<length(largestNum); i++) { //digits
      for (int j=0; j<dataSize; j++) { //node
        int temp = data.get(0) ;
        if ((i == 0) && (Math.abs(temp) > largestNum)) largestNum = temp ;
        int b = nth(temp,i) ;
        a[b].add(temp) ;
        data.remove(0) ;
      }
      merge(data,a) ;

    }
  }

  public static void radixSort(SortableLinkedList data) {
    SortableLinkedList positive = new SortableLinkedList() ;
    SortableLinkedList negative = new SortableLinkedList() ;
    int dataSize = data.size() ;
    for (int i=0; i<dataSize; i++) {
      if (data.get(0) >= 0) {
        positive.add(data.get(0)) ;
      }
      else {
        negative.add(data.get(0) * -1) ;
      }
      data.remove(0) ;
    }
    if (positive.size() > 0) radixSortSimple(positive) ;
    if (negative.size() > 0) radixSortSimple(negative) ;
    for (int i=negative.size()-1; i>-1; i--) {
      data.add(negative.get(i) * -1) ;
    }
    data.extend(positive) ;
  }

/*
  public static void radixSort(SortableLinkedList data) {
    int largestNum = Math.abs(data.get(0)) ;
    SortableLinkedList[] a = new SortableLinkedList[20] ;
    for (int i=0; i<20; i++) {
      a[i] = new SortableLinkedList() ;
    }
    for (int i=0; i<length(largestNum); i++) { //digits
      for (int j=0; j<data.size(); j++) { //node
        int temp = data.get(j) ;
        if (Math.abs(temp) > largestNum) largestNum = temp ;
        int b = nth(temp,i) + 10 ;
        a[b].add(temp) ;
      }
      merge(data,a) ;
      for (int j=0; j<data.size();j++) {
        data.remove(0) ;
      }
    }
  }
*/
}
