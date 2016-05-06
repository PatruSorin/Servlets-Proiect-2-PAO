/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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
@WebServlet(urlPatterns = {"/SearchServlet"})
public class SearchServlet extends HttpServlet {

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
        
    String nume;
    String prenume ;
    String telefon_mobil ;
    String telefon_fix;
    String email ;
    String adresa;
    String oras ;
    String judet ;
    String cod_postal;
        
     //Introducerea datelor din formular in variabile
        
        nume = request.getParameter("nume");
        if(nume.isEmpty())
            nume="null";
        
        prenume = request.getParameter("prenume");
        if(prenume.isEmpty())
            prenume="null";
        
        telefon_mobil = request.getParameter("telefon_mobil");
        if(telefon_mobil.isEmpty())
            telefon_mobil="null";
        
        telefon_fix = request.getParameter("telefon_fix");
        if(telefon_fix.isEmpty())
            telefon_fix="null";
        
        email = request.getParameter("email");
        if(email.isEmpty())
            email="null";
        
        adresa = request.getParameter("adresa");
        if(adresa.isEmpty())
            adresa="null";
        
        oras = request.getParameter("oras");
        if(oras.isEmpty())
            oras="null";
        
        judet = request.getParameter("judet");
        if(judet.isEmpty())
            judet="null";
        
        cod_postal = request.getParameter("cod_postal");
        if(cod_postal.isEmpty())
            cod_postal="null";
        
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
        
       
        
        //Cauta in baza de date valorile din variabile
        
        String sql = "select * from contacte where "
                    +"nume='"+nume+"' or prenume='"+prenume+"' or telefon_mobil= '"+telefon_mobil+"'"
                    +"or telefon_fix='"+telefon_fix+"' or email='"+email+"' or oras='"+oras+"'"
                    +"or judet='"+judet+"' or cod_postal='"+cod_postal+"'";
        
        ResultSet myRs = myStmt.executeQuery(sql);
        
        
        
        
    //TO DO: Afiseaza rezultatele cautarii    
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SearchServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Rezultate cautare:</h1>");
            
            //Tabel cu rezultatele obtinute
            out.println("<table border=\"1\" style=\"width:100%\">");
            
            out.println("<tr>");
            out.println("<th>Nume</th>");
            out.println("<th>Prenume</th>");
            out.println("<th>Telefon mobil</th>");
            out.println("<th>Telefon fix</th>");
            out.println("<th>Email</th>");
            out.println("<th>Adresa</th>");
            out.println("<th>Oras</th>");
            out.println("<th>Judet</th>");
            out.println("<th>Cod postal</th>");
            out.println("</tr>");
            
            while(myRs.next()){
            out.println("<tr>");
            out.println("<td>"+myRs.getString("nume")+"</td>");
            out.println("<td>"+myRs.getString("prenume")+"</td>");
            out.println("<td>"+myRs.getString("telefon_mobil")+"</td>");
            out.println("<td>"+myRs.getString("telefon_fix")+"</td>");
            out.println("<td>"+myRs.getString("email")+"</td>");
            out.println("<td>"+myRs.getString("adresa")+"</td>");
            out.println("<td>"+myRs.getString("oras")+"</td>");
            out.println("<td>"+myRs.getString("judet")+"</td>");
            out.println("<td>"+myRs.getString("cod_postal")+"</td>");
            out.println("</tr>");
            }
          
 
            out.println("</table>");
        
            out.println("</body>");
            out.println("</html>");
        }
        
        }
        catch(ClassNotFoundException | SQLException exc){
        
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
