<%-- 
    Document   : userProfile
    Created on : 15/05/2019, 10:12:08 PM
    Author     : tonny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                                
                                <a href="#" class="list-group-item" id="miCuenta"> <i class="fas fa-user-cog big-icon"></i> <label class="dOp mx-1">  Mi cuenta</label></a>
                                <a href="#" class="list-group-item" id="misCompras"> <i class="fas fa-tags big-icon"></i> <label class="dOp mx-1">  Mis Compras</label></a>
                                <a href="#" class="list-group-item" id="misConversaciones"> <i class="fas fa-comment-dots big-icon"></i> <label class="dOp mx-1">  Conversaciones</label></a>
                                
                                
                               
                              </div>  <!-- list-group .// -->
                            </div>
                      </article> <!-- card-group-item.// -->
                    </div>
                    <br>
                </div>


                <div class="col-sm-12 col-md-8 col-lg-9">

                          

                          <div class="row" id="comprasRealizadas">
                             
                              <div class="col-sm-12 col-md-12 col-lg-12">
                                      <div class="card my-3" >
                                        <article class="card-group-item">
                                          <header class="card-header"><h6 class="title">Compras Realizadas </h6></header>
                                            <div class="filter-content" id="cotPendientes">
                                            <table id="comprasCliente" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
                                                        <thead>
                                                          <tr>
                                                            <th class="th-sm">ID

                                                            </th>
                                                            <th class="th-sm">FECHA

                                                            </th>
                                                            <th class="th-sm">ESTATUS

                                                            </th>
                                                            <th class="th-sm">TOTAL

                                                            </th>
                                                            <th class="th-sm">OPCIONES

                                                            </th>
                                                           
                                                        </thead>
                                                        <tbody>
                                                              
                                                        </tbody>
                                                         </table>
                                            </div>
                                          </article>
                                      </div>
                              </div>
                          </div>

                      
                    
                          <div class="row" id="misDatos">
                              <div class="col-sm-12 col-md-12 col-lg-12">
                                <div class="card my-3">
                                  <article class="card-group-item">
                                    <header class="card-header"><h6 class="title"> Mi Cuenta </h6></header>
                                      <div class="filter-content" >
                                        <div class="row" id="datosUsuario" style="padding: 1em;">
                                            
                                        </div>
                                      </div>
                                    </article>
                                </div>
                              </div>
                              
                              
                          </div>

                         <div class="row" id="conversacionesAdm">
                            <div class="col-sm-12 col-md-12 col-lg-12">
                            <div class="card my-3" >
                              <article class="card-group-item">
                                <header class="card-header"><h6 class="title">Conversaciones </h6></header>
                                  <div class="filter-content" id="cotPendientes">
                                  <table id="comprasCliente" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
                                              <thead>
                                                <tr>
                                                  <th class="th-sm">VENTA

                                                  </th>
                                                  <th class="th-sm">FECHA

                                                  </th>
                                                  <th class="th-sm">CLIENTE

                                                  </th>
                                                  <th class="th-sm">ESTATUS

                                                  </th>
                                                  <th class="th-sm">OPCIONES

                                                  </th>
                                                 
                                              </thead>
                                              <tbody>
                                                    
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
