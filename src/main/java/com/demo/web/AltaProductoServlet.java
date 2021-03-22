/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.web;

import com.demo.model.DB;
import com.demo.model.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AltaProductoServlet", urlPatterns = {"/alta-nuevo-producto"})
public class AltaProductoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /*
        1. leer parametros  request.getParameter
        2. Validar  (null, o vacio)
        3. Convertir a su tipo , por ejemplo precio de STring a Double
        4. Crear un nuevo objeto Producto  con los dtos
        5. llamar a la bd a altaProducto
        6. Generar html de salida que ponga
               Has dado de alta un nuevo producto
               Ir a lista (enlace para ir a lista-producto

        */
        boolean valido = true;
        Producto producto;
        String nombre = request.getParameter("nombre");
        String desc = request.getParameter("descripcion");
        String sPrecio = request.getParameter("precio");
        String sCantidad = request.getParameter("stock");
        String[] colores = request.getParameterValues("colores");
        
        if(nombre == null || nombre.trim().length() == 0){
            valido = false;
        }
        
        if(desc == null || desc.trim().length() == 0){
            valido = false;
        }
        
        double precio = 0;
        int cantidad = 0;
        
        if(sPrecio == null || sPrecio.trim().length() == 0){
            valido = false;
        }else{
            try{
                 precio = Double.parseDouble(sPrecio);
            }catch(NumberFormatException e){
                valido = false;
            }
        }
        
        if(sCantidad == null || sCantidad.trim().length() == 0){
            valido = false;
        }else{
            try{
                cantidad = Integer.parseInt(sCantidad);
            }catch(NumberFormatException e){
                valido = false;
            }
        }
        
        if(colores == null){
            valido = false;
        }
        
        System.out.println("... aqui");
        if(valido){
            System.out.println("... creo el producto ");
            producto = new Producto(null, nombre,desc, precio, cantidad, colores);
            DB.addProducto(producto);
        }
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Alta</title>");            
            out.println("</head>");
            out.println("<body>");
            if(valido){
                out.println("<h1> Se ha dado de alta el producot " +  desc + " </h1>");
                out.println("<a href='lista-productos'>Ir a ver lista</a>");
            }else{
                out.println("<h1> No se pudo dar de alta. Datos incorrectos</h1>");
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }



    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
