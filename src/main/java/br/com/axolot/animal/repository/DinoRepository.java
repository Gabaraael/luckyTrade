package br.com.axolot.animal.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.axolot.animal.model.AnimaliaEntity;

@Repository
public interface DinoRepository extends JpaRepository<AnimaliaEntity, Long> {

    @Override
    ArrayList<AnimaliaEntity> findAll();


}
