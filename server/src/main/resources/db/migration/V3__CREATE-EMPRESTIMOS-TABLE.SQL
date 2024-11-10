CREATE SEQUENCE emprestimos_id_seq;

CREATE TABLE emprestimos (
    id BIGINT PRIMARY KEY DEFAULT nextval('emprestimos_id_seq'),
    usuario_id BIGINT NOT NULL,
    livro_id BIGINT NOT NULL,
    data_emprestimo DATE NOT NULL,
    data_devolucao DATE NOT NULL,
    status VARCHAR(10) NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    FOREIGN KEY (livro_id) REFERENCES livros(id)
);