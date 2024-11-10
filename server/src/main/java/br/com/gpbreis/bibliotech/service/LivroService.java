package br.com.gpbreis.bibliotech.service;

import br.com.gpbreis.bibliotech.dto.LivroDto;
import br.com.gpbreis.bibliotech.model.Livro;
import br.com.gpbreis.bibliotech.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    LivroRepository livroRepository;

    public LivroDto criarLivro(LivroDto livroDto) {

        Livro novoLivro = this.toLivro(livroDto);
        livroRepository.save(novoLivro);
        return this.toDto(novoLivro);
    }

    public LivroDto lerLivro(Long id) {

        Livro livro = livroRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Livro não encontrado"));
        return this.toDto(livro);
    }

    public LivroDto atualizarLivro(Long id, LivroDto livroDto) {
        Livro livro = livroRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Livro não encontrado"));

        livro.setAutor(livroDto.titulo());
        livro.setAutor(livroDto.autor());
        livro.setIsbn(livroDto.isbn());
        livro.setDataPublicacao(livroDto.dataPublicacao());
        livro.setCategoria(livroDto.categoria());

        this.livroRepository.save(livro);

        return this.toDto(livro);

    }

    public void deletarLivro(Long id) {
        this.livroRepository.deleteById(id);
    }

    public LivroDto toDto(Livro livro){
        return new LivroDto(livro.getId(),
                            livro.getTitulo(),
                            livro.getAutor(),
                            livro.getIsbn(),
                            livro.getDataPublicacao(),
                            livro.getCategoria());
    }

    public Livro toLivro(LivroDto livroDto) {
        return new Livro(livroDto.id(),
                        livroDto.titulo(),
                        livroDto.autor(),
                        livroDto.isbn(),
                        livroDto.dataPublicacao(),
                        livroDto.categoria());
    }
}
