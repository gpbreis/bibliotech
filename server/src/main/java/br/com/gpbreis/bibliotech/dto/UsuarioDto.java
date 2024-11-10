package br.com.gpbreis.bibliotech.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;

@Validated
public record UsuarioDto(Long id,
                         @NotBlank String nome,
                         @Email String email,
                         @PastOrPresent LocalDate dataCadastro,
                         @NotBlank String telefone) {}
