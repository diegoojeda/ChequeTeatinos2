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
            <h2>Nuevo Usuario</h2>
            <form name="formcontacto" action="anadeUsuarioServlet" method="post">
              <div class="form_settings">
                <!-- Campos formulario -->
                <p><span>Email</span><input class="contact" type="email" name="email" value="${email}" required/></p>
                <p><span>Contraseña</span><input class="contact" type="password" name="password" value="${password}" required/></p>
                <p><span>Nombre</span><input class="contact" type="text" name="nombre" value="${nombre}" required/></p>
                <p><span>Apellidos</span><input class="contact" type="text" name="apellidos" value="${apellidos}" required/></p>
                <p><span>Telefono</span><input class="contact" type="tel" name="telefono" value="${telefono}" required/></p>
                
                <input class="submit" type="submit" value="Registrarse" />
              </div>
            </form> 
        </section>
    </jsp:body>
</t:genericpage>