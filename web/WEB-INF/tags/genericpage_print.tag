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
            <div id="logo">
                <div id="logo_text" class="logo_text bordenegro">
                     <h1 class="mismalinea"><a href="homeServlet" id="logomalaga">Cheque<span class="logo_colour">Teatinos</span></a></h1>
                     <!--<img id="next" class="mismalinea nextprev" src="resources/media/images/next.png" alt="Siguiente" onclick="$.backstretch('next')"/>
                     <img id="playpause" class="mismalinea playpause" src="resources/media/images/pause.png" alt="Play Pause" onclick="play()"/>
                     <img id="prev" class="mismalinea nextprev" src="resources/media/images/prev.png" alt="Anterior" onclick="$.backstretch('prev')"/>-->

                    <h2>Ofertas de establecimientos de Teatinos (Málaga).</h2>

                </div>         
            </div> 
        </header>
        <div id="site_content_print">
            <jsp:doBody/>
        </div>
    </body>
</html>