/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function selectandtitle(selectsub, title){
 
    quitarSelected(selectsub);
    document.title = title;
}

function guardarSitio(nombre){
    var existe = 0;
    
    for (var i=0;i<localStorage.length;i++){
        if(localStorage.getItem(i) == nombre)
            existe=1;
    }
    if(existe == 0){
        var id=localStorage.length;
        localStorage.setItem(id,nombre);
        alert(nombre + " se ha guardado. Puede verlo en Tus Sitios");
    }
    else{
        alert(nombre + " ya existe en Tus Sitios");
    }
}

function cargarDescripcion(iconos,imagen, nombre, direccion, url, informacion, selectsub, title){ 
    var array = iconos.split(',')
    $("section").load('sections/des_categoria.html', function(){
        initialize(direccion, nombre, imagen, informacion);
        $("#encabezado").append("\<h3>"+ nombre +"</h3>");
        $("#encabezado").append("\<h4 class='mismalinea'>"+ direccion +"</h4>");
      
        $("#opciones").append("\<a href='#' onclick='toggleStreetView()' class='mismalinea'><img id='cambiarvista' class='iconosmapas' src='resources/media/images/street_view.png' alt='Mapa' title='Ver Mapa'></img></a>");
        $('#opciones').append('<img class="iconosmapas mismalinea" src="resources/media/images/save-icon.png" alt="Guardar" onclick="guardarSitio(\'' + nombre + '\')"></img>');
        
        for(i=0; i<array.length; i=i+2){
            $("#encabezado").append("<img class='rowiconos mismalinea derecha' src='" + array[i] + "' alt='"+ array[i+1] +"'></img>");
        }  
        
        $("#informacion").append("\<h5 class'mismalinea'><a href='"+ url +"'>"+ url +"</a></h5><br>");
        
        $("#informacion").append("\<h2>Descripci&oacute;n</h2>");
        $("#informacion").append("\<h6><span>"+ informacion +"</span></h6>");
        
    });        

    selectandtitle(selectsub, title);
}

function cargarSeccion(file, selectsub){
    $("section").load('sections/categoria.html', function(){
        $.getJSON(file,function(data){
            for(sitio in data.sitios){
                var title = "Malagatur4all - " + data.sitios[sitio].nombre;
                var accesibilidades = new String;
                var numdis = 0;
                for(discapacidad in data.sitios[sitio].discapacidades){
                    accesibilidades = accesibilidades + "<img class='coliconos' src='" + data.sitios[sitio].discapacidades[discapacidad][0] + "' alt='"+ data.sitios[sitio].discapacidades[discapacidad][1] +"'></img>";
                    numdis = numdis + 1;
                }
                $('#tablacategoria').append('\
                <tr id="trcategoria">\n\
                    <td><img alt="'+ data.sitios[sitio].nombre +'" class="colimages" src="'+ data.sitios[sitio].imagen +'"></img></td>\n\
                    <td class="coldescription"><a href="#" onclick="cargarDescripcion(\'' + data.sitios[sitio].discapacidades + '\',\'' + data.sitios[sitio].imagen + '\', \'' + data.sitios[sitio].nombre + '\', \'' + data.sitios[sitio].direccion + '\',\'' + data.sitios[sitio].url + '\',\'' + data.sitios[sitio].informacion + '\',\''+ selectsub +'\',\''+ title +'\');return false"><h3>' + data.sitios[sitio].nombre + '</h3></a><h4>' + data.sitios[sitio].direccion + '</h4></td>\n\
                    <td class="colimages"><ul>' 
                        + accesibilidades +
                    '</ul></td>\n\
                </tr>'); 
                
            }
        });
    });
}

function eliminarSitio(clave){
    if(confirm("Desea eliminar  "+ localStorage.getItem(clave) + " de Tus Sitios?")){
        if (clave in localStorage){
            localStorage.removeItem(clave);
        }            
        cargarTusSitios()
    }
}

function cargarTusSitios(){
    $("section").load('sections/categoria.html', function(){
        for (var i in localStorage){
            $('#tablacategoria').append('<tr id="trcategoria"><td><img class="iconosmapas" src="resources/media/images/delete.png" alt="Eliminar" onclick="eliminarSitio(\'' + i + '\')"></img></td> <td><h3>' + localStorage.getItem(i) + '</h3></td></tr>');
        }

    });
}

function quitarSelected(add){
    $("#liinicio").removeClass("selected"); 
    $("#lialojamiento").removeClass("selected");    
    $("#licultura").removeClass("selected");    
    $("#liocio").removeClass("selected");  
    $("#lirestaurantes").removeClass("selected");  
    $("#linosotros").removeClass("selected");
    $("#lisitios").removeClass("selected");  

    $(add).addClass("selected");  
}

$(document).ready(function() {
    $.backstretch([
        "http://yaentucasa.com/img/cms/malaga1.jpg"
      , "resources/media/images/a_malagueta-panorama.jpg"
      , "http://www.fuengirola.es/portal_localweb/img/portal/slideshow/1.jpg"
      , "http://fotos.diariosur.es/200907/puerto_marina-09-1.jpg"
      , "http://blog.avexperience.es/wp-content/uploads/2012/09/malaga.jpg"
    ], {duration: 8000, fade: 1000}); 
    
    
    $("section").load('sections/inicio.html'); 
    selectandtitle("#liinicio", "Malagatur4all - Inicio");     

    
    $("#inicio").click(function(event) {
        $("section").load('sections/inicio.html');
        selectandtitle("#liinicio", "Malagatur4all - Inicio");                 
    });
    
    $("#alojamiento").click(function(event) {
        cargarSeccion("contents/alojamiento.json","#lialojamiento");
        selectandtitle("#lialojamiento", "Malagatur4all - Alojamiento");                 
    });
    
    $("#cultura").click(function(event) {
        cargarSeccion("contents/cultura.json","#licultura");
        selectandtitle("#licultura", "Malagatur4all - Cultura");                 
    });

    $("#ocio").click(function(event) {
        cargarSeccion("contents/ocio.json","#liocio");
        selectandtitle("#liocio", "Malagatur4all - Ocio");                 
    });

    $("#restaurantes").click(function(event) {
        cargarSeccion("contents/restaurantes.json","#lirestaurantes");
        selectandtitle("#lirestaurantes", "Malagatur4all - Restaurantes");                 
    });
    
    $("#tussitios").click(function(event) {
        cargarTusSitios();
        selectandtitle("#lisitios", "Malagatur4all - Tus Sitios");                 
    });
    
    $("#nosotros").click(function(event) {
        $("section").load('sections/nosotros.html');
        selectandtitle("#linosotros", "Malagatur4all - Nosotros");                 
    });
    
});