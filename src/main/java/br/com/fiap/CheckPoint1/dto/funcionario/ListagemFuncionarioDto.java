package br.com.fiap.CheckPoint1.dto.funcionario;

import br.com.fiap.CheckPoint1.model.Funcionario;

public record ListagemFuncionarioDto(Long id, String nome, int idade, String cargo) {
    public ListagemFuncionarioDto(Funcionario funcionario){
        this(funcionario.getId(), funcionario.getNome(), funcionario.getIdade(), funcionario.getCargo());
    }
}
