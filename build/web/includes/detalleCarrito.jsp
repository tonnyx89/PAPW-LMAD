<%-- 
    Document   : detalleCarrito
    Created on : 16/05/2019, 07:21:27 PM
    Author     : tonny
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Models.Articulo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    ArrayList<Articulo> pdts = (ArrayList) request.getAttribute("carrito");
%>


<main>

 <div class="container">
            <div class="row my-3">
                
				<h2 class="text-center">Carrito de Compras</h2>
				<hr>
                                <br>
            </div>
	<div class="row my-2">
			<div class="col-lg-8 col-md-10 col-sm-12">
				
					<div class="card cart-main">
						<table class="table table-hover shopping-cart-wrap">
						<thead class="text-muted">
						<tr>
						  <th scope="col">Producto</th>
						  <th scope="col" width="120">Cantidad</th>
						  <th scope="col" width="120">Precio</th>
						  <th scope="col" class="text-right" width="200">Acción</th>
						</tr>
						</thead>
						<tbody>
                                                    
                                                <%
                                                    if(!pdts.isEmpty()){
                                                        int var = 0;                                                        
                                                    for(Articulo in : pdts){
                                                        var+=1;
                                                %>   
                                                    <tr id="<%= var %>">
                                                            <td >
                                                               
                                                                <input type="hidden" name="pID" id="prod<%= var%>" value="<%= in.getIdArticulo()%>">
                                                                <input type="hidden" name="pDes" id="descuento<%= var%>"   value="<%= in.getDescuento() %>">
                                                                <input type="hidden" name="pID" id="precio<%= var%>" value="<%= in.getPrecio() %>">
                                                                
                                                                
                                                                <figure class="media">
                                                                    <div class="img-wrap"><img src="ImagenPrincipal?id=<%= in.getIdArticulo() %>&type=1" class=" img-xs"></div>
                                                                    <figcaption class="media-body">
                                                                        <h6 class="title text-truncate"><%= in.getNombre() %></h6>
                                                                        <dl class="dlist-inline small">
                                                                           
                                                                          <dt>Descuento: </dt>
                                                                          <dd><% if(in.getDescuento()< 0){ out.print("N/A"); }else{out.print(in.descuentoPorcentaje());} %> </dd>
                                                                        </dl>
                                                                    </figcaption>
                                                                </figure> 
                                                            </td>
                                                            <td>  
                                                                <input onchange="calcularCarrito();updateProducto('prod<%= var%>','prod-cant<%= var%>');" class="form-control"  name="cantidad<%= var%>" id="prod-cant<%= var%>" type="number" min="1" max="99" name="cantidad" value="<%= in.getUnidades() %>">
                                                            </td>
                                                            <td> 
                                                                <div class="price-wrap"> 
                                                                    <var  value="<%= in.getPrecio() %>" class="price">$ <%= in.getPrecio() %></var> 
                                                                    <small class="text-muted">(MXN)</small> 
                                                                </div> <!-- price-wrap .// -->
                                                            </td>
                                                            <td class="text-right"> 
                                                                <a data-original-title="Save to Wishlist" title="" href="" class="btn btn-outline-success" data-toggle="tooltip"> <i class="fa fa-heart"></i></a> 
                                                                <button onclick="eliminarArticulo(<%= var %>,<%= in.getIdArticulo() %>)" class="btn btn-outline-danger"> × Remover</button>
                                                            </td>
                                                    </tr>
                                                    <% 
                                                            }
                                                         %>
                                                <input type="hidden" id="intValues" name="intValues" value="<%= var%>">
                                                <%
                                                        }
                                                        else{
                                                            
                                                           out.print("<tr><td colspan=4 class=\"text-center\"> Sin Artitculos </td></tr>");
                                                           
                                                        }
                                                      %>
                                                    
                                                    
						
						</tbody>
						</table>
						</div> <!-- card.// -->
				<br>
				<br>
			</div>

			<div class="col-lg-4 col-md-2 col-sm-12">
				<p class="alert alert-success">Todos los envíos nacionales son gratuitos. Para envíos internacionales contacta a Servicio a Cliente. </p>
					<dl class="dlist-align">
					  <dt>Subtotal: </dt>
					  <dd id="subtotal" class="text-right">$ &nbsp;</dd>
					</dl>
					<dl class="dlist-align">
					  <dt>Descuento:</dt>
					  <dd id="descuento" class="text-right">$ &nbsp;</dd>
					</dl>
					<dl class="dlist-align">
					  <dt>IVA:</dt>
					  <dd id="IVA" class="text-right">$ &nbsp;</dd>
					</dl>
					<dl class="dlist-align h4">
					  <dt>Total:</dt>
					  <dd class="text-right"><strong>$ &nbsp;</strong><strong id="total-carrito"></strong></dd>
					</dl>
					<hr>

					<div class="row">
						<figure class="mb-3 col">
								<div class="text-wrap small text-muted">
									Elija el método de pago:
								</div>
								<br>
								<select class="form-control" name="pay-method" id="metodoPago" style="width:100%;">
									<option value="0" disabled selected>Seleccione</option>
									<option value="1">Crédito</option>
									<option value="2">Débito</option>
									<option value="3">OXXO</option>
									<option value="4">Paypal</option>
									<option value="5">Transferencia</option>
								</select>
						</figure>
						<br>
						<br>
					</div>

					<figure class="itemside mb-3">
						<aside class="aside"><img src="img/icons/pay-visa.png"></aside>
						 <div class="text-wrap small text-muted">
					Paga a 12 MSI <br>
					Solo bancos participantes 
						 </div>
					</figure>
					<figure class="itemside mb-3">
						<aside class="aside"> <img src="img/icons/pay-mastercard.png"> </aside>
						 <div class="text-wrap small text-muted">
					Recibe 10% de bonificación pagando con MasterCard 
					 
						 </div>
					</figure>
					<hr>

					<div class="row">
						<figure class="itemside mb-3 col">
							<button type="button" onclick="confirmarCompra();" class="btn btn-primary btn-block">Confirmar Pedido</button>
						</figure>
						<figure class="itemside mb-3 col">
							<button type="button" onclick="vaciarCarrito();" class="btn btn-danger btn-block">Vaciar Carrto</button>
						</figure>
					</div>
			</div>

		</div>
</div>
</main>
