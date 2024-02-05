import java.util.Scanner;

public class ListaDoble {
    Scanner input = new Scanner (System.in);
    Nodo primero;
    Nodo ultimo;
    public ListaDoble(){
        primero = null;
        ultimo= null;
    }
    public void insertarNodo(double dato){
       Nodo nuevo  = new Nodo ();
       nuevo.dato = dato;
       if (primero == null){
        primero = nuevo;
        primero.siguiente = null;
        primero.anterior = null;
        ultimo = primero;
       }else{
        ultimo.siguiente = nuevo;
        nuevo.anterior = ultimo;
        nuevo.siguiente = null;
        ultimo = nuevo;
       }
    }
    public void buscarNodo(double dato){
        Nodo actual = new Nodo();
        actual = primero;
        while (actual != null){
            if(actual.dato == dato){
                System.out.println("Variable encontrada.");
            }else{
                //System.out.println("No existe el elemento.");
            }
            actual = actual.siguiente;
        }
    }
    public void eliminar(double dato){
        Nodo actual = new Nodo();
        actual = primero;
        while (actual != null){
            if(actual.dato == dato){
               actual.dato = 0.0;
            }else{
                System.out.println("No existe el elemento.");
            }
            actual = actual.siguiente;
        }
    }
    public void modificarNodo(double dato, double datoMod){
        Nodo actual = new Nodo();
        actual = ultimo;
        while (actual != null){
            if (actual.dato == dato){
                //System.out.print("Ingrese el nuevo valor: ");
                actual.dato = datoMod;
            }else{
                //System.out.println("Ha ocurrido un error al modificar Nodo");
            }
            actual = actual.anterior;
        }
    }
}
