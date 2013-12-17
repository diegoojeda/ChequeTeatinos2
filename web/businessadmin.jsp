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
        <script>
            $(document).ready(function() {
                selectandtitle("#liempresas", "ChequeTeatinos - Empresas"); 
            });
        </script>          
        <section>
            <br><h5><a href="addbusinessadmin.jsp"><input class="botones" type="button" value="Añadir Empresa" /></a></h5>
                       
        </section>
    </jsp:body>
</t:genericpage>

                    
