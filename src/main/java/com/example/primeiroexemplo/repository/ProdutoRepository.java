package com.example.primeiroexemplo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.primeiroexemplo.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Integer>{
    

}
