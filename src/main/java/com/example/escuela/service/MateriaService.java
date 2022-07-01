package com.example.escuela.service;

import com.example.escuela.model.Materia;
import com.example.escuela.model.MateriaDTO;
import com.example.escuela.repository.MateriaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class MateriaService implements IMateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void crearMateria(MateriaDTO materiaDTO) {


        Materia materia = mapper.convertValue(materiaDTO, Materia.class);
        materiaRepository.save(materia);



    }

    @Override
    public MateriaDTO buscarMateria(Long id) {

        Optional<Materia> materia = materiaRepository.findById(id);
        MateriaDTO materiaDTO = null;
        if (materia.isPresent()) {
            materiaDTO = mapper.convertValue(materia.get(), MateriaDTO.class);
        }
        return materiaDTO;
    }

    @Override
    public void actualizarMateria(MateriaDTO materiaDTO) {
        crearMateria(materiaDTO);
    }

    @Override
    public void eliminarMateria(Long id) {

        materiaRepository.deleteById(id);


    }

    @Override
    public Set<MateriaDTO> listarMaterias() {

        List<Materia> materias = materiaRepository.findAll();
        Set<MateriaDTO> materiasDTO = new HashSet<>();

        for (Materia materia : materias) {
            materiasDTO.add(mapper.convertValue(materia, MateriaDTO.class));
        }

        return materiasDTO;
    }
}
