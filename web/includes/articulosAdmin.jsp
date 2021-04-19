<%-- 
    Document   : articulosAdmin
    Created on : 23/05/2019, 12:26:33 PM
    Author     : tonny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<main>
	
        <div class="container">
            <div id="dbTitle" class="row">
                <div class="col-sm-12 col-md-12 col-lg-12 text-center my-3">
                  <h3 id="tituloDashboard"> Resumen de mi Actividad </h3>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12 col-md-4 col-lg-3">

                   <div class="card ">
                      <article class="card-group-item">
                        <header class="card-header"><h6 class="title">Opciones </h6></header>
                          <div class="filter-content" id="opcionesDashboard">
                              <div class="list-group">
                                
                                <a href="#" class="list-group-item" id="articulosP"> <i class="fas fa-store-alt big-icon"></i> <label class="dOp mx-1">  Articulos Publicados</label></a>
                                <a href="#" class="list-group-item" id="articulosB"> <i class="fas fa-eraser big-icon"></i> <label class="dOp mx-1">  Borradores</label></a>
                                <a href="#" class="list-group-item" id="articulosN"> <i class="fas fa-cart-plus big-icon"></i> <label class="dOp mx-1">  Nuevo Articulo</label></a>
                                <a href="VerPerfil?op=2&id=1" class="list-group-item" id="misConversaciones"> <i class="fas fa-chart-bar big-icon"></i> <label class="dOp mx-1">  Reportes</label></a>
                                
                           
                               
                              </div>  <!-- list-group .// -->
                            </div>
                      </article> <!-- card-group-item.// -->
                    </div>
                    <br>
                </div>


                <div class="col-sm-12 col-md-8 col-lg-9">
                       
                            <div class="row" id="nuevoArticulo">
                            
                             
                              <div class="col-sm-12 col-md-12 col-lg-12">
                                    <div class="card">
                                      <article class="card-group-item">
                                        <header class="card-header"><h4 class="title">Nuevo Articulo </h4></header>
                                          <div class="filter-content" id="Otro">
                                            <div class="row my-5">
				
					<div class="col-lg-10 col-md-10 col-sm-12">
							<form action="NuevoArticulo" method="POST" enctype="multipart/form-data">
						<div class="row">
						
							<div class="col-lg-12 col-md-12 col-sm-12">
								
								<input class="form-control my-2" type="text" name="nombreA" id="nomA" placeholder="Nombre del Articulo">
								<textarea  class="form-control my-3" name="descripcionA" id="descA" cols="30" rows="10" placeholder="Descripción del Articulo."></textarea>
							</div>
							<div class="col-lg-4 col-md-4 col-sm-12 my-2">
								<label for="">Precio: $</label>
								<input  class="form-control" type="number" name="precioA" id="precA" value="0.00" step="0.5">
							</div>
							<div class="col-lg-4 col-md-4 col-sm-12 my-2">
								<label for="">Existencias: </label>
								<input  class="form-control " type="number" name="unidadesA" id="unidA" value="1">
							</div>
							<div class="col-lg-4 col-md-4 col-sm-12  my-2">
									<label for="">Descuento: </label>
								<input  class="form-control" type="number" name="descuentoA" step="0.05" id="descA">
							
							</div>
							<div class="col-lg-12 col-md-12 col-sm-12 my-3">
                                                                    <select class="form-control" name="categorias" id=catA"">
									<option value="0" disabled>Selecciona una o más categorías</option>
                                                                            <optgroup label="Dama"></optgroup>
                                                                                <option value="1">Jeans</option>
                                                                                <option value="2">Tops</option>
                                                                                <option value="3">Bottoms</option>
                                                                                <option value="4">Shoes</option>
                                                                                <option value="5">Jackets & Sweaters</option>
                                                                                <option value="6">Accesorios</option>
                                                                            <optgroup label="Caballero"></optgroup>
                                                                                <option value="7">Jeans</option>
                                                                                <option value="8">Tops</option>
                                                                                <option value="9">Bottoms</option>
                                                                                <option value="10">Shoes</option>
                                                                                <option value="11">Jackets & Sweaters</option>
                                                                                <option value="12">Accesorios</option>                                            
                                                                    </select>
							</div>
							<div class="col-lg-12 col-md-12 col-sm-12">
								<div class="form-group my-3">
									<label>Imagenes del Articulo: </label>
									<input  type="file" name="imagenOne" id="imageOne"  class="form-control">
                                                                        <input type="file" name="imagenTwo"  id="imageTwo" class="form-control">
                                                                        <input  type="file" name="imagenThree"  id="imagenhree" class="form-control" >
								</div>
							</div>
							<div class="col-lg-12 col-md-12 col-sm-12">
									<div class="form-group my-3">
										<label for="file-2">Video del Articulo: </label>
										<input id="file-2" type="file" name="videos" id="videoS" class="form-control" >
									</div>
								</div>
							
						</div>
					</div>
					<div class="col-lg-2 col-md-2 col-sm-12">
						<span>
							<button type="submit" class="btn btn-success btn-art"> <i class="fas fa-check"></i>   Guardar </button>
						</span>
						<span>
						
						</span>
						<span>
							
						</span>
						<span>
							<button class="btn btn-danger btn-art"> <i class="fas fa-trash-alt"></i>   Eliminar </button>
						</span>
					</div>
			</form>
        </div>
                                          </div>
                                        </article>
                                    </div>
                              </div>

                          </div>
                                

                          
                          <div class="row" id="inventario">
                              <div class="col-sm-12 col-md-12 col-lg-12">
                                    <div class="card my-3">
                                        <article class="card-group-item">
                                          <header class="card-header"><h4 class="title">Articulos en Tienda </h4></header>
                                            <div class="filter-content" id="cotRecibidas">
                                                <table id="ventasAdmin" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
                                                        <thead>
                                                          <tr>
                                                            <th class="th-sm">ID

                                                            </th>
                                                            <th class="th-sm">NOMBRE

                                                            </th>
                                                            <th class="th-sm">PRECIO

                                                            </th>
                                                            <th class="th-sm">STOCK
                                                              </th>

                                                         
                                                            <th class="th-sm">OPCIONES

                                                            </th>
                                                           
                                                        </thead>
                                                        <tbody id="inventarioPublico">
                                                              
                                                        </tbody>
                                                         </table>
                                                
                                            </div>
                                          </article>
                                      </div>
                              </div>
                          </div>

                          <div class="row" id="borradores">
                             
                              <div class="col-sm-12 col-md-12 col-lg-12">
                                      <div class="card" >
                                        <article class="card-group-item">
                                          <header class="card-header"><h4 class="title">Borradores </h4></header>
                                            <div class="filter-content" id="cotPendientes">
                                            <table id="comprasCliente" class="table table-striped table-hover table-sm " cellspacing="0" width="100%">
                                                        <thead>
                                                          <tr>
                                                            <th class="th-sm">ID

                                                            </th>
                                                        
                                                            <th class="th-sm">NOMBRE
                                                            </th>
                                                            <th class="th-sm">PRECIO

                                                            </th>
                                                              <th class="th-sm">STOCK

                                                            </th>
                                                            <th class="th-sm">OPCIONES

                                                            </th>
                                                           
                                                        </thead>
                                                        <tbody id="inventarioBorradores">
                                                              
                                                        </tbody>
                                                         </table>
                                            </div>
                                          </article>
                                      </div>
                              </div>
                          </div>

                 

                        

                      <br>
                </div>

                


            </div>
</div>

		

</main>
