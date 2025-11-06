package br.com.gabriel.atividade_devops_2.service.impl;

import br.com.gabriel.atividade_devops_2.data.entity.TrickModel;
import br.com.gabriel.atividade_devops_2.data.request.TrickRequest;
import br.com.gabriel.atividade_devops_2.data.response.TrickResponse;
import br.com.gabriel.atividade_devops_2.exception.tricks.client_error.TrickNotFoundException;
import br.com.gabriel.atividade_devops_2.repository.TrickRepository;
import br.com.gabriel.atividade_devops_2.service.TrickService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TrickServiceImpl implements TrickService {

    private final TrickRepository trickRepository;

    @Override
    public TrickResponse save(TrickRequest trickRequest) {
        var trickModel = new TrickModel(trickRequest);
        trickModel = trickRepository.save(trickModel);
        return new TrickResponse(trickModel);
    }

    @Override
    public TrickResponse findById(UUID trickId) {
        return trickRepository.findById(trickId)
                .map(TrickResponse::new)
                .orElseThrow(() -> new TrickNotFoundException(trickId));
    }

    @Override
    public TrickResponse update(UUID trickId, TrickRequest trickRequest) {
        var trickModel = trickRepository.findById(trickId)
                .orElseThrow(() -> new TrickNotFoundException(trickId));
        trickModel.update(trickRequest);
        trickModel = trickRepository.save(trickModel);
        return new TrickResponse(trickModel);
    }

    @Override
    public void delete(UUID trickId) {
        final var trickModel = trickRepository.findById(trickId)
                .orElseThrow(() -> new TrickNotFoundException(trickId));
        trickRepository.delete(trickModel);
    }

    @Override
    public List<TrickResponse> findAll() {
        return trickRepository.findAll()
                .stream()
                .map(TrickResponse::new)
                .toList();
    }
}
