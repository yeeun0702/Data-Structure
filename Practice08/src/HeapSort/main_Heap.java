package HeapSort;

public class main_Heap {
   public static void main(String[] args) {
      String a[] = {" ","90","60","80","50","30","40","70","10","20"};   
      Heap_Sort.sort(a);
      System.out.printf("정렬 결과: ");
      for (int i = 1; i < a.length; i++) {
         System.out.printf(a[i]+"  ");
      }
   }
}