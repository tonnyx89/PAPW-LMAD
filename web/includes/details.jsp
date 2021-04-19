<%-- 
    Document   : details
    Created on : 13/05/2019, 06:35:29 PM
    Author     : tonny
--%>
<%@page import="java.io.PrintWriter"%>
<%@page import="Models.Articulo"%>
<%@page import="Models.Usuario"%>
<%
     Articulo a = new Articulo();
    a =(Articulo) request.getAttribute("producto");
    
    Usuario user = (Usuario)session.getAttribute("usuario");
     
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<main>
    
    <script>
	$(document).ready(function(){

		$("#AddtoCar").click(function(){
			var id = $('[name="productoId"]').val();
			var usuario = $('[name="usuarioId"]').val(); 
			var cant = $('[name="cantidadP"]').val();;

			var data = {
				"idUsuario" : usuario,
				"idArticulo" : id,
				"cantidad" : cant	
			};

			$.ajax({
				type: "POST",
				url:"AgregarCarrito" ,
				enctype: "multipart/form-data",
				data: data,
				beforesend: function(e){
                                        alert("Se agregaron " + cant + "unidades");
				},
				success: function(e){
                                   console.log(e);
                                   $("#elementosCarrito").html(e);
                                   value = e;
				}

			});

		});
                
                
                $("#saveChanges").click(function(){
                    var nombre = document.getElementById("nomA").value;
                    var desc = document.getElementById("descA").value;
                    var pre = document.getElementById("precA").value;
                    var desct = document.getElementById("desctA").value;
                    var unids = document.getElementById("unidA").value;
                    var id =  document.getElementById("idProd").value;
                    
                    var datos = {
                        "id" : id,
                        "nombreA": nombre,
                        "descripcionA": desc,
                        "precioA": pre,
                        "unidadesA": unids,
                        "descuentoA": desct
                    };
                    
                    $.ajax({
                        url:"EditarArticulo" ,
                        type: "POST",
                        data: datos,
                        beforesend: function(){
                            
                        },
                        success: function(){
                            location.reload();
                        }
                        
                    });
                });

	});
