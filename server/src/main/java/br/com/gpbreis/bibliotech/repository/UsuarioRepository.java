package br.com.gpbreis.bibliotech.repository;


import br.com.gpbreis.bibliotech.model.Livro;
import br.com.gpbreis.bibliotech.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

//    @Query("select l.id, l.titulo, l.autor, l.isbn, l.dataPublicacao, l.categoria from Livro l where l.categoria in " +
//            "(select distinct l2.categoria from Livro l2 where l2.id in (select e.Livro.id from Emprestimo e))" +
//            "and l.id not in (select e2.Livro.id from Emprestimo e2 where e2.usuarioId = :usuarioId)")
//    List<Livro> recomendacoes(@Param("usuarioId") Usuario id);
}
