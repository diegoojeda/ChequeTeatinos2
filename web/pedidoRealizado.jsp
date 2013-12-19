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
        <script>
            $(document).ready(function() {
                selectandtitle("ninguno", "ChequeTeatinos - Tu compra"); 
            });
        </script>   
        
        <jsp:include page="structpage/aside.jsp" />
        <section>
            <c:if test="${not empty carrito}">
                <h2>Tu compra</h2>
            </c:if>            
            
            Tu pedido ha sido realizado con éxito.
            <h2><<< Añadir detalles de la compra >>></h2>
        </section>
    </jsp:body>
</t:genericpage>