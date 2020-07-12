package br.com.rbs.translator.service

import reactor.test.StepVerifier
import spock.lang.Specification

class MorseProcessorTest extends Specification {

    MorseProcessor processor

    def setup() {
        processor = new MorseProcessor(
                10,
                '.-.-.-'
        )
    }

    def "should process break"() {
        when:
            String result = processor.processBreak(text)
        then:
            result == expected
        where:
            text                                      | expected
            '.... --- .-.. .-           -- . .-.. ..' | '.... --- .-.. .-'
            '.... --- .-.. .-        -- . .-.. ..'    | '.... --- .-.. .-        -- . .-.. ..'
            '.... --- .-.. .- .-.-.- -- . .-.. ..'    | '.... --- .-.. .-'
    }

    def "should process text"() {
        when:
            def result = processor.process(text)
        then:
            StepVerifier.create(result)
                    .expectNext(expected)
                    .verifyComplete()
        where:
            text                                      | expected
            '.... --- .-.. .-           -- . .-.. ..' | '.... --- .-.. .-'
            '.... --- .-.. .- .-.-.- -- . .-.. ..'    | '.... --- .-.. .-'
    }
}
