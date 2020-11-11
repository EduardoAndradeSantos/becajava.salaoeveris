package br.salaoeveris.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.salaoeveris.app.request.ServicoRequest;
import br.salaoeveris.app.response.BaseResponse;
import br.salaoeveris.app.response.ListaServicoResponse;
import br.salaoeveris.app.service.ServicoService;

@RestController
@RequestMapping("/servicos")
public class ServicoController extends BaseController {

	private final ServicoService _service;

	public ServicoController(ServicoService service) {
		_service = service;
	}

	// POST - INSERIR SERVIÇO
	@PostMapping
	public ResponseEntity<BaseResponse> inserir(@RequestBody ServicoRequest request) {
		try {
			BaseResponse response = _service.inserir(request);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

	// GET - OBTER UM SERVICO POR ID
	@GetMapping(path = "/{id}")
	public ResponseEntity<BaseResponse> obter(@PathVariable Long id) {
		try {
			BaseResponse response = _service.obter(id);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

	// GET - LISTAR TODOS OS SERVIÇOS
	@GetMapping
	public ResponseEntity<BaseResponse> listar() {
		try {
			ListaServicoResponse clientes = _service.listar();
			return ResponseEntity.status(clientes.statusCode).body(clientes);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

}
