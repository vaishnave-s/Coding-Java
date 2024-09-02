package DSA.Recursion;

class Main {
	public static int fibonacciSequence(int num) {
		if(num<2){
			return num;
		}
		return fibonacciSequence(num-1)+ fibonacciSequence(num-2);


	}

	public static void main(String args[]) {
		int num = 9;
		for(int i=0;i<num;i++){
			System.out.print(fibonacciSequence(i));

		}

	}
}