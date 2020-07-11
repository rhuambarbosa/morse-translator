package br.com.rbs.translator.service


import reactor.test.StepVerifier
import spock.lang.Specification

class TranslateServiceTest extends Specification {

    private static final String TEXT = 'HOLA MELI'
    private static final String MORSE = '.... --- .-.. .-  -- . .-.. ..'
    private static final String BINARY = '010010000100111101001100010000010010000001001101010001010100110001001001'
    private static final String BINARY_SEPARATOR = '01001000 01001111 01001100 01000001 00100000 01001101 01000101 01001100 01001001'

    TranslateService service

    def setup() {
        service = new TranslateService()
    }

    def "should encode text2Morse"() {
        when:
            def result = service.encode2Morse(TEXT)
        then:
            StepVerifier.create(result)
                    .expectNext(MORSE)
                    .verifyComplete()
    }

    def "should encode text2binary"() {
        when:
            def result = service.encode2Binary(TEXT, separator)
        then:
            StepVerifier.create(result)
                    .expectNext(expected)
                    .verifyComplete()
        where:
            separator | expected
            false     | BINARY
            true      | BINARY_SEPARATOR
    }

    def "should decode morse2text"() {
        when:
            def result = service.decode2Morse(MORSE)
        then:
            StepVerifier.create(result)
                    .expectNext(TEXT)
                    .verifyComplete()
    }

    def "should decode morse2binary"() {
        when:
            def result = service.morse2binary(MORSE, separator)
        then:
            StepVerifier.create(result)
                    .expectNext(expected)
                    .verifyComplete()
        where:
            separator | expected
            false     | BINARY
            true      | BINARY_SEPARATOR
    }

    def "should decode binary2text"() {
        when:
            def result = service.decode2Binary(BINARY)
        then:
            StepVerifier.create(result)
                    .expectNext(expected)
                    .verifyComplete()
        where:
            binary           | expected
            BINARY           | TEXT
            BINARY_SEPARATOR | TEXT
    }

    def "should encode binary2Morse"() {
        when:
            def result = service.binary2morse(binary)
        then:
            StepVerifier.create(result)
                    .expectNext(expected)
                    .verifyComplete()
        where:
            binary           | expected
            BINARY           | MORSE
            BINARY_SEPARATOR | MORSE
    }

    def "should error when try decode not binary"() {
        when:
            def result = service.decode2Binary(TEXT)
        then:
            StepVerifier.create(result)
                    .expectErrorMatches {
                        throwable ->
                            throwable instanceof NumberFormatException
                    }
                    .verify()
    }
}