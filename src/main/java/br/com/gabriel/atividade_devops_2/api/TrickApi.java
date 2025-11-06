package br.com.gabriel.atividade_devops_2.api;

import br.com.gabriel.atividade_devops_2.data.request.TrickRequest;
import br.com.gabriel.atividade_devops_2.data.response.TrickResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@RequestMapping("/v1/tricks")
@Tag(name = "Trick Controller", description = "Operations related to tricks")
public interface TrickApi {

    @PostMapping
    @Operation(summary = "Create trick", description = "Creates a new trick")
    @ApiResponse(responseCode = "201", description = "Trick created")
    @ApiResponse(responseCode = "4xx", description = "Invalid informed data")
    ResponseEntity<TrickResponse> createTrick(@Valid @RequestBody TrickRequest trickRequest);

    @GetMapping("/{trickId}")
    @Operation(summary = "Find trick", description = "Find a trick by its id")
    @ApiResponse(responseCode = "200", description = "Trick found")
    @ApiResponse(responseCode = "404", description = "Trick not found")
    @ApiResponse(responseCode = "4xx", description = "Invalid informed data")
    ResponseEntity<TrickResponse> findTrick(@PathVariable UUID trickId);

    @GetMapping
    @Operation(summary = "Find all tricks", description = "Find all created trick")
    @ApiResponse(responseCode = "200", description = "Tricks found")
    ResponseEntity<List<TrickResponse>> findAllTricks();

    @PutMapping("/{trickId}")
    @Operation(summary = "Update trick", description = "Find a trick by its id and update it")
    @ApiResponse(responseCode = "200", description = "Trick updated")
    @ApiResponse(responseCode = "404", description = "Trick not found")
    @ApiResponse(responseCode = "4xx", description = "Invalid informed data")
    ResponseEntity<TrickResponse> updateTrick(
            @PathVariable UUID trickId,
            @RequestBody @Valid TrickRequest trickRequest
    );

    @DeleteMapping("/{trickId}")
    @Operation(summary = "Delete trick", description = "Find a trick by its id and delete it")
    @ApiResponse(responseCode = "204", description = "Trick deleted")
    @ApiResponse(responseCode = "404", description = "Trick not found")
    @ApiResponse(responseCode = "4xx", description = "Invalid informed data")
    ResponseEntity<Void> deleteTrick(@PathVariable UUID trickId);
}
