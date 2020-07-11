package br.com.rbs.translator.converter

import spock.lang.Specification

class BinaryConverterTest extends Specification {

    def "should encode HOLA MELI"() {
        when:
            String result = BinaryConverter.encode('HOLA MELI', separator)
        then:
            result == expected
        where:
            separator | expected
            false     | '010010000100111101001100010000010010000001001101010001010100110001001001'
            true      | '01001000 01001111 01001100 01000001 00100000 01001101 01000101 01001100 01001001'
    }

    def "should decode binary HOLA MELI"() {
        when:
            String result = BinaryConverter.decode(binary)
        then:
            result == expected
        where:
            binary                                                                             | expected
            '010010000100111101001100010000010010000001001101010001010100110001001001'         | 'HOLA MELI'
            '01001000 01001111 01001100 01000001 00100000 01001101 01000101 01001100 01001001' | 'HOLA MELI'
    }

}
