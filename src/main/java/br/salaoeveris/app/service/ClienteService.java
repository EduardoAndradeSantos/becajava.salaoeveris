package br.salaoeveris.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.salaoeveris.app.model.Cliente;
import br.salaoeveris.app.repository.ClienteRepository;
import br.salaoeveris.app.request.ClienteRequest;
import br.salaoeveris.app.response.BaseResponse;
import br.salaoeveris.app.response.ClienteResponse;
import br.salaoeveris.app.response.ListaClienteResponse;

@Service
public class ClienteService {
	
	// PROPRIEDADES
	final ClienteRepository _repository;
	
	// CONSTRUTOR
	public ClienteService(ClienteRepository repository) {
		_repository = repository;
	}

	// METODO DE INSERIR CLIENTE
	public BaseResponse inserir(ClienteRequest clienteRequest) {

		BaseResponse baseResponse = new BaseResponse();
		Cliente cliente = new Cliente();
		baseResponse.statusCode = 400;

		if (clienteRequest.getNome().isEmpty() || clienteRequest.getNome() == null) {
			baseResponse.message = "O Nome deve ser preenchido";
			return baseResponse;
		} else if (clienteRequest.getTelefone().isEmpty() || clienteRequest.getTelefone() == null) {
			baseResponse.message = "O Telefone deve ser preenchido";
			return baseResponse;
		} else if (clienteRequest.getEndereco().isEmpty() || clienteRequest.getEndereco() == null) {
			baseResponse.message = "O Endereço deve ser preenchido";
			return baseResponse;
		} else if (clienteRequest.getCpf().isEmpty() || clienteRequest.getCpf() == null) {
			baseResponse.message = "o CPF deve ser preeenchidos";
			return baseResponse;
		}

		cliente.setNome(clienteRequest.getNome());
		cliente.setEndereco(clienteRequest.getEndereco());
		cliente.setTelefone(clienteRequest.getTelefone());
		cliente.setCpf(clienteRequest.getCpf());

		_repository.save(cliente);
		baseResponse.message = "Cliente inserido com sucesso";
		baseResponse.statusCode = 201;

		return baseResponse;

	}

	// METODO DE CONSULTAR UM CLIENTE

	public ClienteResponse obter(Long id) {
		Optional<Cliente> cliente = _repository.findById(id);

		ClienteResponse response = new ClienteResponse();

		if (cliente.isEmpty()) {
			response.message = "Cliente não existe";
			response.statusCode = 400;
			return response;
		}

		response.setNome(cliente.get().getNome());
		response.setTelefone(cliente.get().getTelefone());
		response.setEndereco(cliente.get().getEndereco());
		response.message = "Cliente obtido com sucesso";
		response.statusCode = 201;

		return response;
	}

	// METODO DE CONSULTA LISTA DE CLIENTES
	public ListaClienteResponse listar() {

		List<Cliente> lista = _repository.findAll();
		List<ClienteResponse> listaResponse = new ArrayList<ClienteResponse>();
		ListaClienteResponse response = new ListaClienteResponse();

		for (Cliente c : lista) {
			ClienteResponse cliente = new ClienteResponse();
			cliente.setId(c.getId());
			cliente.setNome(c.getNome());
			cliente.setEndereco(c.getEndereco());
			cliente.setTelefone(c.getTelefone());

			listaResponse.add(cliente);
		}

		response.setClientes(listaResponse);
		;
		response.statusCode = 200;
		response.message = "Clientes obtidos com sucesso";

		return response;
	}
}
