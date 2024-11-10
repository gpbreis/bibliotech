package br.com.gpbreis.bibliotech.repository;


import br.com.gpbreis.bibliotech.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
