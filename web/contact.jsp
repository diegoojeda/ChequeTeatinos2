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
                selectandtitle("#licontacto", "ChequeTeatinos - Contacto"); 
            });
        </script>                         
        
        <jsp:include page="structpage/aside.jsp" />
        <section>
            <h2>Contacto</h2>
            <div id="formulario">
                <form name="formcontacto" action="" method="post">
                  <div class="form_settings">
                    <p><span>Nombre</span><input class="contact" type="text" name="nombre" value="" required/></p>
                    <p><span>Email</span><input class="contact" type="email" name="email" value="" required/></p>
                    <p><span>Mensaje</span><textarea class="contact textarea" rows="8" cols="50" name="mensaje" required></textarea></p>
                    <p style="padding-top: 15px"><span>&nbsp;</span><input class="submit" type="submit" name="contact_submitted" value="Enviar" /></p>
                  </div>
                </form>                
            </div>
        </section>
    </jsp:body>
</t:genericpage>




