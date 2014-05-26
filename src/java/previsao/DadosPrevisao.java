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
public class DadosPrevisao {
    private String data;
    private String tempo;
    private String maxima;
    private String minima;
    private String iuv;

    public DadosPrevisao(String datas, String tempos, String maximas, String minimas, String iuvs) {
        this.data = datas;
        this.tempo = tempos;
        this.maxima = maximas;
        this.minima = minimas;
        this.iuv = iuvs;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public String getMaxima() {
        return maxima;
    }

    public void setMaxima(String maxima) {
        this.maxima = maxima;
    }

    public String getMinima() {
        return minima;
    }

    public void setMinima(String minima) {
        this.minima = minima;
    }

    public String getIuv() {
        return iuv;
    }

    public void setIuv(String iuv) {
        this.iuv = iuv;
    }

    
    
    
}
