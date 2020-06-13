package com.clientesRest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clientesRest.model.Cliente;
import com.clientesRest.repository.IClienteRepository;

@Service
public class ClienteService implements IClienteService{

	@Autowired
	private IClienteRepository clienteRepo;
	
	@Override
	public Cliente create(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteRepo.save(cliente);
	}

	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return clienteRepo.findAll();
	}

	
	
}
