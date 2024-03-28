package com.example.produto.repositories;

import com.example.produto.models.GrupoProduto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGrupoProdutoRepository extends JpaRepository<GrupoProduto, Long> {
}
