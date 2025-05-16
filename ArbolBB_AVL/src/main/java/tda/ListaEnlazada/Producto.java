package tda.ListaEnlazada;

public class Producto implements IProducto {

    private String nombre;
    private Integer stock;
    private Integer precio;
    private String descripcion;
    private String codigo;

    public Producto(String nombre, Integer stock, Integer precio, String etiqueta) {
        this.nombre = nombre;
        this.codigo = etiqueta;
        this.precio = precio;
        this.stock = stock;
    }


    public Comparable getCodProducto(){
        return this.codigo;
    }


    public Integer getPrecio(){
        return this.precio;
    }

    public void setPrecio(Integer precio){
        this.precio = precio;
    }


    public Integer getStock(){
        return this.stock;
    }

    public void setStock(Integer stock){
        this.stock = stock;
    }

    public Boolean agregarCantidadStock(Integer nuevoStock){
        this.stock += nuevoStock;
        return true;
    }

    public void restarCantidadStock(Integer stock){
        this.stock -= stock;
    }


    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getDescripcion(){
        return this.descripcion;
    }

    public String getCodigo(){
        return this.codigo;
    }
}
