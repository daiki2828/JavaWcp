
public class 課題1_2 {

	public static void main(String[] args) {
		
		int d =0;
		
		for (int i=2; i<=100; i++) {
			if ( i%2 == 0 ) {
				d += i;
			}
		}
		System.out.println("2から100までの偶数の合計は" + d + "です。");

	}

}
