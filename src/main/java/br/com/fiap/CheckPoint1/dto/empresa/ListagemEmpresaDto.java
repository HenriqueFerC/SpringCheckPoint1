package br.com.fiap.CheckPoint1.dto.empresa;

import br.com.fiap.CheckPoint1.model.Empresa;
import br.com.fiap.CheckPoint1.model.TipoEmpresa;

public record ListagemEmpresaDto(Long id, String nome, String cnpj, TipoEmpresa tipo) {
    public ListagemEmpresaDto(Empresa empresa){
        this(empresa.getId(), empresa.getNome(), empresa.getCnpj(), empresa.getTipo());
    }
}
