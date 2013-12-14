var map;
var panorama;
var geocoder;
function initialize(direccion, nombre, imagen, informacion) {          
      geocoder = new google.maps.Geocoder();
      var pos = new google.maps.LatLng(-25.363882,131.044922);


        // Create an array of styles.
        var styles = [
            {
              "stylers": [
                { "invert_lightness": true }
              ]
            }
          ];

        // Create a new StyledMapType object, passing it the array of styles,
        // as well as the name to be displayed on the map type control.
        var styledMap = new google.maps.StyledMapType(styles,
          {name: "Styled Map"});

        // Create a map object, and include the MapTypeId to add
        // to the map type control.
        var mapOptions = {
          zoom: 16,
          center: pos,
          mapTypeControlOptions: {
            mapTypeIds: [google.maps.MapTypeId.ROADMAP, 'map_style']
          }
        };

      

      var map = new google.maps.Map(document.getElementById('mapa'), mapOptions);

        map.mapTypes.set('map_style', styledMap);
        map.setMapTypeId('map_style');

      var contentString = '<div id="content">'+
                            '<div id="siteNotice">'+
                            '</div>'+
                            '<h2 id="firstHeading" class="firstHeading">'+ nombre +'</h2>'+
                            '<div id="bodyContent">'+
                            '<img class="colimages" src="'+ imagen +'" alt="'+ nombre +'"/>'+
                            '</div>'+
                            '</div>';

      var infowindow = new google.maps.InfoWindow({
          content: contentString
      });
      
    

    var address = direccion;
    geocoder.geocode( { 'address': address}, function(results, status) {




      if (status == google.maps.GeocoderStatus.OK) {
        map.setCenter(results[0].geometry.location);
        panorama = map.getStreetView();
        panorama.setPosition(results[0].geometry.location);
        panorama.setPov(/** @type {google.maps.StreetViewPov} */({
          heading: 265,
          pitch: 0
        }));      
        var marker = new google.maps.Marker({
            map: map,
            position: results[0].geometry.location
        });
        google.maps.event.addListener(marker, 'click', function() {
          infowindow.open(map,marker);
        });            
      } else {
        alert('Geocode was not successful for the following reason: ' + status);
      }
    });
    
    
} 

var rutas = false;
function toggleStreetView() {
    if(document.getElementById('mapa').style.height == "0px"){
        document.getElementById('mapa').style.height = "400px";
        document.getElementById('mapa').style.visibility = "visible";
        document.getElementById('map_canvas').style.height = "0px";
        document.getElementById('directionsPanel').style.height = "0px";
        document.getElementById('map_canvas').style.visibility = "hidden";
        document.getElementById('directionsPanel').style.visibility = "hidden";
          document.getElementById('cambiarvista').src = "resources/media/images/street_view.png";
    }
    else{
        
        
        var toggle = panorama.getVisible();
        if (toggle == false) {      
          document.getElementById('cambiarvista').src = "resources/media/images/position.png";
          document.getElementById('cambiarvista').alt = "Mapa";
          document.getElementById('cambiarvista').title = "Ver Mapa";
          panorama.setVisible(true);
        } else {
          document.getElementById('cambiarvista').src = "resources/media/images/street_view.png";
          document.getElementById('cambiarvista').alt = "Street View";
          document.getElementById('cambiarvista').title = "Ver Street View";
          panorama.setVisible(false);
        }
    }
}
