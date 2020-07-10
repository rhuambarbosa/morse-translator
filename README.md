# Morse Translator
Morse code Translator

Aplicação para conversão em morse comportando as seguintes conversões:

TEXT -> MORSE |
TEXT -> BINARY | 
MORSE -> TEXT |
MORSE -> BINARY |
BINARY -> TEXT |
BIMARY -> MORSE

## Deploy
Deploy [heroku](https://www.heroku.com)

Ativada automaticamente quando possui uma chamada a API

Finalizada automaticamente após 30 min sem interação.

## Uso

Ativar a aplicação através do [health](https://translate-morse.herokuapp.com/actuator/health)

Montar a chamada esperada conforme opções abaixo:

uri:  https://translate-morse.herokuapp.com

| Verbo  |  Conversão      | Endpoint                                        | Descrição |
| -------|-----------------|-------------------------------------------------|-----------|
| POST   | TEXT -> MORSE   | /2morse          | Texto para Morse |
| POST   | TEXT -> BINARY  | /2binary?separator=true                 | Texto para binario, pode escolher se deve ou não possuir espaçamento |
| POST   | MORSE -> TEXT   | /2text           |  Morse para texto |
| POST   | MORSE -> BINARY | /morse2binary?separator=false                  |  Morse para binario, pode escolher se deve ou não possuir espaçamento |
| POST   | BINARY -> TEXT  | /binary2text | Binario para texto |
| POST   | BINARY -> MORSE | /binary2morse  |  Binario para morse |

### Payload: 

| TEXT | MORSE | BINARY |
|------|-----|-----|
| {"text":"HOLA MELI"} | {"text":"01001000 01001111 01001100 01000001 00100000 01001101 01000101 01001100 01001001"} |{"text":".... --- .-.. .-  -- . .-.. .."} |

### curl:

TEXT -> MORSE | /2morse 
```json
curl --location --request POST 'https://translate-morse.herokuapp.com/translate/2morse' \
--header 'Content-Type: application/json' \
--data-raw '{
	"text":"HOLA MELI"	
}'
```


