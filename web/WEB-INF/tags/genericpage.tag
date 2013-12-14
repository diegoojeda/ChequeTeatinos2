<%-- 
    Document   : genericpage
    Created on : 13-dic-2013, 10:43:37
    Author     : escabia
--%>

<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>ChequeTeatinos</title>
        <link rel="stylesheet" type="text/css" href="resources/css/plantilla/style.css" title="style" />
        <link rel="stylesheet" type="text/css" href="resources/css/propio/utils.css" title="style" />
        <link rel="stylesheet" type="text/css" href="resources/css/propio/cssmapas.css">
        
        <script type="text/javascript" src="resources/js/library/jquery-2.0.3.js"></script>
        <script type="text/javascript" src="resources/js/library/jquery.backstretch.min.js"></script>
        
        <!-- JSON Contents -->
        <script type="text/javascript" src="contents/alojamiento.json"></script>
        
        <!-- Javascript Files -->
        <script type="text/javascript" src="resources/js/propio/logocanvas.js" ></script>
        <script type="text/javascript" src="resources/js/propio/footerheader.js" ></script>
        <script type="text/javascript" src="resources/js/propio/email.js" ></script>
        <script src="https://maps.googleapis.com/maps/api/js?sensor=false"></script> 
        <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&amp;sensor=false"></script>        
        <script type="text/javascript" src="resources/js/propio/mapas.js" ></script>
        <script type="text/javascript" src="resources/js/propio/rutas.js" ></script>
        <script type="text/javascript" src="resources/js/propio/utils.js" ></script>
        <script type="text/javascript" src="resources/js/propio/redessociales.js" ></script>
       
        
    </head>    
    <body>
        <header>
              <jsp:invoke fragment="header"/>
        </header>
        <div id="site_content">
            <jsp:doBody/>
        </div>
        <footer>
            <a href="http://validator.w3.org/check?uri=referer"><img src="resources/media/images/HTML5_w3c.png" alt="Validar HTML5" class="icons"/></a>  
            <img src="resources/media/images/separador.png" alt="Separador de imágenes" class="icons" />
            <a href="http://fundacion.vodafone.es/fundacion/es"><img src="resources/media/images/icon_fundacion_vodafone.jpg" alt="Ir a Fundación Vodafone" class="icons"/></a>
            <img src="resources/media/images/separador.png" alt="Separador de imágenes" class="icons" />
            <a href="http://www.uma.es"><img src="resources/media/images/ico_uma.png" alt="Ir a Universidad de Málaga" class="icons"/></a>
            <img src="resources/media/images/separador.png" alt="Separador de imágenes" class="icons" />
            <a href="http://masterinftel.uma.es/"><img src="resources/media/images/master.png" alt="Ir a MasterInftel" class="icons"/></a>
        </footer>
    </body>
</html>