package org.example;


/** Clase Producto */
public class Articulo {
    String codigo;
    String nombre;
    double precio;
    int stock;
    boolean disponible;

    /**
     * Constructor
     * @param codigo Código único del producto
     * @param nombre Nombre del producto
     * @param precio Precio del producto
     * @param stock Cantidad disponible en stock
     */
    public Articulo(String codigo, String nombre, double precio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.disponible = stock > 0; // Inicialmente disponible si hay stock
    }

    /**
     * Intenta vender una cantidad del producto.
     * @param cantidadAVender Cantidad que se desea vender.
     * @return true si la venta se pudo realizar (hay stock suficiente y el producto está disponible).
     */
    public boolean venderProducto(int cantidadAVender) {
        boolean ventaExitosa = false;
        if (this.disponible && this.stock >= cantidadAVender && cantidadAVender > 0) {
            this.stock = this.stock - cantidadAVender;
            if (this.stock == 0) {
                this.disponible = false;
            }
            ventaExitosa = true;
        }
        return ventaExitosa;
    }

    /**
     * Incrementa el stock del producto.
     * @param cantidadAIncrementar Cantidad a añadir al stock.
     */
    public void reponerStock(int cantidadAIncrementar) {
        if (cantidadAIncrementar > 0) {
            this.stock = this.stock + cantidadAIncrementar;
            this.disponible = true; // Al reponer stock, el producto vuelve a estar disponible
        }
    }

    /**
     * Muestra la información del producto.
     * @return Cadena con el código, nombre, precio, stock y disponibilidad del producto.
     */
    public String mostrarInformacion() {
        return this.codigo + " - " + this.nombre + " - Precio: " + this.precio + "€ - Stock: " + this.stock + " - Disponible: " + (this.disponible ? "Sí" : "No");
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
        this.disponible = stock > 0;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}