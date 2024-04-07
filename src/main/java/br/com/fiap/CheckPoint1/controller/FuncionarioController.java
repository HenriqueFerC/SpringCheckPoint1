package br.com.fiap.CheckPoint1.controller;

import br.com.fiap.CheckPoint1.dto.cliente.AtualizarClienteDto;
import br.com.fiap.CheckPoint1.dto.funcionario.AtualizarFuncionarioDto;
import br.com.fiap.CheckPoint1.dto.funcionario.CadastrarFuncionarioDto;
import br.com.fiap.CheckPoint1.dto.funcionario.DetalhesFuncionarioDto;
import br.com.fiap.CheckPoint1.dto.funcionario.ListagemFuncionarioDto;
import br.com.fiap.CheckPoint1.model.Funcionario;
import br.com.fiap.CheckPoint1.repository.FuncionarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesFuncionarioDto> cadastrar(@RequestBody CadastrarFuncionarioDto funcionarioDto, UriComponentsBuilder uriBulder){
        var funcionario = new Funcionario(funcionarioDto);
        funcionarioRepository.save(funcionario);
        var url = uriBulder.path("funcionarios/{id}").buildAndExpand(funcionario.getId()).toUri();
        return ResponseEntity.created(url).body(new DetalhesFuncionarioDto(funcionario));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        try {
            funcionarioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EmptyResultDataAccessException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesFuncionarioDto> atualizar(@PathVariable("id") Long id, @RequestBody AtualizarFuncionarioDto funcionarioDto){
        var funcionario = funcionarioRepository.getReferenceById(id);
        funcionario.atualizarFucnionario(funcionarioDto);
        return ResponseEntity.ok(new DetalhesFuncionarioDto(funcionario));
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalhesFuncionarioDto> buscarPorId(@PathVariable("id") Long id){
        try {
            var funcionario = funcionarioRepository.getReferenceById(id);
            return ResponseEntity.ok(new DetalhesFuncionarioDto(funcionario));
        }catch (EmptyResultDataAccessException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ListagemFuncionarioDto>> listar(Pageable pageable){
        var lista = funcionarioRepository.findAll(pageable).stream().map(ListagemFuncionarioDto::new).toList();
        if(lista.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(lista);

    }

}
