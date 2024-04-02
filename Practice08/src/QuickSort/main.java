package QuickSort;

public class main {
	public static void main(String[] args) {
		String a[] = {"Q","U","I","C","K","S","O","R","T","E","X","A","M","P","L","E"};
		Quick.sort(a);
		System.out.print("���� ���: ");
		for (int i = 0; i < a.length; i++) {
			System.out.printf(a[i]+"  ");
		}
	}
} 	