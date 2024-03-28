package com.example.produto.repositories;

import com.example.produto.models.Produto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class IProdutoRepositoryTest {

    @Autowired
    IProdutoRepository produtoRepository;

    @Test
    @DisplayName("Deve encontrar o produto com sucesso")
    void findProdutoByCodigoSucesso() {
        String codigo = "002";
        Optional<Produto> produto = produtoRepository.findProdutoByCodigo(codigo);
        assertThat(produto.isPresent()).isTrue();
    }

    @Test
    @DisplayName("Não deve encontrar o produto com o código informado")
    void findProdutoByCodigoException() {
        String codigo = "003";
        Optional<Produto> produto = produtoRepository.findProdutoByCodigo(codigo);
        assertThat(produto.isEmpty()).isTrue();
    }
}