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
//    private ArrayList<String> datas;
//    private ArrayList<String> tempos;
//    private ArrayList<String> maximas;
//    private ArrayList<String> minimas;
//    private ArrayList<String> iuvs;
    private ArrayList<DadosPrevisao> listaDadosPrevisao;

    public Previsao(String nomeCidade, String uf, ArrayList<DadosPrevisao> listaDadosPrevisao) {
        this.nomeCidade = nomeCidade;
        this.uf = uf;
        this.listaDadosPrevisao = listaDadosPrevisao;
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

    public ArrayList<DadosPrevisao> getListaDadosPrevisao() {
        return listaDadosPrevisao;
    }

    public void setListaDadosPrevisao(ArrayList<DadosPrevisao> listaDadosPrevisao) {
        this.listaDadosPrevisao = listaDadosPrevisao;
    }
    
}
