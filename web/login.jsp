<%-- 
    Document   : home
    Created on : 13-dic-2013, 9:20:12
    Author     : escabia
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE HTML>

<t:genericpage>
    <jsp:attribute name="header">
        <jsp:include page="structpage/header.jsp" />      
    </jsp:attribute>

    <jsp:body>
        <jsp:include page="structpage/aside.jsp" />
        <section>
            <c:if test="${not empty info}">
                <h5 class="info">${info}</h5>
            </c:if>
            <h2> Login </h2>                
            <div id="formulario">
                <form name="formcontacto" action="loginServlet" method="post">
                  <div class="form_settings">
                    <p><span>Email</span><input class="contact" type="email" name="email" required value="${email}"/></p>
                    <p><span>Contraseña</span><input class="contact" type="password" name="password" required value="${pass}"/></p>
                    <div>
                        <p><input class="submit" type="submit" value="Entrar" /></p>
                    </div>
                    <c:if test="${not empty errorlogin}">
                        <h5 class="error">${errorlogin}</h5>
                    </c:if>
                  </div>
                </form> 
            </div>
        </section>
    </jsp:body>
</t:genericpage>
