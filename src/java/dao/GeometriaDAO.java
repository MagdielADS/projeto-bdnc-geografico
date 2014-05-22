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
       String sql = "SELECT the_geom as theGeom FROM municipio WHERE nome_municipio ilike ?";
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
       return theGeomAsText;
   }
   
   public String getGeometriaEstado(String siglaEstado) throws SQLException{
       String sql = "SELECT the_geom as theGeom FROM estado WHERE sigla_estado ilike ?";
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
       String sql = "SELECT the_geom as theGeom FROM microrregiao WHERE nome_micro ilike ?";
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
       String sql = "SELECT the_geom as theGeom FROM mesorregiao WHERE nome_meso ilike ?";
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
       String sql = "SELECT the_geom as theGeom FROM regiao WHERE nome_regiao ilike ?";
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
   
   public String getGeometriaPeloRaioDeUmPonto(double latitude, double longitude, int raioKm) throws SQLException{
       String sql = "SELECT (ST_UNION(the_geom)) as theGeom FROM municipio WHERE ST_DISTANCE(the_geom,ST_Point(?, ?)) * 111.32 <= ?";
       String theGeomAsText = null;
       Connection connection = ConnectionFactory.getInstance().getConnection();
       try{
           PreparedStatement stmt = connection.prepareStatement(sql);
           stmt.setDouble(1, longitude);
           stmt.setDouble(2, latitude);
           stmt.setInt(3, raioKm);
           ResultSet resultSet = stmt.executeQuery();
           resultSet.next();
           theGeomAsText = resultSet.getString("theGeom");
       } finally{
           connection.close();
       }
       return theGeomAsText;
   }
   
   public String getGeometriaAsSVG(String geometria) throws SQLException{
       String sql = "SELECT ST_AsSVG(?) as SVG";
       Connection connection = ConnectionFactory.getInstance().getConnection();
       String svg = null;
       try{
           PreparedStatement stmt = connection.prepareCall(sql);
           stmt.setString(1, geometria);
           ResultSet resultSet = stmt.executeQuery();
           resultSet.next();
           svg = resultSet.getString("SVG");
       }finally{
           connection.close();
       }
       return svg;
   }
   
}
