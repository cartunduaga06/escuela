package com.example.escuela.service;

import com.example.escuela.model.Cursada;
import com.example.escuela.model.CursadaDTO;
import com.example.escuela.repository.CursadaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CursadaService implements ICursadaService {

    @Autowired
    private CursadaRepository cursadaRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void crearCursada(CursadaDTO cursadaDTO) {
        Cursada cursada = mapper.convertValue(cursadaDTO, Cursada.class);
        cursadaRepository.save(cursada);
    }

    @Override
    public CursadaDTO buscarCursada(Long id) {
        Optional<Cursada> cursada = cursadaRepository.findById(id);
        CursadaDTO cursadaDTO = null;
        if (cursada.isPresent()) {
            cursadaDTO = mapper.convertValue(cursada.get(), CursadaDTO.class);
        }
        return cursadaDTO;
    }

    @Override
    public void actualizarCursada(CursadaDTO cursadaDTO) {
        crearCursada(cursadaDTO);
    }

    @Override
    public void eliminarCursada(Long id) {
        cursadaRepository.deleteById(id);
    }

    @Override
    public Set<CursadaDTO> listarCursadas() {
        List<Cursada> cursadas = cursadaRepository.findAll();
        Set<CursadaDTO> cursadasDTO = new HashSet<>();
        for (Cursada cursada : cursadas) {
            cursadasDTO.add(mapper.convertValue(cursada, CursadaDTO.class));
        }
        return cursadasDTO;
    }




}
