package br.salaoeveris.app.response;

import java.util.List;

import br.salaoeveris.app.model.Servico;

public class ListaServicoResponse extends BaseResponse {

	private List<Servico>Servicos;

    public List<Servico> getServicos() {
        return Servicos;
    }

    public void setServicos(List<Servico> servicos) {
        Servicos = servicos;
    }
    
}
