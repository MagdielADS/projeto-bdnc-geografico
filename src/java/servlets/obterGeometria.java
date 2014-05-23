/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import coordenadas.Coordenadas;
import dao.GeometriaDAO;
import dao.ViewBoxDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mapa.Mapa;

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
            GeometriaDAO geometriaDAO = new GeometriaDAO();
            ViewBoxDAO viewBoxDAO = new ViewBoxDAO();
            String nomeGeometria = request.getParameter("nomeGeometria");
            String tipo = request.getParameter("tipo");
            String viewBox = null;
            Mapa mapa = null;
            Coordenadas coordenadas;
            switch(tipo){
                case "municipio":
                    mapa = geometriaDAO.getMapaMunicipio(nomeGeometria);
                    viewBox = viewBoxDAO.getTamanhoViewBox(mapa.getGeometria());
                    
                    break;
                case "estado":
                    mapa = geometriaDAO.getMapaEstado(nomeGeometria);
                    viewBox = viewBoxDAO.getTamanhoViewBox(mapa.getGeometria());
                    break;
                case "microrregiao":
                    mapa = geometriaDAO.getMapaMicro(nomeGeometria);
                    viewBox = viewBoxDAO.getTamanhoViewBox(mapa.getGeometria());
                    break;
                case "messorregiao":
                    mapa = geometriaDAO.getMapaMeso(nomeGeometria);
                    viewBox = viewBoxDAO.getTamanhoViewBox(mapa.getGeometria());
                    break;
                case "regiao":
                    mapa = geometriaDAO.getMapaRegiao(nomeGeometria);
                    viewBox = viewBoxDAO.getTamanhoViewBox(mapa.getGeometria());
                    break;
            }
            request.setAttribute("geometria", mapa.getGeometriaSVG());
            request.setAttribute("nomeGeometria", mapa.getNome());
            request.setAttribute("viewBox", viewBox);
            request.setAttribute("desenharGeometria", true);
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
