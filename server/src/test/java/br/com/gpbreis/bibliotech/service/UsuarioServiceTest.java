package br.com.gpbreis.bibliotech.service;

import br.com.gpbreis.bibliotech.dto.UsuarioDto;
import br.com.gpbreis.bibliotech.model.Usuario;
import br.com.gpbreis.bibliotech.repository.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

    @Mock
    UsuarioRepository usuarioRepository;

    @InjectMocks
    UsuarioService usuarioService;

    @Test
    void criarUsuarioNaoDeveRetornarErro(){
        Usuario usuario = new Usuario(1L,
                                "Gustavo",
                                "gpbreis@gmail.com",
                                LocalDate.of(2024,11,9),
                                "44999999999");

        Mockito.when(usuarioRepository.save(usuario)).thenReturn(usuario);
        UsuarioDto usuarioCriado = usuarioService.criarUsuario(usuarioService.toDto(usuario));

        Assertions.assertEquals(1L, usuarioCriado.id());
    }
}
