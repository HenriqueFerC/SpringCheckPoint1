package br.com.fiap.CheckPoint1.model;

import br.com.fiap.CheckPoint1.dto.empresa.AtualizarEmpresaDto;
import br.com.fiap.CheckPoint1.dto.empresa.CadastroEmpresaDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("JpaAttributeTypeInspection")
@Getter @Setter
@NoArgsConstructor

@Entity
@Table(name="TB_EMPRESA")
public class Empresa {

    @Id
    @GeneratedValue
    @Column(name="ID_EMPRESA")
    private Long id;

    @Column(name="NM_EMPRESA", length = 50, nullable = false)
    private String nome;

    @Column(name="CNPJ", length = 14, nullable = false)
    private String cnpj;

    @Column(name="TIPO_EMPRESA", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoEmpresa tipo;

//    @OneToMany
//    @JoinColumn(name="ID_DEPARTAMENTO")
//    private Departamento departamento;
//
//    @OneToMany
//    @JoinColumn(name="ID_FUNCIONARIO")
//    private Funcionario funcionario;

    public Empresa(CadastroEmpresaDto empresaDto){
        nome = empresaDto.nome();
        cnpj = empresaDto.cnpj();
        tipo = empresaDto.tipo();
//        departamento = empresaDto.departamento();
//        funcionario = empresaDto.funcionario();
    }

    public void atualizarEmpresa(AtualizarEmpresaDto empresaDto){
        nome = empresaDto.nome();
        cnpj = empresaDto.cnpj();
        tipo = empresaDto.tipo();
    }

}
