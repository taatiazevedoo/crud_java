package com.example.produto.repositories;

import com.example.produto.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IProdutoRepository extends JpaRepository<Produto, Long> {

    Optional<Produto> findProdutoByCodigo(String codigo);

}
