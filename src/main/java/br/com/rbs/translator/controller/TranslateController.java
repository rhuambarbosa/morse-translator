package br.com.rbs.translator.controller;

import br.com.rbs.translator.domain.TranslateRequest;
import br.com.rbs.translator.domain.TranslateResponse;
import br.com.rbs.translator.service.TranslateService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/translate",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class TranslateController {

    private final TranslateService translateService;

    public TranslateController(TranslateService translateService) {
        this.translateService = translateService;
    }

    @PostMapping("/2text")
    public Mono<ResponseEntity<TranslateResponse>> translate2Human(@RequestBody TranslateRequest request) {
        return translateService.decode2Morse(request.getText())
                .map(response -> new ResponseEntity<>(response, response.getStatus()));
    }

    @PostMapping("/2morse")
    public Mono<ResponseEntity<TranslateResponse>> decodeBits2Morse(@RequestBody TranslateRequest request) {
        return translateService.encode2Morse(request.getText())
                .map(response -> new ResponseEntity<>(response, response.getStatus()));
    }

    @PostMapping("/2binary")
    public Mono<ResponseEntity<TranslateResponse>> encode2Binary(@RequestBody TranslateRequest request, boolean separator) {
        return translateService.encode2Binary(request.getText(), separator)
                .map(response -> new ResponseEntity<>(response, response.getStatus()));
    }

    @PostMapping("/morse2binary")
    public Mono<ResponseEntity<TranslateResponse>> morse2binary(@RequestBody TranslateRequest request, boolean separator) {
        return translateService.morse2binary(request.getText(), separator)
                .map(response -> new ResponseEntity<>(response, response.getStatus()));
    }

    @PostMapping("/binary2morse")
    public Mono<ResponseEntity<TranslateResponse>> binary2morse(@RequestBody TranslateRequest request) {
        return translateService.binary2morse(request.getText())
                .map(response -> new ResponseEntity<>(response, response.getStatus()));
    }

    @PostMapping("/binary2text")
    public Mono<ResponseEntity<TranslateResponse>> binary2text(@RequestBody TranslateRequest request) {
        return translateService.decode2Binary(request.getText())
                .map(response -> new ResponseEntity<>(response, response.getStatus()));
    }
}
