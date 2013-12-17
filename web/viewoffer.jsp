<%-- 
    Document   : home
    Created on : 13-dic-2013, 9:20:12
    Author     : escabia
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
                    <img src="<c:url value="cargarImagenBD"><c:param name="id" value="${ofertaDetalle.emp.id}"/></c:url>"
                         alt="Company Image"/>
                    <br>
                    ${ofertaDetalle.ofe.descripcion}
                    <c:if test="${not empty ofertaDetalle.ofe.existencias}">
                        <br>Existencias: ${ofertaDetalle.ofe.existencias}
                    </c:if>
                        <br>Válido hasta: <fmt:formatDate value="${ofertaDetalle.ofe.fechaValidez}" pattern="dd-mm-yyyy"/>
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
                        <span class="model">
                            Empresa:
                        </span>
                                ${ofertaDetalle.emp.nombre}<br>
                        <span class = "model">
                            Dirección: 
                        </span>
                        ${ofertaDetalle.emp.direccion}
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
