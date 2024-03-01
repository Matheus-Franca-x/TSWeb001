package com.fatec.sigvs.controller;

import org.springframework.web.bind.annotation.RestController;

import com.fatec.sigvs.model.Cliente;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class Controller 
{
	@GetMapping("/alo-mundo")
	public String alo() 
	{
		return "teste de execução de api";
	}
	
	@GetMapping("/clientes")
	public Cliente getCliente()
	{
		Cliente cliente = new Cliente(1, "Jose", "Av. Aguia de Haia");
		return cliente;
	}
	
	@GetMapping("/clientes-todos")
	public List<Cliente> getAll()
	{
		List<Cliente> lista = new ArrayList<Cliente>();
		lista.add(new Cliente(1, "Jose", "Av. Aguia de Haia"));
		lista.add(new Cliente(2, "Silva", "Av. Paulista"));
		lista.add(new Cliente(3, "Maria", "Rua Frei Joao"));
		return lista;
	}
	
	@GetMapping("/clientes/{id}")
	public Cliente getClientePorId(@PathVariable("id") int id)
	{
		return new Cliente(id, "Jose", "Av. Aguia de Haia");
	}
	
	@PostMapping("/clientes")
	public Cliente cadastrarCliente (@RequestBody Cliente cliente)
	{
		List<Cliente> lista = new ArrayList<>();
		lista.add(new Cliente(1, cliente.getNome(), cliente.getEndereco()));
		return lista.get(0);
	}
	
	@GetMapping("/clientes1")
	public ResponseEntity<Cliente> obtemCliente()
	{
		Cliente cliente = new Cliente(1, "Jose", "Av. Aguia de Haia");
//		return ResponseEntity.ok(cliente);
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/clientes/{id}/update")
	public Cliente atualizar(@RequestBody Cliente cliente, @PathVariable ("id") int id)
	{
		Cliente clienteAtualizado = new Cliente(id, cliente.getNome(), cliente.getEndereco());
		return clienteAtualizado;
	}
	
	@DeleteMapping("/clientes/{id}/delete")
	public String delete(@PathVariable("id") int id)
	{
		return "Cliente excluído com sucesso" + id;
	}
	
}
