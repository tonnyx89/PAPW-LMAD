<%-- 
    Document   : frmNuevoProducto
    Created on : 13/05/2019, 08:00:55 PM
    Author     : tonny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<main>
    
    
	<div class="container">
        <div class="row my-5">
				<div class="col-lg-12 col-md-12 col-sm-12 text-center">
					<h4 id="artPageTitle">Nuevo Articulo</h4>
				</div>
					<div class="col-lg-9 col-md-9 col-sm-12">
							<form action="CargarProducto" method="POST" enctype="multipart/form-data">
						<div class="row">
						
							<div class="col-lg-12 col-md-12 col-sm-12">
								
								<input class="form-control my-2" type="text" name="nombreA" id="" placeholder="Nombre del Articulo">
								<textarea  class="form-control my-3" name="descripcionA" id="" cols="30" rows="10" placeholder="Descripción del Articulo."></textarea>
							</div>
							<div class="col-lg-4 col-md-4 col-sm-12 my-2">
								<label for="">Precio: $</label>
								<input  class="form-control" type="number" name="precioA" id="">
							</div>
							<div class="col-lg-4 col-md-4 col-sm-12 my-2">
								<label for="">Existencias: </label>
								<input  class="form-control " type="number" name="unidadesA" id="">
							</div>
							<div class="col-lg-4 col-md-4 col-sm-12  my-2">
									<label for="">Descuento: </label>
								<input  class="form-control" type="number" name="descuentoA" id="">
							
							</div>
							<div class="col-lg-12 col-md-12 col-sm-12 my-3">
                                                                    <select class="form-control" name="categorias" id="">
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
									<label for="file-1">Imagenes del Articulo: </label>
									<input id="file-1" type="file" name="imagen1"  class="form-control">
                                                                        <input id="file-1" type="file" name="imagen2"  class="form-control">
                                                                        <input id="file-1" type="file" name="imagen3"  class="form-control" >
								</div>
							</div>
							<div class="col-lg-12 col-md-12 col-sm-12">
									<div class="form-group my-3">
										<label for="file-2">Video del Articulo: </label>
										<input id="file-2" type="file" name="videos" class="form-control" >
									</div>
								</div>
							
						</div>
					</div>
					<div class="col-lg-3 col-md-2 col-sm-12">
						<span >
                                                    <button type="submit" class="btn btn-success btn-art"> <i class="fas fa-check"></i><small>Publicar</small>   </button>
						</span >
						<span class="my-2">
                                                    <button class="btn btn-warning btn-art"> <i class="fas fa-eraser"></i> <small>  Borrador</small> </button>
						</span>
						<span class="my-2">
                                                    <button class="btn btn-primary btn-art"> <i class="far fa-save"></i> <small>  Guardar </small></button>
						</span>
						<span class="my-2">
                                                    <button class="btn btn-danger btn-art"> <i class="fas fa-trash-alt"></i> <small>  Eliminar </small> </button>
						</span>
					</div>
			</form>
        </div>
        <div class="row">

        </div>
	</div>
</main>	
