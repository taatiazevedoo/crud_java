package com.example.produto.services;

import com.example.produto.exceptions.NotFoundGrupoProdutoException;
import com.example.produto.exceptions.NotFoundProdutoException;
import com.example.produto.models.GrupoProduto;
import com.example.produto.models.Produto;
import com.example.produto.dto.ProdutoDTO;
import com.example.produto.repositories.IGrupoProdutoRepository;
import com.example.produto.repositories.IProdutoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService implements IProdutoService {

    @Autowired
    private IProdutoRepository produtoRepository;
    @Autowired
    private IGrupoProdutoRepository grupoProdutoRepository;
    private static final Logger logger = LoggerFactory.getLogger(ProdutoService.class);

    @Override
    public List<ProdutoDTO> getProdutoList() {
        try {
            List<Produto> produtoList = produtoRepository.findAll();
            if (produtoList.isEmpty()) {
                return new ArrayList<>();
            }

            return produtoList.stream()
                    .map(ProdutoDTO::new)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            logger.error("Erro ao buscar lista de produtos");
            throw e;
        }
    }

    @Override
    public ProdutoDTO getProdutoById(Long idProduto) {
        Produto produto = produtoRepository.findById(idProduto)
                .orElseThrow(() -> new NotFoundProdutoException("Produto não encontrado com o ID: " + idProduto));
        return new ProdutoDTO(produto);
    }

    @Override
    public ProdutoDTO saveProduto(Produto produto) {
        try {
            Produto produtoNovo = produtoRepository.save(produto);

            if (produto.getGrupoProduto() != null) {
                Long idGrupoProduto = produto.getGrupoProduto().getId();
                GrupoProduto grupoProduto = grupoProdutoRepository.findById(idGrupoProduto)
                        .orElseThrow(() -> new NotFoundGrupoProdutoException("Grupo produto não encontrado com o ID: " + idGrupoProduto));
                produtoNovo.setGrupoProduto(grupoProduto);
            }

            return new ProdutoDTO(produtoNovo);
        } catch (Exception e) {
            logger.error("Erro ao salvar o produto ID: " + produto.getId());
            throw e;
        }
    }

    @Override
    public ProdutoDTO updateProduto(Long idProduto, Produto produtoAtualizado) {
        try {
            Produto produto = produtoRepository.findById(idProduto)
                    .orElseThrow(() -> new NotFoundProdutoException("Produto não encontrado com o ID: " + idProduto));

            produto.setDescricao(produtoAtualizado.getDescricao());
            produto.setCodigo(produtoAtualizado.getCodigo());
            produto.setPrecoCusto(produtoAtualizado.getPrecoCusto());
            produto.setPrecoVenda(produtoAtualizado.getPrecoVenda());
            produto.setObservacao(produtoAtualizado.getObservacao());

            if (produto.getGrupoProduto() != null) {
                Long idGrupoProduto = produto.getGrupoProduto().getId();
                GrupoProduto grupoProduto = grupoProdutoRepository.findById(idGrupoProduto)
                        .orElseThrow(() -> new NotFoundGrupoProdutoException("Grupo produto não encontrado com o ID: " + idGrupoProduto));
                produto.setGrupoProduto(grupoProduto);
            }

            Produto produtoNovo = produtoRepository.save(produto);
            return new ProdutoDTO(produtoNovo);
        } catch (Exception e) {
            logger.error("Erro ao alterar dados do produto ID : " + idProduto);
            throw e;
        }
    }

    @Override
    public void deleteProduto(Long idProduto) {
        try {
            produtoRepository.deleteById(idProduto);
        } catch (Exception e) {
            logger.error("Erro ao deletar o produto ID: " + idProduto);
            throw e;
        }
    }

    public ProdutoDTO getProdutoByCodigo(String codigo) {
        Optional<Produto> produto = produtoRepository.findProdutoByCodigo(codigo);
        if (produto.isEmpty()) {
            throw new NotFoundGrupoProdutoException("Produto não encontrado com código : " + codigo);
        }

        return new ProdutoDTO(produto.get());
    }
}
