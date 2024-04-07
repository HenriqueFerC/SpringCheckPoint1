package br.com.fiap.CheckPoint1.dto.funcionario;

import br.com.fiap.CheckPoint1.model.Endereco;

public record CadastrarFuncionarioDto(String nome, int idade, String cpf, double salario, String cargo) {
}
