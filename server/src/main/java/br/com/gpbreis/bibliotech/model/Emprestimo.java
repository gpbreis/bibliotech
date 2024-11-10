package br.com.gpbreis.bibliotech.model;

import br.com.gpbreis.bibliotech.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "emprestimos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emprestimos_id_seq")
    @SequenceGenerator(name = "emprestimos_id_seq", sequenceName = "emprestimos_id_seq", initialValue = 1, allocationSize = 1)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuarioId;
    @ManyToOne
    @JoinColumn(name = "livro_id", referencedColumnName = "id")
    private Livro livroId;
    @Column(name = "data_emprestimo")
    private LocalDate dataEmprestimo;
    @Column(name = "data_devolucao")
    private LocalDate dataDevolucao;
    private StatusEnum status;
}
