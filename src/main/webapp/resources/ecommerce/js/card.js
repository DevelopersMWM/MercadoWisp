
        $(document).ready(function() {
        	$("#payment-form\\:titular").attr("data-openpay-card","holder_name");
        	$("#payment-form\\:tarjeta").attr("data-openpay-card","card_number");
        	$("#payment-form\\:mes").attr("data-openpay-card","expiration_month");
        	$("#payment-form\\:anio").attr("data-openpay-card","expiration_year");
        	$("#payment-form\\:cvv").attr("data-openpay-card","cvv2");        	
            OpenPay.setId('mexcviwsqt2snzeylcy5');
            OpenPay.setApiKey('pk_41f1c1b5d9e3450a85f4e5e882c13ca7');
            OpenPay.setSandboxMode(true);
            //Se genera el id de dispositivo
            var deviceSessionId = OpenPay.deviceData.setup("payment-form", "deviceIdHiddenFieldName");            
/* $("#payment-form\\:pago").click(function(){
	 alert("Hola");
	   $("#payment-form\\:pago").prop("disabled", false);
	 $("#payment-form\\:pay-button").click();
	 });*/
 $("#payment-form\\:pay-button").click(function(event){
	 event.preventDefault();
	 alert("Hola");
  	  $("#payment-form\\:pay-button").prop( "disabled", true);
      OpenPay.token.extractFormAndCreate('payment-form', sucess_callbak, error_callbak); 
	 });       
            var sucess_callbak = function(response) {
              var token_id = response.data.id;            
              $('#payment-form\\:token_id').val(token_id);
              $('#payment-form').submit();
              alert(token_id);
            };
            var error_callbak = function(response) {
                var desc = response.data.description != undefined ? response.data.description : response.message;
                alert("ERROR [" + response.status + "] " + desc);
                $("#pay-button").prop("disabled", false);
            };
        });
