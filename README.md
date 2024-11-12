# Bibliotech


## Desafio técnico Elotech: Gestão de Biblioteca com Recomendação de Livros
Este é um projeto em desenvolvimento para o desafio técnico da empresa Elotech Gestão Pública, sendo o objeto desenvolver uma aplicação de gestão de biblioteca permitindo o cadastro de usuários, livros, empréstimos e recomendações de livros. Devendo ser utilizado um banco de dados relacional, api rest para as operações de CRUD e duas questões bônus, sendo uma integração com a API do Google Books e desenvolver o frontend em Reac ou Angular.

A branch main será mantida sem atualizações até o retorno, mas o projeto continuará a ser desenvolvido.

# Índice

- [Pré-requisitos](#pré-requisitos)
- [Instalação](#instalação)
- [Configuração](#configuração)
- [Utilização](#utilização)

## Pré-requisitos

**Java 21 <br>
PostgreSQL 16 <br>
Maven 3.9.9**

# Instalação

1. Instale o PostgreSQL
2. Clone o repositório
````bash
git clone git@github.com:gpbreis/bibliotech.git
````
3. Instale as dependências utlizando o Maven

# Configuração

O nome padrão do banco de dados da aplicação é **bibliotech**, com o usuário **postgres** e a senha **post**. <br>
Caso queira, é possível alterar as informações no arquivo **application.properties**

# Utilização

O projeto utiliza SpringDoc, portanto, é possível testar todos os endpoints da aplicação utilizando o Swagger através do link http://localhost:8080/swagger-ui.html <br>

## Endpoints da API
### GET USUARIOS
````markdown
GET /usuarios/{id} -- Retorna os dados de determinado usuário.
````
````json
{
  "id": 1,
  "nome": "Gustavo",
  "email": "gustavo@mail.com",
  "dataCadastro": "2024-11-12",
  "telefone": "99999999"
}
````
### PUT USUARIOS
````markdown
PUT /usuarios/{id} -- Altera os dados de determinado usuário.
````
````json
{
  "id": 1,
  "nome": "Gustavo",
  "email": "gustavo@mail.com",
  "dataCadastro": "2024-11-12",
  "telefone": "99999999"
}
````
### DELETE USUARIOS
````markdown
DELETE /usuarios/{id} -- Apaga determinado usuário.
````
### POST USUARIOS
````markdown
POST /usuarios -- Cadastra um usuário.
````
````json
{
  "nome": "Gustavo",
  "email": "gpbreis@gmail.com",
  "dataCadastro": "2024-11-12",
  "telefone": "99999999"
}
````

### GET LIVROS
````markdown
GET /livros/{id} -- Retorna os dados de determinado livro.
````
````json
{
  "id": 1,
  "titulo": "Java®: Como Programar",
  "autor": "Paul DeiteL, Harvey Deitel",
  "isbn": "8543004799",
  "dataPublicacao": "2016-06-24",
  "categoria": "Programação em Java"
}
````
### PUT LIVROS
````markdown
PUT /livros/{id} -- Altera os dados de determinado livro.
````
````json
{
  "id": 1,
  "titulo": "Java®: Como Programar",
  "autor": "Paul DeiteL, Harvey Deitel",
  "isbn": "8543004799",
  "dataPublicacao": "2016-06-24",
  "categoria": "Programação em Java"
}
````
### DELETE LIVROS
````markdown
DELETE /livros/{id} -- Apaga determinado livro.
````
### POST LIVROS
````markdown
POST /livros -- Cadastra um livro.
````
````json
{
  "titulo": "Java®: Como Programar",
  "autor": "Paul DeiteL, Harvey Deitel",
  "isbn": "8543004799",
  "dataPublicacao": "2016-06-24",
  "categoria": "Programação em Java"
}
````

### GET EMPRESTIMOS
````markdown
GET /emprestimos/{id} -- Retorna os dados de determinado emprestimo.
````
````json
{
  "id": 0,
  "usuarioId": 1,
  "livroId": 1,
  "dataEmprestimo": "2024-11-09",
  "dataDevolucao": "2024-11-15",
  "status": "ATIVO"
}
````
### PUT EMPRESTIMOS
````markdown
PUT /emprestimos/{id} -- Altera os dados de determinado emprestimo.
````
````json
{
  "usuarioId": 1,
  "livroId": 1,
  "dataEmprestimo": "2024-11-09",
  "dataDevolucao": "2024-11-15",
  "status": "DEVOLVIDO"
}
````
### DELETE EMPRESTIMOS
````markdown
DELETE /emprestimos/{id} -- Apaga determinado emprestimo.
````
### POST EMPRESTIMOS
````markdown
POST /emprestimos -- Cadastra um emprestimo.
````
````json
{
  "usuarioId": 1,
  "livroId": 1,
  "dataEmprestimo": "2024-11-09",
  "dataDevolucao": "2024-11-15",
  "status": "ATIVO"
}
````