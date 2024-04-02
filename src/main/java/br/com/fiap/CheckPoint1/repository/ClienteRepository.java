package br.com.fiap.CheckPoint1.repository;

import br.com.fiap.CheckPoint1.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository  extends JpaRepository<Cliente, Long> {
}
