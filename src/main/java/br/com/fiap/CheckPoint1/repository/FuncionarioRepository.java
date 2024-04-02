package br.com.fiap.CheckPoint1.repository;

import br.com.fiap.CheckPoint1.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
