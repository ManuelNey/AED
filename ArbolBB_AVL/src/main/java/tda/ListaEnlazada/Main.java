package tda.ListaEnlazada;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String rutaArchivo = "src/main/java/uy/edu/ucu/aed/tas/ta2/altas.txt";
        Almacen almacengue = new Almacen("SapeAlmacen", "ayer", "0999", GetAltas(rutaArchivo));
        System.out.println(almacengue.imprimirProductos());
        String rutaVentas= "src/main/java/uy/edu/ucu/aed/tas/ta2/ventas.txt";
        almacengue.listarOrdenadoPorNombre();
        //System.out.println(almacengue.ValorStock("src/main/java/uy/edu/ucu/aed/tas/ta2/altas.txt"));
    }

    public static Lista<IProducto> GetAltas(String rutaArchivo) {

        Lista<IProducto> listaProductos = new Lista<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;

            /*ste while recorre las filas del documento Altas.
            Por cada linea crea un producto y lo guarda en una List<Producto>.
            Si un item esta mal definido, es decir, no tiene 4 atributos separados por ",",
            entonces imprime un error en consola. */

            while ((linea = br.readLine()) != null) { // Lee línea por línea

                String[] partes = linea.split(",");    // Separa por comas

                if (partes.length == 4) {  // Asegura que haya 4 partes
                    String codigo = partes[0].trim();
                    String descripcion = partes[1].trim();
                    Integer precio = Integer.parseInt(partes[2].trim());
                    int cantidad = Integer.parseInt(partes[3].trim());

                    Producto newProduct = new Producto(codigo, cantidad, precio, descripcion);
                    listaProductos.insertar(newProduct, codigo);
                } else {
                    System.err.println("Item mal definido: " + linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaProductos;
    }
}
