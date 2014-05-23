/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lerArquivo;

import coordenadas.Coordenadas;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Fernando
 */
public class LerArquivoXML {
//    private String link;
    private final File filepath;
    private URL url;
    
    public LerArquivoXML(Coordenadas coordenadas) {
        //System.out.println("http://servicos.cptec.inpe.br/XML/cidade/7dias/"+coordenadas.getLatitude()+"/"+coordenadas.getLongitude()+"/previsaoLatLon.xml");
        try {    
            this.url = new URL("http://servicos.cptec.inpe.br/XML/cidade/7dias/"+coordenadas.getLatitude()+"/"+coordenadas.getLongitude()+"/previsaoLatLon.xml");
        } catch (MalformedURLException ex) {
            Logger.getLogger(LerArquivoXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.filepath = new File(url.toString());
    }
    
    public void lerAquivo(){
        FileReader fileReader;
        try {
            URLConnection urlConnection = url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            
            
            
            byte[] b = new byte[1024];
            in.read(b);
            String xml = new String(b);
            System.out.println(xml);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LerArquivoXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LerArquivoXML.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
}
