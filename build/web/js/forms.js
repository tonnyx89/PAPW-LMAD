$(document).ready(function(){
	$("#frmRegistroP2").hide();
        
           var mayus = new RegExp("^(?=.*[A-Z])");
  var minus = new RegExp("^(?=.*[a-z])");
  var num = new RegExp("^(?=.*[0-9])");
  var len = new RegExp("^(?=.{8,})");
 
  
  $("#passNuevo").on("keyup",function(){
    var pass = $("#passNuevo").val();

   if(pass.length < 8){
       alert("La contraseña debe tener al menos 8 caracteres.");
   }
   else
   {
        if(!mayus.test(pass) || !minus.test(pass) || !num.test(pass)){
      alert('La contraseña debe tener por lo menos 1 numero, 1 mayuscula y 1 minuscula.');
     
    }
   }
  
  });
  
   $("#nickNuevo").on("keyup",function(){
        var nick = $("#nickNuevo").val();
        
        if(nick.length < 6){
             alert('Su nickname debe contener por lo menos 6 caracteres');
        }
   });
   
     $("#passCNuevo").on("keyup",function(){
         var pssOne =  $("#passNuevo").val();
         var pssTwo =  $("#passCNuevo").val();
         if(pssOne !== pssTwo){
             alert('Las contraseñas no coinciden');
         }
     });

});

$("#nextStep").click(function(){

	var nombre = $("#nombreNuevo").val();
	var apell = $("#apellNuevo").val();
	var mail = $("#mailNuevo").val();
	var nick = $("#nickNuevo").val();

	var pass = $("#passNuevo").val();
	var passCon = $("#passCNuevo").val();

	var next = false;

	next = (nombre == "" || nombre == null) ? false : true;
	next = apell == "" || apell == null ? false : true;
	next = mail == "" || mail == null ? false : true;
	next = pass == "" || pass == null ? false : true;
	next = passCon == "" || passCon == null ? false : true;
        next = pass != passCon ? false : true;
        
        if(nick.length < 6){
            alert("Su nickname debe contener al menos 6 caracteres");
            next = false;
        }
        

	if(next == true){
		$("#frmRegistroP1").hide();
		$("#frmRegistroP2").fadeIn("slow");
		$("#formTitle").html("Datos de Envío");
	}
        else{
            alert('Todos los campos son obligatorios');
            
        }
	


});

$("#BackForm").click(function(){


	$("#frmRegistroP2").hide();
	$("#frmRegistroP1").fadeIn("slow");
	$("#formTitle").html("Crear una Cuenta");
});