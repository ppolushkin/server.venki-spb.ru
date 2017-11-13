package ru.venkispb.server.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.venkispb.server.entity.RevisionsEntity;

import java.util.List;
import java.util.Optional;

public interface RevisionsRepository extends CrudRepository<RevisionsEntity, Integer> {

    Optional<RevisionsEntity> findTopByPageIdOrderByIdDesc(Integer pageId);

    List<RevisionsEntity> findByPageId(Integer pageId);

}
