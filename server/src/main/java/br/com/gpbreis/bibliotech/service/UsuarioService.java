package br.com.gpbreis.bibliotech.service;

import br.com.gpbreis.bibliotech.dto.UsuarioDto;
import br.com.gpbreis.bibliotech.model.Usuario;
import br.com.gpbreis.bibliotech.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;



    public Usuario criarUsuario(UsuarioDto usuarioDto){

        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(usuarioDto.nome());
        novoUsuario.setEmail(usuarioDto.email());
        novoUsuario.setDataCadastro(usuarioDto.dataCadastro());
        novoUsuario.setTelefone(usuarioDto.telefone());

        usuarioRepository.save(novoUsuario);

        return novoUsuario;
    }

    public void deletarUsuario(Long id) {

        Optional<Usuario> usuario = this.usuarioRepository.findById(id);
        if (usuario.isPresent()){
            this.usuarioRepository.deleteById(usuario.get().getId());
        }
    }

    public Usuario atualizarUsuario(UsuarioDto usuarioDto) {
        Usuario usuarioAtualizado = new Usuario();
        usuarioAtualizado.setId(usuarioDto.id());
        usuarioAtualizado.setNome(usuarioDto.nome());
        usuarioAtualizado.setEmail(usuarioDto.email());
        usuarioAtualizado.setDataCadastro(usuarioDto.dataCadastro());
        usuarioAtualizado.setTelefone(usuarioDto.telefone());

        usuarioRepository.save(usuarioAtualizado);

        return usuarioAtualizado;
    }

}
