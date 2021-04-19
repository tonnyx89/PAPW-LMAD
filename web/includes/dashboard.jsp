<%-- 
    Document   : dashboard
    Created on : 15/05/2019, 10:12:22 PM
    Author     : tonny
--%>
<%@page import="Models.Usuario"%>
<%
    Usuario user = (Usuario)request.getAttribute("perfil");
    if(user==null){
        user = (Usuario)session.getAttribute("usuario");
        
        %>
            <input type="hidden" id="usuarioActual" value="<%= user.getIdUsuario() %>">

<%
        
    }
    else{
        %>
        <input type="hidden" id="usuarioActual" value="<%= user.getIdUsuario() %>">
        <%
    }
    %>
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
                                  <% 
                                        if(user!=null && user.getIdUsuario() == 1){
                                            out.println("<a href=\"#\" class=\"list-group-item\" id=\"miResumen\"> <i class=\"fas fa-chart-pie big-icon\"> </i> <label class=\"dOp mx-1\">  Resumen</label></a>");
                                        
                                        }
                                  %>
                                
                                
                                
                                
                                
                                <% 
                                    if(user.getIdUsuario() == 1){
                                    out.println("<a href=\"#\" class=\"list-group-item\" id=\"misVentas\"> <i class=\"fas fa-cash-register big-icon\"></i> <label class=\"dOp mx-1\">  Mis Ventas</label></a>");
                                    out.println("<a href=\"AdministradorArticulos?op=ver\" class=\"list-group-item\" id=\"nuevoArt\"> <i class=\"fas fa-cart-plus big-icon\"></i> <label class=\"dOp mx-1\"> Nuevo Articulo</label></a>"); 
                                    }
                                    else{
                                       out.println("<a href=\"#\" class=\"list-group-item\" id=\"miCuenta\"> <i class=\"fas fa-user-cog big-icon\"></i> <label class=\"dOp mx-1\">  Mi cuenta</label></a>");
                                    out.println("<a href=\"#\" class=\"list-group-item\" id=\"misCompras\"> <i class=\"fas fa-tags big-icon\"></i> <label class=\"dOp mx-1\">  Mis Compras</label></a>");  
                                    }
                                            
                                %>
                                <a href="#" class="list-group-item" id="misConversaciones"> <i class="fas fa-comment-dots big-icon"></i> <label class="dOp mx-1">  Conversaciones</label></a>
                           
                               
                              </div>  <!-- list-group .// -->
                            </div>
                      </article> <!-- card-group-item.// -->
                    </div>
                    <br>
                </div>


                <div class="col-sm-12 col-md-8 col-lg-9">
<% 
                                        if(user!=null && user.getIdUsuario() == 1){
%>                         
                            <div class="row" id="metricas">
                            
                              <div class="col-sm-12 col-md-6 col-lg-6">
                                    <div class="card">
                                      <article class="card-group-item">
                                        <header class="card-header"><h6 class="title">Venta Mensual</h6></header>
                                          <div class="filter-content center" id="Otro">
                                              <h1  class="totalCots">$ <span id="totalMensual">0.00</span> </h1>
                                              <h4 class="totalCots">MXN </h4>
                                          </div>
                                        </article>
                                    </div>
                              </div>
                              <div class="col-sm-12 col-md-6 col-lg-6">
                                    <div class="card">
                                      <article class="card-group-item">
                                        <header class="card-header"><h6 class="title">Total de Ventas </h6></header>
                                          <div class="filter-content center" id="Otro">
                                            
                                            <h1 class="totalCots">$ <span id="ventaTotal" >0.00</span> </h1>
                                            <h4 class="totalCots">MXN </h4>
                                          </div>                                          
                                        </article>
                                    </div>
                              </div>
                              <div class="col-sm-12 col-md-12 col-lg-12 my-2">
                                    <div class="card">
                                      <article class="card-group-item">
                                        <header class="card-header"><h6 class="title"> Ventas por Mes </h6></header>
                                          <div class="filter-content" id="Otro">
                                            <canvas id="resumenMensual"  height="125"></canvas>
                                          </div>
                                        </article>
                                    </div>
                              </div>

                          </div>
                                

                          
                          <div class="row" id="ventasRealizadas">
                              <div class="col-sm-12 col-md-12 col-lg-12">
                                    <div class="card my-3">
                                        <article class="card-group-item">
                                          <header class="card-header"><h6 class="title">Ventas Realizadas </h6></header>
                                            <div class="filter-content" id="cotRecibidas">
                                                <table id="ventasAdmin" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
                                                        <thead>
                                                          <tr>
                                                            <th class="th-sm">ID

                                                            </th>
                                                            <th class="th-sm">FECHA

                                                            </th>
                                                            <th class="th-sm">CLIENTE

                                                            </th>
                                                            <th class="th-sm">TOTAL
                                                              </th>

                                                               <th class="th-sm">METODO DE PAGO

                                                            </th>
                                                         
                                                            <th class="th-sm">OPCIONES

                                                            </th>
                                                           
                                                        </thead>
                                                        <tbody id="ventasTotales">
                                                              
                                                        </tbody>
                                                         </table>
                                                
                                            </div>
                                          </article>
                                      </div>
                              </div>
                          </div>
<% 
    }
