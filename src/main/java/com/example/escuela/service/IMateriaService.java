package com.example.escuela.service;

import com.example.escuela.model.MateriaDTO;

import java.util.Set;

public interface IMateriaService {

    void crearMateria(MateriaDTO materiaDTO);
    MateriaDTO buscarMateria(Long id);
    void actualizarMateria(MateriaDTO materiaDTO);
    void eliminarMateria(Long id);
    Set<MateriaDTO> listarMaterias();

}
