/* 
COUTURE REGISTER VALIDATOR
Author: Tonny García
 */

$(document).ready(function(){
    
    var next = false;
        var contra = $("#passNuevo").val();
        var contraCon = $("#passCNuevo").val();
        
   var mayus = new RegExp("^(?=.*[A-Z])");
  var minus = new RegExp("^(?=.*[a-z])");
  var num = new RegExp("^(?=.*[0-9])");
  var len = new RegExp("^(?=.{8,})");
  var nick = $("#nickU").val().length;
  
  $("#passNuevo").on("keyup",function(){
    var pass = $("#passNuevo").val();

    if(!mayus.test(pass) &&! minus.test(pass) && !num.test(pass) && !len.test(pass)){
      $("#passCNuevo").append("<small id=\"passLe\">La contraseña debe contener al menos 1 mayuscula, 1 minuscula y un dígito.</small>");
      next = false;
    }
    else{
        next = true;
        $("#passLe").hide();
    }
  });
  
    
  $("#nextStep").click(function(){
        
        
        if(nick < 6){
            $("#nickNuevo").addClass("warning-frm");
            $("#nickname-field").append("<small>Debe tener solo 6 caracteres.</small>");
            next = false;
        }
        else{
            next = true;
            $("#nickname-field").empty();
        }
        
    

  
        
        if(contra !== contraCon){
         $("#passCNuevo").addClass("warning-frm");
         $("#passCNuevo").append("<small id=\"contras\">Las contraseñas no coinciden.</small>");
         next = false;
        }
        else{
            next = true;
            $("#contras").empty();
        }
        
        
        
        
     if(next == true){
         $("#frmRegistroP1").hide();
         $("#frmRegistroP2").fadeIn("slow");
     }
        
        
        
    });
    
    $("#BackForm").click(function(event){
        $("#frmRegistroP2").hide();
         $("#frmRegistroP1").fadeIn("slow");
    });
    
    
});


