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
        <section>
            <h2> Panel Administración ${login.cli.nombre}</h2>
            <form action="">
            
                <input class="submit" type="button" value="Añadir Oferta" />
                <input class="submit" type="submit" value="Eliminar Oferta" />
                <table border="1">
                    <thead>
                        <td></td>
                        <td><h4>Oferta</h4></td>
                        <td><h4>Empresa</h4></td>
                    </thead>
                        
                    <c:forEach var="oferta" items="${ofertas.ofertas}" >
                        <tr>
                                <td><input type="radio" name="oferta" value="${oferta.id}" /></td>
                                <td><span class="order model">${oferta.nombreOferta}</span></td>
                                <td><span class="order model">${oferta.empresa}</span></td>
                        </tr>
                    </c:forEach>
                </table>
            </form>
        </section>
    </jsp:body>
</t:genericpage>

                    
