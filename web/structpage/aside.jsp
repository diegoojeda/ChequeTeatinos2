<%-- 
    Document   : aside
    Created on : 13-dic-2013, 17:33:38
    Author     : escabia
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<aside>
    <a href="cart.jsp">
        <br>
        <img src="http://websiteexpert.com/wp-content/uploads/grey-blue-cart1.png" alt="" class="iconosmapas">
    </a>
    <c:forEach var="oferta" items="${carrito}">
        <br> ${oferta.nombreOferta} 
        <a href="
           <c:url value="quitarDelCarritoServlet" >
               <c:param name="idOferta" value="${oferta.id}"/>
           </c:url>">Eliminar</a>
        <br>
        
    </c:forEach>
</aside>  
