<%-- 
    Document   : header
    Created on : 5/05/2019, 08:34:06 PM
    Author     : tonny
--%>

	<%@page import="java.io.PrintWriter"%>
<%@page import="Models.Usuario"%>
<header id="header" class="header-section sticky-top">
    <script>
        var value;
         $("#elementosCarrito").html(value);
    </script>
		<div class="header-top">
			<div class="container">
				<div class="row">
					<div class="col-lg-2 text-center text-lg-left">
						<!-- logo -->
						<a href="Index" class="site-logo">
							<img class="img-logo" src="img/logoCoutureBlack.png" alt="">
						</a>
					</div>
					
					<div class="col-xl-6 col-lg-5">
						<form action="Buscador" method="GET" class="header-search-form">
							<input type="text" name="buscar" placeholder="Buscar en COUTURE ...." required>
                                                        <button type="submit"><i class="fas fa-search"></i></button>
						</form>
					</div>
					<div class="col-lg-0 col-md-0 col-md-sm-11"></div>
					<div class="col-xl-4 col-lg-5 col-md-6 col-sm-12">
						<div class="user-panel my-2">
							<div class="up-item">
								
                                                                
                                                                       

           
                                                
                                                                <% Usuario user = (Usuario)session.getAttribute("usuario");
                                                              
                                                                        if(user!= null){
                                                                            if(user.getIdUsuario() == 1){
                                                                                out.println("<img src=\"ImagenPrincipal?id="+user.getIdUsuario()+"&type=2\" alt=\"Avatar\" class=\"avatar\"> <a href=\"VerPerfil?op=2&id="+ user.getIdUsuario() + "\">"+  user.getNickname() + "</a> &nbsp;");
                                                                      
                                                                            }
                                                                            else{
                                                                                out.println("<img src=\"ImagenPrincipal?id="+user.getIdUsuario()+"&type=2\" alt=\"Avatar\" class=\"avatar\"> <a href=\"VerPerfil?op=1&id="+ user.getIdUsuario() + "\">"+  user.getNickname() + "</a> &nbsp;");
                                                                      
                                                                            }
                                                                        }
                                                                        else{
                                                                          out.println(" <i class=\"fas fa-user\"></i><a href=\"login.jsp\">Login</a> &nbsp; | &nbsp; <a href=\"registrar.jsp\">Crear Cuenta</a>" );
                                                                        }
                                                                    %>
                                                                 
                                                               
								
                                                                
                                                                
                                                                
							</div>
							<div class="up-item">
								<div class="shopping-card">
									<i class="fas fa-shopping-bag"></i>
                                                                            
                                                                        <span id="elementosCarrito"><%if(user!= null){ out.print(user.getProdsCar());}else{out.println("0");} %></span>
                                                                        
								</div>
								<a href="<% if(user!= null){ out.println("Carrito?id=" + user.getIdUsuario()); }else{ out.println("login.jsp");} %>">Carrito</a>
							</div>
                                                     <%
                                                         if(user!=null){
                                                             out.println("<div class=\"up-item\"><div class=\"shopping-card mx-2\"><a href=\"Salir?out=true\"><i class=\"fas fa-sign-out-alt\"></i>Salir</a></div></div>");
                                                             
                                                             %>
                                                             <input type="hidden" name="idU" value="<%= user.getIdUsuario() %>" id="usId">
                                                             <%
                                                         }
                                                         
                                                         %>
						</div>
					</div>
					
				</div>
			</div>
		</div>
		<nav class="navbar navbar-expand-lg navbar-dark sticky-top " >
			<div class="container" style="background: none;">
				<ul class="navbar-nav">
					<li class="nav-item nav-option"><a class="nav-link " href="Index"> Inicio </a></li>
					<li class="nav-item nav-option"><a class="nav-link " href="Buscador?buscar=todos"> Shop </a></li>
		
                                        
                                        <%
                                            if(user!=null){
                                                 
                                                if(user.getIdUsuario() == 1){
                                                    out.println("<li class=\"nav-item nav-option\"><a class=\"nav-link \" href=\"AdministradorArticulos?op=ver\"> Gestionar Productos </a></li>");
                                                     out.println("<li class=\"nav-item nav-option\"><a class=\"nav-link \" href=\"VerPerfil?op=2&id=1\"> Reportes </a></li>");
                                                }
                                                else{
                                                    out.println("<li class=\"nav-item nav-option\"><a class=\"nav-link \" href=\"VerPerfil?op=1&id="+user.getIdUsuario() + "\"> Mi Perfil </a></li>");
                                                }
                                            }
                                        %>
                                </ul>
			</div>

		</nav>
	</header><!-- /header -->