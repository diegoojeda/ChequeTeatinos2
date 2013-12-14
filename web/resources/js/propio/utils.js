/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function selectandtitle(selectsub, title){
    quitarSelected(selectsub);
    document.title = title;
}

function quitarSelected(add){
    $("#liinicio").removeClass("selected"); 
    $("#lialojamiento").removeClass("selected");    
    $("#liocio").removeClass("selected");  
    $("#lirestaurantes").removeClass("selected");  
    
    $(add).addClass("selected");  
}


function autoResizeDiv()
{
    document.getElementById('site_content').style.height = window.innerHeight-255 +'px';
}

$(document).ready(function() {
    window.onresize = autoResizeDiv;
    autoResizeDiv();

    
    /** Carga imagenes **/
    /*$.backstretch([
         "http://yaentucasa.com/img/cms/malaga1.jpg"
      , "resources/media/images/a_malagueta-panorama.jpg"
      , "http://www.fuengirola.es/portal_localweb/img/portal/slideshow/1.jpg"
      , "http://fotos.diariosur.es/200907/puerto_marina-09-1.jpg"
      , "http://www.surcando.com/sites/default/files/malaga%20puerto%202.JPG"
      , "http://blog.avexperience.es/wp-content/uploads/2012/09/malaga.jpg"
      , "http://manuelortegaaparicio.files.wordpress.com/2011/07/mlaga_1.jpg"
      , "http://canales.opinionmalaga.com/turismo/wp-content/uploads/2011/02/turiiicarlos_20110127_1331361.jpg"
    ], {duration: 3500, fade: 1000}); */
        
    selectandtitle("#liinicio", "ChequeTeatinos - Inicio");     
});
