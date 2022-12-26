package br.com.axolot.animal.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.axolot.animal.dtos.DinoDto;
import br.com.axolot.animal.model.AnimaliaEntity;
import br.com.axolot.animal.repository.DinoRepository;

@Service
public class DinoService {

    @Autowired
    DinoRepository dinoRepository;

    public List<DinoDto> findAll() {
        ModelMapper modelMapper = new ModelMapper();

        List<DinoDto> dinoDtos = dinoRepository.findAll()
                .stream()
                .map(dino -> modelMapper.map(dino, DinoDto.class))
                .collect(Collectors.toList());
        return dinoDtos;

    }

    public void create(DinoDto dinoDto) {
        ModelMapper modelMapper = new ModelMapper();
        AnimaliaEntity dino = modelMapper.map(dinoDto, AnimaliaEntity.class);

        try {
            dinoRepository.save(dino);

        } catch (Exception e) {
            throw e;

        }
    }

    public void findById(long id) {

        ModelMapper modelMapper = new ModelMapper();
        try {

//            Dinosaur dinosaur = dinoRepository.findById(id);
            // Dinosaur dinosaur = dinoRepository.findById(id);
//            modelMapper.map(dinoDto, Dinosaur.class);

        } catch (Exception e) {
            throw e;

        }
    }

}
