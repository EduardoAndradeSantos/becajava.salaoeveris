package br.salaoeveris.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.salaoeveris.app.model.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>{

}
