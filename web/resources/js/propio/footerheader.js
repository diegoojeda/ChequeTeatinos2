/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var varplay=1;
function play(){
    if(varplay == 1){
        document.getElementById('playpause').src = 'resources/media/images/play.png';
        $.backstretch("pause");
        varplay=0;
    }
    else{
        document.getElementById('playpause').src = 'resources/media/images/pause.png';
        $.backstretch("resume");
        varplay=1;
    }
}


$(document).ready(function(){
    $("#logo").load('structpage/header.html', function(){
        initlogo();
    });
    $('aside').load('structpage/aside.html');
    $('footer').load('structpage/footer.html');
});
