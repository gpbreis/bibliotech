package br.com.gpbreis.bibliotech.service;

import br.com.gpbreis.bibliotech.dto.EmprestimoDto;
import br.com.gpbreis.bibliotech.model.Emprestimo;
import br.com.gpbreis.bibliotech.model.Livro;
import br.com.gpbreis.bibliotech.model.Usuario;
import br.com.gpbreis.bibliotech.repository.EmprestimoRepository;
import br.com.gpbreis.bibliotech.repository.LivroRepository;
import br.com.gpbreis.bibliotech.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmprestimoService {

    @Autowired
    EmprestimoRepository emprestimoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    LivroRepository livroRepository;

    public EmprestimoDto criarEmprestimo(EmprestimoDto emprestimoDto) {

        if (this.emprestimoRepository.emprestimosAtivos(this.livroRepository.findById(emprestimoDto.livroId()).orElseThrow()) > 0){
            throw new RuntimeException("Já existe um emprestimo ativo para o livro");
        }

        Emprestimo emprestimo = this.toEmprestimo(emprestimoDto);
        emprestimoRepository.save(emprestimo);
        return this.toDto(emprestimo);
    }

    public EmprestimoDto lerEmprestimo(Long id) {

        Emprestimo emprestimo = this.emprestimoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Emprestimo não encontrado"));
        return this.toDto(emprestimo);
    }

    public EmprestimoDto atuarlizarEmprestimo(Long id, EmprestimoDto emprestimoDto) {

        Emprestimo emprestimo = this.emprestimoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Emprestimo não encontrado"));
        Usuario usuario = this.usuarioRepository.findById(emprestimo.getUsuarioId().getId()).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
        Livro livro = this.livroRepository.findById(emprestimo.getLivroId().getId()).orElseThrow(() -> new IllegalArgumentException("Livro não encontrado"));
        emprestimo.setUsuarioId(usuario);
        emprestimo.setLivroId(livro);
        emprestimo.setDataEmprestimo(emprestimoDto.dataEmprestimo());
        emprestimo.setDataDevolucao(emprestimoDto.dataDevolucao());
        emprestimo.setStatus(emprestimoDto.status());
        this.emprestimoRepository.save(emprestimo);
        return this.toDto(emprestimo);
    }

    public void deletarEmprestimo(Long id) {

        this.emprestimoRepository.deleteById(id);
    }

    private EmprestimoDto toDto(Emprestimo emprestimo) {
        return new EmprestimoDto(emprestimo.getId(),
                                emprestimo.getUsuarioId().getId(),
                                emprestimo.getLivroId().getId(),
                                emprestimo.getDataEmprestimo(),
                                emprestimo.getDataDevolucao(),
                                emprestimo.getStatus());
    }

    private Emprestimo toEmprestimo(EmprestimoDto emprestimoDto) {

        Usuario usuario = this.usuarioRepository.findById(emprestimoDto.usuarioId()).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
        Livro livro = this.livroRepository.findById(emprestimoDto.livroId()).orElseThrow(() -> new IllegalArgumentException("Livro não encontrado"));

        return new Emprestimo(emprestimoDto.id(),
                            usuario,
                            livro,
                            emprestimoDto.dataEmprestimo(),
                            emprestimoDto.dataDevolucao(),
                            emprestimoDto.status());
    }
}
