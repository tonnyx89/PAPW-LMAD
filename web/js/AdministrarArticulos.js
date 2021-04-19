/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    $("#nuevoArticulo").hide();
      $("#borradores").hide();
      verArticulos();
    $("#inventario").show();
    
    $("#articulosP").click(function(){
        verArticulos();
           $("#nuevoArticulo").hide();
      $("#borradores").hide();
    $("#inventario").fadeIn("slow");
    });
    
     $("#articulosB").click(function(){
          verBorradores();
           $("#nuevoArticulo").hide();
      $("#borradores").fadeIn("slow");
    $("#inventario").hide();
    });
    
     $("#articulosN").click(function(){
           $("#nuevoArticulo").fadeIn("slow");
      $("#borradores").hide();
    $("#inventario").hide();
    });
});


function guardarNuevo(){
    
}


function guardarBorrador(){
    
}

function publicar(id){
    
    var articulo = parseInt(id);
    
     var datos = {
       "op": "publicar",
       "idArticulo": articulo
   };
   
 $.ajax({
        url: "GestionArticulos",
       type: "POST",
       data: datos,
       beforesend: function(){
           
       },
       success: function(){
           location.reload();
       }
});
    
}

function eliminarArticulo(id){
     var articulo = parseInt(id);
     
        var datos = {
       "op": "eliminar",
       "idArticulo": articulo
   };
   
    $.ajax({
        url: "GestionArticulos",
       type: "POST",
       data: datos,
       beforesend: function(){
           
       },
       success: function(){
           location.reload();
       }
});
   
}



function verBorradores(){
   
   var datos = {
       "op": "borradores"
   };
   
   $.ajax({
       url: "GestionArticulos",
       type: "POST",
       data: datos,
       beforesend: function(){
            $("#inventarioBorradores").empty();
          
       },
       success: function(result){
           console.log(result);
              $("#inventarioBorradores").empty()
           if(result.length > 0){
               for(var x = 0; x< result.length; x++){
                   $("#inventarioBorradores").append("<tr>");
                $("#inventarioBorradores").append("<td>"+ result[x].id +"</td>");
                $("#inventarioBorradores").append("<td>"+ result[x].nombre +"</td>");
                 $("#inventarioBorradores").append("<td>"+ result[x].precio +"</td>");
                $("#inventarioBorradores").append("<td>"+ result[x].stock +"</td>");
                $("#inventarioBorradores").append("<td><button class=\"btn btn-danger\" type=buttton onclick=\"publicar("+ result[x].id +");\"> Publicar </button></td>");
               $("#inventarioBorradores").append("</tr>");
               }
           }
           else{
               
           }
       }
   });
   
}

function verArticulos(){
  var datos = {
       "op": "ver"
   };
   
   $.ajax({
       url: "GestionArticulos",
       type: "POST",
       data: datos,
       beforesend: function(){
           
            $("#inventarioPublico").empty()
       },
       success: function(result){
              $("#inventarioPublico").empty()
           console.log(result);
           if(result.length > 0){
               for(var x = 0; x< result.length; x++){
                   $("#inventarioPublico").append("<tr>");
                $("#inventarioPublico").append("<td>"+ result[x].id +"</td>");
                $("#inventarioPublico").append("<td>"+ result[x].nombre +"</td>");
                 $("#inventarioPublico").append("<td>"+ result[x].precio +"</td>");
                $("#inventarioPublico").append("<td>"+ result[x].stock +"</td>");
                  $("#inventarioPublico").append("<td><button class=\"btn btn-danger\" type=buttton onclick=\"eliminarArticulo("+ result[x].id +");\"> Eliminar </button></td>");
               $("#inventarioPublico").append("</tr>");
               }
           }
           else{
               
           }
       }
   });
   
   
}