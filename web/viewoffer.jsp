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
            <div class="product" title="OferDetail">
                 <img src="" alt="Company Image"/>
                 <span class="order model">
                     ${ofertaDetalle.ofe.nombreOferta}
                 </span>
                 ${ofertaDetalle.ofe.descripcion}
                    <span class="order">
                        
                        <span class="price">
                            Antes: 
                            <strike>
                                ${ofertaDetalle.ofe.precioOriginal}
                            </strike>
                        </span>
                        <span class="price">
                            Ahora: ${ofertaDetalle.ofe.precioConOferta}
                        <span class="euros">
                            €
                        </span>
                     </span>
                 </span>
            </div> 
            <a href="
               <c:url value="carritoServlet"> 
                   <c:param name="idOferta" value="${ofertaDetalle.ofe.id}"/> 
               </c:url>">
                <br>Añadir al carrito<br>
            </a>
        </section>
    </jsp:body>
</t:genericpage>