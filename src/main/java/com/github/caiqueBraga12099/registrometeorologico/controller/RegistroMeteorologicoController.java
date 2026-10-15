package com.github.caiqueBraga12099.registrometeorologico.controller;

import com.github.caiqueBraga12099.registrometeorologico.dto.*;
import com.github.caiqueBraga12099.registrometeorologico.service.RegistroMeteorologicoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;

@RestController
@RequestMapping("/api/registros-meteorologicos")
@Tag(name = "Registros meteorológicos", description = "Cadastro e gerenciamento de medições meteorológicas")
public class RegistroMeteorologicoController {

    private final RegistroMeteorologicoService service;

    public RegistroMeteorologicoController(RegistroMeteorologicoService service) {

        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Listar registros")
    public List<RegistroMeteorologicoResponseDTO> listar() {

        return service.listar();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar registro pelo ID")
    public RegistroMeteorologicoResponseDTO buscar(@PathVariable Long id) {

        return service.buscar(id);
    }

    @PostMapping
    @Operation(summary = "Criar registro")
    public ResponseEntity<RegistroMeteorologicoResponseDTO> criar(@Valid @RequestBody RegistroMeteorologicoRequestDTO dto) {

        var response = service.criar(dto);
        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getRegistroId())
                .toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar todos os dados de um registro")
    public RegistroMeteorologicoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody RegistroMeteorologicoRequestDTO dto) {

        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir registro")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {

        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
