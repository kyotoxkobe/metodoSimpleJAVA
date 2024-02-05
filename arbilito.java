import java.util.Scanner;

public class arbilito {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		double arreglito[] = new double[5];
		for (int i = 0; i <= arreglito.length - 1; i++) {
			System.out.print("Ingrese los numeros a ordenar: ");
			arreglito[i] = input.nextDouble();
		}
		quicksort(arreglito, 0, arreglito.length - 1);
		for (int i = 0; i < arreglito.length; i++) {

			System.out.println(arreglito[i]);
		}

	}

	public static void intercambiar(double[] a, int i, int j) {
		double aux = a[i];
		a[i] = a[j];
		a[j] = aux;
	}

	public static void quicksort(double a[], int primero, int ultimo) {
		int i, j, central;
		double pivote;
		central = (primero + ultimo) / 2;
		pivote = a[central];
		i = primero;
		j = ultimo;
		do {
			while (a[i] < pivote)
				i++;
			while (a[j] > pivote)
				j--;
			if (i <= j) {
				intercambiar(a, i, j);
				i++;
				j--;
			}
		} while (i <= j);
		if (primero < j)
			quicksort(a, primero, j); // mismo proceso con sublista izqda
		if (i < ultimo)
			quicksort(a, i, ultimo); // mismo proceso con sublista drcha
	}
}
