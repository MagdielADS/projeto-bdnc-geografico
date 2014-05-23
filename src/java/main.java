
import coordenadas.Coordenadas;
import dao.GeometriaDAO;
import dao.ViewBoxDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lerArquivo.LerArquivoXML;

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
        ViewBoxDAO viewBoxDAO = new ViewBoxDAO();
        try {
            Coordenadas coordenadas = geometriaDAO.getCoordenadasDeUmPonto("010100000067B5CBF5A44543C0E32EAD2479AD1BC0");
            System.out.println(coordenadas.getLatitude()+" "+coordenadas.getLongitude());
            LerArquivoXML lerArquivoXML = new LerArquivoXML(coordenadas);
            lerArquivoXML.lerAquivo();
            
            System.out.println(coordenadas.getLatitude()+" "+coordenadas.getLongitude());
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
