package br.com.gpbreis.bibliotech.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarios_id_seq")
    @SequenceGenerator(name = "usuarios_id_seq", sequenceName = "usuarios_id_seq", initialValue = 1, allocationSize = 1)
    private Long id;
    private String nome;
    private String email;
    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;
    private String telefone;

}
