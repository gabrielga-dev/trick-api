package br.com.gabriel.atividade_devops_2.repository;

import br.com.gabriel.atividade_devops_2.data.entity.TrickModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TrickRepository extends JpaRepository<TrickModel, UUID> {
}
