package br.com.fiap.CheckPoint1.dto.funcionario;

import br.com.fiap.CheckPoint1.model.Funcionario;

public record DetalhesFuncionarioDto(Long id, String nome, int idade, String cpf, double salario, String cargo) {
    public DetalhesFuncionarioDto(Funcionario funcionario){
        this(funcionario.getId(), funcionario.getNome(), funcionario.getIdade(), funcionario.getCpf(), funcionario.getSalario(), funcionario.getCargo());
    }
}
