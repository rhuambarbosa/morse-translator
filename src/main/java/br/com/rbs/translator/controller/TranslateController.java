package br.com.rbs.translator.controller;

import br.com.rbs.translator.service.TranslateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequestMapping("/translate")
@RestController
public class TranslateController {

    private final TranslateService translateService;

    public TranslateController(TranslateService translateService) {
        this.translateService = translateService;
    }

    @GetMapping("/2text")
    public Mono<String> translate2Human(@RequestParam String text) {
        return translateService.decode2Morse(text);
    }

    @GetMapping("/2morse")
    public Mono<String> decodeBits2Morse(@RequestParam String text) {
        return translateService.encode2Morse(text);
    }

    @GetMapping("/2binary")
    public Mono<String> encode2Binary(@RequestParam String text, boolean separator) {
        return translateService.encode2Binary(text, separator);
    }

    @GetMapping("/binary2text")
    public Mono<String> decode2Binary(@RequestParam String text) {
        return translateService.decode2Binary(text);
    }
}
