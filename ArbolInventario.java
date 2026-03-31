public class ArbolInventario {
    Producto raiz;

    public void insertar(int id, String nombre) {
        raiz = insertarRecursivo(raiz, id, nombre);
    }

    private Producto insertarRecursivo(Producto actual, int id, String nombre) {
        if (actual == null) return new Producto(id, nombre);
        if (id < actual.id) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, id, nombre);
        } else if (id > actual.id) {
            actual.derecho = insertarRecursivo(actual.derecho, id, nombre);
        }
        return actual;
    }

    // NUEVO: Método para buscar un producto por su ID
    public Producto buscar(Producto actual, int idBusqueda) {
        if (actual == null || actual.id == idBusqueda) {
            return actual;
        }
        if (idBusqueda < actual.id) {
            return buscar(actual.izquierdo, idBusqueda);
        }
        return buscar(actual.derecho, idBusqueda);
    }

    public void mostrarInorden(Producto nodo) {
        if (nodo != null) {
            mostrarInorden(nodo.izquierdo);
            System.out.println("ID: " + nodo.id + " - Producto: " + nodo.nombre);
            mostrarInorden(nodo.derecho);
        }
    }
}
