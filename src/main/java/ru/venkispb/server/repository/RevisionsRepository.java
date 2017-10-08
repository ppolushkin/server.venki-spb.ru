package ru.venkispb.server.repository;

import org.springframework.data.repository.CrudRepository;
import ru.venkispb.server.entity.RevisionsEntity;

import java.util.Optional;

public interface RevisionsRepository extends CrudRepository<RevisionsEntity, Integer> {

    Optional<RevisionsEntity> findByPageId(Integer pageId);

}
