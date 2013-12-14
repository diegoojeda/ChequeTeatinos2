var map;
var geocoder;
var destino;
var pos;




function initializeRutas(destino){  
    
    
        geocoder = new google.maps.Geocoder();
        var mapOptions = {
                zoom: 16,              
                mapTypeId: google.maps.MapTypeId.ROADMAP
        };
       
        map = new google.maps.Map(document.getElementById('map_canvas'), mapOptions);
        
        // HTML5 geolocation
        
        if(navigator.geolocation) {
          navigator.geolocation.getCurrentPosition(function(position) {
             pos = new google.maps.LatLng(position.coords.latitude,
                                             position.coords.longitude);
           
            var infowindow = new google.maps.InfoWindow({
              map: map,
              position: pos,
              content: 'Estas aqui'
            });
            map.setCenter(pos);
            var com1= "\"";
            //var origen = new String(pos);
            //alert (origen);
            var res = com1.concat(pos);
           
            var res2 = res.concat(com1);
           // alert("res2 despues"+res2);
            //alert("pos"+pos);
         //   });
           //////////////////////////////////////////////////////////
            var request = {
                    origin:pos,//Aqui es donde me falla
                    destination:destino,
                    travelMode: google.maps.TravelMode.DRIVING
            };
        
        var directionsService = new google.maps.DirectionsService();
        var directionsDisplay = new google.maps.DirectionsRenderer();
       
        // Indicamos dónde esta el mapa para renderizarnos
        directionsDisplay.setMap(map);
        // Indicamos dónde esta el panel para mostrar el texto
        directionsDisplay.setPanel(document.getElementById("directionsPanel"));
       
        directionsService.route(request, function(result, status) {
            if (status == google.maps.DirectionsStatus.OK) {
              directionsDisplay.setDirections(result);
            }
          });
   
          }, function() {
            handleNoGeolocation(true);
            
          });
        } else {
          // Browser doesn't support Geolocation
          handleNoGeolocation(false);
        }
        
        //alert("despues del if"+pos);
        function handleNoGeolocation(errorFlag) {
            if (errorFlag) {
              var content = 'Error: The Geolocation service failed.';
            } else {
              var content = 'Error: Your browser doesn\'t support geolocation.';
            }

            var options = {
              map: map,
              position: new google.maps.LatLng(60, 105),
              content: content
            };

            var infowindow = new google.maps.InfoWindow(options);
            map.setCenter(options.position);
        }
        
       // $(document).ready(function(){
       
}

google.maps.event.addDomListener(window, 'load', initializeRutas);


function ruta(){
    document.getElementById('cambiarvista').src = "resources/media/images/position.png";
    document.getElementById('mapa').style.height = "0px";
    document.getElementById('mapa').style.visibility = "hidden";
    document.getElementById('map_canvas').style.height = "400px";
    document.getElementById('directionsPanel').style.height = "400px";
    document.getElementById('map_canvas').style.visibility = "visible";
    document.getElementById('directionsPanel').style.visibility = "visible";
    
}
