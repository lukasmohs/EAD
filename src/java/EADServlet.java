/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lukasmohs
 */
@WebServlet(name = "EADServlet",
        urlPatterns = {"/submit"})
public class EADServlet extends HttpServlet {
    
    /**
     * Method that handels incoming get requests
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        

        RequestDispatcher view;

        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String age = request.getParameter("age");
        Connection conn = null;
        Statement stmt = null;
        
        try {
                    Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            
            conn = DriverManager.getConnection(url, "liferay", "liferay");
            stmt = conn.createStatement();
      
            String sql = "CREATE TABLE IF NOT EXISTS EAD " +
                   "(id INTEGER not NULL AUTO_INCREMENT, " +
                   " first VARCHAR(255), " + 
                   " last VARCHAR(255), " + 
                   " age INTEGER, " + 
                   " PRIMARY KEY ( id ))"; 

            stmt.executeUpdate(sql);
            
            Statement stmt2 = conn.createStatement();
      
            sql = "INSERT INTO EAD " +
                   "VALUES (NULL, '" + firstName + "', '" + lastName + "'," + age + ")";
            stmt2.executeUpdate(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(EADServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EADServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        view = request.getRequestDispatcher("results.jsp");
        view.forward(request, response);
        
    }
}
