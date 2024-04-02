package br.com.fiap.CheckPoint1.dto.cliente;

import br.com.fiap.CheckPoint1.model.Cliente;

public record ListagemClienteDto(Long id, String nome, int idade) {
    public ListagemClienteDto(Cliente cliente){
        this(cliente.getId(), cliente.getNome(), cliente.getIdade());
    }
}
