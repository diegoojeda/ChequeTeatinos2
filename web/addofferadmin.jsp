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
        <section>
            <h2>Nueva Oferta</h2>
            <form name="formcontacto" action="" method="post">
              <div class="form_settings">
                <!-- Campos formulario -->
                <input class="contact" type="email" name="email" required hidden="true"/>
                <p><span>Nombre</span><input class="contact" type="text" name="nombre" required/></p>
                <p><span>Empresa</span>
                    <select name="empresa">
                        <c:forEach var="empresa" items="${empresas.empresas}" >
                          <option value="${empresa.id}">${empresa.nombre}</option>
                        </c:forEach>
                    </select>
                </p>
                <p><span>Existencias</span><input class="contact" type="number" name="existencias" required/></p>
                <p><span>Descripción</span><input class="contact" type="text" name="descripcion" required/></p>
                <p><span>Fecha de validez</span><input class="contact" type="date" name="fechaValidez" required/></p>
                <p><span>Precio Ofertado</span><input class="contact" type="number" name="precioConOferta" required/></p>
                <p><span>Precio Original</span><input class="contact" type="number" name="precioOriginal" required/></p>
                <input class="submit" type="submit" value="Crear" />
              </div>
            </form> 
        </section>
    </jsp:body>
</t:genericpage>

                    
