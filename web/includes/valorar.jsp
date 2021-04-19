<%-- 
    Document   : valorar
    Created on : 22/05/2019, 06:43:04 PM
    Author     : tonny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="modal fade" id="myModal" role="dialog">
	
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">VALORAR ARTICULO</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
			
				<fieldset class="rating">
				    <input type="radio" id="star5" name="rating" value="5" /><label class = "full" for="star5" title="Awesome - 5 stars"></label>
				    <input type="radio" id="star4half" name="rating" value="4.5" /><label class="half" for="star4half" title="Pretty good - 4.5 stars"></label>
				    <input type="radio" id="star4" name="rating" value="4" /><label class = "full" for="star4" title="Pretty good - 4 stars"></label>
				    <input type="radio" id="star3half" name="rating" value="3.5" /><label class="half" for="star3half" title="Meh - 3.5 stars"></label>
				    <input type="radio" id="star3" name="rating" value="3" /><label class = "full" for="star3" title="Meh - 3 stars"></label>
				    <input type="radio" id="star2half" name="rating" value="2.5" /><label class="half" for="star2half" title="Kinda bad - 2.5 stars"></label>
				    <input type="radio" id="star2" name="rating" value="2" /><label class = "full" for="star2" title="Kinda bad - 2 stars"></label>
				    <input type="radio" id="star1half" name="rating" value="1.5" /><label class="half" for="star1half" title="Meh - 1.5 stars"></label>
				    <input type="radio" id="star1" name="rating" value="1" /><label class = "full" for="star1" title="Sucks big time - 1 star"></label>
				    <input type="radio" id="starhalf" name="rating" value="0.5" /><label class="half" for="starhalf" title="Sucks big time - 0.5 stars"></label>
				 </fieldset>
				
			 </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
			 <button class="btn btn-success" type="button" onclick="valorarArticulo();">Guardar</button>
			
          <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
        </div>
        
      </div>
    </div>
 </div>

<script>
	function valorarArticulo(){

		var usuario = parseInt(document.getElementById("usuarioId").value);
		var producto = parseInt(document.getElementById("idProd").value);
		var raiting = parseFloat($("input[name=rating]:checked").val());

               
		var parametros= {
			"idU" : usuario,
			"idP" : producto,
			"estrellas" : raiting,
			"valorar" : "valoracion"
		};

		
	
		$.ajax({
					data: parametros,
					url: "ValorarArticulo",
					type: "POST",
					beforesend: function(){
						
						

					},
					success: function(response){
						
						console.log(parametros);	
						alert("¡Gracias por su compra!");
						location.reload();
						
						
					}		
				});


	}
</script>
