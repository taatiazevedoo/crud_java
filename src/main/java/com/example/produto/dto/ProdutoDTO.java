package com.example.produto.dto;

import com.example.produto.models.GrupoProduto;
import com.example.produto.models.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {

    private Long id;
    private String descricao;
    private String codigo;
    private GrupoProduto grupoProduto;
    private BigDecimal precoCusto;
    private BigDecimal precoVenda;
    private String observacao;

    public ProdutoDTO(Produto produto) {
        this(produto.getId(), produto.getDescricao(), produto.getCodigo(), produto.getGrupoProduto(), produto.getPrecoCusto(), produto.getPrecoVenda(), produto.getObservacao());
    }

    public Produto toProduto() {
        return new Produto(id, descricao, codigo, grupoProduto, precoCusto, precoVenda, observacao);
    }
}
