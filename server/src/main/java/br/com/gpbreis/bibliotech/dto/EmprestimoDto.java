package br.com.gpbreis.bibliotech.dto;

import br.com.gpbreis.bibliotech.enums.StatusEnum;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record EmprestimoDto(Long id,
                            @NotBlank Long usuarioId,
                            @NotBlank Long livroId,
                            @PastOrPresent LocalDate dataEmprestimo,
                            @FutureOrPresent LocalDate dataDevolucao,
                            @NotBlank StatusEnum status) {
}
