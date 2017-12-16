package mx.com.mwisp.openpay;


public class TestOpenPay {
	public static void main(String[] args) {
//String urlComprobanteBase;
		

		ClienteOpenpay clienteOpenpay = new ClienteOpenpay("Enrrique", "velasquez", "8764946", "Enrrique@gmail.com");
		ObjetoPeticionCard objetoPeticion=new ObjetoPeticionCard("ka4oeb4uwoqczzhdxa0t", "card", 100, "MXN", "mac Pro", "1rvGhOGaFgPwNbrtefA4IwPZbMRjsQpe", clienteOpenpay);

		CargoTarjeta cargoTarjeta=new CargoTarjeta();
		cargoTarjeta.cargoT(objetoPeticion);
		
	}

}
