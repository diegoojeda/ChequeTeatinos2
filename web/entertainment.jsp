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
                selectandtitle("#liocio", "ChequeTeatinos - Ocio"); 
            });
        </script>        
        <jsp:include page="structpage/aside.jsp" />
        <section>
           <h2>Ocio</h2>
           <div class="row">
            <c:forEach var="oferta" items="${ofertas.ofertas}" >
                <ul>
                    <li>
                        <a href="#" class="product" title="Offers">
			<img src="" alt="Company Image"/>
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