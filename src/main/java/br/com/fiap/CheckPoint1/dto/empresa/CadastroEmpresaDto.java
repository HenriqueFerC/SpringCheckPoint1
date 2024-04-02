package br.com.fiap.CheckPoint1.dto.empresa;

import br.com.fiap.CheckPoint1.model.TipoEmpresa;

public record CadastroEmpresaDto(String nome, String cnpj, TipoEmpresa tipo ){
}
