package br.com.fiap.CheckPoint1.controller;

import br.com.fiap.CheckPoint1.dto.cliente.AtualizarClienteDto;
import br.com.fiap.CheckPoint1.dto.cliente.CadastroClienteDto;
import br.com.fiap.CheckPoint1.dto.cliente.DetalhesClienteDto;
import br.com.fiap.CheckPoint1.dto.cliente.ListagemClienteDto;
import br.com.fiap.CheckPoint1.model.Cliente;
import br.com.fiap.CheckPoint1.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesClienteDto> cadastrar(@RequestBody CadastroClienteDto clienteDto, UriComponentsBuilder uriBuilder){
        var cliente = new Cliente(clienteDto);
        clienteRepository.save(cliente);
        var url = uriBuilder.path("clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(url).body(new DetalhesClienteDto(cliente));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesClienteDto> atualizar(@PathVariable("id") Long id, @RequestBody AtualizarClienteDto clienteDto){
        var cliente = clienteRepository.getReferenceById(id);
        cliente.atualizarCLiente(clienteDto);
        return ResponseEntity.ok(new DetalhesClienteDto(cliente));
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalhesClienteDto> buscarPorId(@PathVariable("id") Long id){
        var cliente = clienteRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesClienteDto(cliente));
    }

    @GetMapping
    public ResponseEntity<List<ListagemClienteDto>> listar(Pageable pageable){
       var lista = clienteRepository.findAll(pageable).stream().map(ListagemClienteDto::new).toList();
       return ResponseEntity.ok(lista);
    }

}
