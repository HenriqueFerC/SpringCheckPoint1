package br.com.fiap.CheckPoint1.model;

import br.com.fiap.CheckPoint1.dto.cliente.AtualizarClienteDto;
import br.com.fiap.CheckPoint1.dto.cliente.CadastroClienteDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor

@Entity
@Table(name="TB_CLIENTE")
public class Cliente extends Pessoa{

    public Cliente(Long id, String nome, int idade, String cpf) {
        super(id, nome, idade, cpf);
    }

    public Cliente(CadastroClienteDto clienteDto){
        nome = clienteDto.nome();
        idade = clienteDto.idade();
        cpf = clienteDto.cpf();
    }

    public void atualizarCLiente(AtualizarClienteDto clienteDto){
        nome = clienteDto.nome();
        idade = clienteDto.idade();
        cpf = clienteDto.cpf();
    }

}
