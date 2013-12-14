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
            <h2>Usuario: ${login.cli.nombre}</h2>
            <form name="formcontacto" action="modificaUsuarioServlet" method="post">
              <div class="form_settings">
                <!-- Campos formulario -->
                <input class="contact" type="email" name="email" value="${login.cli.email}" required hidden="true"/>
                <p><span>Nombre</span><input class="contact" type="text" name="nombre" value="${login.cli.nombre}" required/></p>
                <p><span>Apellidos</span><input class="contact" type="text" name="apellidos" value="${login.cli.apellidos}" required/></p>
                <p><span>Telefono</span><input class="contact" type="tel" name="telefono" value="${login.cli.telefono}" required/></p>
                <p><span>Contraseña</span><input class="contact" type="password" name="password" value="${login.cli.pass}" required/></p>
                <input class="submit" type="submit" value="Modificar" />
              </div>
            </form> 
        </section>
    </jsp:body>
</t:genericpage>