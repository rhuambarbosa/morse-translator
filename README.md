# Morse Translator
Morse code Translator

Aplicação para conversão em morse comportando as seguintes conversões:

TEXT -> MORSE |
TEXT -> BINARY | 
MORSE -> TEXT |
MORSE -> BINARY |
BINARY -> TEXT |
BIMARY -> MORSE

## Configuração
Quando inserido um código morse a velociadade poder ser variável de acordo com o operador.  

Se entende aqui que uma pausa prolongada ou a inclusão de um “full stop” (.-.-.-) indica o fim da mensagem.

pausa prolongada = 10 espaços "                 "

full stop = ".-.-.-"


## Deploy
Deploy [heroku](https://www.heroku.com)

Ativada automaticamente quando possui uma chamada a API

Finalizada automaticamente após 30 min sem interação.

## Uso

Ativar a aplicação através do [health](https://translate-morse.herokuapp.com/actuator/health)
```json
request:

curl --location --request GET 'https://translate-morse.herokuapp.com/actuator/health'

response:

{"status": "UP"}
```

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

TEXT -> BINARY
```json
request:

curl --location --request POST 'https://translate-morse.herokuapp.com/translate/2binary?separator=true' \
--header 'Content-Type: application/json' \
--data-raw '{
	"text":"HOLA MELI"	
}'

response:

{
    "code": 200,
    "response": "01001000 01001111 01001100 01000001 00100000 01001101 01000101 01001100 01001001"
}
```

TEXT -> MORSE
```json
request:

curl --location --request POST 'https://translate-morse.herokuapp.com/translate/2morse' \
--header 'Content-Type: application/json' \
--data-raw '{
	"text":"HOLA MELI"	
}'

response:

{
    "code": 200,
    "response": ".... --- .-.. .-  -- . .-.. .."
}
```

MORSE -> TEXT
```json
request:

curl --location --request POST 'https://translate-morse.herokuapp.com/translate/2text' \
--header 'Content-Type: application/json' \
--data-raw '{
	"text":".... --- .-.. .-  -- . .-.. .."	
}'

response:

{
    "code": 200,
    "response": "HOLA MELI"
}
```

MORSE -> BINARY
```json
request:

curl --location --request POST 'https://translate-morse.herokuapp.com/translate/morse2binary' \
--header 'Content-Type: application/json' \
--data-raw '{
	"text":".... --- .-.. .-  -- . .-.. .."	
}'

response:

{
    "code": 200,
    "response": "010010000100111101001100010000010010000001001101010001010100110001001001"
}
```

BINARY -> MORSE
```json
request:

curl --location --request POST 'https://translate-morse.herokuapp.com/translate/binary2morse' \
--header 'Content-Type: application/json' \
--data-raw '{
	"text":"010010000100111101001100010000010010000001001101010001010100110001001001"	
}'

response:

{
    "code": 200,
    "response": ".... --- .-.. .-  -- . .-.. .."
}
```

BINARY -> TEXT
```json
request:

curl --location --request POST 'https://translate-morse.herokuapp.com/translate/binary2text' \
--header 'Content-Type: application/json' \
--data-raw '{
	"text":"01001000 01001111 01001100 01000001 00100000 01001101 01000101 01001100 01001001"	
}'

response:

{
    "code": 200,
    "response": "HOLA MELI"
}
```

