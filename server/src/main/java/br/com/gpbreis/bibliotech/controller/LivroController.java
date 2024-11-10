package br.com.gpbreis.bibliotech.controller;

import br.com.gpbreis.bibliotech.dto.LivroDto;
import br.com.gpbreis.bibliotech.model.Livro;
import br.com.gpbreis.bibliotech.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    @Autowired
    LivroService livroService;

    @PostMapping
    public ResponseEntity<LivroDto> criar(@Valid @RequestBody LivroDto livroDto) {

        LivroDto novoLivro = this.livroService.criarLivro(livroDto);
        return ResponseEntity.ok(novoLivro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDto> ler(@PathVariable("id") Long id) {

        LivroDto livroDto = this.livroService.lerLivro(id);
        return ResponseEntity.ok(livroDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroDto> atualizar(@PathVariable("id") Long id,@Valid @RequestBody LivroDto livroDto){

        LivroDto dto = this.livroService.atualizarLivro(id,livroDto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        this.livroService.deletarLivro(id);
        return ResponseEntity.ok().build();
    }
}
