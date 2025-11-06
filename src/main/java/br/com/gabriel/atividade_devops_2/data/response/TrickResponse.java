package br.com.gabriel.atividade_devops_2.data.response;

import br.com.gabriel.atividade_devops_2.data.entity.TrickModel;
import br.com.gabriel.atividade_devops_2.data.enums.ButtonEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TrickResponse implements Serializable {

    private UUID id;
    private String name;
    private List<ButtonEnum> buttonSequence;

    public TrickResponse(TrickModel trickModel) {
        this.id = trickModel.getId();
        this.name = trickModel.getName();
        this.buttonSequence = Arrays.stream(trickModel.getButtonSequence().split(", "))
                .map(ButtonEnum::valueOf)
                .toList();
    }
}
