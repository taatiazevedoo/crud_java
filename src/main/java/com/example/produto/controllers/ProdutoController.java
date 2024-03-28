package com.example.produto.controllers;

import com.example.produto.dto.ProdutoDTO;
import com.example.produto.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> getProdutoList() {
        List<ProdutoDTO> produtoList = service.getProdutoList();
        return ResponseEntity.ok().body(produtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> getProdutoById(@PathVariable(value = "id") Long idProduto) {
        ProdutoDTO produtoDTO = service.getProdutoById(idProduto);
        return ResponseEntity.ok().body(produtoDTO);
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> saveProduto(@RequestBody ProdutoDTO produto) {
        ProdutoDTO produtoNovo = service.saveProduto(produto.toProduto());
        return ResponseEntity.ok().body(produtoNovo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> updateProduto(@PathVariable(value = "id") Long idProduto, @RequestBody ProdutoDTO produtoAtualizado) {
        final ProdutoDTO produto = service.updateProduto(idProduto, produtoAtualizado.toProduto());
        return ResponseEntity.ok().body(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduto(@PathVariable("id") Long idProduto) throws Exception {
        service.deleteProduto(idProduto);
        return ResponseEntity.ok("Produto deletado com sucesso!");
    }
}
