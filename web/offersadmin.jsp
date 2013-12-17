<%-- 
    Document   : home
    Created on : 13-dic-2013, 9:20:12
    Author     : escabia
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
    <jsp:attribute name="header">
        <jsp:include page="structpage/header_admin.jsp" />      
    </jsp:attribute>

    <jsp:body>
        <script>
            $(document).ready(function() {
                selectandtitle("#liofertas", "ChequeTeatinos - Ofertas"); 
            });
        </script>        
        <section>
            <c:if test="${not empty info}">
                <h5 class="info">${info}</h5>
            </c:if>
            <c:if test="${not empty error}">
                <h5 class="error">${error}</h5>
            </c:if>
            
            <form name="formcontacto" action="eliminaOfertaServlet" method="get">
                <!-- Añadir o eliminar oferta -->
                <br><h5><a href="addofferadmin.jsp"><input class="botones" type="button" value="Añadir Oferta" /></a>
                    <input class="botones" type="submit" value="Eliminar Oferta"/></h5>
                
                <!-- Tabla ofertas -->
                <table border="1">
                    <thead>
                        <td></td>
                        <td><h5>Oferta</h5></td>
                        <td><h5>Empresa</h5></td>
                    </thead>
                        
                    <c:forEach var="oferta" items="${ofertas.ofertas}" >
                        <tr>
                            <td><input type="radio" name="oferta" value="${oferta.id}" /></td>
                            <td><span class="order model">${oferta.nombreOferta}</span></td>
                            <td><span class="order model">${oferta.empresa.nombre}</span></td>
                        </tr>
                    </c:forEach>
                </table>
            </form>
        </section>
    </jsp:body>
</t:genericpage>

                    
