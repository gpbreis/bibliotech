package br.com.gpbreis.bibliotech.service;

import br.com.gpbreis.bibliotech.dto.UsuarioDto;
import br.com.gpbreis.bibliotech.model.Usuario;
import br.com.gpbreis.bibliotech.repository.UsuarioRepository;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;



    public UsuarioDto criarUsuario(UsuarioDto usuarioDto){

        Usuario novoUsuario = this.toUsuario(usuarioDto);
        usuarioRepository.save(novoUsuario);

        return this.toDto(novoUsuario);
    }

    public UsuarioDto lerUsuario(Long id) {

        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
        return this.toDto(usuario);
    }

    public void deletarUsuario(Long id) {

        Optional<Usuario> usuario = this.usuarioRepository.findById(id);
        if (usuario.isPresent()){
            this.usuarioRepository.deleteById(usuario.get().getId());
        }
    }

    public UsuarioDto atualizarUsuario(Long id, UsuarioDto usuarioDto) {

        Usuario usuarioAtualizado = usuarioRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
        usuarioAtualizado.setNome(usuarioDto.nome());
        usuarioAtualizado.setEmail(usuarioDto.email());
        usuarioAtualizado.setDataCadastro(usuarioDto.dataCadastro());
        usuarioAtualizado.setTelefone(usuarioDto.telefone());

        this.usuarioRepository.save(usuarioAtualizado);

        return this.toDto(usuarioAtualizado);
    }

    public UsuarioDto toDto(Usuario usuario) {
        return new UsuarioDto(usuario.getId(),
                            usuario.getNome(),
                            usuario.getEmail(),
                            usuario.getDataCadastro(),
                            usuario.getTelefone());
    }

    public Usuario toUsuario(UsuarioDto usuarioDto) {
        return new Usuario(usuarioDto.id(),
                        usuarioDto.nome(),
                        usuarioDto.email(),
                        usuarioDto.dataCadastro(),
                        usuarioDto.telefone());
    }

}
