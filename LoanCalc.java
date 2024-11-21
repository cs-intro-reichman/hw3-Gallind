// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {
	
	static double epsilon = 0.001;  // Approximation accuracy
	static int iterationCounter;    // Number of iterations 
	
	// Gets the loan data and computes the periodical payment.
    // Expects to get three command-line arguments: loan amount (double),
    // interest rate (double, as a percentage), and number of payments (int).  
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
		

		//System.out.println(endBalance(100000, 5, 10, Double.parseDouble(args[0])));
		//System.out.println(bruteForceSolver(epsilon, epsilon, iterationCounter, epsilon));
	}

	// Computes the ending balance of a loan, given the loan amount, the periodical
	// interest rate (as a percentage), the number of periods (n), and the periodical payment.
	private static double endBalance(double loan, double rate, int n, double payment) {	
		// Replace the following statement with your code
		double endingBalance = loan;
		for (int i = 0; i < n; i++){
			endingBalance = (endingBalance - payment) * (1 + rate / 100);
		}
		return endingBalance;
	}
	
	// Uses sequential search to compute an approximation of the periodical payment
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		// Replace the following statement with your code
		iterationCounter = 0;
		//epsilon = 101;
		double payment = loan / n;
		double amountAdd = 101;
		while (endBalance(loan, rate, n, payment) > epsilon){
			payment += epsilon;
			iterationCounter++;
		}
		return payment;
    }
    
    // Uses bisection search to compute an approximation of the periodical payment 
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
        // Replace the following statement with your code
		iterationCounter = 0;
		double L = loan / n;
		double H = loan;
		double g = (H + L) / 2;

		while ((H - L) > epsilon){
			if (endBalance(loan, rate, n, g) > 0){
				L = g;
				g = (H + L) / 2;
			}
			else {
				H = g;
				g = (H + L) / 2;
			}
			iterationCounter++;
		}

		return g;
    }
}