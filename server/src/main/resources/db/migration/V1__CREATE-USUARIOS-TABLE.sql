CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(55) NOT NULL,
    email VARCHAR(55) NOT NULL,
    data_cadastro DATE NOT NULL,
    telefone VARCHAR(14)
)