package br.com.gpbreis.bibliotech.controller;

import br.com.gpbreis.bibliotech.dto.EmprestimoDto;
import br.com.gpbreis.bibliotech.dto.LivroDto;
import br.com.gpbreis.bibliotech.service.EmprestimoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/emprestimos")
public class EmprestimoController {

    @Autowired
    EmprestimoService emprestimoService;

    @PostMapping
    public ResponseEntity<EmprestimoDto> criar(@Valid @RequestBody EmprestimoDto emprestimoDto) {

        EmprestimoDto novoEmprestimo = this.emprestimoService.criarEmprestimo(emprestimoDto);
        return ResponseEntity.ok(novoEmprestimo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmprestimoDto> ler(@PathVariable Long id) {

        EmprestimoDto emprestimoDto = this.emprestimoService.lerEmprestimo(id);
        return ResponseEntity.ok(emprestimoDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmprestimoDto> atualizar(@PathVariable Long id, @RequestBody EmprestimoDto emprestimoDto) {

        EmprestimoDto dto =this.emprestimoService.atuarlizarEmprestimo(id, emprestimoDto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        this.emprestimoService.deletarEmprestimo(id);
        return ResponseEntity.ok().build();
    }
}
