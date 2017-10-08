package ru.venkispb.server.repository;

import org.springframework.data.repository.CrudRepository;
import ru.venkispb.server.entity.PagesEntity;

import java.util.Optional;

public interface PagesRepository extends CrudRepository<PagesEntity, Integer> {

    Optional<PagesEntity> findByReferenceAndApplicationName(String reference, String ApplicationName);

}
