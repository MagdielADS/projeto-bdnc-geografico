/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Fernando
 */
public class ViewBoxDAO {
    
    public ViewBoxDAO(){
        
    }   
//    
//    public String getViewBoxMunicipio(String nomeMunicipio) throws SQLException{
//        String sql = "SELECT CAST(ST_xmin(box2d(ST_Envelope(the_geom))) as varchar) || ' ' || "
//                + "CAST(ST_ymax(box2d(ST_Envelope(the_geom))) * -1 as varchar) || ' ' || "
//                + "CAST(ST_xmax(box2d(ST_Envelope(the_geom))) - ST_xmin(box2d(ST_Envelope(the_geom))) as varchar) || ' ' || "
//                + "CAST(ST_ymax(box2d(ST_Envelope(the_geom))) - ST_ymin(box2d(ST_Envelope(the_geom))) as varchar) AS viewBox "
//                + "FROM municipio WHERE nome_municipio = ?";
//        String viewBox = null;
//        Connection connection = ConnectionFactory.getInstance().getConnection();
//        try{
//           PreparedStatement stmt = connection.prepareStatement(sql);
//           stmt.setString(1, nomeMunicipio);
//           ResultSet resultSet = stmt.executeQuery();
//           resultSet.next();
//           viewBox = resultSet.getString("viewBox");
//        }finally{
//            connection.close();
//        }
//        return viewBox;
//    }
//    
//    public String getViewBoxEstado(String siglaEstado) throws SQLException{
//        String sql = "SELECT CAST(ST_xmin(box2d(ST_Envelope(the_geom))) as varchar) || ' ' || "
//                + "CAST(ST_ymax(box2d(ST_Envelope(the_geom))) * -1 as varchar) || ' ' || "
//                + "CAST(ST_xmax(box2d(ST_Envelope(the_geom))) - ST_xmin(box2d(ST_Envelope(the_geom))) as varchar) || ' ' || "
//                + "CAST(ST_ymax(box2d(ST_Envelope(the_geom))) - ST_ymin(box2d(ST_Envelope(the_geom))) as varchar) AS viewBox "
//                + "FROM estado WHERE sigla_estado = ?";
//        String viewBox = null;
//        Connection connection = ConnectionFactory.getInstance().getConnection();
//        try{
//           PreparedStatement stmt = connection.prepareStatement(sql);
//           stmt.setString(1, siglaEstado);
//           ResultSet resultSet = stmt.executeQuery();
//           resultSet.next();
//           viewBox = resultSet.getString("viewBox");
//        }finally{
//            connection.close();
//        }
//        return viewBox;
//    }
//    
//    public String getViewBoxMicro(String nomeMicro) throws SQLException{
//        String sql = "SELECT CAST(ST_xmin(box2d(ST_Envelope(the_geom))) as varchar) || ' ' || "
//                + "CAST(ST_ymax(box2d(ST_Envelope(the_geom))) * -1 as varchar) || ' ' || "
//                + "CAST(ST_xmax(box2d(ST_Envelope(the_geom))) - ST_xmin(box2d(ST_Envelope(the_geom))) as varchar) || ' ' || "
//                + "CAST(ST_ymax(box2d(ST_Envelope(the_geom))) - ST_ymin(box2d(ST_Envelope(the_geom))) as varchar) AS viewBox "
//                + "FROM microrregiao WHERE nome_micro = ?";
//        String viewBox = null;
//        Connection connection = ConnectionFactory.getInstance().getConnection();
//        try{
//           PreparedStatement stmt = connection.prepareStatement(sql);
//           stmt.setString(1, nomeMicro);
//           ResultSet resultSet = stmt.executeQuery();
//           resultSet.next();
//           viewBox = resultSet.getString("viewBox");
//        }finally{
//            connection.close();
//        }
//        return viewBox;
//    }
//    
//    public String getViewBoxMeso(String nomeMeso) throws SQLException{
//        String sql = "SELECT CAST(ST_xmin(box2d(ST_Envelope(the_geom))) as varchar) || ' ' || "
//                + "CAST(ST_ymax(box2d(ST_Envelope(the_geom))) * -1 as varchar) || ' ' || "
//                + "CAST(ST_xmax(box2d(ST_Envelope(the_geom))) - ST_xmin(box2d(ST_Envelope(the_geom))) as varchar) || ' ' || "
//                + "CAST(ST_ymax(box2d(ST_Envelope(the_geom))) - ST_ymin(box2d(ST_Envelope(the_geom))) as varchar) AS viewBox "
//                + "FROM mesorregiao WHERE nome_meso = ?";
//        String viewBox = null;
//        Connection connection = ConnectionFactory.getInstance().getConnection();
//        try{
//           PreparedStatement stmt = connection.prepareStatement(sql);
//           stmt.setString(1, nomeMeso);
//           ResultSet resultSet = stmt.executeQuery();
//           resultSet.next();
//           viewBox = resultSet.getString("viewBox");
//        }finally{
//            connection.close();
//        }
//        return viewBox;
//    }
//    
//    public String getViewBoxRegiao(String nomeRegiao) throws SQLException{
//        String sql = "SELECT CAST(ST_xmin(box2d(ST_Envelope(the_geom))) as varchar) || ' ' || "
//                + "CAST(ST_ymax(box2d(ST_Envelope(the_geom))) * -1 as varchar) || ' ' || "
//                + "CAST(ST_xmax(box2d(ST_Envelope(the_geom))) - ST_xmin(box2d(ST_Envelope(the_geom))) as varchar) || ' ' || "
//                + "CAST(ST_ymax(box2d(ST_Envelope(the_geom))) - ST_ymin(box2d(ST_Envelope(the_geom))) as varchar) AS viewBox "
//                + "FROM regiao WHERE nome_regiao = ?";
//        String viewBox = null;
//        Connection connection = ConnectionFactory.getInstance().getConnection();
//        try{
//           PreparedStatement stmt = connection.prepareStatement(sql);
//           stmt.setString(1, nomeRegiao);
//           ResultSet resultSet = stmt.executeQuery();
//           resultSet.next();
//           viewBox = resultSet.getString("viewBox");
//        }finally{
//            connection.close();
//        }
//        return viewBox;
//    }
    
    public String getTamanhoViewBox(String geometria) throws SQLException{
        Connection connection = ConnectionFactory.getInstance().getConnection();
        String sql = "SELECT getTamanhoViewBox('"+geometria+"') as viewBox";
        //System.out.println(sql);
        String viewBox = null;
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            resultSet.next();
            viewBox = resultSet.getString("viewBox");
        }finally{
            connection.close();
        }
        return viewBox;
    }
    
}
