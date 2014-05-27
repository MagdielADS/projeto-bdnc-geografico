<%-- 
    Document   : consultas
    Created on : 24/05/2014, 16:07:44
    Author     : magdiel-bruno
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GeoBrasil Consultas</title>
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
                    <a href="sobre.jsp">O Projeto</a>
                </div>
                <div id="menu_it2">
                    <a href="#">Consultas</a>
                </div>
                <div id="menu_it3">
                    <a href="desenvolvedores.jsp">Desenvolvedores</a>
                </div>
            </div>
            <div id="form">
                <div id="form_search">

                    <form method="POST" action="obterGeometria">
                        <input type="text" name="nomeGeometria" placeholder="Nome" required>
                        <select name="tipo">
                            <option value="municipio">Município</option>
                            <option value="estado">Estado</option>
                            <option value="microrregiao">Microrregião</option>
                            <option value="messorregiao">Messorregião</option>
                            <option value="regiao">Região</option>
                        </select>
                        <input type="submit" value="Pesquisar">
                    </form>

                    <form method="POST" action="obterMunicipiosRaio">
                        <input type="text" name="latitude" placeholder="Latitude" required>
                        <input type="text" name="longitude" placeholder="Longintude" required>
                        <input type="text" name="raio" placeholder="Raio (Km)" required>
                        <input type="submit" value="Pesquisar">
                    </form> 

                </div>
            </div>
            <c:if test="${erro == true}">
                <h2>A pesquisa não retornou nenhum resultado :-(</h2>
            </c:if>
            <c:if test="${desenharGeometria == true}">
                <div id="svg">
                    <label id="municipio"></label>
                    <div id="geom">

                        <?xml version='1.0' encoding='utf-8' ?>
                        <!DOCTYPE svg PUBLIC '-//W3C//DTD SVG 1.1 Basic//EN'
                            'http://www.w3.org/Graphics/SVG/1.1/DTD/svg11-basic.dtd'>

                        <svg xmlns='http://www.w3.org/2000/svg'
                             xmlns:xlink='http:www.w3.org/1999/xlink'
                             width='600' height='600' viewBox='${viewBox}'>
                        <script type='text/ecmascript' xlink:href='js/funcoes.js'> </script>
                        <g id='grupo'>
                        <c:choose>
                            <c:when test="${raio != null}">
                                <path id='${nomeGeometria}' fill='green' fill-opacity='0.2' stroke='red' stroke-width='0.0099' 
                                      onmouseover='Destaca(evt)' onmouseout='Normal(evt)' onclick='Info(evt)' d='${geometria}'/>
                                <c:forEach var="mapa" items="${mapas}">
                                    <path id='${mapa.getNome()}' fill='green' fill-opacity='0.2' stroke='red' stroke-width='0.0099' 
                                          onmouseover='Destaca(evt)' onmouseout='Normal(evt)' onclick='Info(evt)' d='${mapa.getGeometriaSVG()}'/>
                                </c:forEach>
                                <div id="InfoRaio">
                                    <p><span>Latutude:</span> ${latitude}</p>
                                    <p><span>Longitude:</span> ${longitude}</p>
                                    <p><span>Raio:</span> ${raio}</p>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <c:forEach var="mapa" items="${mapas}">
                                    <path id='${mapa.getNome()}' fill='green' fill-opacity='0.2' stroke='red' stroke-width='0.0099' 
                                          onmouseover='Destaca(evt)' onmouseout='Normal(evt)' onclick='Info(evt)' d='${mapa.getGeometriaSVG()}'/>
                                </c:forEach>
                                <path id='${nomeGeometria}' fill='green' fill-opacity='0.2' stroke='red' stroke-width='0.0099' 
                                      onmouseover='Destaca(evt)' onmouseout='Normal(evt)' onclick='Info(evt)' d='${geometria}'/>
                            </c:otherwise>
                        </c:choose>
                        </g>
                        </svg>

                    </div>
                </div>
                <c:if test="${previsao != null}">

                    <div id="previsao">
                        <p>${nomeGeometria}</p>
                        <table>
                            <tr>
                                <th>Data</th>
                                <!--                                <th>Tempo</th>-->
                                <th>Maxima</th>
                                <th>Minima</th>
                                <!--                                <th>Iuv</th>-->
                            </tr>
                            <c:forEach var="prev" items="${previsao.listaDadosPrevisao}">
                                <tr>
                                    <td class="data">${prev.data}</td>
<!--                                    <td>${prev.tempo}</td>-->
                                    <td class="maxima">${prev.maxima}</td>
                                    <td class="minima">${prev.minima}</td>
<!--                                    <td>${prev.iuv}</td>-->
                                </tr>
                            </c:forEach>
                        </table>

                    </div>
                </c:if>
            </c:if>

        </div>   
    </body>
</html>
