package practice01;

public class Hanoi {
   
   static int count = 1;      //count 변수 선언

   static void move(int n, char from, char to, char tmp) { // from, to, tmp (출발지, 도착지, 경유지)
	   // 3개의 장대 중에서 from, to를 제외한 나머지 하나가 tmp가 된다.
	   
	   
      if (n == 1) {
         System.out.println(count + " : " + n + " 이동 : " + from + " -> " + to);
         count++; //count 증가후 else 수행
         
      } else {
         move(n - 1, from, tmp, to);
         System.out.println(count + " : " + n + " 이동 : " + from + " -> " + to);
         count++; 
         move(n - 1, tmp, to, from);
      }
   }

   public static void main(String[] args) {

      move(3, 'A', 'B', 'C');

   }
}