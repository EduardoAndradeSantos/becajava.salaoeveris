package br.salaoeveris.app.service;

import org.springframework.stereotype.Service;

import br.salaoeveris.app.model.Agendamento;
import br.salaoeveris.app.model.Cliente;
import br.salaoeveris.app.model.Servico;
import br.salaoeveris.app.repository.AgendamentoRepository;
import br.salaoeveris.app.request.AgendamentoRequest;
import br.salaoeveris.app.response.BaseResponse;

@Service
public class AgendamentoService {

	final AgendamentoRepository _repository;

	public AgendamentoService(AgendamentoRepository repository) {
		_repository = repository;

	}

	// METODO DE INSERIR UM AGENDAMENTO
	public BaseResponse inserir(AgendamentoRequest agendamentoRequest) {

		BaseResponse response = new BaseResponse();
		
		Agendamento agendamento = new Agendamento();
		
		response.statusCode = 400;

		if (agendamentoRequest.getDataHora() == null) {
			response.message = "Data do Agendamento não inserida.";
			return response;
		} else if (agendamentoRequest.getIdCliente() == null || agendamentoRequest.getIdCliente() == 0) {
			response.message = "Cliente não inserido";
			return response;
		} else if (agendamentoRequest.getIdServico() == null || agendamentoRequest.getIdServico() == 0) {
			response.message = "Serviço não Inserido";
			return response;
		}

		Cliente cliente = new Cliente();
		cliente.setId(agendamentoRequest.getIdCliente());
		agendamento.setCliente(cliente);
		
		Servico servico = new Servico();
		servico.setId(agendamentoRequest.getIdServico());
		agendamento.setServico(servico);
		
		agendamento.setDataHora(agendamentoRequest.getDataHora());

		_repository.save(agendamento);
		response.statusCode = 201;
		response.message = "Agendamento Realizado.";

		return response;

	}

}