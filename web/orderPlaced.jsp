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
    <script type="text/javascript" src="http://jqueryjs.googlecode.com/files/jquery-1.3.1.min.js" > </script> 
    <script type="text/javascript">
        function PrintElem(elem)
        {
            Popup($(elem).html());
        }

        function Popup(data) 
        {
            var mywindow = window.open('', 'my div', 'height=400,width=600');
            mywindow.document.write('<html><head><title></title>');
            /*optional stylesheet*/ //mywindow.document.write('<link rel="stylesheet" href="main.css" type="text/css" />');
            mywindow.document.write('</head><body >');
            mywindow.document.write(data);
            mywindow.document.write('</body></html>');

            mywindow.print();
            mywindow.close();

            return true;
        }

    </script>  
        
        <jsp:include page="structpage/aside.jsp" />
        <section>
            <c:if test="${not empty carrito}">
                <h2>Tu compra</h2>
            </c:if>            
            <h5>Compra realizada con éxito. Imprima sus cheques.</h5>

                    
                    
            <div id="cheques">
                <h2>Cheques</h2>
                <table border="1">

                    <c:forEach var="oferta" items="${compra}" >
                        <tr>
                            <td class="tdempresa"><img class="iconos" src="<c:url value="cargarImagenBD"><c:param name="id" value="${oferta.empresa.id}"/></c:url>"
                                 alt="Company Image"/></td>
                            <td class="tdoferta"><h6 class="order model">${oferta.nombreOferta}</h6></td>
                        </tr>
                    </c:forEach>
                </table>                    
            </div>
                    
                    
            
            
            <input class="botones" type="button" onclick="window.print()" value="Imprimir" /><!-- PrintElem('#cheques') -->
            
        </section>
    </jsp:body>
</t:genericpage>