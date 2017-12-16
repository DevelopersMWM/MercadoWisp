$(document).ready(function() {
        	$("#laura\\:payment-form\\:titular").attr("data-openpay-card","holder_name");
        	$("#laura\\:payment-form\\:tarjeta").attr("data-openpay-card","card_number");
        	$("#laura\\:payment-form\\:mes").attr("data-openpay-card","expiration_month");
        	$("#laura\\:payment-form\\:anio").attr("data-openpay-card","expiration_year");
        	$("#laura\\:payment-form\\:cvv").attr("data-openpay-card","cvv2");        	
            OpenPay.setId('mexcviwsqt2snzeylcy5');
            OpenPay.setApiKey('pk_41f1c1b5d9e3450a85f4e5e882c13ca7');
            OpenPay.setSandboxMode(true);
            //Se genera el id de dispositivo
            var deviceSessionId = OpenPay.deviceData.setup("laura:payment-form", "deviceIdHiddenFieldName");            

 $("#laura\\:payment-form\\:pay-button").click(function(event){
	 event.preventDefault();
	 alert("Hola");
  	  $("#laura\\:payment-form\\:pay-button").prop( "disabled", true);
      OpenPay.token.extractFormAndCreate('laura:payment-form', sucess_callbak, error_callbak); 
	 });       
            var sucess_callbak = function(response) {
              var token_id = response.data.id;            
              $('#laura\\:payment-form\\:token_id').val(token_id);
              $('#laura\\:payment-form').submit();
              alert(token_id);
            };
            var error_callbak = function(response) {
                var desc = response.data.description != undefined ? response.data.description : response.message;
                alert("ERROR [" + response.status + "] " + desc);
                $("#payment-form\\:pay-button").prop("disabled", false);
            };
        });