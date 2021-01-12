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
  }
}
