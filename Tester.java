public class Tester{
  public static void main(String[] args){
    System.out.println(Radix.nth(123,1));
    System.out.println(Radix.nth(-123,1));
    System.out.println(Radix.nth(123,2));
    System.out.println(Radix.nth(-123,2));

    System.out.println();

    System.out.println(Radix.length(0));
    System.out.println(Radix.length(9));
    System.out.println(Radix.length(10));
    System.out.println(Radix.length(15));
    System.out.println(Radix.length(-10));
    System.out.println(Radix.length(5112));

    MyLinkedList original = new MyLinkedList();
    original.add("1");
    original.add("2");
    MyLinkedList[] buckets = new MyLinkedList[10];
    for (int i = 0; i < buckets.length; i++){
      buckets[i] = new MyLinkedList();
      buckets[i].add(i + "");
    }
    Radix.merge(original, buckets);
    System.out.println(original);
  }
}
