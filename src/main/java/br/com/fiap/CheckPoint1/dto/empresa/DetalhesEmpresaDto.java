package br.com.fiap.CheckPoint1.dto.empresa;

import br.com.fiap.CheckPoint1.model.Empresa;
import br.com.fiap.CheckPoint1.model.TipoEmpresa;

public record DetalhesEmpresaDto(Long id, String nome, String cnpj, TipoEmpresa tipo) {
    public DetalhesEmpresaDto(Empresa empresa){
        this(empresa.getId(), empresa.getNome(), empresa.getCnpj(), empresa.getTipo());
    }
}
