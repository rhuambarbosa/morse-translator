package br.com.rbs.translator.controller;

import br.com.rbs.translator.service.TranslateService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequestMapping("/translate")
@RestController
public class TranslateController {

    private final TranslateService translateService;

    public TranslateController(TranslateService translateService) {
        this.translateService = translateService;
    }

    @PostMapping("/2text")
    public Mono<String> translate2Human(@RequestBody TranslateRequest request) {
        return translateService.decode2Morse(request.getText());
    }

    @PostMapping("/2morse")
    public Mono<String> decodeBits2Morse(@RequestBody TranslateRequest request) {
        return translateService.encode2Morse(request.getText());
    }

    @PostMapping("/2binary")
    public Mono<String> encode2Binary(@RequestBody TranslateRequest request, boolean separator) {
        return translateService.encode2Binary(request.getText(), separator);
    }

    @PostMapping("/morse2binary")
    public Mono<String> morse2binary(@RequestBody TranslateRequest request, boolean separator) {
        return translateService.morse2binary(request.getText(), separator);
    }

    @PostMapping("/binary2morse")
    public Mono<String> binary2morse(@RequestBody TranslateRequest request) {
        return translateService.binary2morse(request.getText());
    }

    @PostMapping("/binary2text")
    public Mono<String> binary2text(@RequestBody TranslateRequest request) {
        return translateService.decode2Binary(request.getText());
    }
}
