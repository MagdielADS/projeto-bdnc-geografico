
import dao.GeometriaDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fernando
 */
public class main {
    public static void main(String[] args) {
        GeometriaDAO geometriaDAO = new GeometriaDAO();
        try {
            System.out.println(geometriaDAO.getGeometriaMunicipio("São Paulo"));
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
