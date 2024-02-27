public class GaussJacobi {
    public static void main(String[] args) {

        double[][] A = {
            {5, 1, 1},
            {3, 4, 1},
            {3, 3, 6}
        };
        double[] b = {5, 6, 0};
        
      
        double[] initialGuess = {0, 0, 0};
        
       
        double tol = 0.0001;
        int maxIter = 100;
        
       
        double[] solution = gaussJacobi(A, b, initialGuess, tol, maxIter);
       
        if (solution != null) {
            System.out.println("Solução:");
            for (int i = 0; i < solution.length; i++) {
                System.out.println("x[" + i + "] = " + solution[i]);
            }
        } else {
            System.out.println("O Método de Gauss-Jacobi não convergiu.");
        }
    }
    
    
    public static double[] gaussJacobi(double[][] A, double[] b, double[] initialGuess, double tol, int maxIter) {
        int n = A.length;
        double[] previousValues = new double[n];
        double[] currentValues = initialGuess.clone();
        double[] nextValues = new double[n];
        for (int iter = 0; iter < maxIter; iter++) {
     
            for (int i = 0; i < n; i++) {
                previousValues[i] = currentValues[i];
            }
         
            for (int i = 0; i < n; i++) {
                double sum = 0;
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        sum += A[i][j] * previousValues[j];
                    }
                }
                nextValues[i] = (b[i] - sum) / A[i][i];
            }
          
            double maxDiff = 0;
            for (int i = 0; i < n; i++) {
                double diff = Math.abs(nextValues[i] - previousValues[i]);
                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            }
            
            if (maxDiff < tol) {
                return nextValues;
            }
            
           
            for (int i = 0; i < n; i++) {
                currentValues[i] = nextValues[i];
            }
        }
        
       
        return null;
    }
}
