package practice;

//・1から100までの数を出力する
//・3の倍数の場合は、数字の代わりに”Fizz”と出力する
//・5の倍数の場合は、数字の代わりに”Buzz”と出力する
//・3の倍数であり、かつ、5の倍数の場合には”FizzBuzz”と出力する

public class FizzBazz {
	public static void main(String[] args) {
		
		for (int number=1; number<=100; number++) {
			if (number%3 == 0 && number%5 == 0) {
				System.out.println("FizzBuzz");
			} else if (number%5 == 0) {
				System.out.println("Buzz");
			} else if(number%3 == 0 ) {
				System.out.println("Fizz");
			} else {
				System.out.println(number);
			}
		}
	}
}
