<%-- 
    Document   : results
    Created on : 13/05/2019, 08:01:26 PM
    Author     : tonny
--%>

<%@page import="javax.swing.ImageIcon"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.io.ByteArrayInputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Base64"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.List"%>
<%@page import="Models.Articulo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="container-fluid">
	
	<div class="row">
		<div class="col-lg-2 col-md-4 col-md-sm-11 bg-light border-right " id="sidebar-wrapper">
      			<div class="sidebar-heading" ><br>ELLAS </div>
			      <div class="list-group list-group-flush ">
			        <a href="Buscador?buscar=Jeans&id=1" class="list-group-item list-group-item-action bg-light ">Jeans</a>
			        <a href="Buscador?buscar=Tops&id=2"class="list-group-item list-group-item-action bg-light">Tops</a>
			        <a href="Buscador?buscar=Bottoms&id=3" class="list-group-item list-group-item-action bg-light">Bottoms</a>
			        <a href="Buscador?buscar=Shoescat&id=4" class="list-group-item list-group-item-action bg-light">Shoes</a>
			        <a href="Buscador?buscar=Jacket&id=5" class="list-group-item list-group-item-action bg-light">Jackets & Sweaters</a>
			        <a href="Buscador?buscar=Acc&id=6" class="list-group-item list-group-item-action bg-light">Accesorios</a>
			      </div>
                        <div class="sidebar-heading"><br>ELLOS </div>
			      <div class="list-group list-group-flush ">
                                <a href="Buscador?buscar=Jeans&id=1" class="list-group-item list-group-item-action bg-light ">Jeans</a>
			        <a href="Buscador?buscar=Tops&id=2"class="list-group-item list-group-item-action bg-light">Tops</a>
			        <a href="Buscador?buscar=Bottoms&id=3" class="list-group-item list-group-item-action bg-light">Bottoms</a>
			        <a href="Buscador?buscar=Shoescat&id=4" class="list-group-item list-group-item-action bg-light">Shoes</a>
			        <a href="Buscador?buscar=Jacket&id=5" class="list-group-item list-group-item-action bg-light">Jackets & Sweaters</a>
			        <a href="Buscador?buscar=Acc&id=6" class="list-group-item list-group-item-action bg-light">Accesorios</a>

			        <a href="#" class="list-group-item list-group-item-action bg-light">Todo</a>
			      </div>
    		
		</div>
	
		<div class="col-lg-10 col-md-8 col-md-sm-11">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="row">
                                                Resultados:
					<br>
                                                
					</div>
                                    <div class="row">
                                        <div class="col-lg-4 col-md-2 col-sm-12">&nbsp;</div>
                                        <div class="col-lg-4 col-md-8 col-sm-12">
                                            Filtrar por fecha:
                                                
                                                <br>
                                                <form action="Buscador" method="GET">
                                                    <input type="hidden" name="buscar" value="fecha">
                                                De: <input type="date" id="fechaDesde" name="desde" id="desde" class="form-control" required> Hasta:  <input type="date" name="hasta" id="fechaHasta" class="form-control" required> &nbsp; <button class="btn btn-couture my-2"  type="submit">Filtrar</button>
                                                </form>
                                                
                                                <script>
                                                    
                                                    var now = new Date();

var day = ("0" + now.getDate()).slice(-2);
var month = ("0" + (now.getMonth() + 1)).slice(-2);

var today = now.getFullYear()+"-"+(month)+"-"+(day) ;

$('#fechaDesde').val(today);
$('#fechaHasta').val(today);
                                                    
                                                </script>
                                        </div>
                                        <div class="col-lg-4 col-md-2 col-sm-12">&nbsp;</div>
                                    </div>
					<div class="row">
                                            
                                            <%
                                                  List<Articulo> resultados = (List) request.getAttribute("productos");
                                                  String parametro = (String) request.getAttribute("keyword");
                                                    if(resultados != null){
                                                        
                                                       for(Articulo art : resultados){
                                                      
         

                                                        
                                                            
                                                      
                                              %>
                                              
						<div class="col-lg-3 col-md-6 col-sm-12 item-result">
                                                    <a href="detalleProducto?idProducto=<%= art.getIdArticulo() %>" style="text-decoration: none;">
							<figure class="card card-product">
                                                            <div class="img-wrap"><img class="img-product" src="ImagenPrincipal?id=<%= art.getIdArticulo() %>&type=1"></div>
								<figcaption class="info-wrap">
                                                                    <a href="#" class="title"><%= art.getNombre() %></a>
									<div class="price-wrap">
										<span class="price-new">$ <%= art.getPrecio() %> </span>
									</div> <!-- price-wrap.// -->
								</figcaption>
							</figure> <!-- card // -->
                                                    </a>
						</div> <!-- col // -->

                                                <%
                                                    
                                                      }
                                                    }
else{
        out.print("<h3>No hay coincidencias para"+ parametro + "</h3>");
}
                                                    
                                                    %>
					







						

					</div>	
					</div>
				</div>
				<div class="row">
					<div class="col-lg-3 col-md-1 col-sm-0"></div>
					<div class="col-lg-6 col-md-10 col-sm-12">
						<ul class="pagination justify-content-center" style="margin:20px 0">
  							<li class="page-item"><a class="page-link" href="#">Previous</a></li>
							<li class="page-item"><a class="page-link" href="#">1</a></li>
							<li class="page-item"><a class="page-link" href="#">2</a></li>
							<li class="page-item"><a class="page-link" href="#">3</a></li>
							<li class="page-item"><a class="page-link" href="#">Next</a></li>
						</ul>
					</div>
					<div class="col-lg-3 col-md-1 col-sm-0"></div>
				</div>
			</div>
	</div>
</div>