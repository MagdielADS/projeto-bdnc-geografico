/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import dao.GeometriaDAO;
import dao.ViewBoxDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fernando
 */
public class obterGeometria extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            GeometriaDAO geometriaDao = new GeometriaDAO();
            ViewBoxDAO viewBoxDAO = new ViewBoxDAO();
            String nomeGeometria = request.getParameter("nomeGeometria");
            String tipo = request.getParameter("tipo");
            String geometria = null;
            String viewBox = null;
            switch(tipo){
                case "municipio":
                    geometria = geometriaDao.getGeometriaMunicipio(nomeGeometria);
                    viewBox = viewBoxDAO.getViewBoxMunicipio(nomeGeometria);
                    break;
                case "estado":
                    geometria = geometriaDao.getGeometriaEstado(nomeGeometria);
                    viewBox = viewBoxDAO.getViewBoxEstado(nomeGeometria);
                    break;
                case "microrregiao":
                    geometria = geometriaDao.getGeometriaMicro(nomeGeometria);
                    viewBox = viewBoxDAO.getViewBoxMicro(nomeGeometria);
                    break;
                case "messorregiao":
                    geometria = geometriaDao.getGeometriaMeso(nomeGeometria);
                    viewBox = viewBoxDAO.getViewBoxMeso(nomeGeometria);
                    break;
                case "regiao":
                    geometria = geometriaDao.getGeometriaRegiao(nomeGeometria);
                    viewBox = viewBoxDAO.getViewBoxRegiao(nomeGeometria);
                    break;
            }
            request.setAttribute("geometria", geometria);
            request.setAttribute("nomeGeometria", nomeGeometria);
            request.setAttribute("viewBox", viewBox);
            request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            
        } catch (SQLException ex) {
            Logger.getLogger(obterGeometria.class.getName()).log(Level.SEVERE, null, ex);
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
