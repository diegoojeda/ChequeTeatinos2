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
        <h2>Nueva Empresa</h2>
        <form name="formEmpresa" action="anadeEmpresaServlet" method="post">
            <div class="form_settings">
                <!-- Campos formulario -->
                <p><span>Nombre</span><input class="contact" type="text" name="nombre" required/></p>
                <p><span>Direccion</span><input class="contact" type="text" name="direccion" required/></p>
                <input class="submit" type="submit" value="Crear" />
                <p><span>Imagen</span>
                <form enctype='multipart/form-data' action="guardarImagenBD" method="post">
                    <input type="file" name="imagen" /><br/>
                    <input type="submit" value="Subir archivo" />
                </form>
                </p>
            </div>
        </form>
        <section>
            
        </section>
    </jsp:body>
</t:genericpage>


