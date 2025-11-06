package br.com.gabriel.atividade_devops_2.api.controller;

import br.com.gabriel.atividade_devops_2.api.TrickApi;
import br.com.gabriel.atividade_devops_2.data.request.TrickRequest;
import br.com.gabriel.atividade_devops_2.data.response.TrickResponse;
import br.com.gabriel.atividade_devops_2.service.TrickService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class TrickController implements TrickApi {

    private final TrickService trickService;

    @Override
    public ResponseEntity<TrickResponse> createTrick(TrickRequest trickRequest) {
        final var createdTrick = trickService.save(trickRequest);

        final var url = URI.create("/tricks/" + createdTrick.getId());
        return ResponseEntity.created(url)
                .body(createdTrick);
    }

    @Override
    public ResponseEntity<TrickResponse> findTrick(UUID trickId) {
        final var foundTrick = trickService.findById(trickId);
        return ResponseEntity.ok(foundTrick);
    }

    @Override
    public ResponseEntity<List<TrickResponse>> findAllTricks() {
        final var allTricks = trickService.findAll();
        return ResponseEntity.ok(allTricks);
    }

    @Override
    public ResponseEntity<TrickResponse> updateTrick(UUID trickId, TrickRequest trickRequest) {
        final var updatedTrick = trickService.update(trickId, trickRequest);
        return ResponseEntity.ok(updatedTrick);
    }

    @Override
    public ResponseEntity<Void> deleteTrick(UUID trickId) {
        trickService.delete(trickId);
        return ResponseEntity.noContent().build();
    }
}
