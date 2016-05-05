/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author Patru Sorin
 */
@WebServlet(urlPatterns = {"/AddServlet"})
public class AddServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    String nume;
    String prenume ;
    String telefon_mobil ;
    String telefon_fix;
    String email ;
    String adresa;
    String oras ;
    String judet ;
    String cod_postal;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Introducerea datelor din formular in variabile
        
        nume = request.getParameter("nume");
        prenume = request.getParameter("prenume");
        telefon_mobil = request.getParameter("telefon_mobil");
        telefon_fix = request.getParameter("telefon_fix");
        email = request.getParameter("email");
        adresa = request.getParameter("adresa");
        oras = request.getParameter("oras");
        judet = request.getParameter("judet");
        cod_postal = request.getParameter("cod_postal");
        
        
        String url  = "jdbc:mysql://localhost:3306/agenda";
        String user = "persoana";
        String password = "persoana";
        
        try{
            
        //Incarcam driver?
        Class.forName("com.mysql.jdbc.Driver");
            
        //Realizeaza conexiunea la baza de date   
          Connection myConn = DriverManager.getConnection(url, user, password);  
        
        //Creem un statement
        Statement myStmt = myConn.createStatement();
        
        //TO DO: Introducerea datelor din variabile in baza de date
        
        String sql = "insert into contacte"
                         +"(nume, prenume, telefon_mobil, telefon_fix, email, adresa, oras, judet, cod_postal)"
                         +"values"
                         +"('"+nume+"','"+ prenume +"','"+ telefon_mobil +"','"+ telefon_fix +"','"+ email +"','"+ adresa 
                         +"','"+ oras +"','"+ judet +"','"+ cod_postal+"')";
        
        myStmt.executeUpdate(sql);
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
            out.println("<title>Servlet AddServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddServlet at " + telefon_mobil + "</h1>");
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
