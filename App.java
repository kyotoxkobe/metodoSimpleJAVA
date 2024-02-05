import java.util.Scanner;

public class App {
    public static Scanner input = new Scanner(System.in);

    public static void cls() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void continuar() {
        input.nextLine();
        System.out.println("Pulse una tecla para continuar");
        input.nextLine();
    }

    public static void recorrerMatrizRec(double[][] m, int indice, int j) {
        System.out.print(m[indice][j] + " ");
        if (indice != m.length - 1 || j != m[indice].length - 1) {
            if (j == m[indice].length - 1) {
                indice++;
                j = 0;
                System.out.println("");
            } else {
                j++;
            }
            recorrerMatrizRec(m, indice, j);
        }

    }

    public static void main(String[] args) throws Exception {

        /*
         * double[][] restricciones = {
         * { 9, 3 },
         * { 5, 4 },
         * { 3, 2 },
         * };
         * 
         * double[] soluciones = { 150, 350, 500 };
         * double[] z = { 30, 12 };
         */

        // metodos simplex2 = new metodos(restricciones,z,soluciones);
        // simplex.test(matriz, solucionesArr, cantZz);
        ListaDoble lista = new ListaDoble();
        ListaDoble listaRes = new ListaDoble();
        ListaDoble listaZ = new ListaDoble();
        int filas = 0;
        int columnas = 0;

        double elementos;
        System.out.println("Ingresa la cantidad de filas & columnas");
        filas = input.nextInt();
        columnas = input.nextInt();
        double[][] matriz = new double[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Ingrese los valores de las restricciones: ");
                elementos = input.nextDouble();
                lista.insertarNodo(elementos);
                matriz[i][j] = elementos;
            }
        }
        cls();
        System.out.println("Ingresa la cantidad de soluciones: ");
        int solucioness = input.nextInt();
        double[] solucionesArr = new double[solucioness];
        for (int i = 0; i < solucioness; i++) {
            System.out.print("Ingrese las igualdades: ");
            double x = input.nextDouble();
            listaRes.insertarNodo(x);
            solucionesArr[i] = x;
        }
        cls();
        System.out.print("Ingresa la cantidad de z's:");
        int cantZ = input.nextInt();
        double[] cantZz = new double[cantZ];
        for (int i = 0; i < cantZ; i++) {
            System.out.print("z: ");
            double z = input.nextDouble();
            listaZ.insertarNodo(z);
            cantZz[i] = z;

        }
        recorrerMatrizRec(matriz, 0, 0);
        System.out.println("\n");

