/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Patru Sorin
 */
@WebServlet(urlPatterns = {"/DeleteServlet"})
public class DeleteServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         //Introducerea datelor din formular in variabile
        
        String nume = request.getParameter("nume");
        String prenume = request.getParameter("prenume");
        String telefon_mobil = request.getParameter("telefon_mobil");
        
        
        
        
        String url  = "jdbc:mysql://localhost:3306/agenda";
        String user = "persoana";
        String password = "persoana";
        
        try{
            
        //Incarcam driver
        Class.forName("com.mysql.jdbc.Driver");
            
        //Realizeaza conexiunea la baza de date   
          Connection myConn = DriverManager.getConnection(url, user, password);  
        
        //Creem un statement
        Statement myStmt = myConn.createStatement();
        
        //Stergerea datelor din baza de date
        
        String sql;
          
      
        
        if( !nume.equals("")){
            if( !prenume.equals("")){
                sql="delete from contacte where prenume='"+ prenume +"' and nume='"+nume+"'";
                myStmt.executeUpdate(sql);
                }
            else{
                sql="delete from contacte where nume='"+nume+"'";
                myStmt.executeUpdate(sql);
            }
                
            }
        else if( !prenume.equals("")){
            sql="delete from contacte where prenume='"+ prenume +"'";
            myStmt.executeUpdate(sql);
        }
        
        if( !telefon_mobil.equals(""))
            {     
            sql="delete from contacte where telefon_mobil='"+ telefon_mobil +"'" ;
            myStmt.executeUpdate(sql);
            }
        
        }
        catch(Exception exc){
        
        }
        
        
        //Mesaj afisat utilizatorului
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DeleteServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Datele au fost sterse cu succes!</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
