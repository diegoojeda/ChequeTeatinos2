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
        <c:if test="${empty idul}">
            <script>
                $(document).ready(function() {
                    selectandtitle("#liinicio", "ChequeTeatinos - Inicio"); 
                });
            </script>  
        </c:if>
        <c:if test="${not empty idul}">
            <script>
                $(document).ready(function() {
                    selectandtitle("${idul}", "ChequeTeatinos - ${title}"); 
                });
            </script>  
        </c:if>
            
            
            
        <jsp:include page="structpage/aside.jsp" />
        <section>
            <c:if test="${empty idul}">
                <h2>¡Últimas ofertas!</h2>
            </c:if>
            <c:if test="${not empty idul}">
                <h2>${title}</h2>
            </c:if>
                
            <div class="row">
            <c:forEach var="oferta" items="${ofertas.ofertas}">
                <ul>
                    <li>
                        <img src="<c:url value="cargarImagenBD"><c:param name="id" value="${oferta.empresa.id}"/></c:url>"
                             alt="Company Image"/>
                        <a class="product" title="Offers" href="<c:url value="viewOfferServlet">
                               <c:param name="idOferta" value="${oferta.id}"/> </c:url>"
			<span class="order model">${oferta.nombreOferta}</span>
			<span class="order"><span class="details">Ver</span><span class="price">${oferta.precioConOferta}<span class="euros">€</span></span></span>
			</a>
                    </li>
                </ul>
            </c:forEach>
            </div>
        </section>
    </jsp:body>
</t:genericpage>
