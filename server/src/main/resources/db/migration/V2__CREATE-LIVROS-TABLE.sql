CREATE SEQUENCE livros_id_seq;

CREATE TABLE livros (
    id BIGINT PRIMARY KEY DEFAULT nextval('livros_id_seq'),
    titulo VARCHAR(250) NOT NULL,
    autor VARCHAR(500) NOT NULL,
    isbn VARCHAR(50) NOT NULL,
    data_publicacao DATE NOT NULL,
    categoria VARCHAR(50) NOT NULL
);