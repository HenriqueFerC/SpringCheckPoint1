package br.com.fiap.CheckPoint1.dto.cliente;

import br.com.fiap.CheckPoint1.model.Endereco;

public record CadastroClienteDto(String nome, int idade, String cpf) {
}