</script>
    
    
	<div class="container">
	
			<div class="row my-4" id="detallesProducto" >
                <div class="card">
                    <div class="row no-gutters">
                        <aside class="col-sm-5 border-right">
                <article class="gallery-wrap"> 
                <div class="img-big-wrap center">
                  <div id="layImage"><img src="ImagenPrincipal?id=<%= a.getIdArticulo() %>&type=1"></div>
                </div> <!-- slider-product.// -->
                <div class="img-small-wrap">
                  <div id="im01" class="item-gallery"> <img src="ImagenPrincipal?id=<%= a.getIdArticulo() %>&type=1"></div>
                  <div id="im02" class="item-gallery"> <img src="ImagenPrincipal?id=<%= a.getIdArticulo() %>&type=1"></div>
                  <div id="im03" class="item-gallery"> <img src="ImagenPrincipal?id=<%= a.getIdArticulo() %>&type=1"></div>
                  <div id="im04" class="item-gallery"> <video src="GetVideo?id=<%= a.getIdArticulo() %>"></video></div>
                </div> <!-- slider-nav.// -->
                
                <script>
                    $(document).ready(function(){
                        $("#im01").click(function(){
                            $("#layImage").empty();
                            
                            $("#layImage").html( $("#im01").html());
                            
                        });
                        
                         $("#im02").click(function(){
                            $("#layImage").empty();
                            
                            $("#layImage").html( $("#im02").html());
                        });
                        
                         $("#im03").click(function(){
                            $("#layImage").empty();
                            
                            $("#layImage").html( $("#im03").html());
                        });
                        
                         $("#im04").click(function(){
                            $("#layImage").empty();
                            
                            $("#layImage").html( $("#im04").html());
                        });
                    });
                    </script>
                
                </article> <!-- gallery-wrap .end// -->
                        </aside>
                        <aside class="col-sm-7">
                <article class="p-5">
                    <h3 class="title mb-3"><%  out.println(a.getNombre()); %></h3>
                
                <div class="mb-3"> 
                    <var class="price h3" style="color: #f51167;"> 
                        <span class="currency" >MXN $</span><span class="num"><% out.println(a.getPrecio()); %></span>
                    </var> 
                    <span>/Pza</span> 
                </div> <!-- price-detail-wrap .// -->
                <dl>
                  <dt>Descripcion</dt>
                  <dd><p><% out.println(a.getDescripcion()); %> </p></dd>
                </dl>
                <dl class="row">
                  <dt class="col-sm-3">Modelo #</dt>
                  <dd class="col-sm-9"><% out.println(a.getIdArticulo()); %></dd>
                  <dt class="col-sm-3">Existencias: </dt>
                  <dd class="col-sm-9"><% out.println(a.getUnidades()); %></dd>
      
                </dl>
                <div class="rating-wrap">
                
                    <ul class="rating-stars">
                        <li style="width:<%out.println(a.valoraciones()+"%"); %>" class="stars-active"> 
                            <i class="fa fa-star"></i> <i class="fa fa-star"></i> 
                            <i class="fa fa-star"></i> <i class="fa fa-star"></i> 
                            <i class="fa fa-star"></i> 
                        </li>
                        <li>
                            <i class="fa fa-star"></i> <i class="fa fa-star"></i> 
                            <i class="fa fa-star"></i> <i class="fa fa-star"></i> 
                            <i class="fa fa-star"></i> 
                        </li>
                    </ul>
                    <div class="label-rating">Visto <% out.println(a.getVisitas()); %> veces</div>
                    <div class="label-rating">154 orders </div>
                </div> <!-- rating-wrap.// -->
                <hr>
                    <div class="row">
                        <div class="col-sm-5">
                            <dl class="dlist-inline">
                              <dt>Cantidad </dt>
                              <dd> 
                                  <input type="number" name="cantidadP" min="1" max="10" value=1 class="form-control" style="width:70px;">
                              </dd>
                            </dl>  <!-- item-property .// -->
                        </div> <!-- col.// -->
                        <div class="col-sm-7">
                            
                        </div> <!-- col.// -->
                    </div> <!-- row.// -->
                    <hr>
                   
                        
                        <input type="hidden" name="productoId" id="idProd" value="<%=  a.getIdArticulo() %>">
                      
                      
                        <% 
                                        if(user!=null){
                                            out.println( "<input type=\"hidden\"  id=\"usuarioId\" name=\"usuarioId\" value=\""+ user.getIdUsuario() + "\">");
                                            out.println("<button type=\"submit\" class=\"btn  btn-outline-couture\" id=\"AddtoCar\"> <i class=\"fas fa-shopping-cart\"></i> Agregar al Carrito </button>");
                                            if(user.puedeValorar(user.getIdUsuario(), a.getIdArticulo())){
                                              out.println("<button  class=\"btn  btn-couture\" type=\"button\" data-toggle=\"modal\" data-target=\"#myModal\" >Agregar Valoracion</button>");
                                            }
                                        
                                        }
                                        else{
                                            out.println("<button type=\"submit\" class=\"btn  btn-outline-couture disabled\" style=\"cursor: not-allowed;\"> <i class=\"fas fa-shopping-cart\" ></i> Agregar al Carrito </button>");
                                        }
                        %>
                         <% 
                                        if(user!=null && user.getIdUsuario()==1){
                                            out.println("<button class=\"btn btn-couture\" data-toggle=\"modal\" data-target=\"#ModalEditar\" ><i class=\"far fa-eye\"></i>  Editar</button>");
                                        
                                        }
                                       
                        %>
                  
                        
                    
                
                </article> <!-- card-body.// -->
                        </aside> <!-- col.// -->
                    </div> <!-- row.// -->
                </div> <!-- card.// -->
                
                
				
			</div>
		<div class="row">
			<div class="col-sm-12"><br><br></div>
		</div>

		

	</div>
                        
                        

</main>	
                        
 <div id="ModalEditar" class="modal fade" role="dialog">

     <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
       
        <h4 class="modal-title">Detalles de la Venta</h4>
      </div>
      <div class="modal-body">
          
        
						<div class="row">
						
							<div class="col-lg-12 col-md-12 col-sm-12">
								
								<input class="form-control my-2" type="text" name="nombreA" id="nomA" placeholder="Nombre del Articulo" value="<%= a.getNombre()  %>">
								<textarea  class="form-control my-3" name="descripcionA" id="descA" cols="30" rows="10" placeholder="Descripción del Articulo."  > <%= a.getDescripcion()%> </textarea>
							</div>
							<div class="col-lg-4 col-md-4 col-sm-12 my-2">
								<label for="">Precio: $</label>
								<input  class="form-control" type="number" name="precioA" id="precA" value="<%= a.getPrecio()%>" step="0.5">
							</div>
							<div class="col-lg-4 col-md-4 col-sm-12 my-2">
								<label for="">Existencias: </label>
								<input  class="form-control " type="number" name="unidadesA" id="unidA"  value="<%= a.getUnidades()%>">
							</div>
							<div class="col-lg-4 col-md-4 col-sm-12  my-2">
									<label for="">Descuento: </label>
								<input  class="form-control" type="number" name="descuentoA" step="0.05" id="desctA"  value="<%= a.getDescuento()%>">
                                                                <input type="hidden" name="idArtE" value="<%= a.getIdArticulo()%>">
							
							</div>
						
                                                </div>
 
        
      </div>
      <div class="modal-footer">
          <button type="button" class="btn btn-dark" data-dismiss="modal">Close</button> &nbsp; &nbsp;
        <button type="button" id="saveChanges" class="btn btn-couture" >Guardar</button>
      </div>
                        
    </div>

  </div>

</div>