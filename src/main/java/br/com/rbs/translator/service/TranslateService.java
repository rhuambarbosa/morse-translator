package br.com.rbs.translator.service;

import br.com.rbs.translator.converter.BinaryConverter;
import br.com.rbs.translator.converter.MorseConverter;
import br.com.rbs.translator.domain.TranslateResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import static br.com.rbs.translator.converter.BinaryConverter.encode;
import static reactor.core.publisher.Mono.just;

@Slf4j
@Service
public class TranslateService {

    private final MorseProcessor morseProcessor;

    public TranslateService(MorseProcessor morseProcessor) {
        this.morseProcessor = morseProcessor;
    }

    public Mono<TranslateResponse> encode2Morse(String text) {
        return just(text)
                .map(MorseConverter::encode)
                .map(TranslateResponse::new);
    }

    public Mono<TranslateResponse> decode2Morse(String text) {
        return morseProcessor.process(text)
                .map(MorseConverter::decode)
                .map(TranslateResponse::new);
    }

    public Mono<TranslateResponse> encode2Binary(String text, boolean separator) {
        return just(text)
                .map(input -> encode(input, separator))
                .map(TranslateResponse::new);
    }

    public Mono<TranslateResponse> decode2Binary(String text) {
        return just(text)
                .map(BinaryConverter::decode)
                .map(TranslateResponse::new);
    }

    public Mono<TranslateResponse> morse2binary(String text, boolean separator) {
        return decode2Morse(text)
                .flatMap(response -> encode2Binary(response.getResponse(), separator));
    }

    public Mono<TranslateResponse> binary2morse(String text) {
        return just(text)
                .map(BinaryConverter::decode)
                .flatMap(this::encode2Morse);
    }
}
