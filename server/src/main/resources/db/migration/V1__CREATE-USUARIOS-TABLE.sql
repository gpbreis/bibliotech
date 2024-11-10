CREATE SEQUENCE usuarios_id_seq;

CREATE TABLE usuarios (
    id BIGINT PRIMARY KEY DEFAULT nextval('usuarios_id_seq'),
    nome VARCHAR(55) NOT NULL,
    email VARCHAR(55) NOT NULL,
    data_cadastro DATE NOT NULL,
    telefone VARCHAR(14)
);