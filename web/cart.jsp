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
                
            <!-- Tabla ofertas del carrito -->
            <table border="1">
                <thead>
                <td  class="tdempresa"><h4>Empresa</h4></td>
                    <td class="tdoferta"><h4>Oferta</h4></td>
                    <td><h4>Precio</h4></td>
                    <td></td>
                </thead>

                <c:forEach var="oferta" items="${carrito}" >
                    <tr>
                        <td class="tdempresa"><img class="iconos" src="<c:url value="cargarImagenBD"><c:param name="id" value="${oferta.empresa.id}"/></c:url>"
                             alt="Company Image"/></td>
                        <td class="tdoferta"><h6 class="order model">${oferta.nombreOferta}</h6></td>
                        <td><span class="order model">${oferta.precioConOferta}€</span></td>
                        <td><a href="
                               <c:url value="quitarDelCarritoServlet" >
                                   <c:param name="idOferta" value="${oferta.id}"/>
                               </c:url>"><img class="iconosmapas" src="resources/media/images/delete.png" alt="Eliminar oferta del carrito" /></a></td>
                    </tr>
                </c:forEach>
                <tfoot>
                <td></td>
                <td></td>
                <td>Total: ${precio}€</td>
                <td></td>
                </tfoot>
            </table> 
            <h2>Pago</h2>
                
            <form name="formcontacto" action="" method="post">
              <div class="form_settings">
                <!-- Campos formulario -->
                <p><span>IBAN</span><input class="contact" type="text" name="iban" value="ES 70 0128 0001 01 0123456789" required disabled="true"/></p>
              </div>
            </form>
            <br><br>
                
            <a href="pagarServlet" target="_blank">
                <input class="botones" type="button" value="Finalizar e imprimir" />
            </a>
                
                
            </c:if>            

        </section>
    </jsp:body>
</t:genericpage>
