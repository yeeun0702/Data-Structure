package QuickSort;
 
public class main_Quick {
		
	public static void main(String[] args) {
		
		String a[] = {"1","2","3","4","5","6"};
		Quick_Sort.sort(a);
		System.out.print("정렬 결과: ");
		for (int i = 0; i < a.length; i++) {
			System.out.printf(a[i]+"  ");
		}
		System.out.println("비교 횟수: "+Quick_Sort.count ); //count 호출 
	}
} 	