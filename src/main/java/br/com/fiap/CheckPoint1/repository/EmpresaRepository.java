package br.com.fiap.CheckPoint1.repository;

import br.com.fiap.CheckPoint1.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
