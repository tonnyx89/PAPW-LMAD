<%-- 
    Document   : landscape
    Created on : 5/05/2019, 08:51:00 PM
    Author     : tonny
--%>
<%@page import="java.util.List"%>
<%@page import="Models.Articulo"%>
<main>
		<div class="container-fluid">
	<div class="row">
	<div class="col-lg-12 col-md-12 col-md-sm-12">
			<div class="row">
				<div id="slideShow" class="carousel slide" data-ride="carousel">
					  <ul class="carousel-indicators">
						    <li data-target="#slideShow" data-slide-to="0" class="active"></li>
						    <li data-target="#slideShow" data-slide-to="1"></li>
						    <li data-target="#slideShow" data-slide-to="2"></li>
						    <li data-target="#slideShow" data-slide-to="3"></li>
					  </ul>
						  <div class="carousel-inner">
								<div class="carousel-item active">
								    <img src="img/carrusel/1.jpg" alt="Los Angeles" >
								    <div class="carousel-caption">
								      	<div class="col-sm-6 sliderText">
								      		
								      				<h3 class="slideTitle">GRATIS</h3>
								       		 		<p class="slidePromo">Todos los envíos nacionales en prendas de la colección de Primavera</p>
								       		 		<p>
								       		 			<button type="button" class="btn btn-light">Ver más</button> &nbsp;
								       		 			<button type="button" class="btn btn-outline-light">Ver más</button>
								       		 		</p>								      	
								      	</div>
								      							 
									</div>   
							    </div>
						    	<div class="carousel-item">
							      <img src="img/carrusel/2.jpg" alt="Chicago">
							      <div class="carousel-caption">
							        	<div class="col-sm-6 sliderText">
								      		
								      				<h3 class="slideTitle">REBAJAS</h3>
								       		 		<p class="slidePromo">Todos los envíos nacionales en prendas de la colección de Primavera</p>
								       		 		<p>
								       		 			<button type="button" class="btn btn-light">Ver más</button> &nbsp;
								       		 			<a href="#Rebajas"><button type="button" class="btn btn-outline-light">Ver más</button></a>
								       		 		</p>								      	
								      	</div>
							      </div>   
						    	</div>
							   <div class="carousel-item">
								      <img src="img/carrusel/3.jpg" alt="New York">
								      <div class="carousel-caption">
								      	<div class="col-sm-6">&nbsp;</div>
									        <div class="col-sm-6 sliderText">
								      		
								      				<h3 class="slideTitle">LO MEJOR</h3>
								       		 		<p class="slidePromo">Los mejores productos de la temporada para Ellas.</p>
								       		 		<p>
								       		 			<button type="button" class="btn btn-light">Ver más</button> &nbsp;
								       		 			<a href="#BestToHer"><button type="button" class="btn btn-outline-light">Ver más</button></a>
								       		 		</p>								      	
								      	</div>
								     </div>   
						    	</div>
						    	<div class="carousel-item">
								      <img src="img/carrusel/4.jpg" alt="New York">
								      <div class="carousel-caption">
									        	<div class="col-sm-6 sliderText">
								      		
								      				<h3 class="slideTitle">GRATIS</h3>
								       		 		<p class="slidePromo">Todos los envíos nacionales en prendas de la colección de Primavera</p>
								       		 		<p>
								       		 			<button type="button" class="btn btn-light">Ver más</button> &nbsp;
								       		 			<button type="button" class="btn btn-outline-light">Ver más</button>
								       		 		</p>								      	
								      	</div>
								     </div>   
						    	</div>

					  	</div>
					  <a class="carousel-control-prev" href="#slideShow" data-slide="prev">
					    <span class="carousel-control-prev-icon"></span>
					  </a>
					  <a class="carousel-control-next" href="#slideShow" data-slide="next">
					    <span class="carousel-control-next-icon"></span>
					  </a>
				</div>
			</div>

			<div class="row sectionBar" id="ProductosNuevos">
				<div class="container">

					<div class="row ">
						<div class=" col-lg-12 col-md-12 col-sm-12">
							<h2>Nueva Colección</h2>
							<hr class="land">
						</div>
					</div>
					<div class="row">
                                            
                                            <%  
                                                List<Articulo> nuevos = (List) request.getAttribute("nuevos");
                                                if(nuevos != null){
                                                    
                                                    for(Articulo art : nuevos){
                                                
                                            %>
						<div class="col-lg-3 col-md-6 col-sm-12">
                                                    <a href="detalleProducto?idProducto=<%= art.getIdArticulo() %>" style="text-decoration: none;">
							<figure class="card card-product">
                                                             
								<div class="img-wrap"> <img class="img-product" src="ImagenPrincipal?type=1&id=<%= art.getIdArticulo() %>"></div>
								<figcaption class="info-wrap">
									<a href="detalleProducto?idProducto=<%= art.getIdArticulo() %>" class="title"><%= art.getNombre() %></a>
									<div class="price-wrap">
										<span></span>
										<span class="price-new"> $ <%= art.getPrecio() %> MXN</span>
									</div> <!-- price-wrap.// -->
								</figcaption>
                                                            
							</figure> <!-- card // -->
                                                         </a>
						</div> <!-- col // -->
                                                <%    }
                                                    }
                                                %>
					

					</div>	

				</div>
			</div>

			<div class="row sectionBar">
				<div class="container">
					<div class="row">
						<div class=" col-lg-12 col-md-12 col-sm-12">
							<h2>Los Favoritos</h2>
							<hr class="land">
						</div>
					</div>
					<div class="row">
                                                 <%  
                                                List<Articulo> favoritos = (List) request.getAttribute("vendidos");
                                                if(favoritos != null){
                                                    
                                                    for(Articulo art : favoritos){
                                                
                                            %>
						<div class="col-lg-3 col-md-6 col-sm-12">
                                                    <a href="detalleProducto?idProducto=<%= art.getIdArticulo() %>" style="text-decoration: none;">
							<figure class="card card-product">
                                                             
								<div class="img-wrap"> <img class="img-product" src="ImagenPrincipal?type=1&id=<%= art.getIdArticulo() %>"></div>
								<figcaption class="info-wrap">
									<a href="detalleProducto?idProducto=<%= art.getIdArticulo() %>" class="title"><%= art.getNombre() %></a>
									<div class="price-wrap">
										<span></span>
										<span class="price-new"> $ <%= art.getPrecio() %> MXN</span>
									</div> <!-- price-wrap.// -->
								</figcaption>
                                                            
							</figure> <!-- card // -->
                                                         </a>
						</div> <!-- col // -->
                                                <%    }
                                                    }
                                                %>
					</div>
				</div>
			</div>

			<div class="row sectionBar" id="BestToHer">
				<div class="container outliner">
					<div class="row">
						<div class=" col-lg-12 col-md-12 col-sm-12">
							<h2>En Tendencia</h2>
							<hr class="land">
						</div>
					</div>
					<div class="row">
                                                   <%  
                                                List<Articulo> trend = (List) request.getAttribute("destacados");
                                                if(trend != null){
                                                    
                                                    for(Articulo art : trend){
                                                
                                            %>
						<div class="col-lg-3 col-md-6 col-sm-12">
                                                    <a href="detalleProducto?idProducto=<%= art.getIdArticulo() %>" style="text-decoration: none;">
							<figure class="card card-product">
                                                             
								<div class="img-wrap"> <img class="img-product" src="ImagenPrincipal?type=1&id=<%= art.getIdArticulo() %>"></div>
								<figcaption class="info-wrap">
									<a href="detalleProducto?idProducto=<%= art.getIdArticulo() %>" class="title"><%= art.getNombre() %></a>
									<div class="price-wrap">
										<span></span>
										<span class="price-new"> $ <%= art.getPrecio() %> MXN</span>
									</div> <!-- price-wrap.// -->
								</figcaption>
                                                            
							</figure> <!-- card // -->
                                                         </a>
						</div> <!-- col // -->
                                                <%    }
                                                    }
                                                %>
						
					</div>
				</div>
			</div>

			<div class="row sectionBar" id="Rebajas">
				<div class="container">
					<div class="row">
						<div class=" col-lg-12 col-md-12 col-sm-12">
							<h2>En Rebaja</h2>
							<hr class="land">
						</div>
					</div>
					<div class="row">
						  <%  
                                                List<Articulo> rebajas = (List) request.getAttribute("ofertas");
                                                if(rebajas != null){
                                                    
                                                    for(Articulo art : rebajas){
                                                
                                            %>
						<div class="col-lg-3 col-md-6 col-sm-12">
                                                    <a href="detalleProducto?idProducto=<%= art.getIdArticulo() %>" style="text-decoration: none;">
							<figure class="card card-product">
                                                             
								<div class="img-wrap"> <img class="img-product" src="ImagenPrincipal?type=1&id=<%= art.getIdArticulo() %>"></div>
								<figcaption class="info-wrap">
									<a href="detalleProducto?idProducto=<%= art.getIdArticulo() %>" class="title"><%= art.getNombre() %></a>
									<div class="price-wrap">
										<span></span>
										<span class="price-new"> $ <%= art.getPrecio() %> MXN</span>
									</div> <!-- price-wrap.// -->
								</figcaption>
                                                            
							</figure> <!-- card // -->
                                                         </a>
						</div> <!-- col // -->
                                                <%    }
                                                    }
                                                %>
						
					</div>
				</div>

			</div>

			<div class="row sectionBar" id="LoMasVisto">
				<div class="container">
					<div class="row">
						<div class=" col-lg-12 col-md-12 col-sm-12">
							<h2>Los más vistos</h2>
							<hr class="land">
						</div>
					</div>
					<div class="row">
						  <%  
                                                List<Articulo> vistos = (List) request.getAttribute("vistos");
                                                if(vistos != null){
                                                    
                                                    for(Articulo art : vistos){
                                                
                                            %>
						<div class="col-lg-3 col-md-6 col-sm-12">
                                                    <a href="detalleProducto?idProducto=<%= art.getIdArticulo() %>" style="text-decoration: none;">
							<figure class="card card-product">
                                                             
								<div class="img-wrap"> <img class="img-product" src="ImagenPrincipal?type=1&id=<%= art.getIdArticulo() %>"></div>
								<figcaption class="info-wrap">
									<a href="detalleProducto?idProducto=<%= art.getIdArticulo() %>" class="title"><%= art.getNombre() %></a>
									<div class="price-wrap">
										<span></span>
										<span class="price-new"> $ <%= art.getPrecio() %> MXN</span>
									</div> <!-- price-wrap.// -->
								</figcaption>
                                                            
							</figure> <!-- card // -->
                                                         </a>
						</div> <!-- col // -->
                                                <%    }
                                                    }
                                                %>
					</div>
				</div>
			</div>
	
			</div>
		</div>



</div>
	</main>
