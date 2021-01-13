public class Radix {

  public static int nth(int n, int col) {
    if (n < 0) n = n*-1 ;
    int divisor = (int) Math.pow(10,col+1) ;
    int returnValue = n % divisor ;
    return (returnValue / (divisor/10)) ;
  }

  public static int length(int n) {
    if (n < 0) n = n*-1 ;
    int returnValue = 1 ;
    for (int i=n; i>10; i=i/10) {
      returnValue++ ;
    }
    return returnValue ;
  }

  public static void merge(SortableLinkedList original, SortableLinkedList[] buckets) {
    for (int i=0; i<buckets.length; i++) {
      original.extend(buckets[i]) ;
    }
  }

  public static void radixSortSimple(SortableLinkedList data) {
    int largestNum = Math.abs(data.get(0)) ;
    for (int i=0; i<length(largestNum); i++) { //digits
      SortableLinkedList[] a = new SortableLinkedList[10] ;
      int dataSize = data.size() ;
      for (int j=0; j<10; j++) {
        a[j] = new SortableLinkedList() ;
      }
      for (int j=0; j<data.size(); j++) { //node
        if (Math.abs(data.get(j)) > largestNum) largestNum = data.get(j) ;
        int b = nth(data.get(j),i) ;
        a[b].add(data.get(j)) ;
      }
      merge(data,a) ;
      for (int j=0; j<data.size();j++) {
        data.remove(0) ;
      }
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

}
