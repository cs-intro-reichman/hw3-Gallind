// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	   /* System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6   
		*/ 
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		// Replace the following statement with your code
		for (int i = 0; i < x2; i++){
			x1++;
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		// Replace the following statement with your code
		for (int i = 0; i < x2; i++){
			x1--;
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
        // Replace the following statement with your code
		int firstX1 = x1;
		for (int i = 1; i < x2; i++){

			x1 = plus(x1, firstX1);
		}
		return x1;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		// Replace the following statement with your code
		int solution = 1;
		for (int i = 0; i < n; i++){
			solution = times(solution, x);
		}
		return solution;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
        // Replace the following statement with your code
		int solution = 0;
		while (x1 >= x2){
			solution++;
			x1 = minus(x1, x2);
		}
		return solution;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
        // Replace the following statement with your code
		int solution;
		solution = minus(x1, times(x2, div(x1, x2)));
		return solution;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
        // Replace the following statement with your code
		int i = 0;

        while (times((plus(i, 1)), (plus(i, 1))) <= x) {
            i++;
        }

        // Compare i and i + 1 to find the closer one
        int diff1 = minus(x, times(i, i));             // Difference with i^2
        int diff2 = minus(times(plus(i, 1), plus(i, 1)), x); // Difference with (i + 1)^2

        if (diff1 <= diff2) {
            return i;
        } else {
            return i++;
        }

		
	}	  	  
}