%>
                          <div class="row" id="comprasRealizadas">
                             
                              <div class="col-sm-12 col-md-12 col-lg-12">
                                      <div class="card" >
                                        <article class="card-group-item">
                                          <header class="card-header"><h6 class="title">Compras Realizadas </h6></header>
                                            <div class="filter-content" id="cotPendientes">
                                            <table id="comprasCliente" class="table table-striped table-hover table-sm " cellspacing="0" width="100%">
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
                                                        <tbody id="comprasClienteBody">
                                                              
                                                        </tbody>
                                                         </table>
                                            </div>
                                          </article>
                                      </div>
                              </div>
                          </div>

<% 
                                        if(user!=null && user.getIdUsuario() != 1){
%>                      
                    
                          <div class="row" id="misDatos">
                              <div class="col-sm-12 col-md-12 col-lg-12">
                                <div class="card my-3">
                                  <article class="card-group-item">
                                    <header class="card-header"><h6 class="title"> Mi Cuenta </h6></header>
                                      <div class="filter-content" >
                                        <div class="row" id="datosUsuario" style="padding: 1em;">
                                             <div class="col-lg-3 col-md-12 col-sm-12 text-center">
                                                <img class="img-thumbnail img-lg" src="ImagenPrincipal?id=<%= user.getIdUsuario() %>&type=2" width="160" height="160" style="width: 160px; height: 160px; ">       
                                            </div>
                                            <div class="col-lg-9 col-md-12 col-sm-12">
                                                <div class="row">
                                                     <div class="col-lg-2 col-md-6 col-sm-12">
                                                        <label>Nombre: </label>
                                                      </div>
                                                      <div class="col-lg-10 col-md-6 col-sm-12">
                                                            <%= user.getNombre() + " " + user.getApellido() %>
                                                      </div>
                                                      <div class="col-lg-2 col-md-6 col-sm-12">
                                                            <label>Correo: </label>
                                                      </div>
                                                      <div class="col-lg-10 col-md-6 col-sm-12">
                                                            <%= user.getCorreo() %>
                                                      </div>
                                                      <div class="col-lg-2 col-md-6 col-sm-12">
                                                            <label>Dirección:  </label>
                                                      </div>
                                                      <div class="col-lg-10 col-md-6 col-sm-12">
                                                            <%= user.getCalle() + " " + user.getNumero() + ", " + user.getColonia() %>
                                                            <br>
                                                             <%= user.getCiudadNom()+ ", " + user.getEstadoNom()+ ", " + user.getPaisNom()%>
                                                      </div>
                                                      <div class="col-lg-2 col-md-6 col-sm-12">
                                                            <label>Teléfono:  </label>
                                                        </div>
                                                        <div class="col-lg-10 col-md-6 col-sm-12">
                                                            <%= user.getTelefono() %>
                                                        </div>
                                                </div>
                                            </div>
                                           
                                        </div>
                                      </div>
                                    </article>
                                </div>
                              </div>
                          </div>

<% 
                          }
