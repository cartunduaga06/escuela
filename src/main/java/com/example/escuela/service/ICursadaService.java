package com.example.escuela.service;

import com.example.escuela.model.CursadaDTO;

import java.util.Set;

public interface ICursadaService {

    void crearCursada(CursadaDTO cursadaDTO);
    CursadaDTO buscarCursada(Long id);
    void actualizarCursada(CursadaDTO cursadaDTO);
    void eliminarCursada(Long id);
    Set<CursadaDTO> listarCursadas();

}
