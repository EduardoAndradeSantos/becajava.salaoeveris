package br.salaoeveris.app.response;

import java.util.List;

public class ListaClienteResponse extends BaseResponse {

	private List<ClienteResponse> clientes;

	public List<ClienteResponse> getClientes() {
		return clientes;
	}

	public void setClientes(List<ClienteResponse> clientes) {
		this.clientes = clientes;
	}

}
