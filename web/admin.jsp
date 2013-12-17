<%-- 
    Document   : home
    Created on : 13-dic-2013, 9:20:12
    Author     : escabia
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage_loginadmin>

    <jsp:body>
            <h2> Login  </h2>
            <div id="formulario">
                <form name="formcontacto" action="loginadminServlet" method="post">
                  <div class="form_settings">
                    <p><span>Email</span><input class="contact" type="email" name="email" required/></p>
                    <p><span>Contraseña</span><input class="contact" type="password" name="password" required/></p>
                    <div class="mismalinea">
                        <input class="submit" type="submit" value="Entrar" />
                    </div>
                  </div>
                </form>                
            </div>
    </jsp:body>
</t:genericpage_loginadmin>>
