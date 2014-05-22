/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mapa;

/**
 *
 * @author Fernando
 */
public class Mapa {
    private String nome;
    private String geometria;
    private String geometriaSVG;

    public Mapa() {
    }

    public Mapa(String nome, String geometria, String geometriaSVG) {
        this.nome = nome;
        this.geometria = geometria;
        this.geometriaSVG = geometriaSVG;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGeometria() {
        return geometria;
    }

    public void setGeometria(String geometria) {
        this.geometria = geometria;
    }

    public String getGeometriaSVG() {
        return geometriaSVG;
    }

    public void setGeometriaSVG(String geometriaSVG) {
        this.geometriaSVG = geometriaSVG;
    }
    
}
