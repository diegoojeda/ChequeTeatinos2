<%-- 
    Document   : header
    Created on : 13-dic-2013, 9:24:26
    Author     : escabia
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header>
    <div id="logo">
        <div id="logo_text" class="logo_text bordenegro">
             <h1 class="mismalinea"><a href="" id="logomalaga">Cheque<span class="logo_colour">Teatinos</span></a></h1>
            <h2>Página de Administración</h2>
        </div>         
    </div> 
    <nav>
        <ul id="menu">
            <li id="liofertas"><a href="offersadmin.jsp">Ofertas</a></li>
            <li id="liempresas"><a href="businessadmin.jsp">Empresas</a></li>
            <li id="liclientes"><a href="customersadmin.jsp">Clientes*</a></li>
        </ul>  
        <div class="loginaccount">
            <c:if test="${not empty login.cli.email}">
                <div class="mismalinea">
                    <form action="disconnectadminServlet" method="post">
                        <h6>Se ha conectado como: ${login.cli.nombre}&nbsp;&nbsp;
                        <input class="botones" type="submit" value="Desconectar" /></h6>
                    </form> 
                </div>
            </c:if>
        </div>        
    </nav>
</header>