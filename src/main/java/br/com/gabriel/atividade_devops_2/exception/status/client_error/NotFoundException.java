package br.com.gabriel.atividade_devops_2.exception.status.client_error;

import br.com.gabriel.atividade_devops_2.exception.status.StatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

public class NotFoundException extends StatusException {

    public NotFoundException(List<String> messages) {
        super(
                HttpStatus.NOT_FOUND,
                "Record not found!",
                messages
        );
    }
}
