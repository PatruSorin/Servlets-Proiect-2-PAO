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
@WebServlet(urlPatterns = {"/EditServlet"})
public class EditServlet extends HttpServlet {

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
    
    String nume_search;
    String prenume_search;
           
        try{
        //Introducerea dateleor din formularul de cautare a persoanei ce trebuie editata
        nume_search=request.getParameter("nume_search");
        prenume_search=request.getParameter("prenume_search");
            
            
        String url  = "jdbc:mysql://localhost:3306/agenda";
        String user = "persoana";
        String password = "persoana";
            
        //Incarcam driver
        Class.forName("com.mysql.jdbc.Driver");
            
        //Realizeaza conexiunea la baza de date   
          Connection myConn = DriverManager.getConnection(url, user, password);  
        
        //Creem un statement
        Statement myStmt = myConn.createStatement();
        
       
        
        //Cauta in baza de date valorile din variabile
        
        String sql = "select * from contacte where "
                    +"nume='"+nume_search+"' and prenume='"+prenume_search+"'";
                    
        ResultSet myRs = myStmt.executeQuery(sql);
        
        
        //Introducerea datelor din formularul de editare in variabile
        
        nume = request.getParameter("nume");
        if(nume.isEmpty())
            nume=myRs.getString("nume");
        
        
        prenume = request.getParameter("prenume");
        if(prenume.isEmpty())
            prenume=myRs.getString("prenume");
        
        
        telefon_mobil = request.getParameter("telefon_mobil");
        if(telefon_mobil.isEmpty())
            telefon_mobil=myRs.getString("telefon_mobil");
        
        
        telefon_fix = request.getParameter("telefon_fix");
        if(telefon_fix.isEmpty())
            telefon_fix=myRs.getString("telefon_fix");
        else if(telefon_fix.equals("-"))
              telefon_fix="";
        
        email = request.getParameter("email");
        if(email.isEmpty())
            email=myRs.getString("email");
        
        
        adresa = request.getParameter("adresa");
        if(adresa.isEmpty())
            adresa=myRs.getString("adresa");
        else if(adresa.equals("-"))
              adresa="";
        
        oras = request.getParameter("oras");
        if(oras.isEmpty())
            oras=myRs.getString("oras");
        else if(oras.equals("-"))
              oras="";
        
        judet = request.getParameter("judet");
        if(judet.isEmpty())
            judet=myRs.getString("judet");
        else if(judet.equals("-"))
              judet="";
        
        cod_postal = request.getParameter("cod_postal");
        if(cod_postal.isEmpty())
            cod_postal=myRs.getString("cod_postal");
        else if(cod_postal.equals("-"))
              cod_postal="";
        
        //Modificam datele in tabel
        
        sql="update contacte set "
            +"nume='"+nume+"' , prenume='"+prenume+"' , telefon_mobil= '"+telefon_mobil+"' "
            +", telefon_fix='"+telefon_fix+"' , email='"+email+"' , oras='"+oras+"' "
            +", judet='"+judet+"' , cod_postal='"+cod_postal+"' , adresa='"+adresa+"' "
            +"where nume='"+nume_search+"' and prenume='"+prenume_search+"'";
        
        myStmt.executeUpdate(sql);
        
        }
        catch(ClassNotFoundException | SQLException exc){
        
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Modificari realizate cu succes!</h1>");
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
