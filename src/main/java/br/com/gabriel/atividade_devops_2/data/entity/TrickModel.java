package br.com.gabriel.atividade_devops_2.data.entity;

import br.com.gabriel.atividade_devops_2.data.request.TrickRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "trick")
@NoArgsConstructor
@AllArgsConstructor
public class TrickModel {

    @Id
    private UUID id;

    @Column
    private String name;

    @Column
    private String buttonSequence;

    public TrickModel(TrickRequest trickRequest) {
        this.id = UUID.randomUUID();
        this.name = trickRequest.getName();
        this.buttonSequence = trickRequest.getButtonSequenceText();
    }

    public void update(TrickRequest trickRequest) {
        this.name = trickRequest.getName();
        this.buttonSequence = trickRequest.getButtonSequenceText();
    }
}
