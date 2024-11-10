package br.com.gpbreis.bibliotech.repository;

import br.com.gpbreis.bibliotech.model.Emprestimo;
import br.com.gpbreis.bibliotech.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

    @Query("select count(*) from Emprestimo where livroId = :livroId and status = 1")
    Long emprestimosAtivos(@Param("livroId") Livro id);


}
