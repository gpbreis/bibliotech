package br.com.gpbreis.bibliotech.controller;

import br.com.gpbreis.bibliotech.dto.UsuarioDto;
import br.com.gpbreis.bibliotech.model.Usuario;
import br.com.gpbreis.bibliotech.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> criar(@Valid @RequestBody UsuarioDto usuarioDto){
        Usuario novoUsuario = this.usuarioService.criarUsuario(usuarioDto);
        return ResponseEntity.ok(novoUsuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> ler(@PathVariable("id") Long id){

        UsuarioDto usuarioDto = this.usuarioService.lerUsuario(id);
        return ResponseEntity.ok(usuarioDto);
    }

    @PutMapping
    public ResponseEntity<Usuario> atualizar(@Valid @RequestBody UsuarioDto usuarioDto){
        Usuario usuario = this.usuarioService.atualizarUsuario(usuarioDto);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        this.usuarioService.deletarUsuario(id);
        return ResponseEntity.ok().build();
    }
}
