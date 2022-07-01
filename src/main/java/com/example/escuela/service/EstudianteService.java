package com.example.escuela.service;

import com.example.escuela.model.Estudiante;
import com.example.escuela.model.EstudianteDTO;
import com.example.escuela.repository.EstudianteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EstudianteService implements IestudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;


    @Autowired
    ObjectMapper objectMapper;


    @Override
    public void crearEstudiante(EstudianteDTO estudianteDTO) {
        Estudiante estudiante = objectMapper.convertValue(estudianteDTO, Estudiante.class);
        estudianteRepository.save(estudiante);
    }

    @Override
    public EstudianteDTO buscarEstudiante(Long id) {
        Optional<Estudiante> estudiante = estudianteRepository.findById(id);
        EstudianteDTO estudianteDTO = null;
        if (estudiante.isPresent()) {
            estudianteDTO = objectMapper.convertValue(estudiante.get(), EstudianteDTO.class);
        }
        return estudianteDTO;
    }

    @Override
    public void actualizarEstudiante(EstudianteDTO estudianteDTO) {
        crearEstudiante(estudianteDTO);
    }

    @Override
    public void eliminarEstudiante(Long id) {

        estudianteRepository.deleteById(id);


    }

    @Override
    public Set<EstudianteDTO> listarEstudiantes() {
       List<Estudiante> estudiantes = estudianteRepository.findAll();
         Set<EstudianteDTO> estudiantesDTO = new HashSet<>();

         for (Estudiante estudiante : estudiantes) {
             estudiantesDTO.add(objectMapper.convertValue(estudiante, EstudianteDTO.class));
         }

        return estudiantesDTO;

    }
}
