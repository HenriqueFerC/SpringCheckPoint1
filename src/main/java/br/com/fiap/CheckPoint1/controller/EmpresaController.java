package br.com.fiap.CheckPoint1.controller;

import br.com.fiap.CheckPoint1.dto.departamento.ListagemDepartamentoDto;
import br.com.fiap.CheckPoint1.dto.empresa.AtualizarEmpresaDto;
import br.com.fiap.CheckPoint1.dto.empresa.CadastroEmpresaDto;
import br.com.fiap.CheckPoint1.dto.empresa.DetalhesEmpresaDto;
import br.com.fiap.CheckPoint1.dto.empresa.ListagemEmpresaDto;
import br.com.fiap.CheckPoint1.model.Empresa;
import br.com.fiap.CheckPoint1.repository.EmpresaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("empresas")
public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepository;

    public ResponseEntity<DetalhesEmpresaDto> cadastrar(@RequestBody CadastroEmpresaDto empresaDto, UriComponentsBuilder uriBuilder){
        var empresa = new Empresa(empresaDto);
        empresaRepository.save(empresa);
        var url = uriBuilder.path("empresas/{id}").buildAndExpand(empresa.getId()).toUri();
        return ResponseEntity.created(url).body(new DetalhesEmpresaDto(empresa));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        empresaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesEmpresaDto> atualizar(@PathVariable("id") Long id, AtualizarEmpresaDto empresaDto){
        var empresa = empresaRepository.getReferenceById(id);
        empresa.atualizarEmpresa(empresaDto);
        return ResponseEntity.ok(new DetalhesEmpresaDto(empresa));
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalhesEmpresaDto> buscarPorId(@PathVariable("id") Long id){
        var empresa = empresaRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesEmpresaDto(empresa));
    }

    @GetMapping
    public ResponseEntity<List<ListagemEmpresaDto>> listar(Pageable pageable){
        var lista = empresaRepository.findAll(pageable).stream().map(ListagemEmpresaDto::new).toList();
        return ResponseEntity.ok(lista);
    }

}
