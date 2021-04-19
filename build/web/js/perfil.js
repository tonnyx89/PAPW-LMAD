/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function(){
    
     $("#comprasRealizadas").hide();
     $("#conversacionesAdm").hide();      
        $("#ventasRealizadas").hide();
        
        $("#chatDesplegado").hide();
     
     getReportVentasMensual();
    
    
    $("#miCuenta").click(function(e){
        $("#comprasRealizadas").hide();
        $("#conversacionesAdm").hide();
        $("#chatDesplegado").hide();
        $("#misDatos").fadeIn("slow");
        
    });
    
     $("#misCompras").click(function(e){
        $("#misDatos").hide();
        $("#conversacionesAdm").hide();
        $("#chatDesplegado").hide();
        $("#comprasRealizadas").fadeIn("slow");
        getReportCompras();
    });
    
     $("#misVentas").click(function(e){
        getReportVentas();
        $("#conversacionesAdm").hide();
        $("#metricas").hide();
        $("#chatDesplegado").hide();
        $("#ventasRealizadas").fadeIn("slow");
        
    });
    
     $("#nuevoArt").click(function(e){
        
    });
    
    $("#miResumen").click(function(e){
        getReportVentasMensual();
        $("#chatDesplegado").hide();
         $("#conversacionesAdm").hide();
        $("#metricas").fadeIn("slow");
        $("#ventasRealizadas").hide();
    });
    
     $("#misConversaciones").click(function(e){
         $("#misDatos").hide();
         $("#chatDesplegado").hide();
             $("#metricas").hide();
          $("#ventasRealizadas").hide();
        $("#comprasRealizadas").hide();
        $("#conversacionesAdm").fadeIn("slow");
         
        loadChats();
    });
    
    
    
});

function VerChat( id, chat){
   var usuario = parseInt(id);
   var idChat = parseInt(chat);
   
   loadMessages(usuario, idChat);
   
         $("#misDatos").hide();
             $("#metricas").hide();
          $("#ventasRealizadas").hide();
        $("#comprasRealizadas").hide();
        $("#conversacionesAdm").hide();
   $("#chatDesplegado").fadeIn("slow");
   
   
}

function getReportCompras(){
    
    var usuario = $("#usuarioActual").val();
   
        	
			var parametros = {
				"idUser" : usuario,
				"pvariable" : "compras"
			};

			$.ajax({
				data: parametros,
				url: "Reportes",
				type: "POST",
                                datatype: "json",
				beforesend: function(){
					
				},
				success: function(response){
                                    if(response!=null){
                                        
                                        alert("Reporte generado!");
                                        console.log(response);
                                         $("#comprasClienteBody").empty();
                                        for(var i = 0; i < response.length; i++){
                                         
                                                    $("#comprasClienteBody").append("<tr>");
                                                    $("#comprasClienteBody").append("<td>"+ response[i].id + "</td>");
                                                    $("#comprasClienteBody").append("<td>"+ response[i].fecha + "</td>");
                                                    $("#comprasClienteBody").append("<td> $ "+ response[i].total + "</td>");
                                                    $("#comprasClienteBody").append("<td>"+ response[i].pago + "</td>");
                                                    $("#comprasClienteBody").append("<td><button class=\"btn btn-couture\" onclick=\"verDetalleCompra("+ response[i].id +");\" data-toggle=\"modal\" data-target=\"#ModalDetalleCompra\" ><i class=\"far fa-eye\"></i>  Detalle</button></td>");
                                                    $("#comprasClienteBody").append("</tr>");
       
                                        }
                                        
                                    }
                                    else{
                                        alert("No hay información para mostrar.");
                                    }
					
                                        
                                        
				}		
			}); 
    
    
}

function getReportVentas(){
      var usuario = $("#usuarioActual").val();
   
        	
			var parametros = {
				"idUser" : usuario,
				"pvariable" : "ventas"
			};

			$.ajax({
				data: parametros,
				url: "Reportes",
				type: "POST",
                                datatype: "json",
				beforesend: function(){
					
				},
				success: function(response){
                                    if(response!=null){
                                        
                                        alert("Reporte generado!");
                                        console.log(response);
                                         $("#ventasTotales").empty();
                                        for(var i = 0; i < response.length; i++){
                                         
                                                    $("#ventasTotales").append("<tr>");
                                                    $("#ventasTotales").append("<td>"+ response[i].id + "</td>");
                                                    $("#ventasTotales").append("<td>"+ response[i].fecha + "</td>");
                                                    $("#ventasTotales").append("<td> "+ response[i].nick + "</td>");
                                                    $("#ventasTotales").append("<td> $ "+ response[i].total + "</td>");
                                                    $("#ventasTotales").append("<td>"+ response[i].pago + "</td>");
                                                    $("#ventasTotales").append("<td><button class=\"btn btn-couture\" onclick=\"verDetalleVenta("+ response[i].id +","+ response[i].idUsuario +");\" data-toggle=\"modal\" data-target=\"#ModalDetalleVenta\" ><i class=\"far fa-eye\"></i>  Detalle</button></td>");
                                                    $("#ventasTotales").append("</tr>");
       
                                        }
                                        
                                    }
                                    else{
                                        alert("No hay información para mostrar.");
                                    }
					
                                        
                                        
				}		
			}); 
}

