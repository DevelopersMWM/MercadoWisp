/*VALIDACIÓN PÁGINA CHECKOUT1*/
$(document).ready(function() {
	$("#formReg\\:email").attr("type","email");
	$("#formReg").attr("onSubmit","return validacion();");
	$("#formReg\\:nombre").attr("onkeypress","return Letras(event);");
	$("#formReg\\:apellidos").attr("onkeypress","return Letras(event);");
	$("#formReg\\:empresa").attr("onkeypress","return Letras(event);");
	$("#formReg\\:estado").attr("onkeypress","return Letras(event);");
	$("#formReg\\:telefono").attr("onkeypress","return numeros(event);");
	$("#formReg\\:email").attr("onkeypress","return email(event);");	
	$("#formReg\\:cp").attr("onkeypress","return numeros(event);");
});
function validacion() {
	var nombre, apellidos, empresa, calle, colonia, cp, estado, telefono, email, expresion; 
	nombre = document.getElementById("formReg:nombre").value;
	apellidos = document.getElementById("formReg:apellidos").value;
	empresa = document.getElementById("formReg:empresa").value;
	calle = document.getElementById("formReg:calle").value;
	colonia = document.getElementById("formReg:colonia").value;
	cp = document.getElementById("formReg:cp").value;
	estado = document.getElementById("formReg:estado").value;
	telefono = document.getElementById("formReg:telefono").value;
	email = document.getElementById("formReg:email").value;	
	
	expresion = /^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i;
	
    if (nombre === "" || apellidos === "" || empresa === "" || calle === "" || colonia === "" || cp === "" || estado === "" || telefono === "" || email === "") {
        alert("Por favor rellene todos los campos");
        return false;    }     
    else if(nombre.length>40) {
    	alert("Nombre: Mínimo 40 caracteres");
    	   return false;    
    	   }
    
    else if(apellidos.length>80) {
    	alert("Apellidos: Mínimo 80 caracteres");
    	   return false;    
    	   }
    
    else if(empresa.length>25) {
    	alert("Empresa: Mínimo 25 caracteres");
    	   return false;    
    	   }
    
    else if(calle.length>40) {
    	alert("Calle: Mínimo 40 caracteres");
    	   return false;    
    	   }
    
    else if(colonia.length>50) {
    	alert("Colonia: Mínimo 50 caracteres");
    	   return false;    
    	   }
    
    else if(cp.length>5) {
    	alert("C.P.: Mínimo 5 números");
    	   return false;    
    	   }
    
    else if(isNaN(cp)) {
    	alert("Código Postal: Favor de ingresar números");
    	   return false;    
    	   }
    
    else if(estado.length>20) {
    	alert("Estado: Mínimo 20 caracteres");
    	   return false;    
    	   }
    
    else if(telefono.length>10) {
    	alert("Teléfono: Mínimo 10 caracteres");
    	   return false;    
    	   }
    
    else if(isNaN(telefono)) {
    	alert("Teléfono: Favor de ingresar números");
    	   return false;    
    	   }
    
    else if(email.length>40) {
    	alert("Correo: Mínimo 40 caracteres");
    	   return false;    
    	   }
    
    else if(!expresion.test(email)) {
    	alert("Email: Ingrese un correo válido");
    	   return false;
        }	
    }

function Letras(e) {
    key = e.keyCode || e.which;
    tecla = String.fromCharCode(key).toLowerCase();
    letras = " áéíóúabcdefghijklmnñopqrstuvwxyz";
    especiales = [];
    tecla_especial = false
    for(var i in especiales) {
        if(key == especiales[i]) {
            tecla_especial = true;
            break;
        }    }
    if(letras.indexOf(tecla) == -1 && !tecla_especial){
        return false;
}}

function numeros(e) {
    key = e.keyCode || e.which;
    tecla = String.fromCharCode(key).toLowerCase();
    num = "0123456789";
    tecla_especial = false
    for(var i in especiales) {
        if(key == especiales[i]) {
            tecla_especial = true;
            break;
        }    }
    if(num.indexOf(tecla) == -1)
        return false;
    }

function email(e) {
    key = e.keyCode || e.which;
    tecla = String.fromCharCode(key).toLowerCase();
    num = "0123456789abcdefghijklmnñopqrstuvwxyz@-_.";
     tecla_especial = false
    for(var i in especiales) {
        if(key == especiales[i]) {
            tecla_especial = true;
            break;
        }    }
    if(num.indexOf(tecla) == -1)
        return false;
    }

