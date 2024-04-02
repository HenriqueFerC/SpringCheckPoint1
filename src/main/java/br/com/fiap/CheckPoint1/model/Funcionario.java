package br.com.fiap.CheckPoint1.model;

import br.com.fiap.CheckPoint1.dto.funcionario.AtualizarFuncionarioDto;
import br.com.fiap.CheckPoint1.dto.funcionario.CadastrarFuncionarioDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("JpaAttributeTypeInspection")
@Getter @Setter
@NoArgsConstructor

@Entity
@Table(name="TB_FUNCIONARIO")
public class Funcionario extends Pessoa{

    @Column(name="SALARIO", length = 15, nullable = false)
    private double salario;

    @Column(name="CARGO", length = 15, nullable = false)
    private String cargo;

//    @ManyToMany
//    @JoinColumn(name="ID")
//    private Cliente cliente;

    public Funcionario(Long id, String nome, int idade, String cpf, double salario, String cargo) {
        super(id, nome, idade, cpf);
        this.salario = salario;
        this.cargo = cargo;
    }

    public Funcionario(CadastrarFuncionarioDto funcionarioDto){
        nome = funcionarioDto.nome();
        idade = funcionarioDto.idade();
//        endereco = funcionarioDto.endereco();
        cpf = funcionarioDto.cpf();
        salario = funcionarioDto.salario();
        cargo = funcionarioDto.cargo();
    }

    public void atualizarFucnionario(AtualizarFuncionarioDto funcionarioDto){
        nome = funcionarioDto.nome();
        idade = funcionarioDto.idade();
        cpf = funcionarioDto.cpf();
        salario = funcionarioDto.salario();
        cargo = funcionarioDto.cargo();
    }

}
