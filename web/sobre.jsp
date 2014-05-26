<%-- 
    Document   : sobre
    Created on : 24/05/2014, 13:56:57
    Author     : magdiel-bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GeoBrasil Projeto</title>
        <link rel="stylesheet" type="text/css" href="css/css_home.css"/>
    </head>
    <body>
        <div id="container">
            <div id="Container_logo">
                <div id="image_logo">
                    <a href="home.jsp"><img src="images/logoGeo.png"> </a>
                </div>
            </div>
            <div id="container_menu">
                <div id="menu_it1">
                    <a href="#">O Projeto</a>
                </div>
                <div id="menu_it2">
                    <a href="consultas.jsp">Consultas</a>
                </div>
                <div id="menu_it3">
                    <a href="desenvolvedores.jsp">Desenvolvedores</a>
                </div>
            </div>
            
            <div id="container_centro">
                <p>
                    O projeto proposto é a produção do sistema GeoBrasil, sistema 
                    geográfico para representar graficamente a geometria dos 
                    municípios, estados, microrregiões, mesorregiões e regiões do 
                    Brasil. O sistema deverá permitir ao usuário executar consultas 
                    previamente estabelecidas, a resposta para as mesmas deve ser exibida 
                    na forma visual(mapa). São disponibilizadas as seguintes consultas: 
                    Município pelo nome, estado pelo nome, microrregião pelo nome, 
                    mesorregião pelo nome, região pelo nome e municípios dentro de um raio, 
                    em quilômetros (km), de um ponto informado.  Ao clicar na representação 
                    gráfica da geometria, seu nome deve ser apresentado. Se a representação 
                    gráfica da geometria for de um município, além do nome do município, 
                    deve ser apresentada também a previsão do tempo para os próximos sete dias. 
                </p>   
            </div>
            
            
        </div>
    </body>
</html>
