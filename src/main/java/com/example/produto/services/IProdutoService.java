package com.example.produto.services;

import com.example.produto.models.Produto;
import com.example.produto.dto.ProdutoDTO;

import java.util.List;

public interface IProdutoService {
    ProdutoDTO saveProduto(Produto produto);

    ProdutoDTO updateProduto(Long idProduto, Produto produto);

    void deleteProduto(Long idProduto);

    List<ProdutoDTO> getProdutoList();

    ProdutoDTO getProdutoById(Long idProduto);
}
