package com.example.produto.models;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "grupoproduto")
@Entity(name = "grupoproduto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class GrupoProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "descricao", nullable = false, length = 200)
    private String descricao;
}
