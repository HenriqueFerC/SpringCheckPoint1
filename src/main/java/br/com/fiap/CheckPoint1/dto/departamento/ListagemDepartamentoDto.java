package br.com.fiap.CheckPoint1.dto.departamento;

import br.com.fiap.CheckPoint1.model.Departamento;
import br.com.fiap.CheckPoint1.model.TipoDepartamento;

public record ListagemDepartamentoDto(Long id, TipoDepartamento tipo) {
    public ListagemDepartamentoDto(Departamento departamento){
        this(departamento.getId(), departamento.getTipo());
    }
}
