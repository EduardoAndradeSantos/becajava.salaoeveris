package br.salaoeveris.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.salaoeveris.app.request.AgendamentoRequest;
import br.salaoeveris.app.response.BaseResponse;
import br.salaoeveris.app.service.AgendamentoService;


@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController extends BaseController{
	
	
		// PROPRIEDADES
		private final AgendamentoService _service;

		// CONSTRUTOR
		public AgendamentoController(AgendamentoService service) {
			_service = service;
		}
	
	// POST - INSERIR UM AGENDAMENTO
	@PostMapping
	public ResponseEntity inserir(@RequestBody AgendamentoRequest agendamentoRequest) {
		try {
			BaseResponse response = _service.inserir(agendamentoRequest);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

}
