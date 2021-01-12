public class Radix{
  public static int nth(int n, int col){
    return (int)((Math.abs(n) / Math.pow(10, col)) % 10);
  }

  public static int length(int n){
    if (n == 0){
      return 1;
    }
    return (int)(Math.log10(Math.abs(n))) + 1;
  }

  public static void merge(SortableLinkedList original, SortableLinkedList[] buckets){
    for (int i = 0; i < buckets.length; i++){
      original.extend(buckets[i]);
    }
  }

  public static void radixSortSimple(SortableLinkedList data){
    SortableLinkedList[] buckets = new SortableLinkedList[10];

    for (int i = 0; i < 10; i++){
      buckets[i] = new SortableLinkedList();
    }

    int largestDigit = 0;

    for (int i = 0; i < data.size(); i++){
      int item = data.get(i);
      int digits = length(item);

      if (digits > largestDigit){
        largestDigit = digits;
      }

      buckets[nth(item, 0)].add(item);
      data.remove(i);
      i = i - 1;
    }

    merge(data, buckets);

    for (int i = 1; i < largestDigit; i++){
      for (int j = 0; j < data.size(); j++){
        int item = data.get(0);

        buckets[nth(item, i)].add(item);
        data.remove(0);
        j = j - 1;
      }
      merge(data, buckets);
    }
  }

  public static void radixSort(SortableLinkedList data){
    SortableLinkedList negativeBucket = new SortableLinkedList();
    SortableLinkedList positiveBucket = new SortableLinkedList();

    for (int i = 0; i < data.size(); i++){
      if (data.get(i) < 0){
        negativeBucket.add(Math.abs(data.get(i)));
        data.remove(i);
        i = i - 1;
      }
      else{
        positiveBucket.add(data.get(i));
        data.remove(i);
        i = i - 1;
      }
    }

    radixSortSimple(negativeBucket);
    radixSortSimple(positiveBucket);

    SortableLinkedList reversedNegativeBucket = new SortableLinkedList();

    for (int i = negativeBucket.size() - 1; i >= 0; i--){
      reversedNegativeBucket.add(0 - negativeBucket.get(i));
    }

    data.extend(reversedNegativeBucket);
    data.extend(positiveBucket);
  }

}
