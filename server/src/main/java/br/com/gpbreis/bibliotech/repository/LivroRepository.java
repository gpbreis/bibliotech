package br.com.gpbreis.bibliotech.repository;

import br.com.gpbreis.bibliotech.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
