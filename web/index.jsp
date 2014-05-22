<%-- 
    Document   : index.jsp
    Created on : 20-May-2014, 4:46:17 PM
    Author     : Fernando
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
    <body>
        <h1>Geo Brasil</h1>
      
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
                <input type="text" name="latitude" placeholder="Latitude">
                <input type="text" name="longitude" placeholder="Longintude">
                <input type="text" name="raio" placeholder="Raio">
                <input type="submit" value="Pesquisar">
            </form>                
                
            <?xml version='1.0' encoding='utf-8' ?>
            <!DOCTYPE svg PUBLIC '-//W3C//DTD SVG 1.1 Basic//EN'
            'http://www.w3.org/Graphics/SVG/1.1/DTD/svg11-basic.dtd'>
            <c:if test="${desenharGeometria == true}">
                <svg xmlns='http://www.w3.org/2000/svg'
		xmlns:xlink='http:www.w3.org/1999/xlink'
		width='800' height='800' viewBox='${viewBox}'>
                <script type='text/ecmascript' xlink:href='js/funcoes.js'> </script>
                <g id='grupo'>
                    <path id='${nomeGeometria}' fill='green' fill-opacity='0.2' stroke='red' stroke-width='0.0002' 
                      onmouseover='Destaca(evt)' onmouseout='Normal(evt)' onclick='Info(evt)' d='${geometria}'/>
	        </g>
		</svg>
            </c:if>
    </body>
    
    
    
</html>
