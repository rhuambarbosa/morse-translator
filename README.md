# Morse Translator
Morse code Translator

Aplicação para conversão em morse comportando as seguintes conversões:

TEXT -> MORSE |
TEXT -> BINARY | 
MORSE -> TEXT |
MORSE -> BINARY
BINARY -> TEXT |
BIMARY -> MORSE

## Deploy
Deploy na aplicação no [heroku](https://www.heroku.com/)

Pode acessar a aplicação em morse-translate.heroku.com

Como o deploy esta em uma conta grátis se encerra após 30 min sem uso então deve-se realizar uma chamada de
[health](morse-translate.heroku.com) para verificar se a aplicação esta em pé, com isso a aplicação vai ser levantada após a chamada, após estiver health pode 
fazer uso dos endpoint de conversão.


Funcionalidades

| Verbo |  Conversão      | Endpoint                                        | Descrição |
| ------|-----------------|-------------------------------------------------|-----------|
| Get   | TEXT -> MORSE   | http://morse-translate.heroku.com/              | Cria um novo tipo de cerveja.|
| Get   | TEXT -> BINARY  | http://localhost:8082/beer/beers                | Recebe uma lista de cevejas para criação |
| Get   | MORSE -> TEXT   | http://localhost:8082/beer/beers/{id}           | Remove a cerveja pelo id |
| Get   | MORSE -> BINARY | http://localhost:8082/beer/beers                | Retorna todas as cervejas cadastradas |
| Get   | BINARY -> TEXT  | http://localhost:8082/beer/beers/?page=1&size=3 | Retorna a cerveja paginada e ordenada pelo nome, recebe dois parametro page e size |
| Get   | BINARY -> MORSE | http://localhost:8082/best-beers/{temperature}  | Retorna a melhor cerveja e uma lista do spotfy associada ao nome da cerveja ocm base na temperatura informada |