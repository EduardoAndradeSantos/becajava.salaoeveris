package br.salaoeveris.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.salaoeveris.app.model.Servico;
import br.salaoeveris.app.repository.ServicoRepository;
import br.salaoeveris.app.request.ServicoRequest;
import br.salaoeveris.app.response.BaseResponse;
import br.salaoeveris.app.response.ListaServicoResponse;
import br.salaoeveris.app.response.ServicoResponse;

@Service
public class ServicoService {

	// PROPRIEDADES
	final ServicoRepository _repository;

	// CONSTRUTOR
	public ServicoService(ServicoRepository repository) {
		_repository = repository;
	}

	// METODO PARA INSERIR UM SERVICO
	public BaseResponse inserir(ServicoRequest request) {

		Servico servico = new Servico();
		BaseResponse response = new BaseResponse();
		response.statusCode = 400;

		if (request.getNome().isEmpty() || request.getNome() == "") {
			response.message = "Nome do serviço não foi inserido";
			return response;
		} else if (request.getValor() == null || request.getValor() == 0) {
			response.message = "Valor do serviço não foi inserido";
			return response;
		}

		servico.setNome(request.getNome());
		servico.setValor(request.getValor());

		_repository.save(servico);
		response.statusCode = 201;
		response.message = "Serviço inserido com sucesso.";
		return response;
	}

	// METODO PARA OBTER UM SERVICO
	public ServicoResponse obter(Long id) {

		Optional<Servico> servico = _repository.findById(id);

		ServicoResponse response = new ServicoResponse();

		if (servico.isEmpty()) {
			response.statusCode = 400;
			response.message = "Serviço não foi encontrado";
			return response;
		}

		response.statusCode = 200;
		response.message = "Serviço obtido com sucesso.";
		response.setNome(servico.get().getNome());
		response.setValor(servico.get().getValor());
		return response;
	}

	// METODO PARA LISTAR OS SERVICOS
	public ListaServicoResponse listar() {

		List<Servico> lista = _repository.findAll();

		ListaServicoResponse response = new ListaServicoResponse();

		response.setServicos(lista);
		response.statusCode = 200;
		response.message = "Clientes obtidos com sucesso.";

		return response;
	}

}