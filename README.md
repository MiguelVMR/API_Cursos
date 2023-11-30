# API de Cursos

## Descrição
Este projeto é uma API RESTful criada com Spring Boot para gerenciar Cursos e aulas, que tem a finalidade de realizar as 4 operações (Create-Read-Update-Delete), sendo implementado o "soft delete" onde não apaga o registro físico do banco de dados e paginação na busca de elementos da API

## Instalação

### Pré-requisitos
- Java 17 ou superior
- MySQL
- Maven
- Software de requisições: Postman, insomnia

## Uso

### Endpoints
- `/curso?page=?&size=?` : Retorna todos os cursos. 
- `/cursos/{id}` : Retorna o Curso com o ID especificado.

- Exemplo de Json para requisições do tipo **POST** :

      {
        "nome": "Spring Completo",
        "categoria": "Back-End",
        "aulas": [
            {
            "nome": "Introdução",
            "aulaURL": "www.youtube.com/aulas/introducao-spring"
            },
            {
            "nome": "Configuração em Spring",
            "aulaURL": "www.youtube.com/aulas/configuracao-spring"
            },
            {
            "nome": "Spring Boot",
            "aulaURL": "www.youtube.com/aulas/spring-boot"
            }
        ]
        }

## Observações:
Caso não passar parametros na requisição **GET** para "page" ou "size" os valores padrão serão 0 e 10 respectivamente

<div style="text-align: center;">
  <img src="https://devkico.itexto.com.br/wp-content/uploads/2014/08/spring-boot-project-logo.png" 
  alt="Logo do projeto" style="width: 120px; margin: 0 auto;border-radius:10px">
    <img src="https://s2-techtudo.glbimg.com/twoewJmwpMgtGPcRPP8SxFlDVmM=/0x0:695x393/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_08fbf48bc0524877943fe86e43087e7a/internal_photos/bs/2021/P/f/y52r4ySZWLkJjEhKLhgw/2014-11-14-java-logo.jpg" 
  alt="Logo do projeto" style="width: 200px; margin: 0 auto;border-radius:10px; margin-left:4em">
</div>