package br.salaoeveris.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.salaoeveris.app.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
