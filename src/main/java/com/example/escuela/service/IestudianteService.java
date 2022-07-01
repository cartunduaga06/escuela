package com.example.escuela.service;

import com.example.escuela.model.Estudiante;
import com.example.escuela.model.EstudianteDTO;

import java.util.Set;

public interface IestudianteService {

    void crearEstudiante(EstudianteDTO estudianteDTO);
    EstudianteDTO buscarEstudiante(Long id);
    void actualizarEstudiante(EstudianteDTO estudianteDTO);
    void eliminarEstudiante(Long id);
    Set<EstudianteDTO> listarEstudiantes();

}
