package br.com.gabriel.atividade_devops_2.exception.status;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class StatusException extends RuntimeException {

    private final HttpStatus status;
    private final String title;
    private final List<String> messages;
}
