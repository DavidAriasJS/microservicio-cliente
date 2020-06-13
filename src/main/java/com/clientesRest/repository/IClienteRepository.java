package com.clientesRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clientesRest.model.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, Integer>{
	
	 

}
