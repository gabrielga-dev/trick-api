package br.com.gabriel.atividade_devops_2.service;

import br.com.gabriel.atividade_devops_2.data.request.TrickRequest;
import br.com.gabriel.atividade_devops_2.data.response.TrickResponse;

import java.util.List;
import java.util.UUID;

public interface TrickService {

    TrickResponse save(TrickRequest trickRequest);

    TrickResponse findById(UUID trickId);

    TrickResponse update(UUID trickId, TrickRequest trickRequest);

    void delete(UUID trickId);

    List<TrickResponse> findAll();
}
