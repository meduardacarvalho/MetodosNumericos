public class SistemaLineargaussSeidel {
    public static void main(String[] args) {
        
        double[][] A = {
            {5, 1, 1},
            {3, 4, 1},
            {3, 3, 6}
        };
        double[] b = {5, 6, 0};
        
    
        double[] x = {0, 0, 0};
        
        double tol = 0.0001;
        int maxIter = 100;
        
        double[] solucao = gaussSeidel(A, b, x, tol, maxIter);
        
        
        if (solucao != null) {
            System.out.println("Solução:");
            for (int i = 0; i < solucao.length; i++) {
                System.out.println("x[" + i + "] = " + solucao[i]);
            }
        } else {
            System.out.println("O método não convergiu.");
        }
    }
    

    public static double[] gaussSeidel(double[][] A, double[] b, double[] x, double tol, int maxIter) {
        int n = A.length;
        double[] xAnt = new double[n];
        
        for (int k = 0; k < maxIter; k++) {
          
            System.arraycopy(x, 0, xAnt, 0, n);
            
           
            for (int i = 0; i < n; i++) {
                double soma = 0.0;
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        soma += A[i][j] * x[j];
                    }
                }
                x[i] = (b[i] - soma) / A[i][i];
            }
            
            
            double norma = 0.0;
            for (int i = 0; i < n; i++) {
                norma += Math.pow(x[i] - xAnt[i], 2);
            }
            if (Math.sqrt(norma) < tol) {
                return x;
            }
        }
        return null; 
    }
}
