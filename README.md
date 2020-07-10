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

uri:  http://morse-translate.heroku.com/translate

| Verbo  |  Conversão      | Endpoint                                        | Descrição |
| -------|-----------------|-------------------------------------------------|-----------|
| POST   | TEXT -> MORSE   | /2morse          | Texto para Morse |
| POST   | TEXT -> BINARY  | /2binary?separator=true                 | Texto para binario, pode escolher se deve ou não possuir espaçamento |
| POST   | MORSE -> TEXT   | /2text           |  Morse para texto |
| POST   | MORSE -> BINARY | /morse2binary?separator=false                  |  Morse para binario, pode escolher se deve ou não possuir espaçamento |
| POST   | BINARY -> TEXT  | /binary2text | Binario para texto |
| POST   | BINARY -> MORSE | /binary2morse  |  Binario para morse |

Payload: 

| TEXT | MORSE | BINARY |
|------|-----|-----|
| {"text":"HELLO GUY"} | {"text":"01001000 01000101 01001100 01001100 01001111 00100000 01000111 01010101 01011001"} |{"text":".... . .-.. .-.. ---  --. ..- -.--"} |
