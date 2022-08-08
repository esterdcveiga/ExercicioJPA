package com.exercicio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exercicio.entidade.Cachorro;

@Repository
public interface CachorroRepository extends CrudRepository<Cachorro, Integer>{

}
