
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
            Coordenadas coordenadas = geometriaDAO.getCoordenadasDeUmPonto("010100000069FA4054579D41C0B80370CC5E3617C0");
            LerArquivoXML lerArquivoXML = new LerArquivoXML(coordenadas);
            Previsao previsao = lerArquivoXML.lerAquivoRtornandoPrevisao();

            System.out.println(previsao.getNomeCidade());
            System.out.println(previsao.getUf());
            System.out.println("Datas");
            for (int i = 0; i < previsao.getListaDadosPrevisao().size();i++) {
                System.out.println(previsao.getListaDadosPrevisao().get(i).getData());
                System.out.println(previsao.getListaDadosPrevisao().get(i).getTempo());
                System.out.println(previsao.getListaDadosPrevisao().get(i).getMaxima());
                System.out.println(previsao.getListaDadosPrevisao().get(i).getMinima());
                System.out.println(previsao.getListaDadosPrevisao().get(i).getIuv());
            }

        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
