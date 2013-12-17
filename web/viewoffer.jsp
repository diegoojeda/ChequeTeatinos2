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
            <div class="offer" title="OferDetail">
                <span clas="detailed">
                 <span class="order model">
                     ${ofertaDetalle.ofe.nombreOferta}
                 </span>
                 <img src="<c:url value="cargarImagenBD"><c:param name="id" value="${oferta.empresa.id}"/></c:url>"
                             alt="Company Image"/>
                 ${ofertaDetalle.ofe.descripcion}
                    <span class="order">
                        <span class="price">
                            ${ofertaDetalle.ofe.precioConOferta}
                        <span class="euros">
                            €
                        </span>
                        <span class="before">
                            Antes: ${ofertaDetalle.ofe.precioOriginal}
                        <span class="euros">
                            €
                        </span>
                        </span>     
                        </span>
                    </span>
               <a href="
               <c:url value="carritoServlet">
                   <c:param name="idOferta" value="${ofertaDetalle.ofe.id}"/> 
               </c:url>">
               <span class="details">Añadir al carrito</span> 
                </a>
                </span>
            </div> 
            
        </section>
                        
    </jsp:body>
</t:genericpage>