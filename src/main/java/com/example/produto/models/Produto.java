package com.example.produto.models;

import com.example.produto.models.GrupoProduto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Table(name = "produto")
@Entity(name = "produto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "descricao", nullable = false, length = 200)
    private String descricao;

    @Column(name = "codigo", length = 80)
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "idgrupoproduto")
    private GrupoProduto grupoProduto;

    @Column(name = "precocusto")
    private BigDecimal precoCusto;

    @Column(name = "precovenda", nullable = false)
    private BigDecimal precoVenda;

    @Column(name = "observacao", length = 4000)
    private String observacao;
}
