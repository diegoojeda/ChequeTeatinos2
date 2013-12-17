<%-- 
    Document   : formCargaImagen
    Created on : 16-dic-2013, 11:36:36
    Author     : masterinftel11
--%>
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-15">
        <title>Cargador de imágenes desde BD</title>
    </head>
        
    <body style="margin: 20px;">
        
        <h1>Cargador de imágenes desde BD</h1>
        <hr/>
            
        <h2>Subir una imagen a la BD</h2>
            
        <form enctype='multipart/form-data' action="guardarImagenBD" method="post">
            Elige la imagen (PNG) a subir: <input type="file" name="imagen" /><br/>
            <input type="submit" value="Subir archivo" />
        </form>
    </body>
</html>