function getReportVentasMensual(){
    var parametros= {
                        "pvariable" : "mensual",
                        "id" : 0
                    };
                    
     
var d = new Date();

var mesActual = d.getMonth();
var totalAnual = 0;
                   
    $.ajax({
            data: parametros,
            url: "Reportes",
            type: "POST",
            datatype: "json",
            beforesend: function(){
		

            },
            success: function(datos){
                if(datos!=null){
                    console.log(datos);
              var ctx = document.getElementById('resumenMensual').getContext('2d');
              
              $("#totalMensual").html( datos[mesActual].total.toFixed(2));
              for(var t=0; t < datos.length; t++){
                  totalAnual = totalAnual + datos[t].total;
              }
                $("#ventaTotal").html( totalAnual.toFixed(2));
      var myChart = new Chart(ctx, {
          type: 'line',
          data: {
              labels: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun','Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
              datasets: [{
                  label: 'Ventas Mensuales',
                  data: [datos[0].total,
                        datos[1].total,
                        datos[2].total,
                        datos[3].total,
                        datos[4].total,
                        datos[5].total,
                        datos[6].total,
                        datos[7].total,
                        datos[8].total,
                        datos[9].total,
                        datos[10].total,
                        datos[11].total,
                        ],
                  backgroundColor: [
                      'rgba(255, 205, 255, 0.2)',
                    
                  ],
                  hoverBackgroundColor: ["#FF5A5E", "#5AD3D1", "#FFC870", "#A8B3C5", "#616774"],
                  borderColor: [
                    'rgba(153, 102, 255, 1)',
                      'rgba(255, 99, 132, 1)',
                      'rgba(54, 162, 235, 1)',
                      'rgba(255, 206, 86, 1)',
                      'rgba(75, 192, 192, 1)',
                      'rgba(153, 102, 255, 1)',
                      'rgba(255, 159, 64, 1)',
                      'rgba(255, 99, 132, 1)',
                      'rgba(54, 162, 235, 1)',
                      'rgba(255, 206, 86, 1)',
                      'rgba(75, 192, 192, 1)',
                      'rgba(175, 102, 192, 1)',
                  ],
                  borderWidth: 6
              }]
          },
          options: {
              scales: {
                  yAxes: [{
                      ticks: {
                          beginAtZero: true,
                          stepSize: 1000,
                          max: 10000,
                      }
                  }]
              }
          }
      });                            
                                        
                                       
       
            }                        
	}
    });
}

function verDetalleCompra(id){
    var idCompra = parseInt(id);
    var parametros= {
                        "idCompra" : idCompra,
                        "pvariable" : "detalleCompra"
                    };
                    
    $.ajax({
            data: parametros,
            url: "Reportes",
            type: "POST",
            datatype: "json",
            beforesend: function(){
		

            },
            success: function(response){
                if(response!=null){
                                        
                                        
                                        console.log(response);
                                         $("#detalleComprasTable").empty();
                                        for(var i = 0; i < response.length; i++){
                                         
                                                    $("#detalleComprasTable").append("<tr>");
                                                    $("#detalleComprasTable").append("<td>"+ response[i].cant+ "</td>");
                                                    $("#detalleComprasTable").append("<td><a href =\"detalleProducto?idProducto="+response[i].idArt +"\" >"+ response[i].art + "</a></td>");
                                                    $("#detalleComprasTable").append("<td> $ "+ response[i].total + "</td>");
                                                    
                                                    $("#detalleComprasTable").append("</tr>");
       
                                        }
                                        
                                    }
	}
    });
}

function verDetalleVenta(id, user){
    var venta = parseInt(id); 
    var usuario = parseInt(user);
    
    var parametros = {
        "idUsuario" : usuario,
        "idVenta" : venta,
        "pvariable" : "detalleVenta"
    };
    
        $.ajax({
            data: parametros,
            url: "Reportes",
            type: "POST",
            datatype: "json",
            beforesend: function(){
		

            },
            success: function(response){
                if(response!=null){
                                        
                                        
                                        console.log(response);
                                         $("#detalleVenta").empty();
                                        for(var i = 0; i < response.length; i++){
                                         
                                                    $("#detalleVenta").append("<tr>");
                                                    $("#detalleVenta").append("<td>"+ response[i].cant+ "</td>");
                                                    $("#detalleVenta").append("<td><a href =\"detalleProducto?idProducto="+response[i].idArt +"\" >"+ response[i].art + "</a></td>");
                                                    $("#detalleVenta").append("<td> $ "+ response[i].total + "</td>");
                                                    
                                                    $("#detalleVenta").append("</tr>");
       
                                        }
                                        
                                    }
	}
    });
    
}


