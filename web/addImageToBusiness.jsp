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
        <jsp:include page="structpage/header_admin.jsp" />      
    </jsp:attribute>
    <jsp:body>
        <div class="form_settings">
            <form enctype='multipart/form-data' action="guardarImagenBD" method="post">
                <p><span>Seleccione Empresa</span>
                    <select name="empresa">
                        <c:forEach var="empresa" items="${empresas.empresas}" >
                            <option value="${empresa.id}">${empresa.nombre}</option>
                        </c:forEach>
                    </select>
                </p>
                <p><span>Seleccione Imagen</span></p>
                <input type="file" name="imagen" /><br/>
                <input type="submit" value="Añadir Imagen"/>
            </form>
        </div>
    </jsp:body>
</t:genericpage>
