/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package previsao;

import java.util.ArrayList;

/**
 *
 * @author Fernando
 */
public class Previsao {
    private String nomeCidade;
    private String uf;
    private ArrayList<String> datas;
    private ArrayList<String> tempos;
    private ArrayList<String> maximas;
    private ArrayList<String> minimas;
    private ArrayList<String> iuvs;

    public Previsao(String nomeCidade, String uf, ArrayList<String> datas, ArrayList<String> tempos, ArrayList<String> maximas, ArrayList<String> minimas, ArrayList<String> iuvs) {
        this.nomeCidade = nomeCidade;
        this.uf = uf;
        this.datas = datas;
        this.tempos = tempos;
        this.maximas = maximas;
        this.minimas = minimas;
        this.iuvs = iuvs;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public ArrayList<String> getDatas() {
        return datas;
    }

    public void setDatas(ArrayList<String> datas) {
        this.datas = datas;
    }

    public ArrayList<String> getTempos() {
        return tempos;
    }

    public void setTempos(ArrayList<String> tempos) {
        this.tempos = tempos;
    }

    public ArrayList<String> getMaximas() {
        return maximas;
    }

    public void setMaximas(ArrayList<String> maximas) {
        this.maximas = maximas;
    }

    public ArrayList<String> getMinimas() {
        return minimas;
    }

    public void setMinimas(ArrayList<String> minimas) {
        this.minimas = minimas;
    }

    public ArrayList<String> getIuvs() {
        return iuvs;
    }

    public void setIuvs(ArrayList<String> iuvs) {
        this.iuvs = iuvs;
    }

    
}
