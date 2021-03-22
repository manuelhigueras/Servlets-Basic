package com.demo.model;

public class Producto {
    
    //ATRIBUTOS
    private Integer id;
    private String  nombre;
    private String  descripcion;
    private Double  precio;
    private Integer stock;
    private String[] colores;
    
    //CONSTRUCTORES
    public Producto(Integer id, String nombre, String descripcion, Double precio, Integer stock, String[] colores) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.colores = colores;
    }
   
     public Producto(Integer id, String nombre, String descripcion, 
             Double precio, Integer stock) {
        this(id, nombre, descripcion, precio, stock,
                null);
        String[] coloresIni = {"rojo", "azul", "blanco"};
        this.colores = coloresIni;
        
    }
    
    //GETTERS Y SETTERS

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String[] getColores() {
        return colores;
    }

    public void setColores(String[] colores) {
        this.colores = colores;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", stock=" + stock + ", colores=" + colores + '}';
    }
    
    

}
