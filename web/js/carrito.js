/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
   
       calcularCarrito();
       
   
       
       
      

	
});

function calcularCarrito(){
     var campos = $("#intValues").val();
        
    var Subtotal=0;
	var multiP=0;
	var multiC=0;
	var descuento=0;
	var sumDcto =0;
	var iva = 0;
	var total = 0;

	for(i=1; i <= campos; i++){
	
		multiP = parseFloat(document.getElementById("precio" + i).value);
		multiC = parseFloat(document.getElementById("prod-cant"+ i).value);
		descuento = parseFloat(document.getElementById("descuento"+ i).value);
		Subtotal+=(multiP*multiC);
		sumDcto+=(descuento*multiP)*multiC;

	}
        
        console.log(descuento);
        
	document.getElementById("subtotal").innerHTML ="$  " + Subtotal.toFixed(2);
	document.getElementById("descuento").innerHTML ="$  " + sumDcto.toFixed(2);
	iva = Subtotal * 0.16;	
	document.getElementById("IVA").innerHTML ="$  " + iva.toFixed(2);

	total =  (Subtotal-sumDcto)+ iva;
        console.log(total);

	document.getElementById("total-carrito").innerHTML = total.toFixed(2);
      
        
        
}

function eliminarArticulo(element, prod){
   	var prodt = document.getElementById(prod).value;
	var usuario =  document.getElementById('usId').value;
        var rem = "#" + element;

		var confr = confirm('¿Desea eliminar el articulo de su carrito de compra?');

		if(confr===true){
                 
                   
                     	
			var parametros = {
				"idUser" : usuario,
				"idProducto" : prod,
				"pvariable" : "eliminar"
			};

			$.ajax({
				data: parametros,
				url: "EditarCarrito",
				type: "POST",
				beforesend: function(){
					
				},
				success: function(response){
                                    
					 $(rem).remove();
                                         location.reload();
                                        
				}		
			}); 
} 
    
   
    
}

function vaciarCarrito(){
    
		var usuario =  document.getElementById('usId').value;
		var confr = confirm('¿Desea vaciar TODO el contenido de su carrito de compra?');

		if(confr===true){
			var parametros = {
				"idUser" : usuario,
				"pvariable" : "vaciar",
			};

			$.ajax({
				data: parametros,
				url: "EditarCarrito",
				type: "POST",
				beforesend: function(){
					
				},
				success: function(response){
					location.reload();
				}		
			});
		}
}


function updateProducto(pro, cantd){
    
		var prod = document.getElementById(pro).value;
		var cant = document.getElementById(cantd).value;
		var usuario =  document.getElementById('usId').value;


		var parametros = {
			"idUser" : usuario,
			"cantidad" : cant,
			"idProducto" : prod,
			"pvariable" : "update",
		};

		$.ajax({
			data: parametros,
			url: "EditarCarrito",
			type: "POST",
			beforesend: function(){
				
			},
			success: function(response){
				location.reload();
			}		
		}); 
}


function confirmarCompra(){
		
		var usuario =  document.getElementById('usId').value;
		var pago =  document.getElementById('metodoPago').value;
		console.log(pago);
                console.log(usuario);
		if(pago > 0)
		{
                    
		var parametros = {
			"idUser" : usuario,
			"pago" : pago,
			"pvariable" : "confirmar"
		};

		var result = confirm('¿Desea realizar su compra?');
			if(result === true){
				$.ajax({
					data: parametros,
					url: "EditarCarrito",
					type: "POST",
					beforesend: function(){
						alert('Su compra será procesada. Esta acción no se puede deshacer.');
					},
					success: function(response){
						
							
							location.reload(); 
						
						
					}		
				});
			}
		}
		else
		{
			alert('Seleccione un método de pago.');
		}
}