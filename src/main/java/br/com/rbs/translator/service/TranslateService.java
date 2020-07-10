package br.com.rbs.translator.service;

import br.com.rbs.translator.controller.TranslateRequest;
import br.com.rbs.translator.converter.BinaryConverter;
import br.com.rbs.translator.converter.MorseConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

import static reactor.core.publisher.Mono.just;

@Slf4j
@Service
public class TranslateService {

    public Mono<String> encode2Morse(String text) {
        return just(text)
                .map(MorseConverter::encode)
                .map(String::trim);
    }

    public Mono<String> decode2Morse(String text) {
        return just(text)
                .map(MorseConverter::decode)
                .map(String::trim);
    }

    public Mono<String> encode2Binary(String text, boolean separator) {
        return just(text)
                .map(input -> BinaryConverter.encode(input, separator));
    }

    public Mono<String> decode2Binary(String text) {
        return just(text)
                .map(BinaryConverter::decode)
                .doOnError(e -> log.error("Error on translate={} e={}", text, e.getMessage()));
    }

    public Mono<String> morse2binary(String text, boolean separator) {
        return decode2Morse(text)
                .flatMap(input -> encode2Binary(input, separator));
    }

    public Mono<String> binary2morse(String text) {
        return decode2Binary(text)
                .flatMap(this::encode2Morse);
    }
}
