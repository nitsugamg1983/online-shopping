function $(id) {
  return document.getElementById(id);
}

dragula([$('drag-elements'), $('drop-target')], {
  revertOnSpill: true
}).on('drop', function(el) {
  if ($('drop-target').children.length > 0) {
    
	  
	  
	  $('display').innerHTML = $('drop-target').innerHTML;
    
    
	  var $dropArea = $('display');
	  
    alert($dropArea.children);
    
    
    $dropArea.children.each(function(){
    	
    })
    
    
    
//    
//    
//    $imagenes.each(function(){
//    	alert($(this).attr('src'));
//    });
    
  } else {
    $('display').innerHTML = "Display";
  }

});