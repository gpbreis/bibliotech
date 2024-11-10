package br.com.gpbreis.bibliotech.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record LivroDto(Long id,
                       @NotBlank String titulo,
                       @NotBlank String autor,
                       @NotBlank String isbn,
                       @PastOrPresent LocalDate dataPublicacao,
                       @NotBlank String categoria) {
}
