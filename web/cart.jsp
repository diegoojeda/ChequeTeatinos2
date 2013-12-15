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
        <jsp:include page="structpage/header.jsp" />      
    </jsp:attribute>
        
    <jsp:body>
        <jsp:include page="structpage/aside.jsp" />
        <section>
            ¿Dónde estará mi carro?
        </section>
        <div class="row">
            <c:forEach var="oferta" items="${carrito}" >
                <ul>
                    <li>
                        <span class="order model">
                            ${oferta.nombreOferta}
                        </span>
                        <span>
                            ${oferta.descripcion}
                        </span>
                        <span class="order">
                            <span class="price">
                                ${oferta.precioConOferta}
                                <span class="euros">
                                    €
                                </span>
                                    
                            </span>
                            <a href="
                               <c:url value="quitarDelCarritoServlet" >
                                   <c:param name="idOferta" value="${oferta.id}"/>
                               </c:url>"><br>Eliminar del carrito</a>
                            <br>
                        </span>
                    </li>
                </ul>
            </c:forEach>
        </div>
    </jsp:body>
</t:genericpage>