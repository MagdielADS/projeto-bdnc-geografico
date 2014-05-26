/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionFactory;
import coordenadas.Coordenadas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mapa.Mapa;

/**
 *
 * @author Fernando
 */
public class GeometriaDAO {
//   private Connection connection;

    public GeometriaDAO() {
    }

    public Mapa getMapaMunicipio(String nomeMunicipio) throws SQLException {
        String sql = "SELECT the_geom as theGeom, ST_AsSVG(the_geom) AS svg FROM municipio WHERE nome_municipio ilike ?";
        Connection connection = ConnectionFactory.getInstance().getConnection();
        Mapa mapa;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nomeMunicipio);
            ResultSet resultSet = stmt.executeQuery();
            resultSet.next();
            mapa = new Mapa(nomeMunicipio, resultSet.getString("theGeom"), resultSet.getString("svg"));
        } finally {
            connection.close();
        }
        return mapa;
    }

    public Mapa getMapaEstado(String siglaEstado) throws SQLException {
        String sql = "SELECT the_geom as theGeom, ST_AsSVG(the_geom) AS svg FROM estado WHERE sigla_estado ilike ? OR nome_estado ilike ?";
        Connection connection = ConnectionFactory.getInstance().getConnection();
        Mapa mapa;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, siglaEstado);
            stmt.setString(2, siglaEstado);
            ResultSet resultSet = stmt.executeQuery();
            resultSet.next();
            mapa = new Mapa(siglaEstado, resultSet.getString("theGeom"), resultSet.getString("svg"));
        } finally {
            connection.close();
        }
        return mapa;
    }
    
    public String getSiglaEstado(String nome) throws SQLException{
        String sql = "SELECT sigla_estado AS sigla FROM estado WHERE nome_estado ilike ?";
        Connection connection = ConnectionFactory.getInstance().getConnection();
        String siglaEstado = null;
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet resultSet = stmt.executeQuery();
            resultSet.next();
            siglaEstado = resultSet.getString("sigla");
        }finally {
            connection.close();
        }
        return siglaEstado;
    }
    public ArrayList<Mapa> getMapasMunicipiosEstado(String siglaEstado) throws SQLException {
        String sql = "SELECT M.nome_municipio AS nomeMunicipio, M.the_geom as theGeom, ST_AsSVG(M.the_geom) AS svg "
                + "FROM estado E, municipio M, mesorregiao MESO, microrregiao MICRO "
                + " WHERE E.sigla_estado ilike ? AND "
                + "E.cod_estado = MESO.gid_estado AND MESO.cod_meso = MICRO.gid_meso AND MICRO.cod_micro = M.gid_micro";
        Connection connection = ConnectionFactory.getInstance().getConnection();
        ArrayList<Mapa> mapas = new ArrayList();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, siglaEstado);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                mapas.add(new Mapa(resultSet.getString("nomeMunicipio"), resultSet.getString("theGeom"), resultSet.getString("svg")));
            }
        } finally {
            connection.close();
        }
        return mapas;
    }

    public ArrayList<Mapa> getMapasMunicipiosDaMicrorregiao(String siglaEstado) throws SQLException {
        String sql = "SELECT M.nome_municipio AS nomeMunicipio, M.the_geom as theGeom, ST_AsSVG(M.the_geom) AS svg FROM municipio M, microrregiao MICRO WHERE MICRO.cod_micro = M.gid_micro AND MICRO.nome_micro ilike ?";
        Connection connection = ConnectionFactory.getInstance().getConnection();
        ArrayList<Mapa> mapas = new ArrayList();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, siglaEstado);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                mapas.add(new Mapa(resultSet.getString("nomeMunicipio"), resultSet.getString("theGeom"), resultSet.getString("svg")));
            }
        } finally {
            connection.close();
        }
        return mapas;
    }

    public Mapa getMapaMicro(String nomeMicro) throws SQLException {
        String sql = "SELECT the_geom as theGeom, ST_AsSVG(the_geom) AS svg FROM microrregiao WHERE nome_micro ilike ?";
        Connection connection = ConnectionFactory.getInstance().getConnection();
        Mapa mapa;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nomeMicro);
            ResultSet resultSet = stmt.executeQuery();
            resultSet.next();
            mapa = new Mapa(nomeMicro, resultSet.getString("theGeom"), resultSet.getString("svg"));
        } finally {
            connection.close();
        }
        return mapa;
    }

    public Mapa getMapaMeso(String nomeMeso) throws SQLException {
        String sql = "SELECT the_geom as theGeom, ST_AsSVG(the_geom) AS svg FROM mesorregiao WHERE nome_meso ilike ?";
        Connection connection = ConnectionFactory.getInstance().getConnection();
        Mapa mapa;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nomeMeso);
            ResultSet resultSet = stmt.executeQuery();
            resultSet.next();
            mapa = new Mapa(nomeMeso, resultSet.getString("theGeom"), resultSet.getString("svg"));
        } finally {
            connection.close();
        }
        return mapa;
    }

    public Mapa getMapaRegiao(String nomeRegiao) throws SQLException {
        String sql = "SELECT the_geom as theGeom, ST_AsSVG(the_geom) AS svg FROM regiao WHERE nome_regiao ilike ?";
        Connection connection = ConnectionFactory.getInstance().getConnection();
        Mapa mapa;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nomeRegiao);
            ResultSet resultSet = stmt.executeQuery();
            resultSet.next();
            mapa = new Mapa(nomeRegiao, resultSet.getString("theGeom"), resultSet.getString("svg"));
        } finally {
            connection.close();
        }
        return mapa;
    }

    public ArrayList<Mapa> getMapasMicrorregioesDaMessorregiao(String nomeMeso) throws SQLException {
        String sql = "SELECT MICRO.nome_micro nomeMicro, MICRO.the_geom as theGeom, ST_AsSVG(MICRO.the_geom) AS svg FROM mesorregiao MESO, microrregiao MICRO "
                + "WHERE MESO.nome_meso ilike ? AND MESO.cod_meso = MICRO.gid_meso";
        Connection connection = ConnectionFactory.getInstance().getConnection();
        ArrayList<Mapa> mapas = new ArrayList();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nomeMeso);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                mapas.add(new Mapa(resultSet.getString("nomeMicro"), resultSet.getString("theGeom"), resultSet.getString("svg")));
            }
        } finally {
            connection.close();
        }
        return mapas;
    }

    public Mapa getMapaBrasil() throws SQLException {
        String sql = "SELECT the_geom as theGeom, ST_AsSVG(the_geom) AS svg from pais";
        Connection connection = ConnectionFactory.getInstance().getConnection();
        Mapa mapa;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            resultSet.next();
            mapa = new Mapa("Brasil", resultSet.getString("theGeom"), resultSet.getString("svg"));
        } finally {
            connection.close();
        }
        return mapa;
    }

    public Mapa getMapaPeloRaioDeUmPonto(double latitude, double longitude, int raioKm, String nomeLugar) throws SQLException {
        String sql = "SELECT (ST_UNION(the_geom)) as theGeom, ST_AsSVG(ST_UNION(the_geom)) AS svg FROM municipio WHERE ST_DISTANCE(the_geom,ST_Point(?, ?)) * 111.32 <= ?";
        Connection connection = ConnectionFactory.getInstance().getConnection();
        Mapa mapa;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDouble(1, longitude);
            stmt.setDouble(2, latitude);
            stmt.setInt(3, raioKm);
            ResultSet resultSet = stmt.executeQuery();
            resultSet.next();
            mapa = new Mapa(nomeLugar, resultSet.getString("theGeom"), resultSet.getString("svg"));
        } finally {
            connection.close();
        }
        return mapa;
    }

    public ArrayList<Mapa> getMapasPeloRaioDeUmPonto(double latitude, double longitude, int raioKm, String nomeLugar) throws SQLException {
        String sql = "SELECT nome_municipio AS nomeMunicipio, the_geom as theGeom, ST_AsSVG(the_geom) AS svg"
                + " FROM municipio WHERE ST_DISTANCE(the_geom,ST_Point(?, ?)) * 111.32 <= ?";
        Connection connection = ConnectionFactory.getInstance().getConnection();
        ArrayList<Mapa> mapas = new ArrayList();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDouble(1, longitude);
            stmt.setDouble(2, latitude);
            stmt.setInt(3, raioKm);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                mapas.add(new Mapa(resultSet.getString("nomeMunicipio"), resultSet.getString("theGeom"), resultSet.getString("svg")));
            }
        } finally {
            connection.close();
        }
        return mapas;

    }

    public Coordenadas getCoordenadasDeUmPonto(String geometria) throws SQLException {
        String sql = "SELECT ST_Y('" + geometria + "') AS latitude, ST_X('" + geometria + "') AS longitude";
        Connection connection = ConnectionFactory.getInstance().getConnection();
        Coordenadas coordenadas;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            resultSet.next();
            coordenadas = new Coordenadas(resultSet.getString("latitude"), resultSet.getString("longitude"));
        } finally {
            connection.close();
        }
        return coordenadas;
    }

    public String getCentroidDeUmaGeometria(String geometria) throws SQLException {
        String sql = "SELECT ST_CENTROID('" + geometria + "') AS centroide";
        Connection connection = ConnectionFactory.getInstance().getConnection();
        String centroide;

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            resultSet.next();
            centroide = resultSet.getString("centroide");
        } finally {
            connection.close();
        }
        return centroide;
    }

    public ArrayList<Mapa> getMapasEstadosRegiao(String nomeRegiao) throws SQLException {
        String sql = "SELECT E.sigla_estado AS siglaEstado, E.the_geom as theGeom, ST_AsSVG(E.the_geom) AS svg "
                + "FROM estado E, Regiao R WHERE R.gid = E.gid_regiao AND R.nome_regiao ilike ?";
        Connection connection = ConnectionFactory.getInstance().getConnection();
        ArrayList<Mapa> mapas = new ArrayList();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nomeRegiao);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                mapas.add(new Mapa(resultSet.getString("siglaEstado"), resultSet.getString("theGeom"), resultSet.getString("svg")));
            }
        } finally {
            connection.close();
        }
        return mapas;
    }

//   
//   public String getGeometriaAsSVG(String geometria) throws SQLException{
//       String sql = "SELECT ST_AsSVG(?) as SVG";
//       Connection connection = ConnectionFactory.getInstance().getConnection();
//       String svg = null;
//       try{
//           PreparedStatement stmt = connection.prepareCall(sql);
//           stmt.setString(1, geometria);
//           ResultSet resultSet = stmt.executeQuery();
//           resultSet.next();
//           svg = resultSet.getString("SVG");
//       }finally{
//           connection.close();
//       }
//       return svg;
//   }
}