%>
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
                                                  <th class="th-sm">OPCIONES

                                                  </th>
                                                 
                                              </thead>
                                              <tbody id="conversacionesTabla">
                                                    
                                              </tbody>
                                               </table>
                                  </div>
                                </article>
                            </div>
                    </div>
                              
                              
                        </div>
                         

                       <div class="row" id="chatDesplegado">
                           <input type="hidden" id="compraActual" value="">
                            <div class="col-sm-12 col-md-12 col-lg-12">
                            <div class="card" >
                              <article class="card-group-item">
                                <header class="card-header"><div  class="container-fluid bg-light">
                                    <div class="row">
                                          <div class="col-sm-6"> &nbsp; </div>     
                                          <div class="col-sm-6">
                                               <form id="terminarChat" class="form-inline my-2">
                                                          <label for="nuevoPrecio">$ </label>
                                                          
                                                       
                                                       <% if(user!=null && user.getIdUsuario() == 1){
                                                           out.print("<input type=\"number\" name=\"nuevoPrecio\" id=\"nuevoPrecio\" class=\"form-control\">");
                                                           out.print("<button id=\"pactarOferta\" onclick=\"terminarChat();\" class=\"btn btn-outline-success my-2 my-sm-0 \" type=\"button\">Terminar</button>");
                                                           
}%>
                                                     
                                                   </form>
                                          </div>   
                                    </div>         
                                  </div>
                                </header>
                                  <div class="filter-content" id="cotPendientes">
                                      
                                    
                                    
                                    <div id="mensajesChat" class="container-fluid overflow-auto my-4">
                                    
                                            <div class="row my-5">
                                                <div class="col-lg-12 col-md-12 col-sm-12" id="ContenidoChat">
                                    
                                                      
                                    
                                    
                                                      
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                                  
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                
                                    
                             
                                    
                    
                                                        
                                    
                                                </div>
                                            </div>
                                       
                                        </div>
                                      
                                      
                                    
                                    <div  class="container-fluid footer" id="frmSendMessage">
                                        <input type="hidden" id="idReceptor" value="">
                                         <input type="hidden" id="idChat" value="">
                                                      <div class="row my-2 mx-1">
                                                            <div class="col-lg-11 col-md-11 col-sm-11 ">
                                                                <input type="text" name="mensajeChat" id="msnChat" class="form-control">
                                                            </div>        
                                                            <div class=" col-lg-1 col-md-1 col-sm-1 ">
                                                            
                                                                <button class="btn btn-success" onclick="sendMessage();" name="enviar" id="sendMessage" type="submit" ><i class="fas fa-paper-plane"></i></button>
                                                            
                                                            </div>
                                                      </div>
                                     
                                            
                                    </div>
                                  </div>
                                </article>
                            </div>
                    </div>
                              
                              
                        </div>
                </div>

                


            </div>
</div>

		

</main>	

 <div id="ModalDetalleCompra" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        
        <h4 class="modal-title float-left">Detalles de la Compra</h4>
      </div>
      <div class="modal-body">
          
          
        <table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">Cantidad</th>
      <th scope="col">Producto</th>
      <th scope="col">Costo</th>

    </tr>
  </thead>
  <tbody id="detalleComprasTable">
      
  </tbody>
        </table>
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-couture" data-dismiss="modal">Cerrar</button>
      </div>
    </div>

  </div>
</div>
      
                         
 <div id="ModalDetalleVenta" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
       
        <h4 class="modal-title">Detalles de la Venta</h4>
      </div>
      <div class="modal-body">
          
          
                <table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">Cantidad</th>
      <th scope="col">Producto</th>
      <th scope="col">Costo</th>

    </tr>
  </thead>
  <tbody id="detalleVenta">
      
  </tbody>
        </table>
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-couture" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>