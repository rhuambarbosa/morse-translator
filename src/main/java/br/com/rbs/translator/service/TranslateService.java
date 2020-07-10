package br.com.rbs.translator.service;

import br.com.rbs.translator.converter.BinaryConverter;
import br.com.rbs.translator.converter.MorseConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
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
}
