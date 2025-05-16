package tda.ListaEnlazada;
//
import tda.utils.ManejadorArchivosGenerico;

public class Almacen implements IAlmacen {

    private String nombre;
    private String direccion;
    private String telefono;
    private Lista<IProducto> lista;//Lo cambie de Producto a IProducto porque lo que retorna el metodo getListaProductos de IAlmacen retorn IProducto

    public Almacen(String nombre, String direccion, String telefono, Lista<IProducto> productos) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.lista = productos;
    }


    public String getDireccion(){
        return this.direccion;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public String getTelefono(){
        return this.telefono;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    public String getNombre(){
        return this.nombre;
    }

    public Lista<IProducto> getListaProductos(){
        return this.lista;
    }

    /**
     * Incorporar un nuevo producto al supermercado.
     *
     * @param unProducto
     */
    public void insertarProducto(IProducto unProducto) {
        if(lista.buscar(unProducto.getCodProducto()) == null){//Para evitar duplicados
            lista.insertar(unProducto, unProducto.getNombre());
            }
        else{
            agregarStock(unProducto.getCodProducto(), unProducto.getStock());
        }
        }

        /**
         * Eliminar productos que ya no se venden (por no ser comercializados m�s).
         *
         * @param
         * @return
         */
        public boolean eliminarProducto(Comparable codProducto){
            return lista.eliminar(codProducto);
        }

        /**
         * Imprime la lista de productos
         *
         * @return
         */
        public String imprimirProductos () {
            return lista.imprimir();
        }

        /**
         * Dado un separador ej.:",", ";", imprime los productos separados por tal
         * caracter
         *
         * @param separador
         * @return
         */
        public String imprimirSeparador (String separador){
            return lista.imprimir(separador);
        }

        /**
         * Agregar stock a un producto existente.
         *
         * @param
         * @param cantidad
         * @return
         */
        public Boolean agregarStock (Comparable codProducto, Integer cantidad){
            IProducto producto = buscarPorCodigo(codProducto);
            if(producto != null){
                producto.setStock(producto.getStock() + cantidad);
                return true;
            }
            return false;
        }

        /**
         * Simular la venta de un producto (reducir el stock de un producto
         * existente
         *
         * @param clave
         * @param cantidad
         * @return
         */
        public Integer restarStock(Comparable clave, Integer cantidad){
            IProducto producto = buscarPorCodigo(clave);
            if(producto != null){
                producto.setStock(producto.getStock() - cantidad);
                if(producto.getStock() < 0){
                    producto.setStock(0);
                }
            }
            else{
                return null;
            }
            return producto.getStock();
        }

        /**
         * Dado un código de producto, indicar las existencias del mismo en el
         * almac�n.
         *
         * @param
         * @return
         */
        public IProducto buscarPorCodigo (Comparable codProducto){
            return lista.buscar(codProducto);
        }

        /**
         * Listar todos los productos registrados, ordenados por nombre, presentando
         * adem�s su stock. Imprime por consola la lista de todos los productos
         * registrados y su stock actual.
         */
        public void listarOrdenadoPorNombre() {
            ListaOrdenada<IProducto> listaOrdenada = new ListaOrdenada<>();

            Lista<IProducto>.Nodo actual = lista.getPrimero();
            while (actual != null) {
                IProducto producto = (IProducto) actual.getDato();

                // Verificamos si el producto es null antes de insertarlo
                if (producto != null) {
                    listaOrdenada.insertar(producto, producto.getNombre());
                } else {
                    System.err.println("Producto nulo encontrado, no se insertará en la lista ordenada.");
                }

                actual = actual.getSiguiente();
            }

            Lista<IProducto>.Nodo nodo = listaOrdenada.getPrimero();
            while (nodo != null) {
                IProducto producto = (IProducto) nodo.getDato();

                // Verificamos si el producto es null antes de intentar acceder a sus propiedades
                if (producto != null) {
                    System.out.println(producto.getNombre() + " - Stock: " + producto.getStock());
                } else {
                    System.err.println("Producto nulo encontrado en la lista ordenada.");
                }

                nodo = nodo.getSiguiente();
            }
        }
            /**
             * Busca un producto por su descripci�n.
             *
             * @param descripcion
             * @return
             */
            public IProducto buscarPorDescripcion(String descripcion){
                Lista<IProducto>.Nodo actual = lista.getPrimero();
                while (actual != null) {
                    IProducto producto = (IProducto) actual.getDato();
                    if (producto.getDescripcion() != null && producto.getDescripcion().equals(descripcion)) {
                        return producto;
                    }
                    actual = actual.getSiguiente();
                }
                return null;
            }

            /**
             * Retorna el tama�o del almacen: cantidad de productos. No es lo mismo que
             * el total de stock, sino que ser�a en definitiva el tama�o de la lista.
             *
             * @return
             */
            public int cantidadProductos () {
                return lista.cantElementos();
            }


            public int ValorStock (String ruta){
                ManejadorArchivosGenerico manejadorArchivosGenerico = new ManejadorArchivosGenerico();
                String[] listaValorStock = manejadorArchivosGenerico.leerArchivo(ruta);
                int suma = 0;
                for (String linea : listaValorStock) {
                    String[] elementos = linea.split(",");
                    String codigo = elementos[0];
                    int cantidad = Integer.parseInt(elementos[3]);
                    int precio = Integer.parseInt(elementos[2]);
                    suma += cantidad * precio;
                    buscarPorCodigo(codigo).agregarCantidadStock(cantidad);
                }
                return suma;
            }

        }



