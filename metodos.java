public class metodos {

    private static double[][] a; // TABLA AUXILIAR (DONDE EJECUTAMOS EL CODIGO)
    private static int m; // VARIABLES DE ENTORNO
    private static int n; // VALORES ORIGINALES DE LAS VARIABLES

    private static int[] basis;

    public metodos(double[][] A, double[] b, double[] c) {
        m = b.length;
        n = c.length;
        for (int i = 0; i < m; i++)
            if (!(b[i] >= 0))
                throw new IllegalArgumentException("no se puede resolver");

        a = new double[m + 1][n + m + 1];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = A[i][j];
        for (int i = 0; i < m; i++)
            a[i][n + i] = 1.0;
        for (int j = 0; j < n; j++)
            a[m][j] = c[j];
        for (int i = 0; i < m; i++)
            a[i][m + n] = b[i];

        basis = new int[m];
        for (int i = 0; i < m; i++)
            basis[i] = n + i;

        resolver();

    }

    private void resolver() {
        while (true) {

            int q = bland();
            if (q == -1)
                break;

            int p = valorMinimo(q);
            if (p == -1)
                throw new ArithmeticException("Imposible de resolver");

            pivote(p, q);

            basis[p] = q;
        }
    }

    public void pivote(int p, int q) {

        for (int i = 0; i <= m; i++)
            for (int j = 0; j <= m + n; j++)
                if (i != p && j != q)
                    a[i][j] -= a[p][j] * a[i][q] / a[p][q];

        for (int i = 0; i <= m; i++)
            if (i != p)
                a[i][q] = 0.0;

        for (int j = 0; j <= m + n; j++)
            if (j != q)
                a[p][j] /= a[p][q];          
        a[p][q] = 1.0;
    }

        public int bland() {
        for (int j = 0; j < m + n; j++)
            if (a[m][j] > 0)
                return j;
        return -1;
    }

    public int valorMinimo(int q) {
        int p = -1;
        for (int i = 0; i < m; i++) {

            if (a[i][q] <= 0)
                continue;
            else if (p == -1)
                p = i;
            else if ((a[i][m + n] / a[i][q]) < (a[p][m + n] / a[p][q]))
                p = i;
        }
        return p;
    }

    public double[] primal() {
        double[] x = new double[n];
        for (int i = 0; i < m; i++)
            if (basis[i] < n)
                x[basis[i]] = a[i][m + n];
        return x;
    }

    public static double valores() {
        return -a[m][m + n];
    }

    public double[] dual() {
        double[] y = new double[m];
        for (int i = 0; i < m; i++)
            y[i] = -a[m][n + i];
        return y;
    }

    public void test(double[][] A, double[] b, double[] c) {
        metodos lp;
        try {
            lp = new metodos(A, b, c);
        } catch (ArithmeticException e) {
            System.out.println(e);
            return;
        }

        System.out.println("resp = " + metodos.valores());
        double[] x = lp.primal();
        for (int i = 0; i < x.length; i++)
            System.out.println("x[" + i + "] = " + x[i]);
        double[] y = lp.dual();
        for (int j = 0; j < y.length; j++)
            System.out.println("y[" + j + "] = " + y[j]);
    }

    public void mostrarSolucion() {
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= m + n; j++) {
                System.out.println("[" + a[i][j] + "]");
            }
            System.out.println();
        }
        System.out.println("PRODUCIR: " + valores());
        for (int i = 0; i < m; i++)
            if (basis[i] < n)
                System.out.println("PARA OBTENER:  -->" + a[i][m + n]);
        System.out.println();
    }

}
