
import coordenadas.Coordenadas;
import dao.GeometriaDAO;
import dao.ViewBoxDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lerArquivo.LerArquivoXML;
import previsao.Previsao;

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
            LerArquivoXML lerArquivoXML = new LerArquivoXML(coordenadas);
            Previsao previsao = lerArquivoXML.lerAquivoRtornandoPrevisao();
            
            System.out.println(previsao.getNomeCidade());
            System.out.println(previsao.getUf());
            System.out.println("Datas");
            for (int i = 0; i < previsao.getDatas().size(); i++) {
                System.out.println(previsao.getDatas().get(i));
            }
            
            System.out.println("Tempos");
            for (int i = 0; i < previsao.getTempos().size(); i++) {
                System.out.println(previsao.getTempos().get(i));
            }
            
            System.out.println("Maximas");
            for (int i = 0; i < previsao.getMaximas().size(); i++) {
                System.out.println(previsao.getMaximas().get(i));
            }
            
            System.out.println("Minimas");
            for (int i = 0; i < previsao.getMinimas().size(); i++) {
                System.out.println(previsao.getMinimas().get(i));
            }
            
            System.out.println("Iuvs");
            for (int i = 0; i < previsao.getIuvs().size(); i++) {
                System.out.println(previsao.getIuvs().get(i));
            }

        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
