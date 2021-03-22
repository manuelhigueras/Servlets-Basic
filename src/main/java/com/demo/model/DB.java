package com.demo.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
public class DB {
    
    private static Map<Integer,Producto> productos;
    private static int ultimoId = 0;
    
    static{
        productos = new HashMap<Integer, Producto>();
        productos.put(1, new Producto(1, "Zapatos","Zapatos de ante",123.0, 10));
        productos.put(2, new Producto(2, "Corbata","Corbata seda ",63.0, 13));
        productos.put(3, new Producto(3, "Calcetines","Calcetines de algodón ",23.0, 44));
        ultimoId = 4;
    }

    private DB(){}

    public static synchronized Producto getProducto(Integer id){
        Producto p = productos.get(id);
        return p;
    }
    
    public static synchronized  void addProducto(Producto p ){
        p.setId(ultimoId++);
        productos.put(ultimoId, p);
    }
    
    public static synchronized Collection<Producto> getAllProductos(){
        return productos.values();
    }
    
    
}
