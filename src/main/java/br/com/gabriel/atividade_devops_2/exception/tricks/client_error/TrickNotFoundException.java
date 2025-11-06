package br.com.gabriel.atividade_devops_2.exception.tricks.client_error;

import br.com.gabriel.atividade_devops_2.exception.status.client_error.NotFoundException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.UUID;

public class TrickNotFoundException extends NotFoundException {

    public TrickNotFoundException(UUID trickId) {
        super(
                List.of(
                        String.format("No trick found for the id %s.", trickId)
                )
        );
    }
}
