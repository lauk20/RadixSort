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

}
