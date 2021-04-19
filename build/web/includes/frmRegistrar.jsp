<%-- 
    Document   : frmRegistrar
    Created on : 7/05/2019, 09:51:30 PM
    Author     : tonny
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<main>
      
                                                             
	<div class="container">
	
			<div class="row" id="register">
			
				<div class="col-lg-12 col-md-12 col-sm-12">
					<br>
					<br>
					<h2 id="formTitle">Crear una cuenta</h2>
				<form method="POST" enctype="multipart/form-data" name="RegistroUsuario" id="frmRegistroUsuario" action="RegistrarUsuario">
					<div class="row" id="frmRegistroP1">
						<div class="col-lg-12 col-md-8 col-sm-11"><hr></div>
					
						<div class="col-lg-6 col-md-6 col-sm-12"><input class="form-control field" type="text" id="nombreNuevo" name="nombreU" value="" placeholder="Nombre" required><br></div>
						
						<div class="col-lg-6 col-md-6 col-sm-12"><input class="form-control field" type="text" id="apellNuevo" name="apellidoU" value="" placeholder="Apellido" required><br></div>
							
						<div class="col-lg-7 col-md-6 col-sm-12"><input class="form-control field" type="email" id="mailNuevo" name="mailU" value="" placeholder="Correo electrónico" required><br></div>
						
						<div class="col-lg-5 col-md-6 col-sm-12" id="nickname-field"><input class="form-control field" type="text" id="nickNuevo" name="nickU" value="" placeholder="Nickname" required><br></div>
					
						<div class="col-lg-6 col-md-6 col-sm-12"><input class="form-control field" type="password" id="passNuevo" name="passU" value="" placeholder="Password" required><br></div>
					
						<div class="col-lg-6 col-md-6 col-sm-12"><input class="form-control field" type="password" id="passCNuevo" name="passCU" value="" placeholder="Confirmar password" required><br></div>
							

						<div class="col-lg-7 col-md-3 col-sm-12"><br></div>
						<div class="col-lg-2 col-md-3 col-sm-11"><button type="reset" class="btn btn-danger btn-special form-control"><i class="fas fa-ban"></i> Cancelar</button></div><div class="col-lg-0 col-md-0 col-md-sm-11">&nbsp; </div>
						<div class="col-lg-2 col-md-3 col-sm-11"><button id="nextStep" type="button" class="btn btn-primary btn-special form-control"> Siguiente <i class="fas fa-arrow-circle-right"></i> </button></div><div class="col-lg-0 col-md-0 col-md-sm-11">&nbsp; </div>
						<div class="col-lg-8 col-md-8 col-sm-11"><br></div>
						
							
						</div>
						<div class="row" id="frmRegistroP2">
					
							<div class="col-lg-12 col-md-8 col-sm-11"><hr></div>

						<div class="col-lg-6 col-md-10 col-sm-10"><input class="form-control field" type="text" name="calleU" value="" placeholder="Calle" required></div>
						<div class="col-lg-2 col-md-2 col-sm-2"><input class="form-control field" type="text" name="numeroU" value="" placeholder="Numero" required></div>
                                                <div class="col-lg-4 col-md-12 col-sm-12"><input class="form-control field" type="text" name="coloniaU" value="" placeholder="Colonia o vecindario" required><br></div>
                                                
                                                <div class="col-lg-4 col-md-6 col-sm-12">
                                                    
                                                    <jsp:useBean id="pais" scope="page" class="Utils.cboRegistro"></jsp:useBean>
                                                    <%
                                                            ResultSet pList = pais.paises();
                                                            ResultSet eList = pais.estados();
                                                            ResultSet cList = pais.ciudades();
                                                    %>
							<select name="paisU" class="form-control field" >
								<option value="0" disabled selected> Seleccione su país</option>
                                                                
                                                                <%
                                                                    while(pList.next()){
                                                                 %>
                                                                        <option value="<%= pList.getString("idPais") %>"> <%= pList.getString("nommbrePais")%></option>
                                                                 <%
                                                                    }
                                                                %>
								
							</select>
							<br>
						</div>
						<div class="col-lg-4 col-md-6 col-sm-12">
							<select name="estadoU" class="form-control field">
                                                            
								<option value="0" disabled selected> Selecciona tu Estado</option>
                                                                <%
                                                                    while(eList.next()){
                                                                 %>
                                                                        <option value="<%= eList.getString("idEstado") %>"> <%= eList.getString("nombreEstado")%></option>
                                                                 <%
                                                                    }
                                                                %>
								
							</select>
							<br>
						</div>
                                                
                                                <div class="col-lg-4 col-md-6 col-sm-12">
							<select name="ciudadU" class="form-control field">
								<option value="0" disabled selected> Selecciona tu Ciudad</option>
                                                                <%
                                                                    while(cList.next()){
                                                                 %>
                                                                        <option value="<%= cList.getString("idCiudad") %>"> <%= cList.getString("nombreCiudad")%></option>
                                                                 <%
                                                                    }
                                                                %>
								
							</select>
							<br>
						</div>                
                                                                
                                                                
						<div class="col-lg-12 col-md-11 col-sm-12"><input type="text" name="phoneU" placeholder="Teléfono" class="form-control field input-medium bfh-phone" data-format="dddddddddd" required><br></div>

						<div class="col-lg-2 col-md-4 col-sm-12"><label for="avatar"> Imagen de Perfil</label></div>
						<div class="col-lg-10 col-md-8 col-sm-12"><input id="avatar" class="form-control field" type="file" name="avatarU" value="" placeholder="Avatar" required><br></div>

				
						<div class="col-lg-5 col-md-1 col-sm-11"><br></div>
						<div class="col-lg-2 col-md-3 col-sm-11"><button type="reset" class="btn btn-danger btn-special form-control"><i class="fas fa-ban"></i> Cancelar </button></div><div class="col-lg-0 col-md-0 col-md-sm-11">&nbsp;</div>
						<div class="col-lg-2 col-md-3 col-sm-11"><button type="button" id="BackForm" class="btn btn-primary btn-special form-control"> <i class="fas fa-arrow-circle-left"></i> Atras </button></div><div class="col-lg-0 col-md-0 col-md-sm-11">&nbsp;</div>
						<div class="col-lg-2 col-md-3 col-sm-11"><button type="submit" class="btn btn-primary btn-special form-control"> Confirmar <i class="fas fa-check-circle"></i> </button></div><div class="col-lg-0 col-md-0 col-md-sm-11"> &nbsp;</div>
					</div>
				</form>
				</div>
			</div>
		<div class="row">
			<div class="col-sm-12"><br><br></div>
		</div>

		

	</div>
</main>	
                                                              
