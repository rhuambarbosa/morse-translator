package br.com.rbs.translator.converter

import spock.lang.Specification
import spock.lang.Unroll

import static br.com.rbs.translator.converter.MorseConverter.decode
import static br.com.rbs.translator.converter.MorseConverter.encode

class MorseConverterTest extends Specification {

    @Unroll
    def "should encode #text in #morse"() {
        when:
            String result = encode(text)
        then:
            result == morse
        where:
            text | morse
            "A"  | ".-"
            "a"  | ".-"
            "B"  | "-..."
            "b"  | "-..."
            "C"  | "-.-."
            "c"  | "-.-."
            "D"  | "-.."
            "d"  | "-.."
            "E"  | "."
            "e"  | "."
            "F"  | "..-."
            "f"  | "..-."
            "G"  | "--."
            "g"  | "--."
            "H"  | "...."
            "h"  | "...."
            "I"  | ".."
            "i"  | ".."
            "J"  | ".---"
            "j"  | ".---"
            "K"  | "-.-"
            "k"  | "-.-"
            "L"  | ".-.."
            "l"  | ".-.."
            "M"  | "--"
            "m"  | "--"
            "N"  | "-."
            "n"  | "-."
            "O"  | "---"
            "o"  | "---"
            "P"  | ".--."
            "p"  | ".--."
            "Q"  | "--.-"
            "q"  | "--.-"
            "R"  | ".-."
            "r"  | ".-."
            "S"  | "..."
            "s"  | "..."
            "T"  | "-"
            "t"  | "-"
            "U"  | "..-"
            "u"  | "..-"
            "V"  | "...-"
            "v"  | "...-"
            "W"  | ".--"
            "w"  | ".--"
            "X"  | "-..-"
            "x"  | "-..-"
            "Y"  | "-.--"
            "y"  | "-.--"
            "Z"  | "--.."
            "z"  | "--.."
            "0"  | "-----"
            "1"  | ".----"
            "2"  | "..---"
            "3"  | "...--"
            "4"  | "....-"
            "5"  | "....."
            "6"  | "-...."
            "7"  | "--..."
            "8"  | "---.."
            "9"  | "----."
            "."  | ".-.-"
            ","  | "--..--"
            "?"  | "..--.."
            " "  | ""
    }

    @Unroll
    def "should decode #morse in #text"() {
        when:
            String result = decode(morse)
        then:
            result == text
        where:
            morse    | text
            ".-"     | "A"
            "-..."   | "B"
            "-.-."   | "C"
            "-.."    | "D"
            "."      | "E"
            "..-."   | "F"
            "--."    | "G"
            "...."   | "H"
            ".."     | "I"
            ".---"   | "J"
            "-.-"    | "K"
            ".-.."   | "L"
            "--"     | "M"
            "-."     | "N"
            "---"    | "O"
            ".--."   | "P"
            "--.-"   | "Q"
            ".-."    | "R"
            "..."    | "S"
            "-"      | "T"
            "..-"    | "U"
            "...-"   | "V"
            ".--"    | "W"
            "-..-"   | "X"
            "-.--"   | "Y"
            "--.."   | "Z"
            "-----"  | "0"
            ".----"  | "1"
            "..---"  | "2"
            "...--"  | "3"
            "....-"  | "4"
            "....."  | "5"
            "-...."  | "6"
            "--..."  | "7"
            "---.."  | "8"
            "----."  | "9"
            ".-.-"   | "."
            "--..--" | ","
            "..--.." | "?"
            " "      | ""
    }

    def "should encode HOLA MELI"() {
        when:
            String result = encode('HOLA MELI')
        then:
            result == '.... --- .-.. .-  -- . .-.. ..'
    }

    def "should decode .... --- .-.. .-  -- . .-.. .."() {
        when:
            String result = decode('.... --- .-.. .-  -- . .-.. ..')
        then:
            result == 'HOLA MELI'
    }
}
