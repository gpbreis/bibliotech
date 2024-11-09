package br.com.gpbreis.bibliotech.model;

import br.com.gpbreis.bibliotech.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "livros")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String titulo;
    private String autor;
    private String isbn;
    @Column(name = "data_publicacao", nullable = false)
    private LocalDate dataPublicacao;
    @Column(name = "data_devolucao", nullable = false)
    private LocalDate dataDevolucao;
    @Column(nullable = false)
    private StatusEnum status;
}