<%-- 
    Document   : aside
    Created on : 13-dic-2013, 17:33:38
    Author     : escabia
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<aside>
    <c:if test="${empty login.cli.email}"><!-- Si no estás logeado -->
        <a href="login.jsp"><img src="http://websiteexpert.com/wp-content/uploads/grey-blue-cart1.png" alt="" class="iconos"></a>
    </c:if>
    <c:if test="${not empty login.cli.email}">
    <a href="cart.jsp"><img src="http://websiteexpert.com/wp-content/uploads/grey-blue-cart1.png" alt="" class="iconos"></a>
    </c:if>
    <c:forEach var="oferta" items="${carrito}">
        ${oferta.nombreOferta}
        <a href="
           <c:url value="quitarDelCarritoServlet">
               <c:param name="idOferta" value="${oferta.id}"/>
           </c:url>">
            <img class="iconosmapas" src="resources/media/images/delete.png" alt="Delete carrito"/>
        </a>

    </c:forEach>
</aside>  
