package br.com.gabriel.atividade_devops_2.data.request;

import br.com.gabriel.atividade_devops_2.data.enums.ButtonEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TrickRequest {

    @NotBlank
    private String name;

    @NotNull
    @NotEmpty
    private List<ButtonEnum> buttonSequence;

    @JsonIgnore
    public String getButtonSequenceText() {
        return this.buttonSequence.stream()
                .map(Enum::name)
                .collect(Collectors.joining(", "));
    }
}
