package ru.venkispb.server.repository;

import org.springframework.data.repository.CrudRepository;
import ru.venkispb.server.entity.PagesEntity;

import java.util.List;
import java.util.Optional;

public interface PagesRepository extends CrudRepository<PagesEntity, Integer> {

    List<PagesEntity> findByApplicationName(String applicationName);

    Optional<PagesEntity> findByApplicationNameAndReference(String applicationName, String reference);

}
