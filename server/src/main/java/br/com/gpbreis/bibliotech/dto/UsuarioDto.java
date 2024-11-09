package br.com.gpbreis.bibliotech.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record UsuarioDto(@NotBlank Long id,
                         @NotBlank String nome,
                         @Email String email,
                         @PastOrPresent LocalDate dataCadastro,
                         @NotBlank String telefone) {}
