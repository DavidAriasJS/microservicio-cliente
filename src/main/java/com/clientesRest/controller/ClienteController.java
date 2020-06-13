package com.clientesRest.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clientesRest.model.Cliente;
import com.clientesRest.model.Data;
import com.clientesRest.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@PostMapping("/crearcliente")
	public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
		return new ResponseEntity<>(clienteService.create(cliente),HttpStatus.CREATED);
	}
	
	@GetMapping("/kpideclientes")
	public Data kpis() {
		
		List<Cliente> lists = clienteService.findAll();
		
		Float promedio; 
		Integer suma = 0;
		Integer cont = 0;
		for (Cliente cliente : lists) {
			suma = (Integer) cliente.getEdad() + (Integer) suma;
			cont++;
		}
		
		promedio = (float) (suma / cont);
		
		
		
		//DESVIACION ESTANDAR
		
		double sumD = 0;
		for (Cliente cliente : lists) {
			sumD += Math.pow ( cliente.getEdad() - promedio, 2 );
		}
		
		double desviacion = Math.sqrt ( sumD / ( double ) cont );
		
	 	Data response = new Data();
		response.setPromedio_edad(promedio);
		response.setDesviacion_estandar(desviacion);
		return response;
	}
	
	@GetMapping("/listclientes")
	public ResponseEntity<List<Cliente>> findAll(){
		
		List<Cliente> lists = clienteService.findAll();
		
		//Población vulnerable por covid
        Integer tasaEdadMinProbable = 70;
		Integer tasaEdadMaxProbable = 100;
		
		Random random = new Random();
		int edadMuerteAprox = random.nextInt(tasaEdadMaxProbable + 1 - tasaEdadMinProbable) + tasaEdadMinProbable;
		
		ArrayList alist = new ArrayList();
		
		for (Cliente cliente : lists) {
			
			Integer edadMuerteProm = edadMuerteAprox - cliente.getEdad();
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(cliente.getFecha_nacimiento());
			calendar.add(Calendar.YEAR, - edadMuerteProm );
			
		    SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		    //String datetime = dateformat.format(calendar.getTime());
			 String datetime = dateformat.format(calendar.getTime());
			cliente.setFecha_muerte(datetime);
			alist.add(cliente);
		}
		
		return new ResponseEntity<>(alist, HttpStatus.OK);
	}
	
	
}
