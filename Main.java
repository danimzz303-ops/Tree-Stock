import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArbolInventario arbol = new ArbolInventario();
        Scanner leer = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- SISTEMA TREE-STOCK ---");
            System.out.println("1. Registrar Producto");
            System.out.println("2. Mostrar Inventario (Inorden)");
            System.out.println("3. Buscar Producto por ID");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = leer.nextInt();

            if (opcion == 1) {
                System.out.print("ID: "); int id = leer.nextInt();
                System.out.print("Nombre: "); String nom = leer.next();
                arbol.insertar(id, nom);
            } else if (opcion == 2) {
                System.out.println("\n--- INVENTARIO ---");
                arbol.mostrarInorden(arbol.raiz);
            } else if (opcion == 3) {
                System.out.print("Ingrese ID a buscar: ");
                int idBusqueda = leer.nextInt();
                Producto encontrado = arbol.buscar(arbol.raiz, idBusqueda);
                if (encontrado != null) {
                    System.out.println("¡Encontrado!: " + encontrado.nombre);
                } else {
                    System.out.println("El producto no existe.");
                }
            }
        } while (opcion != 0);
        
        leer.close();
    }
}