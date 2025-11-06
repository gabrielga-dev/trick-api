package br.com.gabriel.atividade_devops_2.data.response;

import br.com.gabriel.atividade_devops_2.exception.status.StatusException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiErrorResponse implements Serializable {

    private Integer status;
    private String title;
    private List<String> messages;

    public ApiErrorResponse(StatusException ex) {
        this.status = ex.getStatus().value();
        this.title = ex.getTitle();
        this.messages = ex.getMessages();
    }
}
