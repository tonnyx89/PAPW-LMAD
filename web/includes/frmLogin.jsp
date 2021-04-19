<%-- 
    Document   : frmLogin
    Created on : 8/05/2019, 10:59:40 PM
    Author     : tonny
--%>
<main>
	<div class="container-fluid">
	<div class="row">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-2 col-sm-11">
					
				</div>
				<div class="col-lg-6 col-md-8 col-sm-11">
					<br>
					
					<div id="loginFormBackground">
						<br>
						<h2>Iniciar sesión</h2>
						<br>
						<form action="Login" accept-charset="utf-8" method="POST">
							<input class="form-control field" type="text" id="nombreUsuario" name="userName"  placeholder="Usuario o orreo electrónico" required><br>
							<input class="form-control field" type="password" id="passwordUsuario" name="userPassword"  placeholder="Contraseña"><br>
							<div class="form-check" style="text-align: right;" >
                                                            <label class="form-check-label">¿Nuevo en el sitio? Puedes crear una <a href="registrar.jsp">cuenta nueva aquí.</a></label><br>
							</div>
							
							<br>
							<br>

							<p style="text-align: right;">
								<input  type="reset" class="btn btn-outline-dark loginBtn" name="Entrar" value="Cancelar">
								<input  type="submit" class="btn btn-outline-light loginBtn" name="Entrar" value="Entrar">
							</p>
						</form>
						
				
					</div>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
				</div>
				<div class="col-lg-3 col-md-2 col-sm-11">
					
				</div>
				

			</div>			
		</div>
	</div>
	
</div>
</main>