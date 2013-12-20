<%-- 
    Document   : home
    Created on : 13-dic-2013, 9:20:12
    Author     : escabia
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<t:genericpage>
    <jsp:attribute name="header">
        <jsp:include page="structpage/header.jsp" />      
    </jsp:attribute>
    
    <jsp:body>
        <script>
            $(document).ready(function() {
                initialize("${ofertaDetalle.emp.direccion}", "${ofertaDetalle.emp.nombre}","<c:url value='cargarImagenBD'><c:param name='id' value='${ofertaDetalle.emp.id}'/></c:url>");
            });
        </script>
        <jsp:include page="structpage/aside.jsp" />
        <section>
            <table>
                <td>
                    <a class="product center" title="Offers" href="
                       <c:url value="carritoServlet">
                           <c:param name="idOferta" value="${ofertaDetalle.ofe.id}"/> 
                       </c:url>">
                        <img src="resources/media/images/shoppingcart.png" alt="Añadir al carrito" class="iconos">
                        <span class="order"><span class="details"><h5>Añadir al carrito</h5></span></span>
                    </a>
                </td>
                <td>
                    <img src="resources/media/images/separatorvertical.png"/>
                </td>
                <td>
                    <div class="offer" title="OferDetail">
                        <span clas="detailed">
                            <h2>
                                ${ofertaDetalle.ofe.nombreOferta}
                            </h2>
                            <br>
                            <h5>${ofertaDetalle.ofe.descripcion}</h5>
                            <c:if test="${not empty ofertaDetalle.ofe.existencias}">
                                <br>Existencias: ${ofertaDetalle.ofe.existencias}
                            </c:if>
                                <br>Válido hasta: <fmt:formatDate value="${ofertaDetalle.ofe.fechaValidez}" pattern="dd MMMM yyyy"/>
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
                        </span>
                    </div>                    
                </td>
            </table>

            <!-- Mapas -->
            <div id="mapa"></div><br>
        </section>
        
    </jsp:body>
</t:genericpage>
