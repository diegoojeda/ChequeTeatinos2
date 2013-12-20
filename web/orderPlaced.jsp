<%-- 
    Document   : home
    Created on : 13-dic-2013, 9:20:12
    Author     : escabia
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<t:genericpage_print>    
    <jsp:body>
        <section>
            <div id="cheques">
                <h2>Cheques ${login.cli.email}</h2>
                <table border="1">

                    <c:forEach var="oferta" items="${compra}" >
                        <tr>
                            <td class="tdempresa"><img class="iconos" src="<c:url value="cargarImagenBD"><c:param name="id" value="${oferta.empresa.id}"/></c:url>"
                                 alt="Company Image"/></td>
                                <td class="tdoferta">
                                    <h4 class="order model">${oferta.nombreOferta}</h4>
                                    <h6>${oferta.descripcion}</h6>
                                </td>
                            <td class="tdoferta"><h6 class="order model">Válido hasta: <fmt:formatDate value="${oferta.fechaValidez}" pattern="dd MMMM yyyy"/></h6></td>
                            <td class="tdoferta"><h6 class="order model">Referencia: ${oferta.id}${oferta.empresa.id}</h6></td>
                        </tr>
                    </c:forEach>
                </table> 
                <span>* Tickets individuales con fecha de validez indicada en el cheque. No son transferibles.</span>
            </div>
            <br><br>
            <input class="botones" type="button" onclick="window.print()" value="Imprimir" /><!-- PrintElem('#cheques') -->
            
        </section>
    </jsp:body>
</t:genericpage_print>