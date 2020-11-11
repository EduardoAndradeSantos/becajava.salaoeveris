package br.salaoeveris.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.salaoeveris.app.model.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long>{

}
