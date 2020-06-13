package com.clientesRest.service;

import java.util.List;

import com.clientesRest.model.Cliente;

public interface IClienteService {
	
	Cliente create(Cliente cliente);
	
	List<Cliente> findAll();

}