function sendMessage(){
    
    var usuario = document.getElementById("usuarioActual").value;
    var mensaje = document.getElementById("msnChat").value;
    var recibe = document.getElementById("idReceptor").value;
    var chat  = document.getElementById("idChat").value;
    
    var data = {
        "idEnvia" : usuario,
        "idRecibe" : recibe,
        "mensaje" : mensaje,
        "idChat" : chat,
        "pvariable" : "enviar"
    };
    
    
    $.ajax({
        url: "ChatCompra",
        type: "POST" ,
        data: data,
        beforesend: function(){
             loadMessages(usuario, compra);
              
               document.getElementById("msnChat").value = "";
        },
        success: function(){
            var compra =  document.getElementById("compraActual").value;
            loadMessages(usuario, compra);
         
        }
    });
    
}


function loadMessages(us, com){
    var compra = com;
    var usuario = us;
     var actual = document.getElementById("usuarioActual").value;
     document.getElementById("compraActual").value = compra;
    var data={
        "compra" : compra,
        "usuario" : usuario,
        "pvariable" : "ver"
    };
    
    console.log(data);
    
      $("#ContenidoChat").empty();
    
    $.ajax({
         url: "ChatCompra",
        type: "POST" ,
        data: data,
        beforesend: function(){
             $("#ContenidoChat").empty();
        },
        success: function(msg){
            
            if(msg.length > 0){
                
                for(var x = 0; x < msg.length; x++){
                   if(msg[x].envia == actual){
                        $("#ContenidoChat").append("<div class=\"container sentMsg\"><div class=\"row text-left\"><div class=\"col-sm-12\"><small id=\"nicknameSent\"></small></div></div><div class=\"row\" id=textoMensaje><div class=\"col-sm-12\">" + msg[x].mensaje + "</div></div><div class=\"row text-right\"><div class=\"col-sm-12\"><small>" + msg[x].fecha +"</small></div></div></div>");
                     
                   }
                   else{
                        document.getElementById("idReceptor").value = msg[x].envia;
                         document.getElementById("idChat").value = msg[x].chat;
                         $("#ContenidoChat").append("<div class=\"container recivedMsg\"><div class=\"row text-left\"><div class=\"col-sm-12\"><small id=\"nicknameSent\"></small></div></div><div class=\"row\" id=textoMensaje><div class=\"col-sm-12\">" + msg[x].mensaje + "</div></div><div class=\"row text-right\"><div class=\"col-sm-12\"><small>" + msg[x].fecha +"</small></div></div></div>");
                   }
                }
            }
            else{
                
            }
            
        }
        
    });
}


function loadChats(){
    var usuario = document.getElementById("usuarioActual").value;
    
    var datos = {
      "idUsuario" : usuario,
      "pvariable" : "listaChats" 
    };
    
    console.log(datos);
    
    $.ajax({
        url:"ChatCompra" ,
        type: "POST",
        data: datos,
        beforesend: function(){
            
        },
        success: function(result){
            $("#conversacionesTabla").empty();
           if( result.length > 0)
           {
               var cts = result;
               console.log(cts);
              for(var i=0; i < result.length; i++) 
              {
                  $("#conversacionesTabla").append("<tr>");
             $("#conversacionesTabla").append("<td>" + result[i].idCompra  +"</td>");
              $("#conversacionesTabla").append("<td>" + result[i].fecha  +"</td>");
               $("#conversacionesTabla").append("<td>" + result[i].usuario  +"</td>");
                $("#conversacionesTabla").append("<td><button class=\"btn btn-couture\" onclick=\"VerChat(" + result[i].usuario +","+ result[i].idCompra  +");\">Ver Chat</button></td>");
             $("#conversacionesTabla").append("</tr>");
              }
           }
           else{
                $("#conversacionesTabla").append("<tr>");
             $("#conversacionesTabla").append("<td colspan=4> No hay registros </td>");
             
              $("#conversacionesTabla").append("</tr>");
           }
        }
    });
}

function terminarChat(){
    var usuario = document.getElementById("idReceptor").value;
    var compra = document.getElementById("compraActual").value;
    var precio = document.getElementById("nuevoPrecio").value;
    
    var datos = {
      "usuario" : usuario,
      "compra" : compra,
      "precio" : precio,
      "pvariable" : "terminar"
    };
    
    $.ajax({
        url: "ChatCompra",
        type: "POST",
        data: datos,
        beforesend: function(){
            
        },
        success: function(){
         
         alert('Se ha ajustado el total de la compra a $' + precio);
            
        }
    });
    
}
                                               
