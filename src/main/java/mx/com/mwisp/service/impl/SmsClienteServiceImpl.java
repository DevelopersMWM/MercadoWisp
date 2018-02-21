package mx.com.mwisp.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.eclipse.persistence.queries.ResultSetMappingQuery;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.mwisp.dao.ClienteInternetDAO;
import mx.com.mwisp.dao.MensajeDAO;
import mx.com.mwisp.dao.SmsClienteDAO;
import mx.com.mwisp.model.SmsCliente;
import mx.com.mwisp.service.SmsClienteService;
import mx.com.mwm.bo.BOClienteInternetInterface;
import mx.com.mwm.bo.BOMensajeInterface;
import mx.com.mwm.bo.BOSmsClienteInterface;
import mx.com.mwm.bo.impl.BOSmsCliente;
import mx.com.mwm.dto.DTOClienteInternet;
import mx.com.mwm.dto.DTOMensaje;
import mx.com.mwm.dto.DTOSmsCliente;

@Service
public class SmsClienteServiceImpl implements SmsClienteService {

	@Autowired
	SmsClienteDAO smsClienteDaoImpl;
	@Autowired
	BOSmsClienteInterface boSmsClienteImpl;
	@Autowired
	ClienteInternetDAO cliente;
	@Autowired
	MensajeDAO mensaje;
	
	@Autowired
	BOClienteInternetInterface boCliente;
	@Autowired
	BOMensajeInterface boMensaje;
	
	@Transactional
	@Override
	public void insertarSmsEnviado(DTOSmsCliente dtoSmsCliente){
		
		DTOClienteInternet dtoClienteInter=new DTOClienteInternet();
		dtoClienteInter=boCliente.modeloClientetoDtoCliente(cliente.findClientById(dtoSmsCliente.getIdCliente()));
		String numeroCelular=dtoClienteInter.getTelefono();
		
		DTOMensaje dtoMensaje=new DTOMensaje();
		dtoMensaje=boMensaje.modelMensajeToDtoMensaje(mensaje.findMensajeById(dtoSmsCliente.getIdMensaje()));
		String tempSms=dtoMensaje.getCuerpoDeMensaje();
		String mensajeTexto=tempSms.replaceAll(" ", "%20");
		
		String idwM ="77986";
		String formato="http://54.39.22.80/sms/sms.php?idMwm=%s&numCelular=%s&mjeTexto=%s ";
		String request=String.format(formato,idwM, numeroCelular,mensajeTexto);
		
		
		try {
			URL url=new URL(request);
			System.out.println(url);
			HttpURLConnection conn=(HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("charset", "utf-8");
			conn.setUseCaches(false);
			if(conn.getResponseCode()!=200) {
				System.out.println(conn.getResponseCode());
				throw new RuntimeException("Código de error"+conn.getResponseCode());
			}
			
			BufferedReader br=new BufferedReader(new InputStreamReader((conn.getInputStream()), "UTF-8"));
			String apiOutput=br.readLine();
			
			JSONObject jsonObject= new JSONObject(apiOutput);
			Object idObjSMS=jsonObject.getJSONObject("response").getJSONObject("result").getJSONArray("success").getJSONObject(0).get("id");
			String idSMS=idObjSMS.toString();
			Object estadoObjSMS=jsonObject.getJSONObject("response").getJSONObject("result").getJSONArray("success").getJSONObject(0).get("status");
			String estadoSMS=estadoObjSMS.toString();
			
			dtoSmsCliente.setIdServicioSms(idSMS);
			dtoSmsCliente.setStatus(estadoSMS);
			
			System.out.println(apiOutput);
			conn.disconnect();
			SmsCliente modelSmsCliente=boSmsClienteImpl.dtoSmsClienteToModelSmscliente(dtoSmsCliente);
			smsClienteDaoImpl.guardarSmsACliente(modelSmsCliente);
		}catch (IOException e) {
			// TODO: handle exception
			System.out.println("Error en envío de SMS MWM"+e);

		}
		//SmsCliente modelSmsCliente=boSmsClienteImpl.dtoSmsClienteToModelSmscliente(dtoSmsCliente);
		//{smsClienteDaoImpl.guardarSmsACliente(modelSmsCliente);
	}

	@Transactional
	@Override
	public List<DTOSmsCliente> listarMensajesAClientes() {
		// TODO Auto-generated method stub
		return boSmsClienteImpl.listModelSmsClienteToListDtoSmsCliente(smsClienteDaoImpl.listarSmsClientes());
	}

	@Transactional
	@Override
	public void eliminarMensajeEnviado(int id) {
		smsClienteDaoImpl.eliminarSmsAClienteEnDB(id);
	}

	@Transactional
	@Override
	public void actualizarSmsACliente(int id, DTOSmsCliente dtoSmscliente) {
		SmsCliente smsCliente=boSmsClienteImpl.dtoSmsClienteToModelSmscliente(dtoSmscliente);
		smsClienteDaoImpl.actualizarSmsACliente(id, smsCliente);
	}
	
	@Transactional
	@Override
	public DTOSmsCliente bucarSMSEnviadoPorId(int id) {
		return boSmsClienteImpl.modelSmsClienteToDTOSmsCliente(smsClienteDaoImpl.findSmsAClienteById(id));
	}

	@Transactional
	@Override
	public void actulializarMensajes() {
		String formato="http://54.39.22.80/sms/status-smsforid.php?idSms=%s";
		String request;
		for(SmsCliente smsCliente:smsClienteDaoImpl.listarSmsClientes()) {
			request=String.format(formato, smsCliente.getIdSmsServ());
			System.out.println("Request:=>>"+request);
			try {
				URL url=new URL(request);
				//System.out.println(url);
				HttpURLConnection conn=(HttpURLConnection) url.openConnection();
				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				conn.setRequestProperty("charset", "utf-8");
				conn.setUseCaches(false);
				if(conn.getResponseCode()!=200) {
					System.out.println(conn.getResponseCode());
					throw new RuntimeException("Código de error"+conn.getResponseCode());
				}
				
				BufferedReader br=new BufferedReader(new InputStreamReader((conn.getInputStream()), "UTF-8"));
				String apiOutput=br.readLine();
				
				JSONObject jsonObject= new JSONObject(apiOutput);
				Object statusObj =jsonObject.getJSONObject("response").getJSONObject("result").get("status");
				String status=statusObj.toString();
				if(!status.equals(smsCliente.getEstatus())) {
					smsCliente.setEstatus(status);
					smsClienteDaoImpl.actualizarSmsACliente(smsCliente.getIdSms(), smsCliente);
				}
				System.out.println("Mensaje:"+jsonObject.getJSONObject("response").getJSONObject("result").get("message"));
				System.out.println("Estado de Mensaje:"+jsonObject.getJSONObject("response").getJSONObject("result").get("status"));
				System.out.println(apiOutput);
				conn.disconnect();
			}catch (IOException e) {
				// TODO: handle exception
				System.out.println("Error en envío de SMS MWM"+e);

			}

		}
	}

}
