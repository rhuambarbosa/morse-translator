package br.com.rbs.translator.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class MorseProcessor {

    private final String longPause;
    private final String fullStop;

    public MorseProcessor(@Value("${break.qtdSeparatorLongPause}") int qtdSeparatorLongPause,
                          @Value("${break.fullStop}") String fullStop) {
        this.longPause = buildLongPause(qtdSeparatorLongPause);
        this.fullStop = fullStop;
    }

    public Mono<String> process(String text) {
        text = processBreak(text);
        return Mono.just(text);
    }

    private String processBreak(String text) {
        text = processBreak(text, longPause);
        return processBreak(text, fullStop);
    }

    private String processBreak(String text, final String pause) {
        String textReturn = text;

        int idx = text.indexOf(pause);
        if (idx != -1) {
            textReturn = text.substring(0, idx);
        }

        return textReturn.trim();
    }

    private String buildLongPause(int qtdLongPause) {
        return " ".repeat(Math.max(0, qtdLongPause));
    }
}