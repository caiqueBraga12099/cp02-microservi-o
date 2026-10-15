package com.github.caiqueBraga12099.registrometeorologico.service;

import com.github.caiqueBraga12099.registrometeorologico.dto.*;
import com.github.caiqueBraga12099.registrometeorologico.entity.RegistroMeteorologico;
import com.github.caiqueBraga12099.registrometeorologico.repository.RegistroMeteorologicoRepository;
import com.github.caiqueBraga12099.registrometeorologico.exception.RegistroNaoEncontradoException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Sort;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class RegistroMeteorologicoService {

    private final RegistroMeteorologicoRepository repository;

    public RegistroMeteorologicoService(RegistroMeteorologicoRepository repository) {

        this.repository = repository;
    }

    public List<RegistroMeteorologicoResponseDTO> listar() {

        return repository.findAll(Sort.by("registroId")).stream().map(RegistroMeteorologicoResponseDTO::fromEntity).toList();
    }

    public RegistroMeteorologicoResponseDTO buscar(Long id) {

        return RegistroMeteorologicoResponseDTO.fromEntity(obter(id));
    }

    @Transactional
    public RegistroMeteorologicoResponseDTO criar(RegistroMeteorologicoRequestDTO dto) {

        var registro = new RegistroMeteorologico();
        preencher(registro, dto);
        return RegistroMeteorologicoResponseDTO.fromEntity(repository.save(registro));
    }

    @Transactional
    public RegistroMeteorologicoResponseDTO atualizar(Long id, RegistroMeteorologicoRequestDTO dto) {

        var registro = obter(id);
        preencher(registro, dto);
        return RegistroMeteorologicoResponseDTO.fromEntity(repository.save(registro));
    }

    @Transactional
    public void excluir(Long id) {

        repository.delete(obter(id));
    }

    private RegistroMeteorologico obter(Long id) {

        return repository.findById(id).orElseThrow(() -> new RegistroNaoEncontradoException(id));
    }

    private void preencher(RegistroMeteorologico r, RegistroMeteorologicoRequestDTO d) {

        r.setEstacaoNome(d.getEstacaoNome());
        r.setDataRegistro(d.getDataRegistro());
        r.setTemperatura(d.getTemperatura());
        r.setPercentualUmidade(d.getPercentualUmidade());
        r.setPrecipitacao(d.getPrecipitacao());
        r.setCondicaoClimatica(d.getCondicaoClimatica());
    }
}
