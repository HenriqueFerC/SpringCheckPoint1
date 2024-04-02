package br.com.fiap.CheckPoint1.dto.cliente;

import br.com.fiap.CheckPoint1.model.Cliente;

public record DetalhesClienteDto(Long id, String nome, int idade, String cpf) {
    public DetalhesClienteDto(Cliente cliente){
        this(cliente.getId(), cliente.getNome(), cliente.getIdade(),  cliente.getCpf());
    }
}
