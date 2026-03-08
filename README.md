# Praticando Spring Framework: Challenge Fórum Hub

  * É uma aplicação de um forúm para interação de alunos e professores para uma instituição educacional.

## Objetivos:

  * Oferecer um fórum para discussões, certificar a segurança e dignidade das informações;
  * O sistema possui um crud de tópico, autenticação e autorização dos usuários;

## Funcionalidades:

  * No crud, pode-se criar, listar um ou todos, atualizar e deletar tópicos; de acordo com o usuário logado;
  * Possui segurança de acordo com cada endpoint indicado;
  * Armaneza os dados no banco de dados;

## Ferramentas Utilizadas:

  * Java 21;
  * Maven;
  * Spring Boot;
  * MySQL;
  * IntelliJ IDEA;

    ## Dependências do Spring Initializr:

      * Lombok;
      * Spring Web;
      * Spring Boot DevTools;
      * Spring Data JPA;
      * Flyway Migration;
      * MySQL Driver;
      * Validation;
      * Spring Security;
   
  ## Requisito para Execução:

  * Java JDK 21 ou versão mais atualizada;
  * Maven 4.0.0 ou versão mais atualizada;
  * Banco de dados (MySQL) - 8.0;
  * Insomnia ou Postman (Para fazer os teste das requisições) - Pois não dispõe de uma interface;

  ## Referência dos Endpoints:

  * **POST** - /login = Público, para fazer login;
  * **GET** - /topicos = Público, pode-se listar todos os tópicos;
  * **GET** - /topicos/{id} = Público, pode-se listar um tópico específico através do id;
  * **POST** - /topicos = Privado, só um usuário que tenha um token para autorizar, consegue fazer a criação de um tópico;
  * **PUT** -  /topicos/{id} = Privado, assim como no anterior para fazer a atualização do tópico, necessita do token;
  * **DELETE** - /topicos/{id} = Privado, para excluir um tópico também é necessário o token;

## OBS.:

*Precisará adicionar o seu nome de usuário e senha do banco de dados MySQL, no arquivo application.properties, dentro da pasta resources. Cria esses dados na instalação do banco de dados na sua máquina.

