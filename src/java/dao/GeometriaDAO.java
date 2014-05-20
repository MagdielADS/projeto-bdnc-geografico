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
public class GeometriaDAO {
//   private Connection connection;

   public GeometriaDAO(){
   }
   
   public String getGeometriaMunicipio(String nomeMunicipio) throws SQLException{
       String sql = "SELECT ST_AsSVG(the_geom) as theGeom FROM municipio WHERE nome_municipio ilike ?";
       String theGeomAsText = null;
       Connection connection = ConnectionFactory.getInstance().getConnection();
       try {
           PreparedStatement stmt = connection.prepareStatement(sql);
           stmt.setString(1, nomeMunicipio);
           ResultSet resultSet = stmt.executeQuery();
           resultSet.next();
           theGeomAsText = resultSet.getString("theGeom");
       } finally {
           connection.close();
       }
       System.out.println(nomeMunicipio);
       return theGeomAsText;
   }
   
   public String getGeometriaEstado(String siglaEstado) throws SQLException{
       String sql = "SELECT ST_AsSVG(the_geom) as theGeom FROM estado WHERE sigla_estado ilike ?";
       String theGeomAsText = null;
       Connection connection = ConnectionFactory.getInstance().getConnection();
       try {
           PreparedStatement stmt = connection.prepareStatement(sql);
           stmt.setString(1, siglaEstado);
           ResultSet resultSet = stmt.executeQuery();
           resultSet.next();
           theGeomAsText = resultSet.getString("theGeom");
       } finally {
           connection.close();
       }
       return theGeomAsText;
   }
   
   public String getGeometriaMicro(String nomeMicro) throws SQLException{
       String sql = "SELECT ST_AsSVG(the_geom) as theGeom FROM microrregiao WHERE nome_micro ilike ?";
       String theGeomAsText = null;
       Connection connection = ConnectionFactory.getInstance().getConnection();
       try {
           PreparedStatement stmt = connection.prepareStatement(sql);
           stmt.setString(1, nomeMicro);
           ResultSet resultSet = stmt.executeQuery();
           resultSet.next();
           theGeomAsText = resultSet.getString("theGeom");
       } finally {
           connection.close();
       }
       return theGeomAsText;
   }

   public String getGeometriaMeso(String nomeMeso) throws SQLException{
       String sql = "SELECT ST_AsSVG(the_geom) as theGeom FROM mesorregiao WHERE nome_meso ilike ?";
       String theGeomAsText = null;
       Connection connection = ConnectionFactory.getInstance().getConnection();
       try {
           PreparedStatement stmt = connection.prepareStatement(sql);
           stmt.setString(1, nomeMeso);
           ResultSet resultSet = stmt.executeQuery();
           resultSet.next();
           theGeomAsText = resultSet.getString("theGeom");
       } finally {
           connection.close();
       }
       return theGeomAsText;
   }
   
   public String getGeometriaRegiao(String nomeRegiao) throws SQLException{
       String sql = "SELECT ST_AsSVG(the_geom) as theGeom FROM regiao WHERE nome_regiao ilike ?";
       String theGeomAsText = null;
       Connection connection = ConnectionFactory.getInstance().getConnection();
       try {
           PreparedStatement stmt = connection.prepareStatement(sql);
           stmt.setString(1, nomeRegiao);
           ResultSet resultSet = stmt.executeQuery();
           resultSet.next();
           theGeomAsText = resultSet.getString("theGeom");
       } finally {
           connection.close();
       }
       return theGeomAsText;
   }
   
   public String getGeometriaPeloRaioCidade(String nomeMunicipio, int raioKm) throws SQLException{
       String sql = "SELECT ST_UNION(M.the_geom) AS theGeom"
               + "FROM municipio M "
               + "WHERE ST_DISTANCE(ST_CENTROID(M.the_geom), (SELECT ST_CENTROID(the_geom) FROM municipio WHERE nome_municipio ilike ?)) * 111.32 <= ?"
               + "AND ST_DISTANCE(ST_CENTROID(M.the_geom), (SELECT ST_CENTROID(the_geom) FROM municipio WHERE nome_municipio ilike '?')) * 111.32 > 0";
       String theGeomAsText = null;
       Connection connection = ConnectionFactory.getInstance().getConnection();
       try{
           PreparedStatement stmt = connection.prepareStatement(sql);
           stmt.setString(1, nomeMunicipio);
           stmt.setInt(2, raioKm);
           stmt.setString(3, nomeMunicipio);
           ResultSet resultSet = stmt.executeQuery();
           resultSet.next();
           theGeomAsText = resultSet.getString("theGeom");
       } finally{
           connection.close();
       }
       return theGeomAsText;
   }
   
}
