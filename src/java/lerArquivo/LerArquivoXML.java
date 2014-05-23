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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import previsao.Previsao;
/**
 *
 * @author Fernando
 */
public class LerArquivoXML {
//    private String link;

    private final File filepath;
    private URL url;

    public LerArquivoXML(Coordenadas coordenadas) {
       try {
            this.url = new URL("http://servicos.cptec.inpe.br/XML/cidade/7dias/" + coordenadas.getLatitude() + "/" + coordenadas.getLongitude() + "/previsaoLatLon.xml");
        } catch (MalformedURLException ex) {
            Logger.getLogger(LerArquivoXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.filepath = new File(url.toString());
    }

    public Previsao lerAquivoRtornandoPrevisao() {
        Previsao previsao = null;
        try {
            URLConnection urlConnection = url.openConnection();
//            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

//            byte[] b = new byte[1024];
//            in.read(b);
//            String xml = new String(b);
//            System.out.println(xml);
            
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(url.openStream());
            doc.normalize();
            
            //recuperando nome Cidade
            String nomeCidade = doc.getElementsByTagName("nome").item(0).getTextContent();
            String uf = doc.getElementsByTagName("uf").item(0).getTextContent();

            //Lista de datas
            NodeList nodeListDatas = doc.getElementsByTagName("dia");
            ArrayList<String> datas = new ArrayList();
            for (int i = 0; i < nodeListDatas.getLength(); i++) {
                datas.add(nodeListDatas.item(i).getTextContent());
            }
            
            //Lista de tempo
            NodeList nodeListTempo = doc.getElementsByTagName("tempo");
            ArrayList<String> tempos = new ArrayList();
            for (int i = 0; i < nodeListTempo.getLength(); i++) {
                tempos.add(nodeListTempo.item(i).getTextContent());
            }
            
            //Lista de maximas
            NodeList nodeListMaximas = doc.getElementsByTagName("maxima");
            ArrayList<String> maximas = new ArrayList();
            for (int i = 0; i < nodeListMaximas.getLength(); i++) {
                maximas.add(nodeListMaximas.item(i).getTextContent());
            }
            
            //Lista de maximas
            NodeList nodeListMinimas = doc.getElementsByTagName("minima");
            ArrayList<String> minimas =  new ArrayList();
            for (int i = 0; i < nodeListMinimas.getLength(); i++) {
                minimas.add(nodeListMinimas.item(i).getTextContent());
            }
            
            //Lista de iuvs
            NodeList nodeListIuvs = doc.getElementsByTagName("iuv");
            ArrayList<String> iuvs =  new ArrayList();
            for (int i = 0; i < nodeListIuvs.getLength(); i++) {
                iuvs.add(nodeListIuvs.item(i).getTextContent());
            }

            
            previsao = new Previsao(nomeCidade, uf, datas, tempos, maximas, minimas, iuvs);
        
        } catch (IOException ex) {
            Logger.getLogger(LerArquivoXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(LerArquivoXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(LerArquivoXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return previsao;
    }

}
