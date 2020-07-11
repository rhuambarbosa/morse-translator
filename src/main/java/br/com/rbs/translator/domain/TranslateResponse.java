package br.com.rbs.translator.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.OK;

@Data
public class TranslateResponse {

    private int code;
    private final String response;

    @JsonIgnore
    private HttpStatus status = OK;

    public TranslateResponse(String response) {
        this.code = status.value();
        this.response = response;
    }
}