        while (true) {
            int opc = 0;
            System.out.println("  1. Ver solucion.");
            System.out.println("  2. Modificar variables. ");
            System.out.println("  3. Modificar");
            System.out.println("  4. Eliminar");
            System.out.println("  5. Mostrar");
            System.out.println("  6. Salir");
            System.out.print(" Escoja una Opción: ");
            opc = input.nextInt();
            switch (opc) {
                case 1:
                    cls();
                    metodos simplex = new metodos(matriz, solucionesArr, cantZz);
                    simplex.mostrarSolucion();
                    continuar();
                    cls();
                    break;
                case 2:
                    cls();
                    System.out.println("Modificar variables.");
                    System.out.println("1. Restricciones");
                    System.out.println("2. soluciones");
                    System.out.println("3. Valores de Z's");
                    int opcCase2 = input.nextInt();
                    switch (opcCase2) {
                        case 1:
                            recorrerMatrizRec(matriz, 0, 0);
                            System.out.println("-----------------");
                            System.out.print("Cantidad: ");
                            int cantidad = input.nextInt();
                            do {
                                System.out.print("Ingrese el elemento a modificar: ");
                                double modificar = input.nextDouble();
                                System.out.print("Ingrese el nuevo dato: ");
                                double modificar2 = input.nextDouble();
                                lista.modificarNodo(modificar, modificar2);
                                for (int i = 0; i < matriz.length; i++) {
                                    for (int j = 0; j < matriz.length; j++) {
                                        if (matriz[i][j] == modificar) {
                                            matriz[i][j] = modificar2;
                                        }

                                    }
                                }
                                cantidad--;
                            } while (cantidad != 0);
                            continuar();
                            cls();
                            // recorrerMatrizRec(matriz, 0, 0);
                            break;
                        case 2:
                            cls();
                            System.out.print("Cantidad: ");
                            cantidad = input.nextInt();
                            do {
                                System.out.print("Ingrese el elemento a modificar: ");
                                double modificar = input.nextDouble();
                                System.out.print("Ingrese el nuevo dato: ");
                                double modificar2 = input.nextDouble();
                                listaRes.modificarNodo(modificar, modificar2);
                                for (int i = 0; i < solucionesArr.length; i++) {
                                    if (solucionesArr[i] == modificar) {
                                        solucionesArr[i] = modificar2;
                                    }
                                }
                                cantidad--;
                            } while (cantidad != 0);
                            continuar();
                            cls();
                            break;
                            case 3:
                            cls();
                            System.out.print("Cantidad: ");
                            cantidad = input.nextInt();
                            do {
                                System.out.print("Ingrese el elemento a modificar: ");
                                double modificar = input.nextDouble();
                                System.out.print("Ingrese el nuevo dato: ");
                                double modificar2 = input.nextDouble();
                                listaZ.modificarNodo(modificar, modificar2);
                                for (int i = 0; i < cantZz.length; i++) {
                                    if (cantZz[i] == modificar) {
                                        cantZz[i] = modificar2;
                                    }
                                }
                                cantidad--;
                            } while (cantidad != 0);
                            continuar();
                            cls();
                            break;
                    }
                    continuar();
                    cls();
                    break;
                case 3:
                cls();
                System.out.println("Eliminar variables");
                System.out.println("1. Restricciones");
                System.out.println("2. soluciones");
                System.out.println("3. Valores de Z's");
                opcCase2 = input.nextInt();
                switch (opcCase2) {
                    case 1:
                        recorrerMatrizRec(matriz, 0, 0);
                        System.out.println("-----------------");
                        System.out.print("Cantidad: ");
                        int cantidad = input.nextInt();
                        do {
                            System.out.print("Ingrese el elemento a eliminar.: ");
                            double modificar = input.nextDouble();
                           /*  System.out.print("Ingrese el nuevo dato: ");
                            double modificar2 = input.nextDouble();*/
                            lista.modificarNodo(modificar,0.0);
                            lista.eliminar(modificar);
                            for (int i = 0; i < matriz.length; i++) {
                                for (int j = 0; j < matriz.length; j++) {
                                    if (matriz[i][j] == modificar) {
                                        matriz[i][j] =0.0;
                                    }

                                }
                            }
                            cantidad--;
                        } while (cantidad != 0);
                        continuar();
                        cls();
                        // recorrerMatrizRec(matriz, 0, 0);
                        break;
                    case 2:
                        cls();
                        System.out.print("Cantidad: ");
                        cantidad = input.nextInt();
                        do {
                            System.out.print("Ingrese el elemento a eliminar: ");
                            double modificar = input.nextDouble();
                            listaRes.eliminar(modificar);
                            listaRes.modificarNodo(modificar, 0.0);
                            for (int i = 0; i < solucionesArr.length; i++) {
                                if (solucionesArr[i] == modificar) {
                                    solucionesArr[i] = 0.0;
                                }
                            }
                            cantidad--;
                        } while (cantidad != 0);
                        continuar();
                        cls();
                        break;
                        case 3:
                        cls();
                        System.out.print("Cantidad: ");
                        cantidad = input.nextInt();
                        do {
                            System.out.print("Ingrese el elemento a eliminar: ");
                            double modificar = input.nextDouble();
                            
                            listaZ.modificarNodo(modificar, 0);
                            for (int i = 0; i < cantZz.length; i++) {
                                if (cantZz[i] == modificar) {
                                    cantZz[i] = 0.0;
                                }
                            }
                            cantidad--;
                        } while (cantidad != 0);
                        continuar();
                        cls();
                        break;
                }
                continuar();
                cls();
                 break;
                case 4:
                    cls();
                    System.out.println("\nEliminar un dato de la cola ");

                    continuar();
                    cls();
                    break;
                case 5:
                    cls();
                    System.out.println("\nMostrar la cola ");

                    continuar();
                    cls();
                    break;
                case 6:
                    cls();
                    System.out.println("\n Programa finalizado... ");
                    break;
                case 7:
                    System.out.println("\nIngresar una persona al sistema.");

                    continuar();
                    cls();
                    break;
                default:
                    cls();
                    System.out.println("\n Opcion No Valida ");
                    break;
            }
        }
    }
}
