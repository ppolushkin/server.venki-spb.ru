package ru.venkispb.server.repository;

import org.springframework.data.repository.CrudRepository;
import ru.venkispb.server.entity.RevisionsEntity;

public interface RevisionsRepository extends CrudRepository<RevisionsEntity, Integer> {
}
