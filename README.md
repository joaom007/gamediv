# Projeto Jogo de adivinhação Scale Systems 

<p>Projeto back end Spring Boot construído em estrutura MVC com arquitetura API REST e tratamento de requisições personalizadas.</p>
<p>Entidades: Jogador (Player), Partida (Game), Jogada (Play), ambos os modelos possuem operações CRUD.</p>

>

## Autor

1. [joaom007](https://github.com/joaom007)

>

## Dependências

* Java 11
* Maven 3.6.3
* Spring Boot
* Banco de Dados H2 (em memória)

>

## Instruções para teste da API

1. Instalação do JAVA 11
2. Instalação do maven 3.6.3+
3. Execução do código
4. Conferir end points da API em http://localhost:8081/players , http://localhost:8081/games , http://localhost:8081/plays
5. Conferir banco de dados em memória em: http://localhost:8081/h2-console , usuário = sa, senha = "vazia"
6. Importar arquivo Insomnia_requests.json da raiz no software de testes insomnia, a fim de testar requisições CRUD (GET, POST, PUT, DELETE)

## Repostas as requisições

* Requisição GET - End points localhost:8081/players e localhost:8081/players/id retorno código 200 ok e 404 para não encontrado
* Requisição POST - End point localhost:8081/players retorno código 201 com retorno do objeto criado.
* Requisição DELETE - End point localhost:8081/players/id retorno código 204 ok, 404 para não encontrado e 400 para bad requests que poderiam criar inconsistência no banco.
* Requisição PUT - End point localhost:8081/players/id código 200 com retorno do objeto alterado e 404 para não encontrado.



