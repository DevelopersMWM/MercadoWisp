package mx.com.mwisp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.mwisp.dao.CuentaDao;
import mx.com.mwisp.model.Cuenta;
import mx.com.mwisp.service.CuentaService;

@Service
public class CuentaServiceImpl implements CuentaService{
	@Autowired
	CuentaDao cuentaDaoImpl;
	
	@Transactional
	@Override
	public void agregarCuenta(Cuenta cuenta) {
		// TODO Auto-generated method stub
		cuentaDaoImpl.insertarCuenta(cuenta);
	}

}
