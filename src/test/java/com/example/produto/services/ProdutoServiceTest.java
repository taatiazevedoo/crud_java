package com.example.produto.services;

import com.example.produto.models.GrupoProduto;
import com.example.produto.models.Produto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.math.BigDecimal;


class ProdutoServiceTest {

    @Autowired
    private IProdutoService produtoService;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    @DisplayName("Deve salvar um novo produto com sucesso")
    void saveProdutoSucesso() {
        GrupoProduto grupoProduto = new GrupoProduto(1l, "Papelaria");
        Produto produto = new Produto(1l, "caderno", "001", grupoProduto, new BigDecimal(2.50), new BigDecimal(5), "");
        produtoService.saveProduto(produto);
    }
}